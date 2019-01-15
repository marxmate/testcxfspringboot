package server.api;

import model.Test;
import org.springframework.stereotype.Service;

@Service
public class TestResourceImpl implements TestResource {

    @Override
    public Test getTestObject(String name, int integerSmall) {
        return new Test("name", 1, 1, 1L, 1L);
    }
}
