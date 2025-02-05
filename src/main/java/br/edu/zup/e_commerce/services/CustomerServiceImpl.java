package br.edu.zup.e_commerce.services;

import br.edu.zup.e_commerce.dtos.CustomerRequestDTO;
import br.edu.zup.e_commerce.dtos.CustomerResponseDTO;
import br.edu.zup.e_commerce.exceptions.BusinessCustomerException;
import br.edu.zup.e_commerce.exceptions.CustomerNotFoundException;
import br.edu.zup.e_commerce.mappers.CustomerMapper;
import br.edu.zup.e_commerce.models.Customer;
import br.edu.zup.e_commerce.repositories.CustomerRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer newCustomer = CustomerMapper.fromDTOToEntity(customerRequestDTO);

        Customer savedCustomer = saveCustomerSafely(newCustomer);

        return CustomerMapper.fromEntityToDTO(savedCustomer);
    }

    @Override
    public CustomerResponseDTO getCustomerByCpf(String cpf) {
        Customer foundCustomer = customerRepository.findByCpf(cpf).orElseThrow(() ->
                new CustomerNotFoundException("Cliente com CPF " + cpf + " não foi encontrado.")
        );

        return CustomerMapper.fromEntityToDTO(foundCustomer);
    }

    @Override
    public CustomerResponseDTO updateCustomer(String cpf, CustomerRequestDTO updateCustomer) {
        Customer existingCustomer = customerRepository.findByCpf(cpf).orElseThrow(() ->
                new CustomerNotFoundException("Cliente com CPF " + cpf + " não foi encontrado.")
        );

        // Permite alterar o CPF
        existingCustomer.setCpf(updateCustomer.getCpf());
        existingCustomer.setName(updateCustomer.getName());
        existingCustomer.setEmail(updateCustomer.getEmail());

        Customer savedCustomer = saveCustomerSafely(existingCustomer);

        return CustomerMapper.fromEntityToDTO(savedCustomer);
    }

    private Customer saveCustomerSafely(Customer customer) {
        try {
            return customerRepository.save(customer);
        } catch (DataIntegrityViolationException e) {
            throw new BusinessCustomerException("CPF e/ou Email já cadastrado(s).");

        }
    }
}
