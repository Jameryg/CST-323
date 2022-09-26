package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Positive;

public class ProductsModel 
{
	// Class variables 
	private Long productId;
	
	@NotNull(message="Image must be a .jpg.")
	@Size(min=2, max=50, message="Image must be a .jpg.")
	private String image;
	
	@NotNull(message="Tape Measure Length is a required field.")
	@Positive
	private float length;
	
	@NotNull(message="Tape Measure Measurement Unit (Ex: Imperial/Metric Systems) is a required field.")
	@Size(min=1, max=20, message="Tape Measure Measurement Unit must be identified.")
	private String measurementUnit;
	
	@NotNull(message="Tape Measure weight is a required field.")
	@Positive
	// @Size(min=6, max=24, message="Tape Measure weight must be identified.")
	private float weight;
	
	@NotNull(message="Tape measure description is a required field.")
	@Size(min=1, max=100, message="Tape measure must have a description.")
	private String description;

	/**
	 * @return the product_id
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param product_id the product_id to set
	 */
	public void setProductId(Long product_id) {
		this.productId = product_id;
	}
	
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the length
	 */
	public float getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(float length) {
		this.length = length;
	}

	/**
	 * @return the measurement_unit
	 */
	public String getMeasurementUnit() {
		return measurementUnit;
	}

	/**
	 * @param measurement_unit the measurement_unit to set
	 */
	public void setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
	}

	/**
	 * @return the weight
	 */
	public float getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param product_id
	 * @param image
	 * @param length
	 * @param measurementUnit
	 * @param weight
	 * @param description
	 */
	public ProductsModel(Long productId, String image, float length, String measurementUnit, float weight, String description) {
		this.productId = productId;
		this.image = image;
		this.length = length;
		this.measurementUnit = measurementUnit;
		this.weight = weight;
		this.description = description;
	}

	/**
	 * default constructor
	 */
	public ProductsModel() {
	}

	@Override
	public String toString() {
		return "ProductsModel [productId=" + productId + ", image=" + image + ", length=" + length
				+ ", measurementUnit=" + measurementUnit + ", weight=" + weight + ", description=" + description + "]";
	}
	
}
	
	