package server.api.config;

import io.swagger.config.ScannerFactory;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.models.Swagger;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class SwaggerConfig {

    @Bean
    @ConfigurationProperties("swagger")
    public Swagger2Feature swagger() {
        return new ExtendedSwagger2Feature();
    }

    @Bean
    @DependsOn("jaxRsServer")
    public ServletContextInitializer initializer() {
        return servletContext -> {
            BeanConfig scanner = (BeanConfig) ScannerFactory.getScanner();
            Swagger swagger = scanner.getSwagger();
            servletContext.setAttribute("swagger", swagger);
        };
    }
}