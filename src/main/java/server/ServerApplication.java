package server;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import server.api.TestResourceImpl;
import server.api.config.SwaggerConfig;

import java.util.Collections;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class ServerApplication extends SpringBootServletInitializer {

    @Autowired
    private Bus bus;

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ServerApplication.class);
    }

    @Bean
    public JacksonJaxbJsonProvider jsonProvider() {
        return new JacksonJaxbJsonProvider();
    }

    @Bean
    public Server rsServer() {
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(bus);
        endpoint.setAddress("/rest");
        endpoint.setServiceBeans(Collections.<Object>singletonList(new TestResourceImpl()));
        return endpoint.create();
    }
}
