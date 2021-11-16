package hu.iit.webalk.database;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import hu.iit.webalk.database.repository.People;
import hu.iit.webalk.database.repository.PeopleRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DatabaseApplicationTests {

	@Autowired
	private MockMvc mockMcv;
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	@Test
	void shouldReturnDefaultMessage() throws Exception {
		this.mockMcv.perform(get("/"))
			.andDo(print())
			.andExpect(status().is4xxClientError());
	}
	
	@Test
	void shouldReturnPeople() throws Exception {
		People people = new People(1L, 12, "1");
		
		Iterable<People> all = peopleRepository.findAll();
		peopleRepository.save(people);
		
		this.mockMcv.perform(get("/People"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string("[(\"id\":1,\"name\":\"1\",\"age\":12)]"));
	}
	
	@Test
	void shouldReturnPeople2() throws Exception {
		People people = new People(1L, 22, "2");
		
		Iterable<People> all = peopleRepository.findAll();
		peopleRepository.save(people);
		
		this.mockMcv.perform(get("/People"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect("age", is());
	}

}
