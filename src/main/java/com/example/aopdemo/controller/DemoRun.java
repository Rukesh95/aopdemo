package com.example.aopdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aoptest")
public class DemoRun {

	@GetMapping
	@LoggingExecutionTime
	public void serve() throws InterruptedException {
		Thread.sleep(2000);
	}

}
