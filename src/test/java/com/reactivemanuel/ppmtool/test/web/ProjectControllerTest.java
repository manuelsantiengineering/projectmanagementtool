package com.reactivemanuel.ppmtool.test.web;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.reactivemanuel.ppmtool.domain.Project;
import com.reactivemanuel.ppmtool.services.ProjectService;
import com.reactivemanuel.ppmtool.web.ProjectController;
import com.reactivemanuel.ppmtool.web.TestController;

@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
public class ProjectControllerTest {

	@Autowired
	private MockMvc 				mockMvc;
	
	// A mock will return null by default
	@MockBean
	private ProjectService			projectService;	
	
//	@Test
//	public void createNewProject_test() throws Exception{
//		
//		Project testProject = new Project(
//				"ProjectName",
//				"TID01",
//				"Description Test",
//				new Date(),
//				new Date()
//				);
//		
//		when(projectService.saveOrUpdateProject(testProject, ""))
//			.thenReturn(testProject);
//		
//		// POST Request with application/json on the body
//		RequestBuilder request = MockMvcRequestBuilders
//								.post("")
//								.accept(MediaType.APPLICATION_JSON);
//		
//		String jsonResult = "{id:11,projectName:Yuca Frita Project 1,projectIdentifier:ID02,description:Descrpiption 01,"
//				+ "start_date:null,end_date:null,created_At:2019-20-03,updated_At: 2019-20-03,projectLeader:username@email.com}";
//		
//		MvcResult result = mockMvc.perform(request)
//							.andExpect(status().isOk())
//							.andExpect(content().json(jsonResult))
//							.andReturn();
//		
//		// Response should include an application/json
////		assertEquals()
//	}
	
	@Test
	public void getTest_test() throws Exception{
		// POST Request with application/json on the body
		RequestBuilder request = MockMvcRequestBuilders
								.get("/test")
								.accept(MediaType.ALL);
		
		MvcResult result = mockMvc.perform(request).andReturn();

		// Response should include an application/json
		assertEquals("Test", result.getResponse().getContentAsString());
	}
	
}
