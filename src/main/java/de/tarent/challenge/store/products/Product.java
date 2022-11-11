package de.tarent.challenge.store.products;

import static javax.persistence.GenerationType.AUTO;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Sets;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Column(name = "sku", unique=true)
    @NotBlank
    private String sku;

    @Column(name = "name")
    @NotBlank
    private String name;
    
    @ElementCollection
    @NotEmpty
    private Set<String> eans;

    private Product() {
    }

    public Product(String sku, String name, Set<String> eans) {
        this.sku = sku;
        this.name = name;
        this.eans = eans;
    }

    public String getSku() {
        return sku;
    }
    
    public void setSku(String sku) {
    	this.sku = sku;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }

    public Set<String> getEans() {
        return Sets.newHashSet(eans);
    }
    
    public void setEans(Set<String> eans) {
    	this.eans = eans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(sku, product.sku) &&
                Objects.equals(name, product.name) &&
                Objects.equals(eans, product.eans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sku, name, eans);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("sku", sku)
                .add("name", name)
                .add("eans", eans)
                .toString();
    }
}
