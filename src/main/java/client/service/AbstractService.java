package client.service;


import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.ws.rs.ext.Provider;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractService<T> implements InitializingBean {

    private static List<Object> providers;

    @Autowired
    private ApplicationContext applicationContext;

    private final Class<T> resourceClass;
    private T resource;
    private long defaultTimeOut = 300000;

    @SuppressWarnings("unchecked")
    public AbstractService() {
        this.resourceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @Override
    public void afterPropertiesSet() {
        if (providers == null) {
            synchronized (AbstractService.class) {
                Map<String, Object> providerBeans = applicationContext.getBeansWithAnnotation(Provider.class);
                providers = new ArrayList<>(providerBeans.values());
            }
        }
        resource = JAXRSClientFactory.create(getServiceUrl(), resourceClass, providers);
        authorizeResource(this.resource);
        addInterceptors(this.resource);
    }

    private void addInterceptors(T resource) {
        WebClient.getConfig(resource).getHttpConduit().getClient().setConnectionTimeout(defaultTimeOut);
        WebClient.getConfig(resource).getHttpConduit().getClient().setReceiveTimeout(defaultTimeOut);
    }

    protected void authorizeResource(T resource) {
        // no-op
    }

    protected abstract String getServiceUrl();

    public T getClient() {
        return resource;
    }
}
