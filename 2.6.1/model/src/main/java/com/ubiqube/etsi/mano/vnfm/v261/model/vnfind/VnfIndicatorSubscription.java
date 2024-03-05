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
package com.ubiqube.etsi.mano.vnfm.v261.model.vnfind;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nonnull;
import jakarta.validation.Valid;

/**
 * This type represents a subscription related to notifications about VNF
 * indicator value changes.
 */
@Schema(description = "This type represents a subscription related to notifications about VNF indicator value changes. ")
@Validated

public class VnfIndicatorSubscription {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("filter")
	private VnfIndicatorNotificationsFilter filter = null;

	@JsonProperty("callbackUri")
	private String callbackUri = null;

	@JsonProperty("_links")
	private VnfIndicatorSubscriptionLinks links = null;

	public VnfIndicatorSubscription id(final String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identifier of this \"Individual subscription\" resource.
	 *
	 * @return id
	 **/
	@Schema(required = true, description = "Identifier of this \"Individual subscription\" resource. ")
	@Nonnull

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public VnfIndicatorSubscription filter(final VnfIndicatorNotificationsFilter filter) {
		this.filter = filter;
		return this;
	}

	/**
	 * Filter settings for this subscription, to define the subset of all
	 * notifications this subscription relates to. A particular notification is sent
	 * to the subscriber if the filter matches, or if there is no filter.
	 *
	 * @return filter
	 **/
	@Schema(description = "Filter settings for this subscription, to define the subset of all notifications this subscription relates to. A particular notification is sent to the subscriber if the filter matches, or if there is no filter. ")

	@Valid

	public VnfIndicatorNotificationsFilter getFilter() {
		return filter;
	}

	public void setFilter(final VnfIndicatorNotificationsFilter filter) {
		this.filter = filter;
	}

	public VnfIndicatorSubscription callbackUri(final String callbackUri) {
		this.callbackUri = callbackUri;
		return this;
	}

	/**
	 * The URI of the endpoint to send the notification to.
	 *
	 * @return callbackUri
	 **/
	@Schema(required = true, description = "The URI of the endpoint to send the notification to. ")
	@Nonnull

	public String getCallbackUri() {
		return callbackUri;
	}

	public void setCallbackUri(final String callbackUri) {
		this.callbackUri = callbackUri;
	}

	public VnfIndicatorSubscription links(final VnfIndicatorSubscriptionLinks links) {
		this.links = links;
		return this;
	}

	/**
	 * Get links
	 *
	 * @return links
	 **/
	@Schema(required = true, description = "")
	@Nonnull

	@Valid

	public VnfIndicatorSubscriptionLinks getLinks() {
		return links;
	}

	public void setLinks(final VnfIndicatorSubscriptionLinks links) {
		this.links = links;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final VnfIndicatorSubscription vnfIndicatorSubscription = (VnfIndicatorSubscription) o;
		return Objects.equals(this.id, vnfIndicatorSubscription.id) &&
				Objects.equals(this.filter, vnfIndicatorSubscription.filter) &&
				Objects.equals(this.callbackUri, vnfIndicatorSubscription.callbackUri) &&
				Objects.equals(this.links, vnfIndicatorSubscription.links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, filter, callbackUri, links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class VnfIndicatorSubscription {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
		sb.append("    callbackUri: ").append(toIndentedString(callbackUri)).append("\n");
		sb.append("    links: ").append(toIndentedString(links)).append("\n");
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
