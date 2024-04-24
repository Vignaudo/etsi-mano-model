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
 *     along with this program.  If not, see https://www.gnu.org/licenses/.
 */
package com.ubiqube.etsi.mano.v261.service.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;

import com.ubiqube.etsi.mano.common.v261.model.vnf.Checksum;
import com.ubiqube.etsi.mano.dao.mano.OnboardingStateType;
import com.ubiqube.etsi.mano.dao.mano.PnfDescriptor;
import com.ubiqube.etsi.mano.service.mapping.StringToUriMapping;
import com.ubiqube.etsi.mano.v261.model.nfvo.nsd.sol005.PnfdInfo;
import com.ubiqube.etsi.mano.v261.model.nfvo.nsd.sol005.PnfdOnboardingStateType;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface Pnfd261Mapping extends StringToUriMapping {

	@Mapping(target = "links", ignore = true)
	PnfdInfo map(PnfDescriptor o);

	@ValueMapping(source = "ERROR", target = "CREATED")
	@ValueMapping(source = "ONBOARDED", target = "ONBOARDING")
	PnfdOnboardingStateType map(OnboardingStateType o);

	@ValueMapping(source = "ONBOARDING", target = "ONBOARDED")
	OnboardingStateType map(PnfdOnboardingStateType o);

	@Mapping(target = "archiveSecurityOption", ignore = true)
	@Mapping(target = "artifacts", ignore = true)
	@Mapping(target = "signingCertificate", ignore = true)
	@Mapping(target = "pnfdExtInvariantId", ignore = true)
	@Mapping(target = "virtualLink", ignore = true)
	PnfDescriptor map(PnfdInfo o);

	@Mapping(target = "md5", ignore = true)
	@Mapping(target = "sha256", ignore = true)
	@Mapping(target = "sha512", ignore = true)
	com.ubiqube.etsi.mano.dao.mano.vim.Checksum map(Checksum o);

}