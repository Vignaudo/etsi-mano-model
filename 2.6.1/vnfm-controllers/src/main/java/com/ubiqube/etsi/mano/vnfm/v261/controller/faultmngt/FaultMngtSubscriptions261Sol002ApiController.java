/**
 *     Copyright (C) 2019-2020 Ubiqube.
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
package com.ubiqube.etsi.mano.vnfm.v261.controller.faultmngt;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.ubiqube.etsi.mano.vnfm.v261.model.faultmngt.FmSubscription;
import com.ubiqube.etsi.mano.vnfm.v261.model.faultmngt.FmSubscriptionRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-11T18:11:39.646+01:00")

@Controller
public class FaultMngtSubscriptions261Sol002ApiController implements FaultmngtSubscriptions261Sol002Api {

	@Override
	public ResponseEntity<FmSubscription> subscriptionsGet(final String version, final String accept, final String contentType, final String authorization, @Valid final String filter, @Valid final String nextpageOpaqueMarker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<FmSubscription> subscriptionsPost(final String version, @Valid final FmSubscriptionRequest fmSubscriptionRequest, final String accept, final String contentType, final String authorization) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> subscriptionsSubscriptionIdDelete(final String subscriptionId, final String version, final String authorization) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<FmSubscription> subscriptionsSubscriptionIdGet(final String subscriptionId, final String version, final String accept, final String contentType, final String authorization) {
		// TODO Auto-generated method stub
		return null;
	}

}
