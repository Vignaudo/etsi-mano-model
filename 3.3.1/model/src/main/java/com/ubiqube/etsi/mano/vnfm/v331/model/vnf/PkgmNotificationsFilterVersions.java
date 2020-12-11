package com.ubiqube.etsi.mano.vnfm.v331.model.vnf;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * PkgmNotificationsFilterVersions
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-06-19T11:42:02.797+02:00")

public class PkgmNotificationsFilterVersions {
	@JsonProperty("vnfSoftwareVersion")
	private String vnfSoftwareVersion = null;

	@JsonProperty("vnfdVersions")
	@Valid
	private List<String> vnfdVersions = null;

	public PkgmNotificationsFilterVersions vnfSoftwareVersion(final String vnfSoftwareVersion) {
		this.vnfSoftwareVersion = vnfSoftwareVersion;
		return this;
	}

	/**
	 * VNF software version to match.
	 * 
	 * @return vnfSoftwareVersion
	 **/
	@ApiModelProperty(required = true, value = "VNF software version to match. ")
	@NotNull

	public String getVnfSoftwareVersion() {
		return vnfSoftwareVersion;
	}

	public void setVnfSoftwareVersion(final String vnfSoftwareVersion) {
		this.vnfSoftwareVersion = vnfSoftwareVersion;
	}

	public PkgmNotificationsFilterVersions vnfdVersions(final List<String> vnfdVersions) {
		this.vnfdVersions = vnfdVersions;
		return this;
	}

	public PkgmNotificationsFilterVersions addVnfdVersionsItem(final String vnfdVersionsItem) {
		if (this.vnfdVersions == null) {
			this.vnfdVersions = new ArrayList<>();
		}
		this.vnfdVersions.add(vnfdVersionsItem);
		return this;
	}

	/**
	 * If present, match VNF packages that contain VNF products with certain VNFD
	 * versions, a certain software version and a certain product name, from one
	 * particular provider.
	 * 
	 * @return vnfdVersions
	 **/
	@ApiModelProperty(value = "If present, match VNF packages that contain VNF products with certain VNFD versions, a certain software version and a certain product name, from one particular provider. ")

	public List<String> getVnfdVersions() {
		return vnfdVersions;
	}

	public void setVnfdVersions(final List<String> vnfdVersions) {
		this.vnfdVersions = vnfdVersions;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final PkgmNotificationsFilterVersions pkgmNotificationsFilterVersions = (PkgmNotificationsFilterVersions) o;
		return Objects.equals(this.vnfSoftwareVersion, pkgmNotificationsFilterVersions.vnfSoftwareVersion) &&
				Objects.equals(this.vnfdVersions, pkgmNotificationsFilterVersions.vnfdVersions);
	}

	@Override
	public int hashCode() {
		return Objects.hash(vnfSoftwareVersion, vnfdVersions);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class PkgmNotificationsFilterVersions {\n");

		sb.append("    vnfSoftwareVersion: ").append(toIndentedString(vnfSoftwareVersion)).append("\n");
		sb.append("    vnfdVersions: ").append(toIndentedString(vnfdVersions)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(final java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}