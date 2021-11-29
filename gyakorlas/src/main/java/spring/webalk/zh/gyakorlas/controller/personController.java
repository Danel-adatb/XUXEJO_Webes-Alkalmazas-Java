package spring.webalk.zh.gyakorlas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import spring.webalk.zh.gyakorlas.dao.personCreateDTO;
import spring.webalk.zh.gyakorlas.dao.personDTO;
import spring.webalk.zh.gyakorlas.service.person;
import spring.webalk.zh.gyakorlas.service.personService;

/*
 * A Controller is typically responsible for preparing a model Map with 
 * data and selecting a view name but it can also write directly to the
 *  response stream and complete the request.
 */

/*
 * @RestController:
 * @RestController is a convenience annotation for creating Restful controllers. 
 * It is a specialization of @Component and is autodetected through classpath scanning. 
 * It adds the @Controller and @ResponseBody annotations. It converts the response to JSON or XML.
 *  It does not work with the view technology, so the methods cannot return ModelAndView. 
 *  It is typically used in combination with annotated handler methods based on the @RequestMapping annotation.
 */

/*
 * @RequestMapping("...")
 * This annotation is used to map web requests onto specific handler classes and/or handler methods.
 * We can use it with class definition to create the base URI
 * We can use it with method to provide the URI pattern for which handler method will be used.
 * We can use a single method for handling multiple URIs
 * etc.
 */

@RestController
@RequestMapping("/person")
public class personController {
	private final personService personServ;
	
	public personController(personService personServ) {
		this.personServ = personServ;
	}
	
	/*
	 * Annotation for mapping HTTP GET requests onto specific handler methods.
	 * Specifically, @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
	 * Igazából egy GET kérést valósít meg mint PHP-ban
	 */
	
	@GetMapping
	public Iterable<personDTO> getAllPerson() {
		List<personDTO> personDTOList = new ArrayList<>();
		for(person person : personServ.getAllPerson()) {
			personDTOList.add(new personDTO(person));
		}
		
		return personDTOList;
		
	}
	
	/*
	 * The @PostMapping is specialized version of @RequestMapping annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.POST).
	 * The @PostMapping annotated methods in the @Controller annotated classes handle the HTTP POST requests matched with given URI expression.
	 * PHP-ban egy $_POST[''] kérés
	 */
	
	/*
	 * @RequestBody - Simply put, the @RequestBody annotation maps the HttpRequest body to a transfer or domain object, enabling automatic 
	 * deserialization of the inbound HttpRequest body onto a Java object.
	 * Spring automatically deserializes the JSON into a Java type, assuming an appropriate one is specified.
	 * By default, the type we annotate with the @RequestBody annotation must correspond to the JSON sent from our client-side controller:
	 */
	
	/*
	 * @Valid - This support is enabled automatically if a JSR-303 provider, such as Hibernate Validator, is present on your classpath. 
	 * When enabled, you can trigger validation simply by annotating a Controller method parameter with the @Valid annotation:
	 * After binding incoming POST parameters, the AppointmentForm will be validated; in this case, to verify the date field value
	 * is not null and occurs in the future.
	 */
	@PostMapping(consumes = "application/json")
	public personDTO save (@RequestBody @Valid personCreateDTO personCreateDto) {
		return new personDTO(personServ.create(personCreateDto.toPerson()));
	}
	
	/*
	 * @DeleteMapping annotation maps HTTP DELETE requests onto specific handler methods. 
	 * It is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.DELETE).
	 * 
	 */
	
	/*
	 * @PathVariable - This is a Spring annotation which indicates that a method parameter should be bound to a URI template variable. 
	 * If the method parameter is Map<String, String> then the map is populated with all path variable names and values.
	 */
	@DeleteMapping("/{id")
	public void delete(@PathVariable("id") long id) {
		personServ.delete(id);
	}
	
	@GetMapping("/{id")
	public personDTO getById(@PathVariable("id") long id) {
		return new personDTO(personServ.getById(id));
	}
	
	/*
	 * Annotation for mapping HTTP PUT requests onto specific handler methods.
	 * Specifically, @PutMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.PUT).
	 * Igazából egy UPDATE
	 */
	@PutMapping
	void save(@RequestBody @Valid personDTO personDto) {
		personServ.save(personDto.toPerson());
	}
	
	/*
	 * In Spring MVC, the @RequestParam annotation is used to read the form data and bind it automatically to the parameter 
	 * present in the provided method. So, it ignores the requirement of HttpServletRequest object to read the provided data.
	 */
	@GetMapping
	Iterable<personDTO> findByAgeGreaterThan(@RequestParam("age") int age) {
		List<spring.webalk.zh.gyakorlas.dao.personDTO> personDtoList = new ArrayList<>();
		for(person person : personServ.findByAgeGreaterThan(age)) {
			personDtoList.add(new spring.webalk.zh.gyakorlas.dao.personDTO(person));
		}
		
		return personDtoList;
	}
	
	
	
}
