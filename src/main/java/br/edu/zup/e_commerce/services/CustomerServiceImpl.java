package br.edu.zup.e_commerce.services;

import br.edu.zup.e_commerce.dtos.CustomerRequestDTO;
import br.edu.zup.e_commerce.dtos.CustomerResponseDTO;
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

        Customer savedCustomer = saveCustomerHandlingExceptions(newCustomer);

        return CustomerMapper.fromEntityToDTO(savedCustomer);
    }

    @Override
    public CustomerResponseDTO getCustomerByCpf(String cpf) {
        Customer foundCustomer = customerRepository.findByCpf(cpf).orElseThrow(() ->
                new NoSuchElementException("Cliente com CPF " + cpf + " não foi encontrado.")
        );
        // CustomerNotFoundException("Cliente com CPF " + cpf + " não foi encontrado.") */

        return CustomerMapper.fromEntityToDTO(foundCustomer);
    }

    @Override
    public CustomerResponseDTO updateCustomer(String cpf, CustomerRequestDTO updateCustomerRequestDTO) {
        Customer existingCustomer = customerRepository.findByCpf(cpf).orElseThrow(() ->
                new NoSuchElementException("Cliente com CPF " + cpf + " não foi encontrado.")
        );

        existingCustomer.setCpf(updateCustomerRequestDTO.getCpf());
        existingCustomer.setName(updateCustomerRequestDTO.getName());
        existingCustomer.setEmail(updateCustomerRequestDTO.getEmail());

        Customer savedCustomer = saveCustomerHandlingExceptions(existingCustomer);

        return CustomerMapper.fromEntityToDTO(savedCustomer);
    }

    private Customer saveCustomerHandlingExceptions(Customer customer) {
        try {
            return customerRepository.save(customer);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("CPF ou email já cadastrado.");
            // throw new BusinessCustomerException("CPF ou email já cadastrado.");
            // e.getMessage().contains("UK_CPF");
        }
    }
}
