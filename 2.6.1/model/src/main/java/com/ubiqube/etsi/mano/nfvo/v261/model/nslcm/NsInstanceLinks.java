/**
 * This copy of Woodstox XML processor is licensed under the
 * Apache (Software) License, version 2.0 ("the License").
 * See the License for details about distribution rights, and the
 * specific rights regarding derivate works.
 *
 * You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/
 *
 * A copy is also included in the downloadable source code package
 * containing Woodstox, in file "ASL2.0", under the same directory
 * as this file.
 */
package com.ubiqube.etsi.mano.nfvo.v261.model.nslcm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.common.v261.model.Link;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Links to resources related to this resource.
 */
@ApiModel(description = "Links to resources related to this resource.")
@Validated


public class NsInstanceLinks {
	@JsonProperty("self")
	private Link self = null;

	@JsonProperty("nestedNsInstances")
	@Valid
	private List<Link> nestedNsInstances = null;

	@JsonProperty("instantiate")
	private Link instantiate = null;

	@JsonProperty("terminate")
	private Link terminate = null;

	@JsonProperty("update")
	private Link update = null;

	@JsonProperty("scale")
	private Link scale = null;

	@JsonProperty("heal")
	private Link heal = null;

	public NsInstanceLinks self(final Link self) {
		this.self = self;
		return this;
	}

	/**
	 * URI of this resource.
	 *
	 * @return self
	 **/
	@ApiModelProperty(required = true, value = "URI of this resource. ")
	@NotNull

	@Valid

	public Link getSelf() {
		return self;
	}

	public void setSelf(final Link self) {
		this.self = self;
	}

	public NsInstanceLinks nestedNsInstances(final List<Link> nestedNsInstances) {
		this.nestedNsInstances = nestedNsInstances;
		return this;
	}

	public NsInstanceLinks addNestedNsInstancesItem(final Link nestedNsInstancesItem) {
		if (this.nestedNsInstances == null) {
			this.nestedNsInstances = new ArrayList<>();
		}
		this.nestedNsInstances.add(nestedNsInstancesItem);
		return this;
	}

	/**
	 * Links to resources related to this notification.
	 *
	 * @return nestedNsInstances
	 **/
	@ApiModelProperty(value = "Links to resources related to this notification. ")

	@Valid

	public List<Link> getNestedNsInstances() {
		return nestedNsInstances;
	}

	public void setNestedNsInstances(final List<Link> nestedNsInstances) {
		this.nestedNsInstances = nestedNsInstances;
	}

	public NsInstanceLinks instantiate(final Link instantiate) {
		this.instantiate = instantiate;
		return this;
	}

	/**
	 * Link to the \"instantiate\" task resource, if the related operation is
	 * possible based on the current status of this NS instance resource (i.e. NS
	 * instance in NOT_INSTANTIATED state).
	 *
	 * @return instantiate
	 **/
	@ApiModelProperty(value = "Link to the \"instantiate\" task resource, if the related operation is possible based on the current status of this NS instance resource (i.e. NS instance in NOT_INSTANTIATED state). ")

	@Valid

	public Link getInstantiate() {
		return instantiate;
	}

	public void setInstantiate(final Link instantiate) {
		this.instantiate = instantiate;
	}

	public NsInstanceLinks terminate(final Link terminate) {
		this.terminate = terminate;
		return this;
	}

	/**
	 * Link to the \"terminate\" task resource, if the related operation is possible
	 * based on the current status of this NS instance resource (i.e. NS instance is
	 * in INSTANTIATED state).
	 *
	 * @return terminate
	 **/
	@ApiModelProperty(value = "Link to the \"terminate\" task resource, if the related operation is possible based on the current status of this NS instance resource (i.e. NS instance is in INSTANTIATED state). ")

	@Valid

	public Link getTerminate() {
		return terminate;
	}

	public void setTerminate(final Link terminate) {
		this.terminate = terminate;
	}

	public NsInstanceLinks update(final Link update) {
		this.update = update;
		return this;
	}

	/**
	 * Link to the \"update\" task resource, if the related operation is possible
	 * based on the current status of this NS instance resource (i.e. NS instance is
	 * in INSTANTIATED state).
	 *
	 * @return update
	 **/
	@ApiModelProperty(value = "Link to the \"update\" task resource, if the related operation is possible based on the current status of this NS instance resource (i.e. NS instance is in INSTANTIATED state). ")

	@Valid

	public Link getUpdate() {
		return update;
	}

	public void setUpdate(final Link update) {
		this.update = update;
	}

	public NsInstanceLinks scale(final Link scale) {
		this.scale = scale;
		return this;
	}

	/**
	 * Link to the \"scale\" task resource, if the related operation is supported
	 * for this NS instance, and is possible based on the current status of this NS
	 * instance resource (i.e. NS instance is in INSTANTIATED state).
	 *
	 * @return scale
	 **/
	@ApiModelProperty(value = "Link to the \"scale\" task resource, if the related operation is supported for this NS instance, and is possible based on the current status of this NS instance resource (i.e. NS instance is in INSTANTIATED state). ")

	@Valid

	public Link getScale() {
		return scale;
	}

	public void setScale(final Link scale) {
		this.scale = scale;
	}

	public NsInstanceLinks heal(final Link heal) {
		this.heal = heal;
		return this;
	}

	/**
	 * Link to the \"heal\" task resource, if the related operation is supported for
	 * this NS instance, and is possible based on the current status of this NS
	 * instance resource (i.e. NS instance is in INSTANTIATED state).
	 *
	 * @return heal
	 **/
	@ApiModelProperty(value = "Link to the \"heal\" task resource, if the related operation is supported for this NS instance, and is possible based on the current status of this NS instance resource (i.e. NS instance is in INSTANTIATED state). ")

	@Valid

	public Link getHeal() {
		return heal;
	}

	public void setHeal(final Link heal) {
		this.heal = heal;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final NsInstanceLinks nsInstanceLinks = (NsInstanceLinks) o;
		return Objects.equals(this.self, nsInstanceLinks.self) &&
				Objects.equals(this.nestedNsInstances, nsInstanceLinks.nestedNsInstances) &&
				Objects.equals(this.instantiate, nsInstanceLinks.instantiate) &&
				Objects.equals(this.terminate, nsInstanceLinks.terminate) &&
				Objects.equals(this.update, nsInstanceLinks.update) &&
				Objects.equals(this.scale, nsInstanceLinks.scale) &&
				Objects.equals(this.heal, nsInstanceLinks.heal);
	}

	@Override
	public int hashCode() {
		return Objects.hash(self, nestedNsInstances, instantiate, terminate, update, scale, heal);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class NsInstanceLinks {\n");

		sb.append("    self: ").append(toIndentedString(self)).append("\n");
		sb.append("    nestedNsInstances: ").append(toIndentedString(nestedNsInstances)).append("\n");
		sb.append("    instantiate: ").append(toIndentedString(instantiate)).append("\n");
		sb.append("    terminate: ").append(toIndentedString(terminate)).append("\n");
		sb.append("    update: ").append(toIndentedString(update)).append("\n");
		sb.append("    scale: ").append(toIndentedString(scale)).append("\n");
		sb.append("    heal: ").append(toIndentedString(heal)).append("\n");
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