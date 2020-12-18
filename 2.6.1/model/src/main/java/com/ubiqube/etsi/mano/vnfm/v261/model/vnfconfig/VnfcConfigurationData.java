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
package com.ubiqube.etsi.mano.vnfm.v261.model.vnfconfig;

import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This type represents configuration parameters of a VNFC instance.
 */
@ApiModel(description = "This type represents configuration parameters of a VNFC instance. ")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-11T19:16:20.445+01:00")

public class VnfcConfigurationData {
	@JsonProperty("vnfcInstanceId")
	private String vnfcInstanceId = null;

	@JsonProperty("extCpConfig")
	private CpConfiguration extCpConfig = null;

	@JsonProperty("dhcpServer")
	private String dhcpServer = null;

	@JsonProperty("vnfcSpecificData")
	private Map<String, Object> vnfcSpecificData = null;

	public VnfcConfigurationData vnfcInstanceId(final String vnfcInstanceId) {
		this.vnfcInstanceId = vnfcInstanceId;
		return this;
	}

	/**
	 * Identifier of a VNFC instance to which this set of configuration data
	 * applies.
	 *
	 * @return vnfcInstanceId
	 **/
	@ApiModelProperty(required = true, value = "Identifier of a VNFC instance to which this set of configuration data applies. ")
	@NotNull

	public String getVnfcInstanceId() {
		return vnfcInstanceId;
	}

	public void setVnfcInstanceId(final String vnfcInstanceId) {
		this.vnfcInstanceId = vnfcInstanceId;
	}

	public VnfcConfigurationData extCpConfig(final CpConfiguration extCpConfig) {
		this.extCpConfig = extCpConfig;
		return this;
	}

	/**
	 * Configuration parameters for the external CPs of the VNFC instance.
	 *
	 * @return extCpConfig
	 **/
	@ApiModelProperty(value = "Configuration parameters for the external CPs of the VNFC instance. ")

	@Valid

	public CpConfiguration getExtCpConfig() {
		return extCpConfig;
	}

	public void setExtCpConfig(final CpConfiguration extCpConfig) {
		this.extCpConfig = extCpConfig;
	}

	public VnfcConfigurationData dhcpServer(final String dhcpServer) {
		this.dhcpServer = dhcpServer;
		return this;
	}

	/**
	 * IP address of the DHCP server that the VNF instance can use to obtain IP
	 * addresses to be assigned to its external CPs.
	 *
	 * @return dhcpServer
	 **/
	@ApiModelProperty(value = "IP address of the DHCP server that the VNF instance can use to obtain IP addresses to be assigned to its external CPs. ")

	public String getDhcpServer() {
		return dhcpServer;
	}

	public void setDhcpServer(final String dhcpServer) {
		this.dhcpServer = dhcpServer;
	}

	public VnfcConfigurationData vnfcSpecificData(final Map<String, Object> vnfcSpecificData) {
		this.vnfcSpecificData = vnfcSpecificData;
		return this;
	}

	/**
	 * Additional configurable properties of the VNFC instance declared in the VNFD
	 * as \"VnfcConfigurableProperties\".
	 *
	 * @return vnfcSpecificData
	 **/
	@ApiModelProperty(value = "Additional configurable properties of the VNFC instance declared in the VNFD as \"VnfcConfigurableProperties\". ")

	@Valid

	public Map<String, Object> getVnfcSpecificData() {
		return vnfcSpecificData;
	}

	public void setVnfcSpecificData(final Map<String, Object> vnfcSpecificData) {
		this.vnfcSpecificData = vnfcSpecificData;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final VnfcConfigurationData vnfcConfigurationData = (VnfcConfigurationData) o;
		return Objects.equals(this.vnfcInstanceId, vnfcConfigurationData.vnfcInstanceId) &&
				Objects.equals(this.extCpConfig, vnfcConfigurationData.extCpConfig) &&
				Objects.equals(this.dhcpServer, vnfcConfigurationData.dhcpServer) &&
				Objects.equals(this.vnfcSpecificData, vnfcConfigurationData.vnfcSpecificData);
	}

	@Override
	public int hashCode() {
		return Objects.hash(vnfcInstanceId, extCpConfig, dhcpServer, vnfcSpecificData);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class VnfcConfigurationData {\n");

		sb.append("    vnfcInstanceId: ").append(toIndentedString(vnfcInstanceId)).append("\n");
		sb.append("    extCpConfig: ").append(toIndentedString(extCpConfig)).append("\n");
		sb.append("    dhcpServer: ").append(toIndentedString(dhcpServer)).append("\n");
		sb.append("    vnfcSpecificData: ").append(toIndentedString(vnfcSpecificData)).append("\n");
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