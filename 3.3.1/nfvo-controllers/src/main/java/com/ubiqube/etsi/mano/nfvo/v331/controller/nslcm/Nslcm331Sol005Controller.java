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
package com.ubiqube.etsi.mano.nfvo.v331.controller.nslcm;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.nslcm.NsLcmGenericFrontController;
import com.ubiqube.etsi.mano.em.v331.model.vnflcm.Link;
import com.ubiqube.etsi.mano.nfvo.v331.model.nslcm.CancelMode;
import com.ubiqube.etsi.mano.nfvo.v331.model.nslcm.NsLcmOpOcc;
import com.ubiqube.etsi.mano.nfvo.v331.model.nslcm.NsLcmOpOccLinks;

@RestController
public class Nslcm331Sol005Controller implements Nslcm331Sol005Api {
	private final NsLcmGenericFrontController nsLcmGenericFrontController;

	public Nslcm331Sol005Controller(final NsLcmGenericFrontController nsLcmGenericFrontController) {
		super();
		this.nsLcmGenericFrontController = nsLcmGenericFrontController;
	}

	@Override
	public ResponseEntity<Void> nslcmV1NsLcmOpOccsNsLcmOpOccIdCancelPost(final String nsLcmOpOccId, @Valid final CancelMode body) {
		return nsLcmGenericFrontController.cancel(nsLcmOpOccId, body.getCancelMode().toString());
	}

	@Override
	public ResponseEntity<NsLcmOpOcc> nslcmV1NsLcmOpOccsNsLcmOpOccIdFailPost(final String nsLcmOpOccId) {
		return nsLcmGenericFrontController.fail(nsLcmOpOccId, NsLcmOpOcc.class, Nslcm331Sol005Controller::makeLinks);
	}

	public static void makeLinks(@NotNull final NsLcmOpOcc nsLcmOpOccs) {
		@NotNull
		final String id = nsLcmOpOccs.getId().toString();
		final NsLcmOpOccLinks nsLcmOpOccLinks = new NsLcmOpOccLinks();

		final Link _continue = new Link();
		_continue.setHref(linkTo(methodOn(NsLcmOpOccs331Sol005Api.class).nsLcmOpOccsNsLcmOpOccIdContinuePost(id)).withSelfRel().getHref());
		nsLcmOpOccLinks.setContinue(_continue);

		final Link nsInstance = new Link();
		nsInstance.setHref(linkTo(methodOn(NsInstances331Sol005Api.class).nsInstancesNsInstanceIdGet(nsLcmOpOccs.getNsInstanceId().toString())).withSelfRel().getHref());
		nsLcmOpOccLinks.setNsInstance(nsInstance);

		final Link retry = new Link();
		retry.setHref(linkTo(methodOn(NsLcmOpOccs331Sol005Api.class).nsLcmOpOccsNsLcmOpOccIdRetryPost(id)).withSelfRel().getHref());
		nsLcmOpOccLinks.setRetry(retry);

		final Link rollback = new Link();
		rollback.setHref(linkTo(methodOn(NsLcmOpOccs331Sol005Api.class).nsLcmOpOccsNsLcmOpOccIdRollbackPost(id)).withSelfRel().getHref());
		nsLcmOpOccLinks.setRollback(rollback);

		final Link self = new Link();
		self.setHref(linkTo(methodOn(NsLcmOpOccs331Sol005Api.class).nsLcmOpOccsNsLcmOpOccIdGet(id)).withSelfRel().getHref());
		nsLcmOpOccLinks.setSelf(self);
		nsLcmOpOccs.setLinks(nsLcmOpOccLinks);
	}

}
