package com.ubiqube.etsi.mano.em.v331.model.vnflcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ubiqube.etsi.mano.em.v331.model.vnflcm.KeyValuePairs;
import com.ubiqube.etsi.mano.em.v331.model.vnflcm.ScaleInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * This type represents request parameters for the \&quot;Scale VNF to Level\&quot; operation. 
 */
@Schema(description = "This type represents request parameters for the \"Scale VNF to Level\" operation. ")
@Validated


public class ScaleVnfToLevelRequest  implements AnyOfScaleVnfToLevelRequest {
  @JsonProperty("instantiationLevelId")
  private String instantiationLevelId = null;

  @JsonProperty("scaleInfo")
  @Valid
  private List<ScaleInfo> scaleInfo = null;

  @JsonProperty("additionalParams")
  private KeyValuePairs additionalParams = null;

  public ScaleVnfToLevelRequest instantiationLevelId(String instantiationLevelId) {
    this.instantiationLevelId = instantiationLevelId;
    return this;
  }

  /**
   * Get instantiationLevelId
   * @return instantiationLevelId
   **/
  @Schema(description = "")
  
    public String getInstantiationLevelId() {
    return instantiationLevelId;
  }

  public void setInstantiationLevelId(String instantiationLevelId) {
    this.instantiationLevelId = instantiationLevelId;
  }

  public ScaleVnfToLevelRequest scaleInfo(List<ScaleInfo> scaleInfo) {
    this.scaleInfo = scaleInfo;
    return this;
  }

  public ScaleVnfToLevelRequest addScaleInfoItem(ScaleInfo scaleInfoItem) {
    if (this.scaleInfo == null) {
      this.scaleInfo = new ArrayList<>();
    }
    this.scaleInfo.add(scaleInfoItem);
    return this;
  }

  /**
   * For each scaling aspect of the current deployment flavour, indicates the target scale level to which the VNF is to be scaled. Either the instantiationLevelId attribute or the scaleInfo attribute shall be included. 
   * @return scaleInfo
   **/
  @Schema(description = "For each scaling aspect of the current deployment flavour, indicates the target scale level to which the VNF is to be scaled. Either the instantiationLevelId attribute or the scaleInfo attribute shall be included. ")
      @Valid
    public List<ScaleInfo> getScaleInfo() {
    return scaleInfo;
  }

  public void setScaleInfo(List<ScaleInfo> scaleInfo) {
    this.scaleInfo = scaleInfo;
  }

  public ScaleVnfToLevelRequest additionalParams(KeyValuePairs additionalParams) {
    this.additionalParams = additionalParams;
    return this;
  }

  /**
   * Get additionalParams
   * @return additionalParams
   **/
  @Schema(description = "")
  
    @Valid
    public KeyValuePairs getAdditionalParams() {
    return additionalParams;
  }

  public void setAdditionalParams(KeyValuePairs additionalParams) {
    this.additionalParams = additionalParams;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScaleVnfToLevelRequest scaleVnfToLevelRequest = (ScaleVnfToLevelRequest) o;
    return Objects.equals(this.instantiationLevelId, scaleVnfToLevelRequest.instantiationLevelId) &&
        Objects.equals(this.scaleInfo, scaleVnfToLevelRequest.scaleInfo) &&
        Objects.equals(this.additionalParams, scaleVnfToLevelRequest.additionalParams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instantiationLevelId, scaleInfo, additionalParams);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScaleVnfToLevelRequest {\n");
    
    sb.append("    instantiationLevelId: ").append(toIndentedString(instantiationLevelId)).append("\n");
    sb.append("    scaleInfo: ").append(toIndentedString(scaleInfo)).append("\n");
    sb.append("    additionalParams: ").append(toIndentedString(additionalParams)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
