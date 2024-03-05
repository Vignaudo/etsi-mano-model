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
/*
 * SOL003 - VNF Lifecycle Management interface
 * SOL003 - VNF Lifecycle Management interface definition  IMPORTANT: Please note that this file might be not aligned to the current version of the ETSI Group Specification it refers to. In case of discrepancies the published ETSI Group Specification takes precedence.  In clause 4.3.2 of ETSI GS NFV-SOL 003 v2.4.1, an attribute-based filtering mechanism is defined. This mechanism is currently not included in the corresponding OpenAPI design for this GS version. Changes to the attribute-based filtering mechanism are being considered in v2.5.1 of this GS for inclusion in the corresponding future ETSI NFV OpenAPI design. Please report bugs to https://forge.etsi.org/bugzilla/buglist.cgi?component=Nfv-Openapis&list_id=61&product=NFV&resolution=
 *
 * OpenAPI spec version: 1.1.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.ubiqube.etsi.mano.vnfm.v261.model.nslcm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.common.v261.model.VimConnectionInfo;
import com.ubiqube.etsi.mano.common.v261.model.nslcm.ExtManagedVirtualLinkData;
import com.ubiqube.etsi.mano.common.v261.model.nslcm.ExtVirtualLinkData;

import io.swagger.v3.oas.annotations.media.Schema;


/**
 * This type represents request parameters for the \&quot;Change VNF
 * flavour\&quot; operation.
 */
@Schema(description = "This type represents request parameters for the \"Change VNF flavour\" operation. ")

public class ChangeVnfFlavourRequest {
	@JsonProperty("newFlavourId")
	private String newFlavourId = null;

	@JsonProperty("instantiationLevelId")
	private String instantiationLevelId = null;

	@JsonProperty("extVirtualLinks")
	private List<ExtVirtualLinkData> extVirtualLinks = null;

	@JsonProperty("extManagedVirtualLinks")
	private List<ExtManagedVirtualLinkData> extManagedVirtualLinks = null;

	@JsonProperty("vimConnectionInfo")
	private List<VimConnectionInfo> vimConnectionInfo = null;

	@JsonProperty("additionalParams")
	private Map<String, String> additionalParams = null;

	public ChangeVnfFlavourRequest newFlavourId(final String newFlavourId) {
		this.newFlavourId = newFlavourId;
		return this;
	}

	/**
	 * Identifier of the VNF deployment flavour to be instantiated.
	 *
	 * @return newFlavourId
	 **/
	@JsonProperty("newFlavourId")
	@Schema(required = true, description = "Identifier of the VNF deployment flavour to be instantiated. ")
	@Nonnull
	public String getNewFlavourId() {
		return newFlavourId;
	}

	public void setNewFlavourId(final String newFlavourId) {
		this.newFlavourId = newFlavourId;
	}

	public ChangeVnfFlavourRequest instantiationLevelId(final String instantiationLevelId) {
		this.instantiationLevelId = instantiationLevelId;
		return this;
	}

	/**
	 * Identifier of the instantiation level of the deployment flavour to be
	 * instantiated. If not present, the default instantiation level as declared in
	 * the VNFD is instantiated.
	 *
	 * @return instantiationLevelId
	 **/
	@JsonProperty("instantiationLevelId")
	@Schema(description = "Identifier of the instantiation level of the deployment flavour to be instantiated. If not present, the default instantiation level as declared in the VNFD is instantiated. ")
	public String getInstantiationLevelId() {
		return instantiationLevelId;
	}

	public void setInstantiationLevelId(final String instantiationLevelId) {
		this.instantiationLevelId = instantiationLevelId;
	}

	public ChangeVnfFlavourRequest extVirtualLinks(final List<ExtVirtualLinkData> extVirtualLinks) {
		this.extVirtualLinks = extVirtualLinks;
		return this;
	}

	public ChangeVnfFlavourRequest addExtVirtualLinksItem(final ExtVirtualLinkData extVirtualLinksItem) {
		if (this.extVirtualLinks == null) {
			this.extVirtualLinks = new ArrayList<>();
		}
		this.extVirtualLinks.add(extVirtualLinksItem);
		return this;
	}

	/**
	 * Information about external VLs to connect the VNF to.
	 *
	 * @return extVirtualLinks
	 **/
	@JsonProperty("extVirtualLinks")
	@Schema(description = "Information about external VLs to connect the VNF to. ")
	public List<ExtVirtualLinkData> getExtVirtualLinks() {
		return extVirtualLinks;
	}

	public void setExtVirtualLinks(final List<ExtVirtualLinkData> extVirtualLinks) {
		this.extVirtualLinks = extVirtualLinks;
	}

	public ChangeVnfFlavourRequest extManagedVirtualLinks(final List<ExtManagedVirtualLinkData> extManagedVirtualLinks) {
		this.extManagedVirtualLinks = extManagedVirtualLinks;
		return this;
	}

	public ChangeVnfFlavourRequest addExtManagedVirtualLinksItem(final ExtManagedVirtualLinkData extManagedVirtualLinksItem) {
		if (this.extManagedVirtualLinks == null) {
			this.extManagedVirtualLinks = new ArrayList<>();
		}
		this.extManagedVirtualLinks.add(extManagedVirtualLinksItem);
		return this;
	}

	/**
	 * Information about internal VLs that are managed by the NFVO.
	 *
	 * @return extManagedVirtualLinks
	 **/
	@JsonProperty("extManagedVirtualLinks")
	@Schema(description = "Information about internal VLs that are managed by the NFVO. ")
	public List<ExtManagedVirtualLinkData> getExtManagedVirtualLinks() {
		return extManagedVirtualLinks;
	}

	public void setExtManagedVirtualLinks(final List<ExtManagedVirtualLinkData> extManagedVirtualLinks) {
		this.extManagedVirtualLinks = extManagedVirtualLinks;
	}

	public ChangeVnfFlavourRequest vimConnectionInfo(final List<VimConnectionInfo> vimConnectionInfo) {
		this.vimConnectionInfo = vimConnectionInfo;
		return this;
	}

	public ChangeVnfFlavourRequest addVimConnectionInfoItem(final VimConnectionInfo vimConnectionInfoItem) {
		if (this.vimConnectionInfo == null) {
			this.vimConnectionInfo = new ArrayList<>();
		}
		this.vimConnectionInfo.add(vimConnectionInfoItem);
		return this;
	}

	/**
	 * Information about VIM connections to be used for managing the resources for
	 * the VNF instance, or refer to external / externally-managed virtual links.
	 * This attribute shall only be supported and may be present if VNF-related
	 * resource management in direct mode is applicable.
	 *
	 * @return vimConnectionInfo
	 **/
	@JsonProperty("vimConnectionInfo")
	@Schema(description = "Information about VIM connections to be used for managing the resources for the VNF instance, or refer to external / externally-managed virtual links. This attribute shall only be supported and may be present if VNF-related resource management in direct mode is applicable. ")
	public List<VimConnectionInfo> getVimConnectionInfo() {
		return vimConnectionInfo;
	}

	public void setVimConnectionInfo(final List<VimConnectionInfo> vimConnectionInfo) {
		this.vimConnectionInfo = vimConnectionInfo;
	}

	public ChangeVnfFlavourRequest additionalParams(final Map<String, String> additionalParams) {
		this.additionalParams = additionalParams;
		return this;
	}

	/**
	 * Additional input parameters for the instantiation process, specific to the
	 * VNF being instantiated, as declared in the VNFD as part of
	 * \&quot;InstantiateVnfOpConfig\&quot;.
	 *
	 * @return additionalParams
	 **/
	@JsonProperty("additionalParams")
	@Schema(description = "Additional input parameters for the instantiation process, specific to the VNF being instantiated, as declared in the VNFD as part of  \"InstantiateVnfOpConfig\". ")
	public Map<String, String> getAdditionalParams() {
		return additionalParams;
	}

	public void setAdditionalParams(final Map<String, String> additionalParams) {
		this.additionalParams = additionalParams;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class ChangeVnfFlavourRequest {\n");

		sb.append("    newFlavourId: ").append(toIndentedString(newFlavourId)).append("\n");
		sb.append("    instantiationLevelId: ").append(toIndentedString(instantiationLevelId)).append("\n");
		sb.append("    extVirtualLinks: ").append(toIndentedString(extVirtualLinks)).append("\n");
		sb.append("    extManagedVirtualLinks: ").append(toIndentedString(extManagedVirtualLinks)).append("\n");
		sb.append("    vimConnectionInfo: ").append(toIndentedString(vimConnectionInfo)).append("\n");
		sb.append("    additionalParams: ").append(toIndentedString(additionalParams)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(final java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
