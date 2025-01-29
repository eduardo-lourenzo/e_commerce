package br.edu.zup.e_commerce.repositories;

import br.edu.zup.e_commerce.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
