package de.tarent.challenge.store.products;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCatalog extends JpaRepository<Product, Long> {

    Product findBySku(String sku);
    Optional<Product> findByName(String name);

}
