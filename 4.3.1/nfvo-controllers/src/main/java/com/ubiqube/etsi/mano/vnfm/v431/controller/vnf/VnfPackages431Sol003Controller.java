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
package com.ubiqube.etsi.mano.vnfm.v431.controller.vnf;

import static com.ubiqube.etsi.mano.nfvo.fc.controller.NfvoConstants.getSafeUUID;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.vnf.VnfPackageFrontController;
import com.ubiqube.etsi.mano.nfvo.v431.service.LinksSol003;
import com.ubiqube.etsi.mano.vnfm.v431.model.vnf.VnfPkgInfo;

@RestController
public class VnfPackages431Sol003Controller implements VnfPackages431Sol003Api {

	private final VnfPackageFrontController frontController;

	public VnfPackages431Sol003Controller(final VnfPackageFrontController frontController) {
		this.frontController = frontController;
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdArtifactsArtifactPathGet(final HttpServletRequest request, final String vnfPkgId, @Valid final String includeSignature) {
		return frontController.getArtifactPath(request, getSafeUUID(vnfPkgId), includeSignature);
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdArtifactsGet(final HttpServletRequest request, final String vnfPkgId, final String excludeAllManoArtifacts,
			final String excludeAllNonManoArtifacts, final String includeExternalArtifacts, final String selectNonManoArtifactSets, final String includeSignatures) {
		return frontController.getSelectArtifacts(request, getSafeUUID(vnfPkgId));
	}

	@Override
	public ResponseEntity<VnfPkgInfo> vnfPackagesVnfPkgIdGet(final String vnfPkgId) {
		return frontController.findByIdReadOnly(getSafeUUID(vnfPkgId), VnfPkgInfo.class, LinksSol003::makeLinks);
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdManifestGet(final String vnfPkgId, @Valid final String includeSignature) {
		return frontController.getManifest(getSafeUUID(vnfPkgId), includeSignature);
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdPackageContentGet(final String vnfPkgId) {
		return frontController.getContent(getSafeUUID(vnfPkgId));
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdVnfdGet(final String vnfPkgId, @Valid final String includeSignature) {
		return frontController.getVfnd(getSafeUUID(vnfPkgId), null, includeSignature);
	}

	@Override
	public ResponseEntity<String> vnfPackagesGet(final MultiValueMap<String, String> requestParams, final String nextpageOpaqueMarker) {
		return frontController.search(requestParams, VnfPkgInfo.class, LinksSol003::makeLinks);
	}

}
