package test_spring;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import springsandbox.Controller.MutableUserController;

@SpringBootTest
@ActiveProfiles("test")
public class BasicApiUnitTest {

    private MutableUserController controller;

    @Test
      public void hello1() {
        System.out.println(controller.count());
    }
}
