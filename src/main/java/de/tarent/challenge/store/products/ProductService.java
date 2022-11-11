package de.tarent.challenge.store.products;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

	private final ProductCatalog productCatalog;

	public ProductService(ProductCatalog productCatalog) {
		this.productCatalog = productCatalog;
	}

	public List<Product> retrieveAllProducts() {
		return productCatalog.findAll();
	}

	public Product retrieveProductBySku(String sku) {
		return productCatalog.findBySku(sku);
	}

	public Product saveProduct(Product product) {
		return productCatalog.save(product);
	}

	public Product updateProduct(Product product) throws NoSuchElementException {
		Optional<Product> optionalProduct = Optional.ofNullable(productCatalog.findByName(product.getName()))
				.orElseThrow(() -> new NoSuchElementException("No product was found with name " + product.getName()));

		Product p = optionalProduct.get();
		
		p.setName(product.getName());
		p.setSku(product.getSku());
		p.setEans(product.getEans());
		
		return productCatalog.save(p);
	}
}
