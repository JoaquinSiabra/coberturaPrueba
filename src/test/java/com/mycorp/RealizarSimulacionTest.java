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


	ZendeskService zendeskService;
	
    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp() {
        assertTrue( true );
    }
    
    @Test
    public void testUsuarioSinPolizaNiTarjeta() {
    	zendeskService = new ZendeskService();

    	UsuarioAlta usuarioAlta = new UsuarioAlta();
    	String userAgent = "AGENT";
    	zendeskService.altaTicketZendesk(usuarioAlta, userAgent);
        assertTrue( true );
    }

}
