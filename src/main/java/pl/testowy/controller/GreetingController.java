package pl.testowy.controller;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetingController {

	 @GetMapping({"/{person}"})
	    public String greetPerson(@PathVariable(name="person", required=false) Optional<String> maybePerson) {
	        String person = maybePerson.filter(StringUtils::isNotBlank).orElse("unknown person");
	        return String.format("Hello %s!", person);
	    }
}
