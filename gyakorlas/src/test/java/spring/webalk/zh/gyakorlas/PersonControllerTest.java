package spring.webalk.zh.gyakorlas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import spring.webalk.zh.gyakorlas.model.person;
import spring.webalk.zh.gyakorlas.model.personRepository;

/* @SprintBootTest
 * Spring Boot provides a @SpringBootTest annotation, which can be used as an alternative 
 * to the standard spring-test @ContextConfiguration annotation when you need Spring Boot features. 
 * The annotation works by creating the ApplicationContext used in your tests through SpringApplication. 
 * In addition to @SpringBootTest a number of other annotations are also provided
 * for testing more specific slices of an application.
 */

/* @AutoConfigureMockMvc
 * MOCK(Default) : Loads a web ApplicationContext and provides a mock web environment. 
 * Embedded servers are not started when using this annotation. If a web environment is not 
 * available on your classpath, this mode transparently falls back to creating a regular 
 * non-web ApplicationContext. It can be used in conjunction with @AutoConfigureMockMvc 
 * or @AutoConfigureWebTestClient for mock-based testing of your web application.
 */

/* @Transactional
 * If your test is @Transactional, it rolls back the transaction at the end of each test
 *  method by default. However, as using this arrangement with either RANDOM_PORT or 
 *  DEFINED_PORT implicitly provides a real servlet environment, the HTTP client and server
 *  run in separate threads and, thus, in separate transactions. Any transaction initiated 
 *  on the server does not roll back in this case.
 */

/*@Autowired
 * The @Autowired annotation provides more fine-grained control over where and how 
 * autowiring should be accomplished. The @Autowired annotation can be used to autowire
 * bean on the setter method just like @Required annotation, constructor, a property 
 * or methods with arbitrary names and/or multiple arguments.
 * 
 * You can use @Autowired annotation on setter methods to 
 * get rid of the <property> element in XML configuration file.
 */

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class PersonControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private personRepository personRepo;
	
	@Test
	public void ShouldNoMainPage() throws Exception {
		this.mockMvc.perform(get("/"))
			.andDo(print())
			.andExpect(status().is4xxClientError());
	}
	
	@Test
	public void ShouldReturnPerson() throws Exception {
		person person = new person(1L, "1", 12);
		
		Iterable<person> all = personRepo.findAll();
		personRepo.save(person);
		
		this.mockMvc.perform(get("/person"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.[0].name", is("1")))
			.andExpect(jsonPath("$.[0].age", is("12")));
	}
	
	@Test
	public void shouldReturnPerson2() throws Exception {
		person person = new person(1L,"2", 22);
		
		Iterable<person> all = personRepo.findAll();
		personRepo.save(person);
		
		this.mockMvc.perform(get("/person"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.[0].name", is("2")))
			.andExpect(jsonPath("$.[0].age", is("22")));
	}
}
