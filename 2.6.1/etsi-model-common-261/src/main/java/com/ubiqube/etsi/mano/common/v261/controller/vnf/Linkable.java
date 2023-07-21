package com.ubiqube.etsi.mano.common.v261.controller.vnf;

import java.util.UUID;

import javax.annotation.Nonnull;

import com.ubiqube.etsi.mano.common.v261.model.FrontApiTypesEnum;
import com.ubiqube.etsi.mano.common.v261.model.vnf.PkgmLinks;
import com.ubiqube.etsi.mano.common.v261.model.vnf.PkgmSubscriptionLinks;
import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfPkgInfoLinks;

/**
 * This is a technical interface for creating live links from VNF common
 * package.
 *
 * @author Olivier Vignaud <ovi@uniqube.com>
 *
 */
public interface Linkable {
	/**
	 * Create link for a VNF Package.
	 *
	 * @param vnfPkgId A Vnf ID.
	 * @return The VNF Packages Links object.
	 */
	VnfPkgInfoLinks getVnfLinks(@Nonnull String _vnfPkgId);

	PkgmLinks createNotificationLink(@Nonnull UUID _vnfPkgId, UUID _subscriptionId);

	PkgmLinks createVnfPackageOnboardingNotificationLinks(@Nonnull UUID _vnfPkgId, UUID _subscriptionId);

	PkgmSubscriptionLinks createSubscriptionsPkgmSubscriptionLinks(@Nonnull String _subscriptionId);

	FrontApiTypesEnum getApi();
}
