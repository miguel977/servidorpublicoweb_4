package com.abctreinamentos.servidorpublico.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.abctreinamentos.servidorpublico.model.ServidorPublico;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
public class ServidorPublicoServiceImpl implements ServidorPublicoService {

	private final String SERVIDOR ="/data/servidorpublico.json";
	@Override
	public List<ServidorPublico> listAll() {
			try {
			TypeReference<List<ServidorPublico>> typeref = 
					new TypeReference<List<ServidorPublico>>(){};
					
			InputStream inputstream = TypeReference.class.getResourceAsStream(SERVIDOR);
			
				List<ServidorPublico> servidorespublicos = 
						new ObjectMapper().readValue(inputstream, typeref);
				
				return servidorespublicos;
				
			} catch (IOException e) {
					System.out.println("Ecesão " + e.getMessage());
					
					return null;
				}
		
	}

	@Override
	public Optional<ServidorPublico> listByMatricula(Long matricula) {
		
		try {
			TypeReference<List<ServidorPublico>> typeref = 
					new TypeReference<List<ServidorPublico>>(){};
					
			InputStream inputstream = TypeReference.class.getResourceAsStream(SERVIDOR);
			
				List<ServidorPublico> servidorespublicos = 
						new ObjectMapper().readValue(inputstream, typeref);
				
				Optional <ServidorPublico> servidorEncontrado = servidorespublicos.stream().filter(servidor -> servidor.matricula()
						.equals(matricula)).findFirst();
				return servidorEncontrado;
				
			} catch (IOException e) {
					System.out.println("Ecesão " + e.getMessage());
					
					return null;
				}
	    }

}
