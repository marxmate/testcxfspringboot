package server.api;

import model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestResourceImpl implements TestResource {

    @Autowired
    private TestBackendService service;

    @Override
    public Test getTestObject(String name, int age) {
        return service.getTest(name, age);
    }

    @Override
    public Test createTest(JsonInput input) {
        return service.create(input);
    }

    @Override
    public Test getTestByPathParam(String name) {
        return service.getTestByNameParam(name);
    }

}
