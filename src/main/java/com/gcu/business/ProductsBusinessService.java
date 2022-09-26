package com.gcu.business;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.ProductsDataService;
import com.gcu.data.entity.ProductsEntity;
import com.gcu.model.ProductsModel;

public class ProductsBusinessService implements ProductsBusinessServiceInterface
{
	@Autowired
	ProductsDataService productsService;
	
	public ProductsBusinessService() 
	{
		
	}
	
	public List<ProductsModel> getProducts() 
	{
		// Get all all the Entity Products
	    List<ProductsEntity> productsEntity = productsService.findAll();
	    // Iterate over the Entity Products and create a list of Domain Products
	    List<ProductsModel> productsDomain = new ArrayList<ProductsModel>();
	    
	    for (ProductsEntity entity : productsEntity)
	    {
	    	productsDomain.add(new ProductsModel(entity.getProduct_id(), entity.getImage(), entity.getLength(), entity.getMeasuremeantUnit(), entity.getWeight(), entity.getDescription()));
	    }
	    // Return list of Domain Products
	    return productsDomain;
	}
	
	public void addProduct(ProductsModel productsModel)
	{
		// Adds a product to the list
		productsService.create(new ProductsEntity(0L, productsModel.getImage(), productsModel.getLength(), productsModel.getMeasurementUnit(), productsModel.getWeight(), productsModel.getDescription(), 1L));
	}

	public void deleteProduct(ProductsModel productsModel) 
	{
		// Delete a product from the list
		productsService.delete(new ProductsEntity(productsModel.getProductId(), productsModel.getImage(), productsModel.getLength(), productsModel.getMeasurementUnit(), productsModel.getWeight(), productsModel.getDescription(), 1L));
	}

	public void updateProduct(ProductsModel productsModel) 
	{
		// Update a product inside of the list
		productsService.update(new ProductsEntity(productsModel.getProductId(), productsModel.getImage(), productsModel.getLength(), productsModel.getMeasurementUnit(), productsModel.getWeight(), productsModel.getDescription(), 1L));
	}
}
