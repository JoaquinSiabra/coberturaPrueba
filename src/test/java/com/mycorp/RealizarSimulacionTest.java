package com.mycorp;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnit44Runner;

import com.mycorp.support.DatosCliente;
import com.mycorp.support.MensajeriaService;
import com.mycorp.support.ZendeskHelper;

import portalclientesweb.ejb.interfaces.PortalClientesWebEJBRemote;
import util.datos.DatosPersonales;
import util.datos.DetallePoliza;
import util.datos.PolizaBasico;
import util.datos.UsuarioAlta;


/**
 * Unit test for simple App.
 */
@RunWith(MockitoJUnit44Runner.class)
public class RealizarSimulacionTest {

	private static String NUM_TARJETA = "NUM_TARJETA";
	private static String NUM_POLIZA = "12345";

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
    }
    
    @Test
    public void testUsuarioSinPolizaNiTarjeta() {
    	UsuarioAlta usuarioAlta = new UsuarioAlta();
    	String userAgent = "AGENT";
    	zendeskService.altaTicketZendesk(usuarioAlta, userAgent);
    }
    
    @Test
    public void testUsuarioConPolizaYNoTarjeta() {
    	UsuarioAlta usuarioAlta = new UsuarioAlta();
    	usuarioAlta.setNumPoliza(NUM_POLIZA);
    	String userAgent = "AGENT";
    	
        when(zendeskHelper.createPolizaBasicoFromUsuarioAlta(any(UsuarioAlta.class))).thenReturn(new PolizaBasico()); 
        
        DetallePoliza detallePoliza = new DetallePoliza();
        DatosPersonales tomador = new DatosPersonales();
        detallePoliza.setTomador(tomador);        
        when(portalclientesWebEJBRemote.recuperarDatosPoliza(any(PolizaBasico.class))).thenReturn(detallePoliza);  
        
        DatosCliente datos = new DatosCliente();
        datos.setFechaNacimiento("01/08/2017");
        datos.setGenCTipoDocumento(1);
        when(zendeskHelper.obtenerDatosCliente(any(String.class))).thenReturn(datos);   
    	zendeskService.altaTicketZendesk(usuarioAlta, userAgent);
    }
    
    @Test
    public void testUsuarioSinPolizaYConTarjeta() {
    	UsuarioAlta usuarioAlta = new UsuarioAlta();
    	usuarioAlta.setNumTarjeta(NUM_TARJETA);
    	String userAgent = "AGENT";
    	zendeskService.altaTicketZendesk(usuarioAlta, userAgent);
    }

}
