package com.example.umatsu.trainingCRUD.controller;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.umatsu.trainingCRUD.common.RequestPathConst;
import com.example.umatsu.trainingCRUD.common.ResourcePathConst;
import com.example.umatsu.trainingCRUD.controller.service.CRUDService;

//@WebAppConfiguration
//@ContextConfiguration(classes = TrainingCrudApplication.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteControllerTest {

	@Rule
	public final MockitoRule rule = MockitoJUnit.rule();

	@InjectMocks
	private DeleteController controller;

	@Mock
	private CRUDService crud;

	// @Autowired
	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		this.mvc = MockMvcBuilders.standaloneSetup(this.controller).build();
	}

	@Test
	public void testDeleteConfirm() throws Exception {

//		doNothing().when(Mockito.spy(new CRUDService())).deleteMember(Mockito.<MemberForm>any());

		this.mvc.perform(MockMvcRequestBuilders.post("/crud/delete/confirm")
		// .contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("id", "1")
		)
//				.andDo(print())
				.andExpect(status().isOk())
				//入力エラーがないこと（そもそも入力チェックをしてない)
				.andExpect(model().hasNoErrors())
				//共通確認用フォームを使用すること
				.andExpect(view().name(ResourcePathConst.VIEW_FORM));
	}

	@Test
	public void testDeleteComplete() throws Exception {

		this.mvc.perform(MockMvcRequestBuilders.post("/crud/delete/complete")
		// .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//				.param("id", "1")
		)
//				 .andDo(print())
				//リダイレクトだとisOkにならないらしい為isFound
				.andExpect(status().isFound())
				//入力エラーがないこと（そもそも入力チェックをしてない)
				.andExpect(model().hasNoErrors())
				//共通確認用フォームを使用すること
				.andExpect(view().name(RequestPathConst.REDIRECT_SELECT_MEMBERS));
	}

	@Test
	public void testDeleteMember() {
		fail("Not yet implemented");
	}

}
