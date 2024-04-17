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
package com.ubiqube.etsi.mano.v451.vnfm.controller.vnfm.vnflcm;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v451.model.em.vnflcm.CreateVnfSnapshotInfoRequest;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VnfSnapshotInfo;
import com.ubiqube.etsi.mano.v451.model.vnfm.vnflcm.VnfSnapshotInfoModificationRequest;
import com.ubiqube.etsi.mano.v451.model.vnfm.vnflcm.VnfSnapshotInfoModifications;

import jakarta.validation.Valid;

@RestController
public class VnfSnapshots451Sol003Controller implements VnfSnapshots451Sol003Api {

	@Override
	public ResponseEntity<List<VnfSnapshotInfo>> vnfSnapshotsGet(@Valid final String filter, @Valid final String allFields, @Valid final String fields, @Valid final String excludeFields, @Valid final String excludeDefault, @Valid final String nextpageOpaqueMarker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<VnfSnapshotInfo> vnfSnapshotsPost(final CreateVnfSnapshotInfoRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> vnfSnapshotsVnfSnapshotInfoIdDelete(final String vnfSnapshotInfoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<VnfSnapshotInfo>> vnfSnapshotsVnfSnapshotInfoIdGet(final String vnfSnapshotInfoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<VnfSnapshotInfoModifications> vnfSnapshotsVnfSnapshotInfoIdPatch(final String vnfSnapshotInfoId, @Valid final VnfSnapshotInfoModificationRequest body, final OffsetDateTime ifUnmodifiedSince, final String ifMatch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Resource> vnfSnapshotsVnfSnapshotInfoIdVnfStateSnapshotGet(final String vnfSnapshotInfoId) {
		// TODO Auto-generated method stub
		return null;
	}

}