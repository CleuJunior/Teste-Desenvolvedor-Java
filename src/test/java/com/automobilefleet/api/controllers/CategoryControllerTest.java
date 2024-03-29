package com.automobilefleet.api.controllers;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.automobilefleet.api.dto.request.CategoryRequest;
import com.automobilefleet.api.dto.response.CategoryResponse;
import com.automobilefleet.services.CategoryService;
import com.automobilefleet.utils.JsonMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
@Transactional
class CategoryControllerTest {
    @InjectMocks
    private CategoryController controller;
    @Mock
    private CategoryService service;
    private MockMvc mockMvc;
    private MockHttpServletResponse httpResponse;
    private CategoryResponse response;
    private CategoryRequest request;
    private final static UUID ID = UUID.fromString("b86a92d8-6908-426e-8316-f72b0c849a4b");
    private static final String NAME = "SUVs";
    private static final String DESCRIPTION = "Veículos utilitários esportivos";
    private final static String URL_ID = "/api/v1/category/{id}";
    private final static String URL_LIST = "/api/v1/category/list";
    private final static String URL_SAVE = "/api/v1/category/save";
    private final static String UPDATE_ID = "/api/v1/category/update/{id}";
    private final static String CONTENT_STRING_JSON = "{\"_id\":\"b86a92d8-6908-426e-8316-f72b0c849a4b\",\"name\":\"SUVs\",\"description\":\"Veículos utilitários esportivos\"}";
    private final static String CONTENT_STRING_JSON_LIST = "[" + CONTENT_STRING_JSON + "]";
    private final static String CHARACTER_ENCODING_UTF_8 = "UTF-8";
    private final static int HTTP_STATUS_OK = 200;
    private final static int HTTP_STATUS_IS_CREATED = 201;
    private final static int HTTP_STATUS_IS_ACCEPETD = 202;

    @BeforeAll
    static void setup() {
        FixtureFactoryLoader.loadTemplates("com.automobilefleet.utils");
    }
    
    @BeforeEach
    void setupAttributes() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
        this.response = new CategoryResponse(ID, NAME, DESCRIPTION);
        this.request = new CategoryRequest(NAME, DESCRIPTION);
    }

    @Test
    void shouldGetBrandByIdAndStatusCodeOK() throws Exception {
        Mockito.when(this.service.getCategoryById(ID)).thenReturn(this.response);

        this.httpResponse = this.mockMvc.perform(get(URL_ID, ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse();

        this.httpResponse.setCharacterEncoding(CHARACTER_ENCODING_UTF_8);

        Assertions.assertEquals(CONTENT_STRING_JSON, httpResponse.getContentAsString());
        Assertions.assertEquals(HTTP_STATUS_OK, httpResponse.getStatus());

        Mockito.verify(this.service).getCategoryById(ID);
        Mockito.verifyNoMoreInteractions(this.service);
    }

    @Test
    void shouldGetListBrandAndStatusCodeOK() throws Exception {
        Mockito.when(this.service.listCategories()).thenReturn(Collections.singletonList(this.response));

        this.httpResponse = this.mockMvc.perform(get(URL_LIST).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse();

        this.httpResponse.setCharacterEncoding(CHARACTER_ENCODING_UTF_8);

        Assertions.assertEquals(CONTENT_STRING_JSON_LIST, httpResponse.getContentAsString());
        Assertions.assertEquals(HTTP_STATUS_OK, httpResponse.getStatus());

        Mockito.verify(this.service).listCategories();
        Mockito.verifyNoMoreInteractions(this.service);
    }

    @Test
    void shoulSaveBrandAndStatusCodeCreated() throws Exception {
        Mockito.when(this.service.saveCategory(any(CategoryRequest.class))).thenReturn(this.response);

        this.httpResponse = this.mockMvc.perform(post(URL_SAVE).contentType(MediaType.APPLICATION_JSON)
                        .content(JsonMapper.asJsonString(this.response)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn()
                .getResponse();

        this.httpResponse.setCharacterEncoding(CHARACTER_ENCODING_UTF_8);

        Assertions.assertEquals(CONTENT_STRING_JSON, httpResponse.getContentAsString());
        Assertions.assertEquals(HTTP_STATUS_IS_CREATED, httpResponse.getStatus());

        Mockito.verify(this.service).saveCategory(any(CategoryRequest.class));
        Mockito.verifyNoMoreInteractions(this.service);
    }

    @Test
    void shouldUpdateBrandAndStatusCodeAccepted() throws Exception {
        Mockito.when(this.service.updateCategory(eq(ID), any(CategoryRequest.class))).thenReturn(this.response);

        this.httpResponse = this.mockMvc.perform(put(UPDATE_ID, ID).contentType(MediaType.APPLICATION_JSON)
                        .content(JsonMapper.asJsonString(this.request)))
                .andExpect(MockMvcResultMatchers.status().isAccepted())
                .andReturn()
                .getResponse();

        this.httpResponse.setCharacterEncoding(CHARACTER_ENCODING_UTF_8);

        Assertions.assertEquals(CONTENT_STRING_JSON, httpResponse.getContentAsString());
        Assertions.assertEquals(HTTP_STATUS_IS_ACCEPETD, httpResponse.getStatus());

        Mockito.verify(this.service).updateCategory(eq(ID), any(CategoryRequest.class));
        Mockito.verifyNoMoreInteractions(this.service);
    }
}