package br.edu.zup.e_commerce.repositories;

import br.edu.zup.e_commerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
