package springapp.web;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springapp-servlet.xml"})
@WebAppConfiguration
public class InventoryControllerMvcTest {
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testController() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
//		ResultMatcher msg = MockMvcResultMatchers.model()
//				.attribute("msg", "Hello World!");

		MockHttpServletRequestBuilder builder1 = MockMvcRequestBuilders.get("/");
		mockMvc.perform(builder1).andExpect(ok);
		
		MockHttpServletRequestBuilder builder2 = MockMvcRequestBuilders.get("/home");
		mockMvc.perform(builder2).andExpect(ok);
		
		MockHttpServletRequestBuilder builder3 = MockMvcRequestBuilders.get("/priceincrease");
		mockMvc.perform(builder3).andExpect(ok);
	}
}
