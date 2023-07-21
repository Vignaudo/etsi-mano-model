package com.ubiqube.etsi.mano.common.v261.model.vnf;

import java.time.OffsetDateTime;

public class VnfPkgChangeNotification {
	private String id = null;

	private String notificationType = null;

	private String subscriptionId = null;

	private OffsetDateTime timeStamp = null;

	private String vnfPkgId = null;

	private String vnfdId = null;

	private PackageChangeType changeType = null;

	private PackageOperationalStateType operationalState = null;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(final String notificationType) {
		this.notificationType = notificationType;
	}

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(final String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public OffsetDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(final OffsetDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getVnfPkgId() {
		return vnfPkgId;
	}

	public void setVnfPkgId(final String vnfPkgId) {
		this.vnfPkgId = vnfPkgId;
	}

	public String getVnfdId() {
		return vnfdId;
	}

	public void setVnfdId(final String vnfdId) {
		this.vnfdId = vnfdId;
	}

	public PackageChangeType getChangeType() {
		return changeType;
	}

	public void setChangeType(final PackageChangeType changeType) {
		this.changeType = changeType;
	}

	public PackageOperationalStateType getOperationalState() {
		return operationalState;
	}

	public void setOperationalState(final PackageOperationalStateType operationalState) {
		this.operationalState = operationalState;
	}

}
