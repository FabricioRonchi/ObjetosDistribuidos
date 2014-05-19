/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import remote.UserFacadeRemote;

public class TesteRMI {
     private static final String JNDI_NAME
            = "java:global/ObjetoDistribuido3/ObjetoDistribuido3-ejb/UserFacade";

    public static void main(String[] args) {

        InitialContext ctx;
        Properties props = new Properties();
        try {
            props.setProperty("java.naming.factory.initial",
                    "com.sun.enterprise.naming.SerialInitContextFactory");

            props.setProperty("java.naming.factory.url.pkgs",
                    "com.sun.enterprise.naming");

            props.setProperty("java.naming.factory.state",
                    "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

            // optional.  Defaults to localhost.  Only needed if web server is running 
            // on a different host than the appserver    
            props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");

            // optional.  Defaults to 3700.  Only needed if target orb port is not 3700.
            props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

            ctx = new InitialContext(props);
            UserFacadeRemote userRemote = (UserFacadeRemote) ctx.lookup(JNDI_NAME);           
            userRemote.findAll();
        } catch (NamingException ex) {
            Logger.getLogger(TesteRMI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}


