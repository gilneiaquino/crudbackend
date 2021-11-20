package br.com.crudbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.crudbackend.modelo.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
