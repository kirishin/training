package com.example.umatsu.trainingCRUD.controller;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.umatsu.trainingCRUD.TrainingCrudApplication;
import com.example.umatsu.trainingCRUD.mapper.TbMemberMapper;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = TrainingCrudApplication.class)
public class DeleteControllerTest {

	@Rule
	public final MockitoRule rule = MockitoJUnit.rule();

	@InjectMocks
	private DeleteController controller;

	@Mock
	private TbMemberMapper mapper;

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		this.mvc = MockMvcBuilders.standaloneSetup(this.controller).build();
	}

	@Test
	public void testDeleteConfirm() throws Exception {
		Mockito.when(mapper.updateByPrimaryKeySelective(null)).thenReturn(null);

		this.mvc.perform(MockMvcRequestBuilders.post("/crud/delete/confirm")
//				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("name", "")).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.model().hasErrors())
				.andExpect(MockMvcResultMatchers.view().name("/crud/delete/complete"));
	}

	@Test
	public void testDeleteComplete() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddInstanceMessage() {
		fail("Not yet implemented");
	}

	@Test
	public void testPutTitle() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteMember() {
		fail("Not yet implemented");
	}

}
