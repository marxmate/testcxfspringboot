package server.api.config;

import io.swagger.config.ScannerFactory;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.models.Swagger;
import io.swagger.models.auth.ApiKeyAuthDefinition;
import io.swagger.models.auth.In;
import org.apache.cxf.Bus;
import org.apache.cxf.annotations.Provider;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;

@Provider(value = Provider.Type.Feature, scope = Provider.Scope.Server)
public class ExtendedSwagger2Feature extends Swagger2Feature {

    @Override
    protected void addSwaggerResource(Server server, Bus bus) {
        super.addSwaggerResource(server, bus);

        BeanConfig config = (BeanConfig) ScannerFactory.getScanner();
        Swagger swagger = config.getSwagger();
        swagger.securityDefinition("Bearer", new ApiKeyAuthDefinition("authorization", In.HEADER));
    }
}