package com.ubiqube.etsi.mano.nfvo.v351.model.vnf;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Date-time stamp. Representation: String formatted according toas defined by
 * the date-time production in IETF RFC 3339.
 */
@Schema(description = "Date-time stamp. Representation: String formatted according toas defined by the date-time production in IETF RFC 3339. ")
@Validated

public class DateTime {

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash();
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class DateTime {\n");

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
