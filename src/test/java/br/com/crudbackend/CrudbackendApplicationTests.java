package br.com.crudbackend;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.crudbackend.modelo.Endereco;
import br.com.crudbackend.repository.EnderecoRepository;

@SpringBootTest
class CrudbackendApplicationTests {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	private EnderecoMock mock = new EnderecoMock();
	
	@Test
	public void cadastrar() {
		Endereco endereco =  enderecoRepository.save(mock.carregarEndereco(0L));
		assertNotNull(endereco);
	}
	
	@Test
	public void alterar() {
		Optional<Endereco> optional = enderecoRepository.findById(mock.carregarEndereco(1L).getId());
		if (optional.isPresent()) {
			Endereco endereco =  enderecoRepository.save(mock.carregarEndereco(1L));
			assertNotNull(endereco);
 		} 
	}
	
	@Test
	public void excluir() {
		Optional<Endereco> optional = enderecoRepository.findById(1L);
		if (optional.isPresent()) {
			enderecoRepository.deleteById(1L);
 		}
 	}
	
	@Test
	public void lista() {
		List<Endereco> lista = enderecoRepository.findAll();
		assertNotNull(lista);
 	}

	@Test
	void contextLoads() {
	}
	
	

}
