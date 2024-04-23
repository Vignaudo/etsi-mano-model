package com.ubiqube.etsi.mano.v451.model.nfvmanocim;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * The supported list of data analytics types. Examples include \&quot;Network service alarm incident analysis\&quot; and others  specified in ETSI GS NFV-IFA 047 [i.30]). 
 */
@Schema(description = "The supported list of data analytics types. Examples include \"Network service alarm incident analysis\" and others  specified in ETSI GS NFV-IFA 047 [i.30]). ")
@Validated



public class MdafSpecificInfo   {
  @JsonProperty("dataAnalyticsTypes")
  @Valid
  private List<String> dataAnalyticsTypes = new ArrayList<>();

  public MdafSpecificInfo dataAnalyticsTypes(List<String> dataAnalyticsTypes) {
    this.dataAnalyticsTypes = dataAnalyticsTypes;
    return this;
  }

  public MdafSpecificInfo addDataAnalyticsTypesItem(String dataAnalyticsTypesItem) {
    this.dataAnalyticsTypes.add(dataAnalyticsTypesItem);
    return this;
  }

  /**
   * Get dataAnalyticsTypes
   * @return dataAnalyticsTypes
   **/
  @Schema(required = true, description = "")
      @NotNull

  @Size(min=1)   public List<String> getDataAnalyticsTypes() {
    return dataAnalyticsTypes;
  }

  public void setDataAnalyticsTypes(List<String> dataAnalyticsTypes) {
    this.dataAnalyticsTypes = dataAnalyticsTypes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MdafSpecificInfo mdafSpecificInfo = (MdafSpecificInfo) o;
    return Objects.equals(this.dataAnalyticsTypes, mdafSpecificInfo.dataAnalyticsTypes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataAnalyticsTypes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MdafSpecificInfo {\n");
    
    sb.append("    dataAnalyticsTypes: ").append(toIndentedString(dataAnalyticsTypes)).append("\n");
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
