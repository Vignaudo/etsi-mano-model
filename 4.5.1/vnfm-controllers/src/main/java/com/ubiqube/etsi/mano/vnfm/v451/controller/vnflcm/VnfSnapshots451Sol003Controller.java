package com.ubiqube.etsi.mano.vnfm.v451.controller.vnflcm;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.em.v451.model.vnflcm.CreateVnfSnapshotInfoRequest;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.VnfSnapshotInfo;
import com.ubiqube.etsi.mano.vnfm.v451.model.vnflcm.VnfSnapshotInfoModificationRequest;
import com.ubiqube.etsi.mano.vnfm.v451.model.vnflcm.VnfSnapshotInfoModifications;

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