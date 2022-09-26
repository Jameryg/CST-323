package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("product")
public class ProductsEntity
{
	@Id
	Long product_id;
	
	@Column("image")
	String image;
	
	@Column("length")	
	float length;
	
	@Column("measurement_unit")
	String measuremeantUnit;
	
	@Column("weight")
	float weight;
	
	@Column("description")
	String description;
	
	@Column("user_id")
	Long userId;

	/**
	 * Default Constructor
	 */
	public ProductsEntity() 
	{
		
	}

	/**
	 * @param product_id
	 * @param image
	 * @param length
	 * @param measuremeantUnit
	 * @param weight
	 * @param description
	 * @param userId
	 */
	public ProductsEntity(Long product_id, String image, float length, String measuremeantUnit, float weight,
			String description, Long userId) 
	{
		this.product_id = product_id;
		this.image = image;
		this.length = length;
		this.measuremeantUnit = measuremeantUnit;
		this.weight = weight;
		this.description = description;
		this.userId = userId;
	}

	/**
	 * @return the product_id
	 */
	public Long getProduct_id()
	{
		return product_id;
	}

	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(Long product_id) 
	{
		this.product_id = product_id;
	}

	/**
	 * @return the image
	 */
	public String getImage() 
	{
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image)
	{
		this.image = image;
	}

	/**
	 * @return the length
	 */
	public float getLength()
	{
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(float length) 
	{
		this.length = length;
	}

	/**
	 * @return the measuremeantUnit
	 */
	public String getMeasuremeantUnit() 
	{
		return measuremeantUnit;
	}

	/**
	 * @param measuremeantUnit the measuremeantUnit to set
	 */
	public void setMeasuremeantUnit(String measuremeantUnit)
	{
		this.measuremeantUnit = measuremeantUnit;
	}

	/**
	 * @return the weight
	 */
	public float getWeight() 
	{
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(float weight)
	{
		this.weight = weight;
	}

	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId()
	{
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}
}
