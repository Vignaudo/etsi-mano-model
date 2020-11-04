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

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.common.v261.model.nslcm.CancelModeType;
import com.ubiqube.etsi.mano.common.v261.model.nslcm.LcmOperationStateType;
import com.ubiqube.etsi.mano.model.ProblemDetails;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This type represents a request a NS lifecycle operation occurrence. It shall
 * comply with the provisions defined in Table 6.5.2.3-1.
 */
@ApiModel(description = "This type represents a request a NS lifecycle operation occurrence. It shall comply with the provisions defined in Table 6.5.2.3-1. ")
@Validated


public class NsLcmOpOcc {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("operationState")
	private LcmOperationStateType operationState = null;

	@JsonProperty("stateEnteredTime")
	private OffsetDateTime stateEnteredTime = null;

	@JsonProperty("nsInstanceId")
	private String nsInstanceId = null;

	@JsonProperty("lcmOperationType")
	private NsLcmOpType lcmOperationType = null;

	@JsonProperty("startTime")
	private OffsetDateTime startTime = null;

	@JsonProperty("isAutomaticInvocation")
	private Boolean isAutomaticInvocation = null;

	@JsonProperty("operationParams")
	private OperationParamsEnum operationParams = null;

	@JsonProperty("isCancelPending")
	private Boolean isCancelPending = null;

	@JsonProperty("cancelMode")
	private CancelModeType cancelMode = null;

	@JsonProperty("error")
	private ProblemDetails error = null;

	@JsonProperty("resourceChanges")
	private NsLcmOpOccResourceChanges resourceChanges = new NsLcmOpOccResourceChanges();

	@JsonProperty("_links")
	private NsLcmOpOccLinks links = null;

	public NsLcmOpOcc id(final String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identifier of this NS lifecycle operation occurrence.
	 *
	 * @return id
	 **/
	@ApiModelProperty(required = true, value = "Identifier of this NS lifecycle operation occurrence. ")
	@NotNull

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public NsLcmOpOcc operationState(final LcmOperationStateType operationState) {
		this.operationState = operationState;
		return this;
	}

	/**
	 * The state of the NS LCM operation.
	 *
	 * @return operationState
	 **/
	@ApiModelProperty(required = true, value = "The state of the NS LCM operation. ")
	@NotNull

	@Valid

	public LcmOperationStateType getOperationState() {
		return operationState;
	}

	public void setOperationState(final LcmOperationStateType operationState) {
		this.operationState = operationState;
	}

	public NsLcmOpOcc stateEnteredTime(final OffsetDateTime stateEnteredTime) {
		this.stateEnteredTime = stateEnteredTime;
		return this;
	}

	/**
	 * Date-time when the current state has been entered.
	 *
	 * @return stateEnteredTime
	 **/
	@ApiModelProperty(required = true, value = "Date-time when the current state has been entered. ")
	@NotNull

	@Valid

	public OffsetDateTime getStateEnteredTime() {
		return stateEnteredTime;
	}

	public void setStateEnteredTime(final OffsetDateTime stateEnteredTime) {
		this.stateEnteredTime = stateEnteredTime;
	}

	public NsLcmOpOcc nsInstanceId(final String nsInstanceId) {
		this.nsInstanceId = nsInstanceId;
		return this;
	}

	/**
	 * Identifier of the NS instance to which the operation applies.
	 *
	 * @return nsInstanceId
	 **/
	@ApiModelProperty(required = true, value = "Identifier of the NS instance to which the operation applies. ")
	@NotNull

	public String getNsInstanceId() {
		return nsInstanceId;
	}

	public void setNsInstanceId(final String nsInstanceId) {
		this.nsInstanceId = nsInstanceId;
	}

	public NsLcmOpOcc lcmOperationType(final NsLcmOpType lcmOperationType) {
		this.lcmOperationType = lcmOperationType;
		return this;
	}

	/**
	 * Type of the actual LCM operation represented by this lcm operation
	 * occurrence.
	 *
	 * @return lcmOperationType
	 **/
	@ApiModelProperty(required = true, value = "Type of the actual LCM operation represented by this lcm operation occurrence. ")
	@NotNull

	@Valid

	public NsLcmOpType getLcmOperationType() {
		return lcmOperationType;
	}

	public void setLcmOperationType(final NsLcmOpType lcmOperationType) {
		this.lcmOperationType = lcmOperationType;
	}

	public NsLcmOpOcc startTime(final OffsetDateTime startTime) {
		this.startTime = startTime;
		return this;
	}

	/**
	 * Date-time of the start of the operation.
	 *
	 * @return startTime
	 **/
	@ApiModelProperty(required = true, value = "Date-time of the start of the operation. ")
	@NotNull

	@Valid

	public OffsetDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(final OffsetDateTime startTime) {
		this.startTime = startTime;
	}

	public NsLcmOpOcc isAutomaticInvocation(final Boolean isAutomaticInvocation) {
		this.isAutomaticInvocation = isAutomaticInvocation;
		return this;
	}

	/**
	 * Set to true if this NS LCM operation occurrence has been automatically
	 * triggered by the NFVO. This occurs in the case of auto-scaling, auto-healing
	 * and when a nested NS is modified as a result of an operation on its composite
	 * NS. Set to false otherwise.
	 *
	 * @return isAutomaticInvocation
	 **/
	@ApiModelProperty(required = true, value = "Set to true if this NS LCM operation occurrence has been automatically triggered by the NFVO. This occurs in the case of auto-scaling, auto-healing and when a nested NS is modified as a result of an operation on its composite NS. Set to false otherwise. ")
	@NotNull

	public Boolean isIsAutomaticInvocation() {
		return isAutomaticInvocation;
	}

	public void setIsAutomaticInvocation(final Boolean isAutomaticInvocation) {
		this.isAutomaticInvocation = isAutomaticInvocation;
	}

	public NsLcmOpOcc operationParams(final OperationParamsEnum operationParams) {
		this.operationParams = operationParams;
		return this;
	}

	/**
	 * Input parameters of the LCM operation. This attribute shall be formatted
	 * according to the request data type of the related LCM operation. The
	 * following mapping between lcmOperationType and the data type of this
	 * attribute shall apply: - INSTANTIATE: InstantiateNsRequest - SCALE:
	 * ScaleNsRequest - UPDATE: UpdateNsRequest - HEAL: HealNsRequest - TERMINATE:
	 * TerminateNsRequest This attribute shall be present if this data type is
	 * returned in a response to reading an individual resource, and may be present
	 * according to the chosen attribute selector parameter if this data type is
	 * returned in a response to a query of a container resource.
	 *
	 * @return operationParams
	 **/
	@ApiModelProperty(value = "Input parameters of the LCM operation. This attribute shall be formatted according to the request data type of the related LCM operation. The following mapping between lcmOperationType and the data type of this attribute shall apply: - INSTANTIATE: InstantiateNsRequest - SCALE: ScaleNsRequest - UPDATE: UpdateNsRequest - HEAL: HealNsRequest - TERMINATE: TerminateNsRequest This attribute shall be present if this data type is returned in a response to reading an individual resource, and may be present according to the chosen attribute selector parameter if this data type is returned in a response to a query of a container resource. ")

	public OperationParamsEnum getOperationParams() {
		return operationParams;
	}

	public void setOperationParams(final OperationParamsEnum operationParams) {
		this.operationParams = operationParams;
	}

	public NsLcmOpOcc isCancelPending(final Boolean isCancelPending) {
		this.isCancelPending = isCancelPending;
		return this;
	}

	/**
	 * If the LCM operation occurrence is in \"PROCESSING\" or \"ROLLING_BACK\"
	 * state and the operation is being cancelled, this attribute shall be set to
	 * true. Otherwise, it shall be set to false.
	 *
	 * @return isCancelPending
	 **/
	@ApiModelProperty(required = true, value = "If the LCM operation occurrence is in \"PROCESSING\" or \"ROLLING_BACK\" state and the operation is being cancelled, this attribute shall be set to true. Otherwise, it shall be set to false. ")
	@NotNull

	public Boolean isIsCancelPending() {
		return isCancelPending;
	}

	public void setIsCancelPending(final Boolean isCancelPending) {
		this.isCancelPending = isCancelPending;
	}

	public NsLcmOpOcc cancelMode(final CancelModeType cancelMode) {
		this.cancelMode = cancelMode;
		return this;
	}

	/**
	 * The mode of an ongoing cancellation. Shall be present when
	 * isCancelPending=true, and shall be absent otherwise.
	 *
	 * @return cancelMode
	 **/
	@ApiModelProperty(value = "The mode of an ongoing cancellation. Shall be present when isCancelPending=true, and shall be absent otherwise. ")

	@Valid

	public CancelModeType getCancelMode() {
		return cancelMode;
	}

	public void setCancelMode(final CancelModeType cancelMode) {
		this.cancelMode = cancelMode;
	}

	public NsLcmOpOcc error(final ProblemDetails error) {
		this.error = error;
		return this;
	}

	/**
	 * If \"operationState\" is \"FAILED_TEMP\" or \"FAILED\" or \"operationState\"
	 * is \"PROCESSING\" or \"ROLLING_BACK\" and previous value of
	 * \"operationState\" was \"FAILED_TEMP\", this attribute shall be present and
	 * contain error information, unless it has been requested to be excluded via an
	 * attribute selector.
	 *
	 * @return error
	 **/
	@ApiModelProperty(value = "If \"operationState\" is \"FAILED_TEMP\" or \"FAILED\" or \"operationState\" is \"PROCESSING\" or \"ROLLING_BACK\" and previous value of \"operationState\" was \"FAILED_TEMP\", this attribute shall be present and contain error information, unless it has been requested to be excluded via an attribute selector. ")

	@Valid

	public ProblemDetails getError() {
		return error;
	}

	public void setError(final ProblemDetails error) {
		this.error = error;
	}

	public NsLcmOpOcc resourceChanges(final NsLcmOpOccResourceChanges resourceChanges) {
		this.resourceChanges = resourceChanges;
		return this;
	}

	/**
	 * Get resourceChanges
	 *
	 * @return resourceChanges
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public NsLcmOpOccResourceChanges getResourceChanges() {
		return resourceChanges;
	}

	public void setResourceChanges(final NsLcmOpOccResourceChanges resourceChanges) {
		this.resourceChanges = resourceChanges;
	}

	public NsLcmOpOcc links(final NsLcmOpOccLinks links) {
		this.links = links;
		return this;
	}

	/**
	 * Get links
	 *
	 * @return links
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Valid

	public NsLcmOpOccLinks getLinks() {
		return links;
	}

	public void setLinks(final NsLcmOpOccLinks links) {
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
		final NsLcmOpOcc nsLcmOpOcc = (NsLcmOpOcc) o;
		return Objects.equals(this.id, nsLcmOpOcc.id) &&
				Objects.equals(this.operationState, nsLcmOpOcc.operationState) &&
				Objects.equals(this.stateEnteredTime, nsLcmOpOcc.stateEnteredTime) &&
				Objects.equals(this.nsInstanceId, nsLcmOpOcc.nsInstanceId) &&
				Objects.equals(this.lcmOperationType, nsLcmOpOcc.lcmOperationType) &&
				Objects.equals(this.startTime, nsLcmOpOcc.startTime) &&
				Objects.equals(this.isAutomaticInvocation, nsLcmOpOcc.isAutomaticInvocation) &&
				Objects.equals(this.operationParams, nsLcmOpOcc.operationParams) &&
				Objects.equals(this.isCancelPending, nsLcmOpOcc.isCancelPending) &&
				Objects.equals(this.cancelMode, nsLcmOpOcc.cancelMode) &&
				Objects.equals(this.error, nsLcmOpOcc.error) &&
				Objects.equals(this.resourceChanges, nsLcmOpOcc.resourceChanges) &&
				Objects.equals(this.links, nsLcmOpOcc.links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, operationState, stateEnteredTime, nsInstanceId, lcmOperationType, startTime, isAutomaticInvocation, operationParams, isCancelPending, cancelMode, error, resourceChanges, links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class NsLcmOpOcc {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    operationState: ").append(toIndentedString(operationState)).append("\n");
		sb.append("    stateEnteredTime: ").append(toIndentedString(stateEnteredTime)).append("\n");
		sb.append("    nsInstanceId: ").append(toIndentedString(nsInstanceId)).append("\n");
		sb.append("    lcmOperationType: ").append(toIndentedString(lcmOperationType)).append("\n");
		sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
		sb.append("    isAutomaticInvocation: ").append(toIndentedString(isAutomaticInvocation)).append("\n");
		sb.append("    operationParams: ").append(toIndentedString(operationParams)).append("\n");
		sb.append("    isCancelPending: ").append(toIndentedString(isCancelPending)).append("\n");
		sb.append("    cancelMode: ").append(toIndentedString(cancelMode)).append("\n");
		sb.append("    error: ").append(toIndentedString(error)).append("\n");
		sb.append("    resourceChanges: ").append(toIndentedString(resourceChanges)).append("\n");
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