package server.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestResourceImpl implements TestResource {

    @Autowired
    private TestBackendService service;

    //TODO: implementation goes here


}
