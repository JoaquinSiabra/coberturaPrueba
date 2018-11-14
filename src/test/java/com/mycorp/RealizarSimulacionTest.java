package com.mycorp;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import junit.framework.TestCase;
import util.datos.UsuarioAlta;


/**
 * Unit test for simple App.
 */
public class RealizarSimulacionTest extends TestCase {

	private static String NUM_TARJETA = "NUM_TARJETA";
	private static String NUM_POLIZA = "NUM_POLIZA";

	ZendeskService zendeskService = new ZendeskService();
	
    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp() {
        assertTrue( true );
    }
    
    @Test
    public void testUsuarioSinPolizaNiTarjeta() {
    	UsuarioAlta usuarioAlta = new UsuarioAlta();
    	String userAgent = "AGENT";
    	zendeskService.altaTicketZendesk(usuarioAlta, userAgent);
        assertTrue( true );
    }
    
    @Test
    public void testUsuarioConPolizaYTarjeta() {
    	UsuarioAlta usuarioAlta = new UsuarioAlta();
    	usuarioAlta.setNumPoliza(NUM_POLIZA);
    	usuarioAlta.setNumTarjeta(NUM_TARJETA);
    	String userAgent = "AGENT";
    	zendeskService.altaTicketZendesk(usuarioAlta, userAgent);
        assertTrue( true );
    }

}
