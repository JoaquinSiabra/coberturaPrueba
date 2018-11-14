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
	private static String NUM_POLIZA = "12345";
	private static String NUM_ACRED = "12345";


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
    public void testUsuarioConPolizaYNoTarjeta() {
    	UsuarioAlta usuarioAlta = new UsuarioAlta();
    	usuarioAlta.setNumPoliza(NUM_POLIZA);
    	String userAgent = "AGENT";
    	zendeskService.altaTicketZendesk(usuarioAlta, userAgent);
        assertTrue( true );
    }
    
    @Test
    public void testUsuarioSinPolizaYConTarjeta() {
    	UsuarioAlta usuarioAlta = new UsuarioAlta();
    	usuarioAlta.setNumTarjeta(NUM_TARJETA);
    	String userAgent = "AGENT";
    	zendeskService.altaTicketZendesk(usuarioAlta, userAgent);
        assertTrue( true );
    }

}
