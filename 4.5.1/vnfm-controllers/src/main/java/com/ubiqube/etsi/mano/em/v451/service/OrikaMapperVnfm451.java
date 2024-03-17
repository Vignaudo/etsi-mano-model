/**
 *     Copyright (C) 2019-2024 Ubiqube.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.ubiqube.etsi.mano.em.v451.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.ubiqube.etsi.mano.dao.mano.AdditionalArtifact;
import com.ubiqube.etsi.mano.dao.mano.ExtManagedVirtualLinkDataEntity;
import com.ubiqube.etsi.mano.dao.mano.ExtVirtualLinkDataEntity;
import com.ubiqube.etsi.mano.dao.mano.GrantInformationExt;
import com.ubiqube.etsi.mano.dao.mano.GrantResponse;
import com.ubiqube.etsi.mano.dao.mano.VnfCompute;
import com.ubiqube.etsi.mano.dao.mano.VnfExtCpDataEntity;
import com.ubiqube.etsi.mano.dao.mano.VnfInstance;
import com.ubiqube.etsi.mano.dao.mano.VnfPackage;
import com.ubiqube.etsi.mano.dao.mano.alarm.Alarms;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfInfoModificationsDto;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfInstantiatedCompute;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfInstantiatedExtLinkPort;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfInstantiatedStorage;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfInstantiatedVirtualLink;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfLcmOpOccs;
import com.ubiqube.etsi.mano.dao.mano.v2.BlueprintParameters;
import com.ubiqube.etsi.mano.dao.mano.v2.VnfBlueprint;
import com.ubiqube.etsi.mano.dao.mano.vim.SoftwareImage;
import com.ubiqube.etsi.mano.dao.mano.vim.VnfStorage;
import com.ubiqube.etsi.mano.em.v451.model.vnffm.Alarm;
import com.ubiqube.etsi.mano.em.v451.model.vnffm.FmSubscription;
import com.ubiqube.etsi.mano.em.v451.model.vnffm.FmSubscriptionRequest;
import com.ubiqube.etsi.mano.em.v451.model.vnfind.VnfIndicatorSubscriptionRequest;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.AffectedExtLinkPort;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.AffectedVirtualLink;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.AffectedVirtualStorage;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.AffectedVnfc;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.ExtManagedVirtualLinkData;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.ExtManagedVirtualLinkInfo;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.ExtVirtualLinkInfo;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.InstantiateVnfRequest;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.LccnSubscription;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.LccnSubscriptionRequest;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.SubscriptionAuthentication;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.SubscriptionAuthenticationParamsOauth2ClientCredentials;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.VnfExtCpData;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.VnfInfoModifications;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.VnfInstanceInstantiatedVnfInfo;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.VnfLcmOpOcc;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.VnfcResourceInfo;
import com.ubiqube.etsi.mano.model.VnfInstantiate;
import com.ubiqube.etsi.mano.nfvo.v451.model.vnf.PkgmSubscriptionRequest;
import com.ubiqube.etsi.mano.nfvo.v451.model.vnf.VnfPackageArtifactInfo;
import com.ubiqube.etsi.mano.nfvo.v451.model.vnf.VnfPackageSoftwareImageInfo;
import com.ubiqube.etsi.mano.nfvo.v451.model.vnf.VnfPackageSoftwareImageInfo.ContainerFormatEnum;
import com.ubiqube.etsi.mano.nfvo.v451.model.vnf.VnfPackageSoftwareImageInfo.DiskFormatEnum;
import com.ubiqube.etsi.mano.nfvo.v451.model.vnf.VnfPkgInfo;
import com.ubiqube.etsi.mano.nfvo.v451.model.vnfsnapshotpkgm.Checksum;
import com.ubiqube.etsi.mano.service.auth.model.AuthParamOauth2;
import com.ubiqube.etsi.mano.service.auth.model.AuthentificationInformations;
import com.ubiqube.etsi.mano.service.event.model.Subscription;
import com.ubiqube.etsi.mano.vnfm.v451.model.grant.Grant;
import com.ubiqube.etsi.mano.vnfm.v451.model.grant.ResourceDefinition;
import com.ubiqube.orika.OrikaMapperFactoryConfigurer;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;

@Service
public class OrikaMapperVnfm451 implements OrikaMapperFactoryConfigurer {

	@Override
	public void configure(final MapperFactory orikaMapperFactory) {
		orikaMapperFactory.classMap(com.ubiqube.etsi.mano.em.v451.model.vnflcm.VnfInstance.class, VnfInstance.class)
				.field("instantiatedVnfInfo.extVirtualLinkInfo", "instantiatedVnfInfo.extVirtualLinkInfo")
				.field("vimConnectionInfo{value}", "vimConnectionInfo")
				.byDefault()
				.register();
		orikaMapperFactory.classMap(VnfInstanceInstantiatedVnfInfo.class, BlueprintParameters.class)
				.field("vnfState", "state")
				.field("localizationLanguage", "localizationLanguage")
				.field("monitoringParameters", "vnfMonitoringParameter")
				.field("extManagedVirtualLinkInfo", "extManagedVirtualLinks")
				.field("vnfVirtualLinkResourceInfo", "virtualLinkResourceInfo")
				.byDefault()
				.register();
		orikaMapperFactory.classMap(VnfPackageArtifactInfo.class, AdditionalArtifact.class)
				.byDefault()
				.field("checksum", "checksum.hash")
				.register();
		orikaMapperFactory.classMap(VnfInfoModifications.class, VnfInfoModificationsDto.class)
				// .field("vimConnectionInfo{value}", "vimConnectionInfo{}")
				.byDefault()
				.register();
		orikaMapperFactory.classMap(VnfExtCpDataEntity.class, VnfExtCpData.class)
				// .field("cpConfig", "cpConfig{value}")
				.exclude("cpConfig")
				.byDefault()
				.register();

		orikaMapperFactory.classMap(VnfPackage.class, VnfPkgInfo.class)
				.field("vnfmInfo", "vnfmInfo")
				.byDefault()
				.customize(new CustomMapper<VnfPackage, VnfPkgInfo>() {
					@Override
					public void mapAtoB(final VnfPackage a, final VnfPkgInfo b, final MappingContext context) {
						// Remap Images
						final Set<VnfCompute> vnfc = a.getVnfCompute();
						if (null != vnfc) {
							vnfc.forEach(x -> {
								final SoftwareImage img = x.getSoftwareImage();
								if (null != img) {
									b.addSoftwareImagesItem(mapSoftwareImage(img));
								}
							});
						}
						final Set<VnfStorage> storage = a.getVnfStorage();
						if (null != storage) {
							storage.forEach(x -> {
								final SoftwareImage img = x.getSoftwareImage();
								if (null != img) {
									b.addSoftwareImagesItem(mapSoftwareImage(img));
								}
							});
						}

					}

					private VnfPackageSoftwareImageInfo mapSoftwareImage(final SoftwareImage img) {
						final VnfPackageSoftwareImageInfo ret = new VnfPackageSoftwareImageInfo();
						final Checksum chk = new Checksum();
						chk.setAlgorithm(img.getChecksum().getAlgorithm());
						chk.setHash(img.getChecksum().getHash());
						ret.setChecksum(chk);
						ret.setContainerFormat(Optional.ofNullable(img.getContainerFormat())
								.map(Object::toString)
								.map(ContainerFormatEnum::fromValue)
								.orElse(null));
						// ret.setCreatedAt(img.get)
						ret.setDiskFormat(Optional.ofNullable(img.getDiskFormat())
								.map(Object::toString)
								.map(DiskFormatEnum::valueOf)
								.orElse(null));
						if (null != img.getId()) {
							ret.setId(img.getId().toString());
						}
						ret.setImagePath(img.getImagePath());
						ret.setMinDisk(Optional.ofNullable(img.getMinDisk()).orElse(null));
						ret.setMinRam(Optional.ofNullable(img.getMinRam()).orElse(null));
						ret.setName(img.getName());
						ret.setProvider(img.getProvider());
						ret.setSize(Optional.ofNullable(img.getSize()).orElse(null));
						ret.setVersion(img.getVersion());
						ret.setCreatedAt(img.getAudit().getCreatedOn());
						return ret;
					}
				})
				.register();
		orikaMapperFactory.classMap(AffectedVirtualLink.class, VnfInstantiatedVirtualLink.class)
				.exclude("audit")
				.field("vnfVirtualLinkDescId", "manoResourceId")
				.field("networkResource.resourceId", "resourceId")
				.field("networkResource.resourceProviderId", "resourceProviderId")
				.field("networkResource.vimLevelResourceType", "vimLevelResourceType")
				.field("networkResource.vimConnectionId", "vimConnectionInformation.id")
				.byDefault()
				.register();
		orikaMapperFactory.classMap(AffectedVnfc.class, VnfInstantiatedCompute.class)
				.exclude("audit")
				.field("computeResource.resourceId", "resourceId")
				.field("computeResource.resourceProviderId", "resourceProviderId")
				.field("computeResource.vimLevelResourceType", "vimLevelResourceType")
				.field("computeResource.vimConnectionId", "vimConnectionInformation.id")
				.byDefault()
				.register();
		orikaMapperFactory.classMap(AffectedExtLinkPort.class, VnfInstantiatedExtLinkPort.class)
				.field("resourceHandle.vimConnectionId", "vimConnectionInformation.vimId")
				.field("resourceHandle.resourceProviderId", "resourceProviderId")
				.field("resourceHandle.resourceId", "resourceId")
				.field("resourceHandle.vimLevelResourceType", "vimLevelResourceType")
				.byDefault()
				.register();
		orikaMapperFactory.classMap(VnfInstantiatedCompute.class, VnfCompute.class)
				.exclude("id")
				.field("storageResourceIds", "storages")
				.field("vduId", "id")
				.byDefault()
				.register();
		orikaMapperFactory.classMap(VnfLcmOpOcc.class, VnfBlueprint.class)
				.field("vnfInstanceId", "vnfInstance.id")
				// .field("resourceChanges", "tasks")
				.field("grantId", "grantsRequestId")
				.field("operationState", "operationStatus")
				.field("isAutomaticInvocation", "automaticInvocation")
				.field("isCancelPending", "cancelPending")
				.field("operationParams", "parameters")
				.field("operationState", "operationStatus")
				.byDefault()
				.register();

		orikaMapperFactory.classMap(ExtManagedVirtualLinkData.class, ExtManagedVirtualLinkDataEntity.class)
				.byDefault()
				.register();
		orikaMapperFactory.classMap(ExtVirtualLinkInfo.class, ExtVirtualLinkDataEntity.class)
				.field("resourceHandle.vimConnectionId", "vimConnectionId")
				.field("resourceHandle.resourceProviderId", "resourceProviderId")
				.field("resourceHandle.resourceId", "resourceId")
				.field("resourceHandle.vimLevelResourceType", "vimLevelResourceType")
				.field("resourceHandle.vimLevelAdditionalResourceInfo", "vimLevelAdditionalResourceInfo")
				.field("resourceHandle.containerNamespace", "containerNamespace")
				.byDefault()
				.register();
		orikaMapperFactory.classMap(ExtManagedVirtualLinkInfo.class, ExtManagedVirtualLinkDataEntity.class)
				.field("networkResource.vimConnectionId", "vimConnectionId")
				.field("networkResource.resourceProviderId", "resourceProviderId")
				.field("networkResource.resourceId", "resourceId")
				.field("networkResource.vimLevelResourceType", "vimLevelResourceType")
				.field("networkResource.vimLevelAdditionalResourceInfo", "vimLevelAdditionalResourceInfo")
				.field("networkResource.containerNamespace", "containerNamespace")
				.byDefault()
				.register();
		orikaMapperFactory.classMap(AffectedVirtualStorage.class, VnfInstantiatedStorage.class)
				.field("storageResource.vimConnectionId", "vimConnectionInformation.vimId")
				.field("storageResource.resourceProviderId", "resourceProviderId")
				.field("storageResource.resourceId", "resourceId")
				.field("storageResource.vimLevelResourceType", "vimLevelResourceType")
				.byDefault()
				.register();
		orikaMapperFactory.classMap(VnfLcmOpOcc.class, VnfLcmOpOccs.class)
				.field("vnfInstanceId", "vnfInstance.id")
				.byDefault()
				.register();
		orikaMapperFactory.classMap(VnfcResourceInfo.class, VnfInstantiatedCompute.class)
				.field("computeResource.resourceId", "resourceId")
				.field("computeResource.resourceProviderId", "resourceProviderId")
				.field("computeResource.vimConnectionId", "vimConnectionInformation.vimId")
				.byDefault()
				.register();
		orikaMapperFactory.classMap(ResourceDefinition.class, GrantInformationExt.class)
				.field("id", "id")
				// .field("id", "resourceDefinitionId")
				.field("type", "type")
				.field("vduId", "vduId")
				.field("resource.vimConnectionId", "vimConnectionId")
				.field("resource.resourceProviderId", "resourceProviderId")
				.field("resource.vimLevelResourceType", "vimLevelResourceType")
				.field("resource.resourceId", "resourceId")
				.field("resource.resourceProviderId", "resourceProviderId")
				.field("resource.vimLevelAdditionalResourceInfo", "vimLevelAdditionalResourceInfo")
				.field("resource.containerNamespace", "containerNamespace")
				.byDefault()
				.register();
		/*
		 * Subscriptions.
		 */
		orikaMapperFactory.classMap(PkgmSubscriptionRequest.class, Subscription.class)
				.fieldMap("filter", "filters").converter("filterConverter").add()
				.field("authentication.paramsBasic", "authentication.authParamBasic")
				.field("authentication.paramsOauth2ClientCredentials", "authentication.authParamOauth2")
				.field("authentication.authType", "authentication.authType")
				.byDefault()
				.register();
		orikaMapperFactory.classMap(VnfIndicatorSubscriptionRequest.class, Subscription.class)
				.fieldMap("filter", "filters").converter("filterConverter").add()
				.field("authentication.paramsBasic", "authentication.authParamBasic")
				.field("authentication.paramsOauth2ClientCredentials", "authentication.authParamOauth2")
				.field("authentication.authType", "authentication.authType")
				.byDefault()
				.register();
		orikaMapperFactory.classMap(LccnSubscriptionRequest.class, Subscription.class)
				.fieldMap("filter", "filters").converter("filterConverter").add()
				.field("authentication.paramsBasic", "authentication.authParamBasic")
				.field("authentication.paramsOauth2ClientCredentials", "authentication.authParamOauth2")
				.field("authentication.authType", "authentication.authType")
				.byDefault()
				.register();
		orikaMapperFactory.classMap(FmSubscriptionRequest.class, Subscription.class)
				.fieldMap("filter", "filters").converter("filterConverter").add()
				.field("authentication.paramsBasic", "authentication.authParamBasic")
				.field("authentication.paramsOauth2ClientCredentials", "authentication.authParamOauth2")
				.field("authentication.authType", "authentication.authType")
				.byDefault()
				.register();
		orikaMapperFactory.classMap(FmSubscription.class, Subscription.class)
				.fieldMap("filter", "filters").converter("filterConverter").add()
				.byDefault()
				.register();
		orikaMapperFactory.classMap(LccnSubscription.class, Subscription.class)
				.fieldMap("filter", "filters").converter("filterConverter").add()
				.byDefault()
				.register();
		orikaMapperFactory.classMap(SubscriptionAuthentication.class, AuthentificationInformations.class)
				.field("paramsBasic", "authParamBasic")
				.field("paramsOauth2ClientCredentials", "authParamOauth2")
				.byDefault()
				.register();
		orikaMapperFactory.classMap(SubscriptionAuthenticationParamsOauth2ClientCredentials.class, AuthParamOauth2.class)
				.field("clientPassword", "clientSecret")
				.byDefault()
				.register();
		orikaMapperFactory.classMap(InstantiateVnfRequest.class, VnfInstantiate.class)
				.field("vimConnectionInfo{value}", "vimConnectionInfo")
				.byDefault()
				.register();
		/*
		 * Fault management.
		 */
		orikaMapperFactory.classMap(Alarm.class, Alarms.class)
				.field("isRootCause", "rootCause")
				.byDefault()
				.register();
		orikaMapperFactory.classMap(Grant.class, GrantResponse.class)
				.field("links.vnfInstance.href", "instanceLink")
				.field("links.vnfLcmOpOcc.href", "lcmLink")
				.field("vimConnectionInfo{key}", "vimConnections{vimId}")
				.field("vimConnectionInfo{value}", "vimConnections{}")
				.byDefault()
				.register();
	}

}