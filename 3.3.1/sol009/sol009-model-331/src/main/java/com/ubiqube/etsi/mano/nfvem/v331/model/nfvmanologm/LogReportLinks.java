package com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanologm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanologm.Link;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Links for this resource.
 */
@Schema(description = "Links for this resource.")
@Validated


public class LogReportLinks   {
  @JsonProperty("self")
  private Link self = null;

  @JsonProperty("objects")
  @Valid
  private List<Link> objects = null;

  public LogReportLinks self(Link self) {
    this.self = self;
    return this;
  }

  /**
   * Get self
   * @return self
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Link getSelf() {
    return self;
  }

  public void setSelf(Link self) {
    this.self = self;
  }

  public LogReportLinks objects(List<Link> objects) {
    this.objects = objects;
    return this;
  }

  public LogReportLinks addObjectsItem(Link objectsItem) {
    if (this.objects == null) {
      this.objects = new ArrayList<>();
    }
    this.objects.add(objectsItem);
    return this;
  }

  /**
   * Links to resources representing the object instances that are logged. Shall be present if the logged object instance information is accessible as a resource.
   * @return objects
   **/
  @Schema(description = "Links to resources representing the object instances that are logged. Shall be present if the logged object instance information is accessible as a resource.")
      @Valid
    public List<Link> getObjects() {
    return objects;
  }

  public void setObjects(List<Link> objects) {
    this.objects = objects;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LogReportLinks logReportLinks = (LogReportLinks) o;
    return Objects.equals(this.self, logReportLinks.self) &&
        Objects.equals(this.objects, logReportLinks.objects);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, objects);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LogReportLinks {\n");
    
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    objects: ").append(toIndentedString(objects)).append("\n");
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
