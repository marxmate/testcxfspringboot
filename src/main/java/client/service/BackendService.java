package client.service;

import org.springframework.beans.factory.annotation.Value;

public class BackendService<T> extends AbstractService<T> {
	
	@Value("${client.backend.address}")
	private String teckBackendBaseUri;


	@Override
	protected String getServiceUrl() {
		return teckBackendBaseUri;
	}
}
