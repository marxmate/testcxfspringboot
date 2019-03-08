package client.api;

import client.service.TestService;
import model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestControllerImpl implements TestController {

    private TestService testService;

    @Autowired
    public TestControllerImpl(TestService testService) {
        this.testService = testService;
    }

    @Override
    public Test getTest() {
     //   return testService.getClient().getTestByPathParam("randomName");
        return null;
    }
}
