package com.ubiqube.etsi.mano.nfvo.v351.model.nslcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ubiqube.etsi.mano.nfvo.v351.model.nslcm.CpProtocolData;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * This type represents an externally provided link port or network address information per instance of an external connection point. In case a link port is provided, the VNFM shall use that link port when connecting the external CP to the external VL. In a link port is not provided, the VNFM shall create a link port on the external VL, and use that link port to connect the external CP to the external VL. NOTE 1: The following conditions apply to the attributes \&quot;linkPortId\&quot; and \&quot;cpProtocolData\&quot;:   - At least one of the \&quot;linkPortId\&quot; and \&quot;cpProtocolData\&quot; attributes shall be present for   an external CP instance representing a subport that is to be created, or an external CP instance   that is to be created by creating the corresponding VNFC or VNF instance during the current or   a subsequent LCM operation, or for an existing external CP instance that is to be re-configured   or added to a particular external virtual link.   - If the \&quot;cpProtocolData\&quot; attribute is absent, the \&quot;linkPortId\&quot; attribute shall be provided  referencing a pre-created link port with pre-configured address information.   - If both \&quot;cpProtocolData\&quot; and \&quot;linkportId\&quot; are provided, the API consumer shall ensure that   the cpProtocolData can be used with the pre-created link port referenced by \&quot;linkPortId\&quot;. NOTE 2: In case the NFVO manages its own identifier space, the NFVO may remap this identifier when communicating with the VNFM. If the NFVO knows that there can be an identifier collision when communicating with the VNFM by using the identifier from the OSS/BSS, the NFVO shall remap it. 
 */
@Schema(description = "This type represents an externally provided link port or network address information per instance of an external connection point. In case a link port is provided, the VNFM shall use that link port when connecting the external CP to the external VL. In a link port is not provided, the VNFM shall create a link port on the external VL, and use that link port to connect the external CP to the external VL. NOTE 1: The following conditions apply to the attributes \"linkPortId\" and \"cpProtocolData\":   - At least one of the \"linkPortId\" and \"cpProtocolData\" attributes shall be present for   an external CP instance representing a subport that is to be created, or an external CP instance   that is to be created by creating the corresponding VNFC or VNF instance during the current or   a subsequent LCM operation, or for an existing external CP instance that is to be re-configured   or added to a particular external virtual link.   - If the \"cpProtocolData\" attribute is absent, the \"linkPortId\" attribute shall be provided  referencing a pre-created link port with pre-configured address information.   - If both \"cpProtocolData\" and \"linkportId\" are provided, the API consumer shall ensure that   the cpProtocolData can be used with the pre-created link port referenced by \"linkPortId\". NOTE 2: In case the NFVO manages its own identifier space, the NFVO may remap this identifier when communicating with the VNFM. If the NFVO knows that there can be an identifier collision when communicating with the VNFM by using the identifier from the OSS/BSS, the NFVO shall remap it. ")
@Validated


public class VnfExtCpConfig  implements AnyOfVnfExtCpConfig {
  @JsonProperty("parentCpConfigId")
  private String parentCpConfigId = null;

  @JsonProperty("linkPortId")
  private String linkPortId = null;

  @JsonProperty("createExtLinkPort")
  private Boolean createExtLinkPort = null;

  @JsonProperty("cpProtocolData")
  @Valid
  private List<CpProtocolData> cpProtocolData = null;

  public VnfExtCpConfig parentCpConfigId(String parentCpConfigId) {
    this.parentCpConfigId = parentCpConfigId;
    return this;
  }

  /**
   * Get parentCpConfigId
   * @return parentCpConfigId
   **/
  @Schema(description = "")
  
    public String getParentCpConfigId() {
    return parentCpConfigId;
  }

  public void setParentCpConfigId(String parentCpConfigId) {
    this.parentCpConfigId = parentCpConfigId;
  }

  public VnfExtCpConfig linkPortId(String linkPortId) {
    this.linkPortId = linkPortId;
    return this;
  }

  /**
   * Get linkPortId
   * @return linkPortId
   **/
  @Schema(description = "")
  
    public String getLinkPortId() {
    return linkPortId;
  }

  public void setLinkPortId(String linkPortId) {
    this.linkPortId = linkPortId;
  }

  public VnfExtCpConfig createExtLinkPort(Boolean createExtLinkPort) {
    this.createExtLinkPort = createExtLinkPort;
    return this;
  }

  /**
   * Indicates the need to create a dedicated link port for the external CP. If set to True, a link port is created. If set to False, no link port is created. This attribute is only applicable for external CP instances without a floating IP address that expose a VIP CP instance for which a dedicated IP address is allocated. It shall be present in that case and shall be absent otherwise. 
   * @return createExtLinkPort
   **/
  @Schema(description = "Indicates the need to create a dedicated link port for the external CP. If set to True, a link port is created. If set to False, no link port is created. This attribute is only applicable for external CP instances without a floating IP address that expose a VIP CP instance for which a dedicated IP address is allocated. It shall be present in that case and shall be absent otherwise. ")
  
    public Boolean isCreateExtLinkPort() {
    return createExtLinkPort;
  }

  public void setCreateExtLinkPort(Boolean createExtLinkPort) {
    this.createExtLinkPort = createExtLinkPort;
  }

  public VnfExtCpConfig cpProtocolData(List<CpProtocolData> cpProtocolData) {
    this.cpProtocolData = cpProtocolData;
    return this;
  }

  public VnfExtCpConfig addCpProtocolDataItem(CpProtocolData cpProtocolDataItem) {
    if (this.cpProtocolData == null) {
      this.cpProtocolData = new ArrayList<>();
    }
    this.cpProtocolData.add(cpProtocolDataItem);
    return this;
  }

  /**
   * Parameters for configuring the network protocols on the link port that connects the CP to a VL. See note 1. 
   * @return cpProtocolData
   **/
  @Schema(description = "Parameters for configuring the network protocols on the link port that connects the CP to a VL. See note 1. ")
      @Valid
    public List<CpProtocolData> getCpProtocolData() {
    return cpProtocolData;
  }

  public void setCpProtocolData(List<CpProtocolData> cpProtocolData) {
    this.cpProtocolData = cpProtocolData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VnfExtCpConfig vnfExtCpConfig = (VnfExtCpConfig) o;
    return Objects.equals(this.parentCpConfigId, vnfExtCpConfig.parentCpConfigId) &&
        Objects.equals(this.linkPortId, vnfExtCpConfig.linkPortId) &&
        Objects.equals(this.createExtLinkPort, vnfExtCpConfig.createExtLinkPort) &&
        Objects.equals(this.cpProtocolData, vnfExtCpConfig.cpProtocolData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parentCpConfigId, linkPortId, createExtLinkPort, cpProtocolData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VnfExtCpConfig {\n");
    
    sb.append("    parentCpConfigId: ").append(toIndentedString(parentCpConfigId)).append("\n");
    sb.append("    linkPortId: ").append(toIndentedString(linkPortId)).append("\n");
    sb.append("    createExtLinkPort: ").append(toIndentedString(createExtLinkPort)).append("\n");
    sb.append("    cpProtocolData: ").append(toIndentedString(cpProtocolData)).append("\n");
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
