package com.ubiqube.etsi.mano.nfvo.v331.controller.vnf;

import static com.ubiqube.etsi.mano.Constants.getSafeUUID;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ubiqube.etsi.mano.controller.vnf.VnfPackageFrontController;
import com.ubiqube.etsi.mano.nfvo.v331.model.vnf.CreateVnfPkgInfoRequest;
import com.ubiqube.etsi.mano.nfvo.v331.model.vnf.ExternalArtifactsAccessConfig;
import com.ubiqube.etsi.mano.nfvo.v331.model.vnf.UploadVnfPkgFromUriRequest;
import com.ubiqube.etsi.mano.nfvo.v331.model.vnf.VnfPkgInfo;

/**
 *
 * @author Olivier Vignaud <ovi@ubiqube.com>
 *
 */
@RestController
public class VnfPackages331Sol005Controller implements VnfPackages331Sol005Api {
	private final VnfPackageFrontController frontController;

	public VnfPackages331Sol005Controller(final VnfPackageFrontController frontController) {
		super();
		this.frontController = frontController;
	}

	@Override
	public ResponseEntity<String> vnfPackagesGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return frontController.search(requestParams, VnfPkgInfo.class, VnfPackages331Sol005Controller::makeLinks);
	}

	@Override
	public ResponseEntity<VnfPkgInfo> vnfPackagesPost(@Valid final CreateVnfPkgInfoRequest body) {
		return frontController.create(body.getUserDefinedData(), VnfPkgInfo.class, VnfPackages331Sol005Controller::makeLinks, null);
	}

	@Override
	public ResponseEntity<List<ResourceRegion>> vnfPackagesVnfPkgIdArtifactsArtifactPathGet(final String vnfPkgId, final HttpServletRequest requestParams, final String range, @Valid final String includeSignatures) {
		return frontController.getArtifact(requestParams, getSafeUUID(vnfPkgId), range, includeSignatures);
	}

	@Override
	public ResponseEntity<Void> vnfPackagesVnfPkgIdArtifactsGet(final String vnfPkgId, final String range, final String includeSignatures, final String excludeAllManoArtifacts, final String excludeAllNonManoArtifacts, final String selectNonManoArtifactSets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> vnfPackagesVnfPkgIdDelete(final String vnfPkgId) {
		return frontController.deleteById(getSafeUUID(vnfPkgId));
	}

	@Override
	public ResponseEntity<ExternalArtifactsAccessConfig> vnfPackagesVnfPkgIdExtArtifactsAccessGet(final String vnfPkgId) {
		return frontController.getExternalArtifacts(getSafeUUID(vnfPkgId));
	}

	@Override
	public ResponseEntity<ExternalArtifactsAccessConfig> vnfPackagesVnfPkgIdExtArtifactsAccessPut(@Valid final ExternalArtifactsAccessConfig body, final String vnfPkgId) {
		return frontController.putExternalArtifact(body, getSafeUUID(vnfPkgId));
	}

	@Override
	public ResponseEntity<VnfPkgInfo> vnfPackagesVnfPkgIdGet(final String vnfPkgId) {
		return frontController.findById(getSafeUUID(vnfPkgId), null, VnfPkgInfo.class, VnfPackages331Sol005Controller::makeLinks);
	}

	@Override
	public ResponseEntity<Void> vnfPackagesVnfPkgIdManifestGet(final String vnfPkgId, @Valid final String includeSignatures) {
		return frontController.getManifest(getSafeUUID(vnfPkgId), includeSignatures);
	}

	@Override
	public ResponseEntity<List<ResourceRegion>> vnfPackagesVnfPkgIdPackageContentGet(final String vnfPkgId, final String range) {
		return frontController.getContent(getSafeUUID(vnfPkgId), range);
	}

	@Override
	public ResponseEntity<Void> vnfPackagesVnfPkgIdPackageContentPut(@Valid final MultipartFile file, final String accept, final String vnfPkgId) {
		return frontController.putContent(getSafeUUID(vnfPkgId), accept, file);
	}

	@Override
	public ResponseEntity<Void> vnfPackagesVnfPkgIdPackageContentUploadFromUriPost(@Valid final UploadVnfPkgFromUriRequest body, final String vnfPkgId, final String accept) {
		return frontController.uploadFromUri(body, getSafeUUID(vnfPkgId), accept);
	}

	@Override
	public ResponseEntity<VnfPkgInfo> vnfPackagesVnfPkgIdPatch(@Valid final String body, final String vnfPkgId) {
		return frontController.modify(body, getSafeUUID(vnfPkgId), VnfPkgInfo.class, VnfPackages331Sol005Controller::makeLinks);
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdVnfdGet(final String vnfPkgId, @Valid final String includeSignatures) {
		return frontController.getVfnd(getSafeUUID(vnfPkgId), includeSignatures);
	}

	private static void makeLinks(final VnfPkgInfo vnfPackage) {

	}
}
