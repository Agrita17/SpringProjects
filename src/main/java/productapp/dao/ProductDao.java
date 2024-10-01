package productapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import productapp.model.Product;

@Component
public class ProductDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//create or update the product and add to db..
	@Transactional
	public void createProduct(Product product)
	{
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
	
	//getAll Product
	
	public List<Product> getAllProduct()
	{
		List<Product> products =this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	//get single product
	
	public Product getProduct(int id)
	{
		Product product = this.hibernateTemplate.get(Product.class, id);
		return product;
	}
	
	//delete product
	@Transactional
	public void delete(int pid)
	{
		Product product = getProduct(pid);
		this.hibernateTemplate.delete(product);
	}
}
