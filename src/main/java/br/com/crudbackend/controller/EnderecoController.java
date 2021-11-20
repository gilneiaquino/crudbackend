package br.com.crudbackend.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.crudbackend.dto.EnderecoFormInclusao;
import br.com.crudbackend.modelo.Endereco;
import br.com.crudbackend.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@PostMapping("cadastrar")
	@Transactional
	public ResponseEntity<Endereco> cadastrar(@RequestBody @Valid EnderecoFormInclusao formInclusao, UriComponentsBuilder uriBuilder) {

		Endereco endereco = enderecoRepository.save(new Endereco(formInclusao));

		URI uri = uriBuilder.path("/endereco/alterar/{id}").buildAndExpand(endereco.getId()).toUri();
		return ResponseEntity.created(uri).body(endereco);
	}

	@PostMapping("alterar")
	public Endereco Alterar(Endereco endereco) {		
		return enderecoRepository.save(endereco);
	}

	@PostMapping("excluir/{id}")
	@Transactional
	public ResponseEntity<Endereco> excluir(Long id) {
		Optional<Endereco> optional = enderecoRepository.findById(id);
		if (optional.isPresent()) {
			enderecoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("listar")
	public List<Endereco> listar() {
		List<Endereco> alunos = enderecoRepository.findAll();
		return alunos;
	}

}
