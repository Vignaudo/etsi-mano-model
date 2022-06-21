package com.ubiqube.etsi.mano.nfvo.v351.model.vnf;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * This type represents a link to a resource in a notification, using an
 * absolute or relative URI.
 */
@Schema(description = "This type represents a link to a resource in a notification, using an absolute or relative URI. ")
@Validated

public class NotificationLink {
	@JsonProperty("href")
	private String href = null;

	public NotificationLink href(final String href) {
		this.href = href;
		return this;
	}

	/**
	 * URI of a resource referenced from a notification. Should be an absolute URI
	 * (i.e. a URI that contains {apiRoot}), however, may be a relative URI (i.e. a
	 * URI where the {apiRoot} part is omitted) if the {apiRoot} information is not
	 * available.
	 *
	 * @return href
	 **/
	@Schema(required = true, description = "URI of a resource referenced from a notification. Should be an absolute URI (i.e. a URI that contains {apiRoot}), however, may be a relative URI (i.e. a URI where the {apiRoot} part is omitted) if the {apiRoot} information is not available. ")
	@NotNull

	public String getHref() {
		return href;
	}

	public void setHref(final String href) {
		this.href = href;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final NotificationLink notificationLink = (NotificationLink) o;
		return Objects.equals(this.href, notificationLink.href);
	}

	@Override
	public int hashCode() {
		return Objects.hash(href);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class NotificationLink {\n");

		sb.append("    href: ").append(toIndentedString(href)).append("\n");
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
