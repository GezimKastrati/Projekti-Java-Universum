package com.backend.testManagement.services;

import com.backend.testManagement.dto.TestDTO;
import com.backend.testManagement.dto.TestDTOSave;
import com.backend.testManagement.exceptions.EntityNotFoundException;
import com.backend.testManagement.mapper.TestMapper;
import com.backend.testManagement.model.Test;
import com.backend.testManagement.repository.TestRepository;
import com.backend.testManagement.services.Impl.TestServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TestServiceTest {

    @Mock
    private TestRepository testRepository;

    @Mock
    private TestMapper testMapper;

    @InjectMocks
    private TestServiceImpl testService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @org.junit.jupiter.api.Test
    void saveTest_Success() {
        TestDTOSave saveDTO = new TestDTOSave("John", "Doe");
        com.backend.testManagement.model.Test entity = new com.backend.testManagement.model.Test();
        TestDTO expectedDTO = TestDTO.builder().id("1").name("John").lastname("Doe").build();

        when(testMapper.mapToEntity(saveDTO)).thenReturn(entity);
        when(testRepository.save(entity)).thenReturn(entity);
        when(testMapper.mapToDTO(entity)).thenReturn(expectedDTO);

        TestDTO result = testService.saveTest(saveDTO);

        assertNotNull(result);
        assertEquals("John", result.getName());
        verify(testRepository).save(entity);
    }

    @org.junit.jupiter.api.Test
    void findTestById_NotFound() {
        when(testRepository.findById("invalid-id")).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> testService.findTestById("invalid-id"));
    }
}