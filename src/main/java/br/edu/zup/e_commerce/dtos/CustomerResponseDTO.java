package br.edu.zup.e_commerce.dtos;

public class CustomerResponseDTO {
    private String cpf;
    private String name;
    private String email;

    public CustomerResponseDTO() {
    }

    public CustomerResponseDTO(String cpf, String name, String email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
