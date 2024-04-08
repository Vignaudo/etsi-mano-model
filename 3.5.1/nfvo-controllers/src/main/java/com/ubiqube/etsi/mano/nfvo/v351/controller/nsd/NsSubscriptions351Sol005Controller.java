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
package com.ubiqube.etsi.mano.nfvo.v351.controller.nsd;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.nsd.NsdSubscriptionFrontController;
import com.ubiqube.etsi.mano.controller.subscription.ApiAndType;
import com.ubiqube.etsi.mano.dao.subscription.SubscriptionType;
import com.ubiqube.etsi.mano.em.v351.model.lcmcoord.Link;
import com.ubiqube.etsi.mano.nfvo.v351.model.nsd.NsdmSubscription;
import com.ubiqube.etsi.mano.nfvo.v351.model.nsd.NsdmSubscriptionLinks;
import com.ubiqube.etsi.mano.nfvo.v351.model.nsd.NsdmSubscriptionRequest;
import com.ubiqube.etsi.mano.service.auth.model.ApiTypesEnum;
import com.ubiqube.etsi.mano.service.event.model.Subscription;
import com.ubiqube.etsi.mano.vnfm.v351service.SubscriptionLinkable351Nfvo;

import jakarta.validation.constraints.NotNull;
import ma.glasnost.orika.MapperFacade;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
public class NsSubscriptions351Sol005Controller implements NsSubscriptions351Sol005Api, SubscriptionLinkable351Nfvo {
	private final NsdSubscriptionFrontController nsdSubscriptionFrontController;
	private final MapperFacade mapper;

	public NsSubscriptions351Sol005Controller(final NsdSubscriptionFrontController nsdSubscriptionFrontController, final MapperFacade mapper) {
		this.nsdSubscriptionFrontController = nsdSubscriptionFrontController;
		this.mapper = mapper;
	}

	/**
	 * Query multiple subscriptions.
	 *
	 * The GET method queries the list of active subscriptions of the functional
	 * block that invokes the method. It can be used e.g. for resynchronization
	 * after error situations. This method shall support the URI query parameters,
	 * request and response data structures, and response codes. This resource
	 * represents subscriptions. The client can use this resource to subscribe to
	 * notifications related to NSD management and to query its subscriptions.
	 *
	 */
	@Override
	public ResponseEntity<List<NsdmSubscription>> subscriptionsGet(final MultiValueMap<String, String> requestParams, final String nextpageOpaqueMarker) {
		return nsdSubscriptionFrontController.search(requestParams, NsdmSubscription.class, NsSubscriptions351Sol005Controller::makeLink);
	}

	/**
	 * Subscribe to NSD and PNFD change notifications.
	 *
	 * The POST method creates a new subscription. This method shall support the URI
	 * query parameters, request and response data structures, and response codes,
	 * as specified in the Tables 5.4.8.3.1-1 and 5.4.8.3.1-2 of GS-NFV SOL 005.
	 * Creation of two subscription resources with the same callbackURI and the same
	 * filter can result in performance degradation and will provide duplicates of
	 * notifications to the OSS, and might make sense only in very rare use cases.
	 * Consequently, the NFVO may either allow creating a subscription resource if
	 * another subscription resource with the same filter and callbackUri already
	 * exists (in which case it shall return the \&quot;201 Created\&quot; response
	 * code), or may decide to not create a duplicate subscription resource (in
	 * which case it shall return a \&quot;303 See Other\&quot; response code
	 * referencing the existing subscription resource with the same filter and
	 * callbackUri). This resource represents subscriptions. The client can use this
	 * resource to subscribe to notifications related to NSD management and to query
	 * its subscriptions.
	 *
	 */
	@Override
	public ResponseEntity<NsdmSubscription> subscriptionsPost(final NsdmSubscriptionRequest body) {
		final Subscription req = mapper.map(body, Subscription.class);
		return nsdSubscriptionFrontController.create(req, x -> mapper.map(x, NsdmSubscription.class), NsSubscriptions351Sol005Api.class, NsSubscriptions351Sol005Controller::makeLink, NsSubscriptions351Sol005Controller::getSelfLink);
	}

	/**
	 * Terminate Subscription
	 *
	 * This resource represents an individual subscription. It can be used by the
	 * client to read and to terminate a subscription to notifications related to
	 * NSD management. The DELETE method terminates an individual subscription. This
	 * method shall support the URI query parameters, request and response data
	 * structures, and response codes, as specified in the Table 5.4.9.3.3-2.
	 *
	 */
	@Override
	public ResponseEntity<Void> subscriptionsSubscriptionIdDelete(final String subscriptionId) {
		return nsdSubscriptionFrontController.delete(subscriptionId);
	}

	/**
	 * Read an individual subscription resource.
	 *
	 * This resource represents an individual subscription. It can be used by the
	 * client to read and to terminate a subscription to notifications related to
	 * NSD management. The GET method retrieves information about a subscription by
	 * reading an individual subscription resource. This resource represents an
	 * individual subscription. It can be used by the client to read and to
	 * terminate a subscription to notifications related to NSD management.
	 *
	 */
	@Override
	public ResponseEntity<NsdmSubscription> subscriptionsSubscriptionIdGet(final String subscriptionId) {
		return nsdSubscriptionFrontController.findById(subscriptionId, NsdmSubscription.class, NsSubscriptions351Sol005Controller::makeLink);
	}

	private static void makeLink(@NotNull final NsdmSubscription subs) {
		final NsdmSubscriptionLinks nsdmSubscriptionLinks = new NsdmSubscriptionLinks();
		final Link self = new Link();
		self.setHref(linkTo(methodOn(NsSubscriptions351Sol005Api.class).subscriptionsSubscriptionIdGet(subs.getId())).withSelfRel().getHref());
		nsdmSubscriptionLinks.setSelf(self);
	}

	private static String getSelfLink(@NotNull final NsdmSubscription subs) {
		return linkTo(methodOn(NsSubscriptions351Sol005Api.class).subscriptionsSubscriptionIdGet(subs.getId())).withSelfRel().getHref();
	}

	@Override
	public String makeSelfLink(final String id) {
		return linkTo(methodOn(NsSubscriptions351Sol005Api.class).subscriptionsSubscriptionIdGet(id)).withSelfRel().getHref();
	}

	@Override
	public ApiAndType getApiAndType() {
		return ApiAndType.of(ApiTypesEnum.SOL005, SubscriptionType.NSD);
	}

}
