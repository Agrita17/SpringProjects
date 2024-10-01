package productapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productapp.dao.ProductDao;
import productapp.model.Product;

@Controller
public class MainController {
	@Autowired
	private ProductDao productDao;

	@RequestMapping("/")
	public String home(Model m) {
		List<Product> products = productDao.getAllProduct();
		m.addAttribute("product", products);
		return "index";
	}

	// Add product form action
	@RequestMapping("/addProduct")
	public String addProduct(Model m) {
		// sending data from controller to views
		m.addAttribute("title", "Add Product");
		return "add_product_form";
	}

	// handle add product form
	@RequestMapping(value = "/handle-product", method = RequestMethod.POST)
	public RedirectView handleProduct(/* taking data from view to controller */ @ModelAttribute Product product,
			HttpServletRequest request) {

		System.out.println(product);
		productDao.createProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}

	// delete handler
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request) {
		this.productDao.delete(productId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}

	@RequestMapping("update/{productId}")
	public String updateProduct(@PathVariable("productId") int pid, Model model) {
		Product product = this.productDao.getProduct(pid);
		model.addAttribute("product", product);
		return "update_form";
	}

	// handle updatde product form
	/*
	 * @RequestMapping(value="/update-product", method = RequestMethod.POST) public
	 * RedirectView updateProduct( taking data from view to
	 * controller @ModelAttribute Product product, HttpServletRequest request) {
	 * 
	 * System.out.println(product); productDao.updateProduct(product); RedirectView
	 * redirectView = new RedirectView();
	 * redirectView.setUrl(request.getContextPath()+"/"); return redirectView; }
	 */

}
