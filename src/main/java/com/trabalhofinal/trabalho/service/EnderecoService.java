package com.trabalhofinal.trabalho.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.trabalhofinal.trabalho.dto.ConsultaCep;
import com.trabalhofinal.trabalho.entity.Endereco;
import com.trabalhofinal.trabalho.repository.EnderecoRepository;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;

	//get all
	public List<Endereco> getAllEnderecos(){
		return enderecoRepository.findAll(); 
	}
	
	//get id
	public Endereco getEnderecoById(int id) {
		return enderecoRepository.findById(id).orElse(null);
	}
	
	//save
	public ConsultaCep consultaCepApiExterna(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		
		String uri = "https://viacep.com.br/ws/{cep}/json";
		
		Map<String,String> params = new HashMap<String, String>();
		params.put("cep", cep);
		
		ConsultaCep consultaCep = restTemplate.getForObject(uri, ConsultaCep.class, params);
		
		return consultaCep;
	}
	
	public Endereco saveEnderecoFromApi(String cep) {
		ConsultaCep consultaCep = consultaCepApiExterna(cep);
		
		Endereco endereco = new Endereco();
		
		endereco.setCep(consultaCep.getCep());
		endereco.setBairro(consultaCep.getBairro());
		endereco.setCidade(consultaCep.getLocalidade());
		endereco.setComplemento(consultaCep.getComplemento());
		endereco.setNumero(consultaCep.getNumero());
		endereco.setRua(consultaCep.getLogradouro());
		endereco.setUf(consultaCep.getUf());
		
		return enderecoRepository.save(endereco);
	}
	
	//update
	public Endereco updateEndereco (Endereco endereco, int id) { 

		Endereco enderecoExistenteNoBanco = enderecoRepository.findById(id).get();
		enderecoExistenteNoBanco.setBairro(endereco.getBairro());
		enderecoExistenteNoBanco.setCidade(endereco.getCidade());
		enderecoExistenteNoBanco.setComplemento(endereco.getComplemento());
		enderecoExistenteNoBanco.setNumero(endereco.getNumero());
		enderecoExistenteNoBanco.setRua(endereco.getRua());
		enderecoExistenteNoBanco.setUf(endereco.getUf());
		
		return enderecoRepository.save(enderecoExistenteNoBanco);
	}

    public Endereco deleteEndereco(Integer id){
        enderecoRepository.deleteById(id);
        return getEnderecoById(id);
    }
    
    // public Endereco deleteEndereco(Integer id){
    //     Endereco endereco = getEnderecoById(id);
        
    //     //Incluir tratamento para id not found
    //     if(endereco != null){
    //         enderecoRepository.deleteById(id);
    //         return endereco;
    //     } else {
    //         return endereco;
    //     }
    // }
}
