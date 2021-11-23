package spring.webalk.zh.gyakorlas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
