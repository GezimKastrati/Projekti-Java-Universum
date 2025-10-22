package com.backend.testManagement.controller;

import com.backend.testManagement.dto.TestDTO;
import com.backend.testManagement.dto.TestDTOSave;
import com.backend.testManagement.services.TestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TestController.class)
class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TestService testService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void saveTest_Success() throws Exception {
        TestDTOSave saveDTO = new TestDTOSave("John", "Doe");
        TestDTO responseDTO = TestDTO.builder().id("1").name("John").lastname("Doe").build();

        when(testService.saveTest(any(TestDTOSave.class))).thenReturn(responseDTO);

        mockMvc.perform(post("/api/tests/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(saveDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.lastname").value("Doe"));
    }
}