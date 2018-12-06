package client.api;

import client.service.TestService;
import model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class TestController {

    private TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Test getTest() {
        return testService.getClient().getTest("nameIn", 6);
    }
}
