package client.api;

import model.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface TestController {

    @RequestMapping(value = "get", method = RequestMethod.GET)
    Test getTest();
}
