/**
 * 
 */
package com.rockwell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rockwell.model.Result;
import com.rockwell.service.CeremonialAssemblyLineStartupService;

/**
 * @author anand.golechha
 *
 */
@RestController
@RequestMapping("/app/v1")
public class CeremonialAppController {
	
	@Autowired
	private CeremonialAssemblyLineStartupService ceremonialService;
	
	@GetMapping(value = "/runningplcs")
	public ResponseEntity<Result> getRunningPLCCount() {
		return ResponseEntity.ok(ceremonialService.getInogurationProcessResult(1100));
	}

}
