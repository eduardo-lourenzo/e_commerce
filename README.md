# E-Commerce
Sistema básico de E-Commerce que permita o cadastro de produtos, clientes e a realização de compras.

### Observações e anotações:
```@Column(unique = true)```

Exceções:
Hibernate: org.hibernate.exception.ConstraintViolationException
JPA: javax.persistence.PersistenceException

PUT /clientes/{cpf} → Atualiza dados de um cliente
O cliente tem Id que será mantido ao atualizar o cliente.
O CPF da url será considerado um dado antigo.
E o CPF do body será considerado um dado novo.
Considerando que o cliente possa corrigir/alterar o CPF.