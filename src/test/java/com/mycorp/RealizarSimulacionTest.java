package com.mycorp;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnit44Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.mycorp.support.MensajeriaService;
import com.mycorp.support.ZendeskHelper;

import junit.framework.TestCase;
import portalclientesweb.ejb.interfaces.PortalClientesWebEJBRemote;
import util.datos.PolizaBasico;
import util.datos.UsuarioAlta;


/**
 * Unit test for simple App.
 */
@RunWith(MockitoJUnit44Runner.class)
public class RealizarSimulacionTest {

	private static String NUM_TARJETA = "NUM_TARJETA";
	private static String NUM_POLIZA = "12345";
	private static String NUM_ACRED = "12345";

	@InjectMocks
	ZendeskService zendeskService = new ZendeskService();
	
	@Mock
    private PortalClientesWebEJBRemote portalclientesWebEJBRemote;
	@Mock
    MensajeriaService emailService;
    @Mock
    ZendeskHelper zendeskHelper;
	
    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp() {
       // assertTrue( true );
    }
    
    @Test
    public void testUsuarioSinPolizaNiTarjeta() {
    	UsuarioAlta usuarioAlta = new UsuarioAlta();
    	String userAgent = "AGENT";
    	zendeskService.altaTicketZendesk(usuarioAlta, userAgent);
       // assertTrue( true );
    }
    
    @Test
    public void testUsuarioConPolizaYNoTarjeta() {
    	UsuarioAlta usuarioAlta = new UsuarioAlta();
    	usuarioAlta.setNumPoliza(NUM_POLIZA);
    	String userAgent = "AGENT";
    	
        when(zendeskHelper.createPolizaBasicoFromUsuarioAlta(any(UsuarioAlta.class))).thenReturn(new PolizaBasico());

    	
    	zendeskService.altaTicketZendesk(usuarioAlta, userAgent);
        //assertTrue( true );
    }
    
    @Test
    public void testUsuarioSinPolizaYConTarjeta() {
    	UsuarioAlta usuarioAlta = new UsuarioAlta();
    	usuarioAlta.setNumTarjeta(NUM_TARJETA);
    	String userAgent = "AGENT";
    	zendeskService.altaTicketZendesk(usuarioAlta, userAgent);
        //assertTrue( true );
    }

}
