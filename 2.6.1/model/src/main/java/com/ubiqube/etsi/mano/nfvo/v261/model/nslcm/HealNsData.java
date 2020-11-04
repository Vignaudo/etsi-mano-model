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
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This type represents the information used to heal a NS. It shall comply with
 * the provisions defined in Table 6.5.3.43-1.
 */
@ApiModel(description = "This type represents the information used to heal a NS.  It shall comply with the provisions defined in Table 6.5.3.43-1. ")
@Validated


public class HealNsData {
	/**
	 * Indicates the degree of healing. Possible values include: - HEAL_RESTORE:
	 * Complete the healing of the NS restoring the state of the NS before the
	 * failure occurred - HEAL_QOS: Complete the healing of the NS based on the
	 * newest QoS values - HEAL_RESET: Complete the healing of the NS resetting to
	 * the original instantiation state of the NS - PARTIAL_HEALING
	 */
	public enum DegreeHealingEnum {
		HEAL_RESTORE("HEAL_RESTORE"),

		HEAL_QOS("HEAL_QOS"),

		HEAL_RESET("HEAL_RESET"),

		PARTIAL_HEALING("PARTIAL_HEALING");

		private final String value;

		DegreeHealingEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static DegreeHealingEnum fromValue(final String text) {
			for (final DegreeHealingEnum b : DegreeHealingEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("degreeHealing")
	private DegreeHealingEnum degreeHealing = null;

	@JsonProperty("actionsHealing")
	@Valid
	private List<String> actionsHealing = null;

	@JsonProperty("healScript")
	private String healScript = null;

	@JsonProperty("additionalParamsforNs")
	private Map<String, String> additionalParamsforNs = null;

	public HealNsData degreeHealing(final DegreeHealingEnum degreeHealing) {
		this.degreeHealing = degreeHealing;
		return this;
	}

	/**
	 * Indicates the degree of healing. Possible values include: - HEAL_RESTORE:
	 * Complete the healing of the NS restoring the state of the NS before the
	 * failure occurred - HEAL_QOS: Complete the healing of the NS based on the
	 * newest QoS values - HEAL_RESET: Complete the healing of the NS resetting to
	 * the original instantiation state of the NS - PARTIAL_HEALING
	 *
	 * @return degreeHealing
	 **/
	@ApiModelProperty(required = true, value = "Indicates the degree of healing. Possible values include: - HEAL_RESTORE: Complete the healing of the NS restoring the state of the NS before the failure occurred - HEAL_QOS: Complete the healing of the NS based on the newest QoS values - HEAL_RESET: Complete the healing of the NS resetting to the original instantiation state of the NS - PARTIAL_HEALING ")
	@NotNull

	public DegreeHealingEnum getDegreeHealing() {
		return degreeHealing;
	}

	public void setDegreeHealing(final DegreeHealingEnum degreeHealing) {
		this.degreeHealing = degreeHealing;
	}

	public HealNsData actionsHealing(final List<String> actionsHealing) {
		this.actionsHealing = actionsHealing;
		return this;
	}

	public HealNsData addActionsHealingItem(final String actionsHealingItem) {
		if (this.actionsHealing == null) {
			this.actionsHealing = new ArrayList<>();
		}
		this.actionsHealing.add(actionsHealingItem);
		return this;
	}

	/**
	 * Used to specify dedicated healing actions in a particular order (e.g. as a
	 * script). The actionsHealing attribute can be used to provide a specific
	 * script whose content and actions might only be possible to be derived during
	 * runtime.
	 *
	 * @return actionsHealing
	 **/
	@ApiModelProperty(value = "Used to specify dedicated healing actions in a particular order (e.g. as a script). The actionsHealing attribute can be used to provide a specific script whose content and actions might only be possible to be derived during runtime. ")

	public List<String> getActionsHealing() {
		return actionsHealing;
	}

	public void setActionsHealing(final List<String> actionsHealing) {
		this.actionsHealing = actionsHealing;
	}

	public HealNsData healScript(final String healScript) {
		this.healScript = healScript;
		return this;
	}

	/**
	 * Reference to a script from the NSD that shall be used to execute dedicated
	 * healing actions in a particular order. The healScript, since it refers to a
	 * script in the NSD, can be used to execute healing actions which are defined
	 * during NS design time.
	 *
	 * @return healScript
	 **/
	@ApiModelProperty(value = "Reference to a script from the NSD that shall be used to execute dedicated healing actions in a particular order. The healScript, since it refers to a script in the NSD, can be used to execute healing actions which are defined during NS design time. ")

	public String getHealScript() {
		return healScript;
	}

	public void setHealScript(final String healScript) {
		this.healScript = healScript;
	}

	public HealNsData additionalParamsforNs(final Map<String, String> additionalParamsforNs) {
		this.additionalParamsforNs = additionalParamsforNs;
		return this;
	}

	/**
	 * Allows the OSS/BSS to provide additional parameter(s) to the healing process
	 * at the NS level.
	 *
	 * @return additionalParamsforNs
	 **/
	@ApiModelProperty(value = "Allows the OSS/BSS to provide additional parameter(s) to the healing process at the NS level. ")

	@Valid

	public Map<String, String> getAdditionalParamsforNs() {
		return additionalParamsforNs;
	}

	public void setAdditionalParamsforNs(final Map<String, String> additionalParamsforNs) {
		this.additionalParamsforNs = additionalParamsforNs;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final HealNsData healNsData = (HealNsData) o;
		return Objects.equals(this.degreeHealing, healNsData.degreeHealing) &&
				Objects.equals(this.actionsHealing, healNsData.actionsHealing) &&
				Objects.equals(this.healScript, healNsData.healScript) &&
				Objects.equals(this.additionalParamsforNs, healNsData.additionalParamsforNs);
	}

	@Override
	public int hashCode() {
		return Objects.hash(degreeHealing, actionsHealing, healScript, additionalParamsforNs);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class HealNsData {\n");

		sb.append("    degreeHealing: ").append(toIndentedString(degreeHealing)).append("\n");
		sb.append("    actionsHealing: ").append(toIndentedString(actionsHealing)).append("\n");
		sb.append("    healScript: ").append(toIndentedString(healScript)).append("\n");
		sb.append("    additionalParamsforNs: ").append(toIndentedString(additionalParamsforNs)).append("\n");
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