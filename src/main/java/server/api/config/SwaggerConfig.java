package server.api.config;

import io.swagger.v3.oas.models.security.SecurityScheme;
import model.Test;
import org.apache.cxf.jaxrs.openapi.OpenApiFeature;
import org.apache.cxf.jaxrs.swagger.ui.SwaggerUiConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.QueryParam;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class SwaggerConfig {

    public static final String BEARER_AUTH = "bearerAuth";

    @Bean
    @ConfigurationProperties("swagger")
    public OpenApiFeature swagger() {
        OpenApiFeature openApiFeature = new OpenApiFeature();
        openApiFeature.setTitle("Backend Application");
        openApiFeature.setDescription("Swagger documentation of Backend Application REST services");
        openApiFeature.setSecurityDefinitions(Collections.singletonMap(BEARER_AUTH, new SecurityScheme()
                .in(SecurityScheme.In.HEADER)
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .name("Authorization")
                .bearerFormat("JWT")));
        openApiFeature.setScan(true);
        Set<String> packages = new HashSet<>();
        packages.add("server.api");
        openApiFeature.setResourcePackages(packages);
        openApiFeature.setReadAllResources(true);
        openApiFeature.setSwaggerUiConfig(
                new SwaggerUiConfig()
                        .url("/rest/openapi.json"));
        return openApiFeature;
    }
}