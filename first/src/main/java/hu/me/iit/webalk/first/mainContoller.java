package hu.me.iit.webalk.first;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class mainContoller {
	
	@RequestMapping(path="/", produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	ResponseDto gyoker() {
		ResponseDto rdto = new ResponseDto();
		
		rdto.setId(123);
		rdto.setMessage("Hello World!");
		return rdto;
	}
}
