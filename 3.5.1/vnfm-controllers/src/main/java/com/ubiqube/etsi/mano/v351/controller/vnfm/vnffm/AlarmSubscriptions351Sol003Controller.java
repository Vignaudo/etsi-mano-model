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
package com.ubiqube.etsi.mano.v351.controller.vnfm.vnffm;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.subscription.ApiAndType;
import com.ubiqube.etsi.mano.dao.subscription.SubscriptionType;
import com.ubiqube.etsi.mano.service.auth.model.ApiTypesEnum;
import com.ubiqube.etsi.mano.service.event.model.Subscription;
import com.ubiqube.etsi.mano.v351.model.em.lcmcoord.Link;
import com.ubiqube.etsi.mano.v351.model.em.vnffm.FmNotificationsFilter;
import com.ubiqube.etsi.mano.v351.model.em.vnffm.FmSubscription;
import com.ubiqube.etsi.mano.v351.model.em.vnffm.FmSubscriptionLinks;
import com.ubiqube.etsi.mano.v351.model.em.vnffm.FmSubscriptionRequest;
import com.ubiqube.etsi.mano.v351.services.SubscriptionLinkable351Vnfm;
import com.ubiqube.etsi.mano.v351.services.mapping.subscription.FmSubscription351Mapping;
import com.ubiqube.etsi.mano.vnfm.fc.vnffm.FaultMngtSubscriptionsFrontController;

import jakarta.validation.Valid;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@ConditionalOnMissingClass("com.ubiqube.etsi.mano.vnfm.v331.controller.vnffm.VnfFmSubscriptions331Sol003Api")
@RestController
public class AlarmSubscriptions351Sol003Controller implements AlarmSubscriptions351Sol003Api, SubscriptionLinkable351Vnfm {
	private final FaultMngtSubscriptionsFrontController faultMngtSubscriptionsFrontController;
	private final FmSubscription351Mapping mapper;

	public AlarmSubscriptions351Sol003Controller(final FaultMngtSubscriptionsFrontController faultMngtSubscriptionsFrontController, final FmSubscription351Mapping mapper) {
		this.faultMngtSubscriptionsFrontController = faultMngtSubscriptionsFrontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<List<FmSubscription>> subscriptionsGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return faultMngtSubscriptionsFrontController.search(requestParams, x -> mapper.map(x, FmNotificationsFilter.class), AlarmSubscriptions351Sol003Controller::makeLinks);
	}

	@Override
	public ResponseEntity<FmSubscription> subscriptionsPost(@Valid final FmSubscriptionRequest body) {
		final Subscription req = mapper.map(body);
		return faultMngtSubscriptionsFrontController.create(req, x -> mapper.map(x, FmNotificationsFilter.class), AlarmSubscriptions351Sol003Api.class, AlarmSubscriptions351Sol003Controller::makeLinks, AlarmSubscriptions351Sol003Controller::makeSelf);
	}

	@Override
	public ResponseEntity<Void> subscriptionsSubscriptionIdDelete(final String subscriptionId) {
		return faultMngtSubscriptionsFrontController.delete(subscriptionId);
	}

	@Override
	public ResponseEntity<FmSubscription> subscriptionsSubscriptionIdGet(final String subscriptionId) {
		return faultMngtSubscriptionsFrontController.findById(subscriptionId, x -> mapper.map(x, FmNotificationsFilter.class), AlarmSubscriptions351Sol003Controller::makeLinks);
	}

	private static void makeLinks(final FmSubscription subscription) {
		final FmSubscriptionLinks links = new FmSubscriptionLinks();
		final Link link = new Link();
		link.setHref(linkTo(methodOn(AlarmSubscriptions351Sol003Api.class).subscriptionsSubscriptionIdGet(subscription.getId())).withSelfRel().getHref());
		links.setSelf(link);
		subscription.setLinks(links);
	}

	private static String makeSelf(final FmSubscription subscription) {
		return linkTo(methodOn(AlarmSubscriptions351Sol003Api.class).subscriptionsSubscriptionIdGet(subscription.getId())).withSelfRel().getHref();
	}

	@Override
	public String makeSelfLink(final String id) {
		return linkTo(methodOn(AlarmSubscriptions351Sol003Api.class).subscriptionsSubscriptionIdGet(id)).withSelfRel().getHref();
	}

	@Override
	public ApiAndType getApiAndType() {
		return ApiAndType.of(ApiTypesEnum.SOL003, SubscriptionType.VNFFM);
	}

}
