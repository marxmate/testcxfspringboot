package client.service;


import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;
import java.lang.reflect.ParameterizedType;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractService<T> implements InitializingBean {

    @Autowired
    private ApplicationContext applicationContext;

    @Value("${cxf.metrics.enabled:false}")
    private boolean metricsEnabled;

    private final Class<T> resourceClass;
    private T resource;

    @SuppressWarnings("unchecked")
    public AbstractService() {
        this.resourceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @Override
    public void afterPropertiesSet() {
        Client client = ClientBuilder.newClient();
        client.register(new LoggingFilter());
        WebTarget target = client.target(UriBuilder.fromPath(getServiceUrl()));
        postProcessClient(client);
        resource = WebResourceFactory.newResource(resourceClass, target);
    }

    protected void postProcessClient(Client client) {
        // no-op
    }

    protected abstract String getServiceUrl();

    public T getClient() {
        return resource;
    }

    public class LoggingFilter implements ClientRequestFilter {
        private final Logger LOG = Logger.getLogger(LoggingFilter.class.getName());

        @Override
        public void filter(ClientRequestContext requestContext) {
            LOG.log(Level.SEVERE, Objects.toString(requestContext.getUri()));
            LOG.log(Level.INFO, Objects.toString(requestContext.getEntity()));
        }
    }
}

