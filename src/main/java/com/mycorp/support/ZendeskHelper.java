package com.mycorp.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import util.datos.UsuarioAlta;

public class ZendeskHelper {
	
	  @Value("#{envPC['tarjetas.getDatos']}")
	  public String TARJETAS_GETDATOS = "";
	  
	    /** The rest template. */
	    @Autowired
	    @Qualifier("restTemplateUTF8")
	    private RestTemplate restTemplate;

	   public String obtenerDatosTarjeta(UsuarioAlta usuarioAlta) {
	    	 String urlToRead = TARJETAS_GETDATOS + usuarioAlta.getNumTarjeta();
	         ResponseEntity<String> res = restTemplate.getForEntity( urlToRead, String.class);
	         if(res.getStatusCode() == HttpStatus.OK){     
	        	 return res.getBody();
	         }
	         return null;
	    }
	   
	   public DatosCliente obtenerDatosCliente(String idCliente) {
           return restTemplate.getForObject("http://localhost:8080/test-endpoint", DatosCliente.class, idCliente);
	   }
	
}
