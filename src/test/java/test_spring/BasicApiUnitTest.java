package test_spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import springsandbox.Controller.MutableUserController;
import springsandbox.Entity.MutableUser;
import springsandbox.SpringSandBoxApplication;

import java.util.NoSuchElementException;

import static com.google.common.truth.Truth.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = SpringSandBoxApplication.class)
//@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class BasicApiUnitTest {

    @Autowired
    private MutableUserController controller;

    @Test
    public void test_01_create_should_inc_count() {
        String prefix = "mutable users count: ";
        assertThat(controller.count()).isEqualTo(prefix + 0);
        controller.create("youcef");
        assertThat(controller.count()).isEqualTo(prefix + 1);
        controller.create("kalbo");
        assertThat(controller.count()).isEqualTo(prefix + 2);
        controller.create("kalbo");
        assertThat(controller.count()).isEqualTo(prefix + 2);
    }

    @Test
    public void test_02_rename_should_alter_name() {
        controller.create("kalbo");

        String expectedName = "odinz";
        MutableUser target = controller.find("kalbo");

        MutableUser expected = new MutableUser();
        expected.setName(expectedName);
        expected.setId(target.getId());
        expected.setVersion(target.getVersion() + 1);

        MutableUser renamedUser = controller.rename("kalbo", expectedName);

        assertThat(renamedUser).isEqualTo(expected);
        assertThat(renamedUser.getName()).isEqualTo(expected.getName());
        assertThat(renamedUser.getVersion()).isEqualTo(expected.getVersion());
    }

    @Test(expected = NoSuchElementException.class)
    public void test_03_rename_non_existing_should_fail() {
        controller.rename("test","test2");
    }
}
