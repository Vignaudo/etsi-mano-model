package com.ubiqube.etsi.mano.common.v261.model.lcmgrant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Information about assets for the VNF that are managed by the NFVO in the VIM,
 * such as software images and virtualised compute resource flavours. The Grant
 * response allows the NFVO to pass to the VNFM VIM assets related to the VNF
 * package that is identified by the vnfdId attribute in the corresponding Grant
 * request. The NFVO may send in each Grant response the full set of VIM assets
 * related to the VNF package defined by the vnfdId in the related Grant
 * request, but shall send this information if the vnfdId in the related Grant
 * request differs from the vnfdId passed in the previous Grant request, or if
 * the Grant response is related to an InstantiateVnf operation. The set of VIM
 * assets shall not change between subsequent Grant responses if the vnfdId has
 * not changed. During each LCM operation occurrence, the VIM assets that relate
 * to the VNF package identified by the current value of the vnfdId attribute in
 * the “VnfInstance” structure shall be used by the VNFM for newly created
 * resources. If the VNF package identifier of the VNF instance has been
 * updated, VIM assets that relate to the previously-used VNF package(s), and
 * that were communicated in previous Grant responses, apply to existing
 * resources.
 */
@ApiModel(description = "Information about assets for the VNF that are managed by the NFVO in the VIM, such as software images and virtualised compute resource flavours. The Grant response allows the NFVO to pass to the VNFM VIM assets related to the VNF package that is identified by the vnfdId attribute in the corresponding Grant request. The NFVO may send in each Grant response the full set of VIM assets related to the VNF package defined by the vnfdId in the related Grant request, but shall send this information if the vnfdId in the related Grant request differs from the vnfdId passed in the previous Grant request, or if the Grant response is related to an InstantiateVnf operation. The set of VIM assets shall not change between subsequent Grant responses if the vnfdId has not changed. During each LCM operation occurrence, the VIM assets that relate to the VNF package identified by the current value of the vnfdId attribute in the “VnfInstance” structure shall be used by the VNFM for newly created resources. If the VNF package identifier of the VNF instance has been updated, VIM assets that relate to the previously-used VNF package(s), and that were communicated in previous Grant responses, apply to existing resources. ")
@Validated
public class GrantVimAssets {
	@JsonProperty("computeResourceFlavours")
	@Valid
	private List<VimComputeResourceFlavour> computeResourceFlavours = null;

	@JsonProperty("softwareImages")
	@Valid
	private List<VimSoftwareImage> softwareImages = null;

	public GrantVimAssets computeResourceFlavours(final List<VimComputeResourceFlavour> computeResourceFlavours) {
		this.computeResourceFlavours = computeResourceFlavours;
		return this;
	}

	public GrantVimAssets addComputeResourceFlavoursItem(final VimComputeResourceFlavour computeResourceFlavoursItem) {
		if (this.computeResourceFlavours == null) {
			this.computeResourceFlavours = new ArrayList<>();
		}
		this.computeResourceFlavours.add(computeResourceFlavoursItem);
		return this;
	}

	/**
	 * Mappings between virtual compute descriptors defined in the VNFD and compute
	 * resource flavours managed in the VIM.
	 *
	 * @return computeResourceFlavours
	 **/
	@ApiModelProperty(value = "Mappings between virtual compute descriptors defined in the VNFD and compute resource flavours managed in the VIM. ")

	@Valid

	public List<VimComputeResourceFlavour> getComputeResourceFlavours() {
		return computeResourceFlavours;
	}

	public void setComputeResourceFlavours(final List<VimComputeResourceFlavour> computeResourceFlavours) {
		this.computeResourceFlavours = computeResourceFlavours;
	}

	public GrantVimAssets softwareImages(final List<VimSoftwareImage> softwareImages) {
		this.softwareImages = softwareImages;
		return this;
	}

	public GrantVimAssets addSoftwareImagesItem(final VimSoftwareImage softwareImagesItem) {
		if (this.softwareImages == null) {
			this.softwareImages = new ArrayList<>();
		}
		this.softwareImages.add(softwareImagesItem);
		return this;
	}

	/**
	 * Mappings between software images defined in the VNFD and software images
	 * managed in the VIM.
	 *
	 * @return softwareImages
	 **/
	@ApiModelProperty(value = "Mappings between software images defined in the VNFD and software images managed in the VIM. ")

	@Valid

	public List<VimSoftwareImage> getSoftwareImages() {
		return softwareImages;
	}

	public void setSoftwareImages(final List<VimSoftwareImage> softwareImages) {
		this.softwareImages = softwareImages;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final GrantVimAssets grantVimAssets = (GrantVimAssets) o;
		return Objects.equals(this.computeResourceFlavours, grantVimAssets.computeResourceFlavours) &&
				Objects.equals(this.softwareImages, grantVimAssets.softwareImages);
	}

	@Override
	public int hashCode() {
		return Objects.hash(computeResourceFlavours, softwareImages);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class GrantVimAssets {\n");

		sb.append("    computeResourceFlavours: ").append(toIndentedString(computeResourceFlavours)).append("\n");
		sb.append("    softwareImages: ").append(toIndentedString(softwareImages)).append("\n");
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
