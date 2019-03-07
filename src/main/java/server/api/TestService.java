package server.api;

import model.Test;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public Test getTest(String name, int integerSmall){
        return new Test(name, integerSmall);
    }

    public Test create(JsonInput input) {
        return new Test(input.getName(), input.getAge());
    }
}
