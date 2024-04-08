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
package com.ubiqube.etsi.mano.nfvo.v431.controller.nsfm;

import static com.ubiqube.etsi.mano.Constants.getSafeUUID;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.nsfm.NsAlarmFrontController;
import com.ubiqube.etsi.mano.dao.mano.alarm.AckState;
import com.ubiqube.etsi.mano.em.v431.model.vnffm.Alarm;
import com.ubiqube.etsi.mano.em.v431.model.vnffm.AlarmLinks;
import com.ubiqube.etsi.mano.em.v431.model.vnffm.AlarmModifications;
import com.ubiqube.etsi.mano.em.v431.model.vnflcm.Link;

import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import ma.glasnost.orika.MapperFacade;

@RestController
public class Alarms431Sol005Controller implements Alarms431Sol005Api {
	private final NsAlarmFrontController nsAlarmFrontController;
	private final MapperFacade mapper;

	public Alarms431Sol005Controller(final NsAlarmFrontController nsAlarmFrontController, final MapperFacade mapper) {
		this.nsAlarmFrontController = nsAlarmFrontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<Alarm> alarmsAlarmIdGet(final String alarmId) {
		return nsAlarmFrontController.findById(getSafeUUID(alarmId), x -> mapper.map(x, Alarm.class), Alarms431Sol005Controller::makeLinks);
	}

	@Override
	public ResponseEntity<AlarmModifications> alarmsAlarmIdPatch(final String alarmId, @Valid final AlarmModifications body, final String ifMatch) {
		return nsAlarmFrontController.patch(alarmId, AckState.valueOf(body.getAckState().toString()), ifMatch, x -> mapper.map(x, AlarmModifications.class));
	}

	@Override
	public ResponseEntity<String> alarmsGet(final MultiValueMap<String, String> requestParams, @Nullable final String nextpageOpaqueMarker) {
		return nsAlarmFrontController.search(requestParams, nextpageOpaqueMarker, Alarm.class, Alarms431Sol005Controller::makeLinks);
	}

	private static void makeLinks(final Alarm alarm) {
		final AlarmLinks links = new AlarmLinks();
		final Link self = new Link();
		self.setHref(linkTo(methodOn(Alarms431Sol005Api.class).alarmsAlarmIdGet(alarm.getId())).withSelfRel().getHref());
		links.setSelf(self);
		alarm.setLinks(links);
	}

}
