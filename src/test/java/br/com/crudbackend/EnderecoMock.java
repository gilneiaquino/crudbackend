package br.com.crudbackend;

import br.com.crudbackend.modelo.Endereco;

public class EnderecoMock {
	
	public Endereco carregarEndereco(Long id) {
		
		Endereco form = new Endereco();
		form.setId(id);
		form.setCity("Cidade");
		form.setComplement("comple");
		form.setId(0L);
		form.setLatitude("");
		form.setLongitude("");
		form.setCountry("Pais");
		form.setNeighbourhood("Bairro");
		form.setNumber(1L);
		form.setState("Estado");
		form.setStreetName("Rua");
		form.setZipcode("77777777"); 
		return form;
	}

}
