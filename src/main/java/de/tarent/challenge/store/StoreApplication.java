package de.tarent.challenge.store;

import com.google.common.collect.ImmutableSet;
import de.tarent.challenge.store.products.Product;
import de.tarent.challenge.store.products.ProductCatalog;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

    public void dataSetup(ProductCatalog catalog) {
        catalog.save(new Product("102", "Milch", ImmutableSet.of("12345678", "77777777", "23498128")));
        catalog.save(new Product("2035", "Brot", ImmutableSet.of("34558821", "12323410")));
        catalog.save(new Product("S-155", "Käse", ImmutableSet.of("34598146", "43565922", "23454045")));
        catalog.save(new Product("1488", "Wurst", ImmutableSet.of("18754629", "46025548")));
        catalog.save(new Product("B001", "Couscous", ImmutableSet.of("54342316")));
    }

    @Bean
    ApplicationRunner init(ProductCatalog productCatalog) {
        return (ApplicationArguments args) -> dataSetup(productCatalog);
    }
}