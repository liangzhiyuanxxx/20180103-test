import application.SpringBootController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * 测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class SpringBootControllerTest {
    private MockMvc mockMvc;

    @Before
    public  void setUp() throws Exception{
        mockMvc= MockMvcBuilders.standaloneSetup(new SpringBootController()).build();
    }

    @Test
    public void testUserController() throws Exception {
        RequestBuilder requestBuilder=null;
        requestBuilder= MockMvcRequestBuilders.get("/");
         mockMvc.perform(requestBuilder);
        System.out.println("123213");
    }
}
