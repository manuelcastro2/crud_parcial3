package com.crud_parcial3.app.Controller;
import org.springframework.web.bind.annotation.*;

public class IndexController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

}
