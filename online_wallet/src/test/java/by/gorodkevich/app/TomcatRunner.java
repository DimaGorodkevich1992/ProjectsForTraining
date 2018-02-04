package by.gorodkevich.app;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;

public class TomcatRunner {
    public static void main(String[] args) throws LifecycleException, ServletException {
        startTomcat();
    }

    private static void startTomcat() throws LifecycleException, ServletException {
        System.setProperty("catalina.base", new File(".").getAbsolutePath());

        Tomcat tomcat = new Tomcat();
        Connector httpsConnector = createHttpsConnector();
        tomcat.getService().addConnector(httpsConnector);
        tomcat.setConnector(httpsConnector);
        tomcat.setBaseDir("target");
        tomcat.setPort(8080);
        tomcat.addWebapp("", (new File("./target/classes")).getAbsolutePath());
        tomcat.start();
        tomcat.getServer().await();
    }

    private static Connector createHttpsConnector() {
        Connector connector = new Connector();
        connector.setPort(8080);
        connector.setScheme("http");

        return connector;
    }
}
