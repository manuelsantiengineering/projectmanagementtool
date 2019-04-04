package com.reactivemanuel.ppmtool.web;

import java.security.Principal;

//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactivemanuel.ppmtool.domain.Project;
import com.reactivemanuel.ppmtool.services.ValidationErrorService;
import com.reactivemanuel.ppmtool.services.ProjectService;

@RestController
@RequestMapping("/api/project")
@CrossOrigin
public class ProjectController {
	
	@Autowired
	private ProjectService			projectService;	
	
	@Autowired
	private ValidationErrorService 	validationErrorService;

	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, 
											BindingResult result, Principal principal){
		
		ResponseEntity<?> errorMap = validationErrorService.mapValidationErrorService(result);	
		if(errorMap!=null)	{	return errorMap;	}
		
		projectService.saveOrUpdateProject(project, principal.getName());
		return new ResponseEntity<Project>(project, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/all")
	public Iterable<Project> getAllProjects(Principal principal){
		return projectService.findAllProjects(principal.getName());		
	}
	
	@GetMapping("/test")
	public String getTest(){
		return ("Test");		
	}
	
	@GetMapping("/{projectIdentifier}")
	public ResponseEntity<?> getProjectByIdentifier(@PathVariable String projectIdentifier, Principal principal){
		Project project = projectService.findProjectByIdentifier(projectIdentifier.toUpperCase(), principal.getName());
		return new ResponseEntity<Project>(project, HttpStatus.OK); 
	}
	
	@DeleteMapping("/{projectIdentifier}")
	public ResponseEntity<?> deleteProjectByIdentifier(@PathVariable String projectIdentifier, Principal principal){
		Project project = projectService.deleteProjectByIdentifier(projectIdentifier.toUpperCase(), principal.getName());
		return new ResponseEntity<Project>(project, HttpStatus.OK); 
	}
	
}
