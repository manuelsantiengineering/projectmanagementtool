package com.reactivemanuel.ppmtool.test.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.reactivemanuel.ppmtool.web.BacklogController;

@RunWith(SpringRunner.class)
@WebMvcTest(BacklogController.class)
public class ProjectControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void createNewProject_test() throws Exception{
		// POST Request with application/json on the body
		RequestBuilder request = MockMvcRequestBuilders
								.post("/api/project")
								.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request).andReturn();
		
		// Response should include an application/json
//		assertEquals()
	}
	
}
