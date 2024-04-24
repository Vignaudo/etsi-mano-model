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
package com.ubiqube.etsi.mano.v261.vnfm.controller.vnfpm.sol002;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.common.v261.model.Link;
import com.ubiqube.etsi.mano.common.v261.model.nsperfo.PerformanceReport;
import com.ubiqube.etsi.mano.v261.vnfm.nsperfo.CreatePmJobRequest;
import com.ubiqube.etsi.mano.v261.vnfm.nsperfo.PmJob;
import com.ubiqube.etsi.mano.v261.vnfm.nsperfo.PmJobLinks;
import com.ubiqube.etsi.mano.vnfm.fc.vnfpm.VnfmPmGenericFrontController;

import jakarta.validation.Valid;
import ma.glasnost.orika.MapperFacade;

/**
 *
 * @author Olivier Vignaud {@literal {@literal <ovi@ubiqube.com>}}
 *
 */
@RestController
public class PmJobs261Sol002Controller implements PmJobs261Sol002Api {
	private final VnfmPmGenericFrontController vnfmPmGenericFrontController;
	private final MapperFacade mapper;

	public PmJobs261Sol002Controller(final VnfmPmGenericFrontController vnfmPmGenericFrontController, final MapperFacade mapper) {
		this.vnfmPmGenericFrontController = vnfmPmGenericFrontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<String> pmJobsGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return vnfmPmGenericFrontController.search(requestParams, x -> mapper.map(x, PmJob.class), PmJobs261Sol002Controller::makeLinks, PmJob.class);
	}

	@Override
	public ResponseEntity<Void> pmJobsPmJobIdDelete(final String pmJobId) {
		return vnfmPmGenericFrontController.deleteById(UUID.fromString(pmJobId));
	}

	@Override
	public ResponseEntity<PmJob> pmJobsPmJobIdGet(final String pmJobId) {
		return vnfmPmGenericFrontController.findById(UUID.fromString(pmJobId), x -> mapper.map(x, PmJob.class), PmJobs261Sol002Controller::makeLinks);
	}

	@Override
	public ResponseEntity<PerformanceReport> pmJobsPmJobIdReportsReportIdGet(final String pmJobId, final String reportId) {
		return vnfmPmGenericFrontController.findReportById(pmJobId, reportId, x -> mapper.map(x, PerformanceReport.class));
	}

	@Override
	public ResponseEntity<PmJob> pmJobsPost(@Valid final CreatePmJobRequest createPmJobRequest) {
		final com.ubiqube.etsi.mano.dao.mano.pm.PmJob req = mapper.map(createPmJobRequest, com.ubiqube.etsi.mano.dao.mano.pm.PmJob.class);
		return vnfmPmGenericFrontController.pmJobsPost(req, x -> mapper.map(x, PmJob.class), PmJobs261Sol002Controller::makeLinks, PmJobs261Sol002Controller::makeSelf);
	}

	private static String makeSelf(final PmJob x) {
		return linkTo(methodOn(PmJobs261Sol002Api.class).pmJobsPmJobIdGet(x.getId())).withSelfRel().getHref();
	}

	private static void makeLinks(final PmJob x) {
		final PmJobLinks links = new PmJobLinks();
		Link link = new Link();
		link.setHref(linkTo(methodOn(PmJobs261Sol002Api.class).pmJobsPmJobIdGet(x.getId())).withSelfRel().getHref());
		links.setSelf(link);

		link = new Link();
		link.setHref("");
		// links.setObjects(link);

		x.setLinks(links);
	}

}