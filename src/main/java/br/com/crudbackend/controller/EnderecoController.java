package br.com.crudbackend.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.crudbackend.dto.EnderecoFormAlteracao;
import br.com.crudbackend.dto.EnderecoFormInclusao;
import br.com.crudbackend.modelo.Endereco;
import br.com.crudbackend.repository.EnderecoRepository;
import br.com.crudbackend.util.LatitudeLongitude;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	private static final String VAZIO = "";
	@Autowired
	private EnderecoRepository enderecoRepository;

	@PostMapping("cadastrar")
	@Transactional
	public ResponseEntity<Endereco> cadastrar(@RequestBody @Valid EnderecoFormInclusao formInclusao, UriComponentsBuilder uriBuilder) throws JSONException, IOException {
		
		LatitudeLongitude coordenada = new LatitudeLongitude();
		if(formInclusao.getLatitude().equals(VAZIO)) {
			formInclusao.setLatitude(coordenada.recuperarLatitude().toString());
		}
		
		if(formInclusao.getLongitude().equals(VAZIO)) {
			formInclusao.setLongitude(coordenada.recuperarLongitude().toString());
		}

		Endereco endereco = enderecoRepository.save(new Endereco(formInclusao));

		URI uri = uriBuilder.path("/endereco/alterar/{id}").buildAndExpand(endereco.getId()).toUri();
		return ResponseEntity.created(uri).body(endereco);
	}

	@PostMapping("alterar")
	public ResponseEntity<Endereco>  Alterar(@RequestBody @Valid EnderecoFormAlteracao formAlteracao) { 
		
		Optional<Endereco> optional = enderecoRepository.findById(formAlteracao.getId());
		if (optional.isPresent()) {
			enderecoRepository.save(new Endereco(formAlteracao));
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();

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
