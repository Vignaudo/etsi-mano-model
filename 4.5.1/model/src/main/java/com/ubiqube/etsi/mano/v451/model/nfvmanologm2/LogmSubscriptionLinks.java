package com.ubiqube.etsi.mano.v451.model.nfvmanologm2;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.Link;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Links to resources related to this resource.
 */
@Schema(description = "Links to resources related to this resource.")
@Validated

public class LogmSubscriptionLinks {
	@JsonProperty("self")
	private Link self = null;

	public LogmSubscriptionLinks self(final Link self) {
		this.self = self;
		return this;
	}

	/**
	 * Get self
	 *
	 * @return self
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public Link getSelf() {
		return self;
	}

	public void setSelf(final Link self) {
		this.self = self;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final LogmSubscriptionLinks logmSubscriptionLinks = (LogmSubscriptionLinks) o;
		return Objects.equals(this.self, logmSubscriptionLinks.self);
	}

	@Override
	public int hashCode() {
		return Objects.hash(self);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class LogmSubscriptionLinks {\n");

		sb.append("    self: ").append(toIndentedString(self)).append("\n");
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
