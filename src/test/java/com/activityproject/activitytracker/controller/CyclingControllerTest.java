package com.activityproject.activitytracker.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.activityproject.activitytracker.dto.CyclingDto;
import com.activityproject.activitytracker.mapper.CyclingMapper;
import com.activityproject.activitytracker.mapper.CyclingMapperImpl;
import com.activityproject.activitytracker.model.Cycling;
import com.activityproject.activitytracker.model.User;
import com.activityproject.activitytracker.repository.CyclingRepository;
import com.activityproject.activitytracker.service.CyclingService;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CyclingController.class})
@ExtendWith(SpringExtension.class)
class CyclingControllerTest {
    @Autowired
    private CyclingController cyclingController;

    @MockBean
    private CyclingService cyclingService;

    /**
     * Method under test: {@link CyclingController#createActivity(CyclingDto)}
     */
    @Test
    void testCreateActivity() {
        User user = new User();
        user.setBirthDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setCyclingList(new ArrayList<>());
        user.setName("Name");
        user.setOverallDistanceCycling(10.0f);
        user.setOverallDistanceRunning(10.0f);
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        user.setRunningList(new ArrayList<>());
        user.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setUser_id(UUID.randomUUID());
        user.setUsername("janedoe");
        user.setWeight(10.0f);

        Cycling cycling = new Cycling();
        cycling.setAverageCadency(10.0f);
        cycling.setAveragePower(10.0f);
        cycling.setCalories(10.0f);
        cycling.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        cycling.setDistance(10.0f);
        cycling.setDoneDay(LocalDate.of(1970, 1, 1));
        cycling.setDoneTime(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        cycling.setId(UUID.randomUUID());
        cycling.setSpeed(10.0f);
        cycling.setUser(user);
        CyclingRepository cyclingRepository = mock(CyclingRepository.class);
        when(cyclingRepository.save(Mockito.<Cycling>any())).thenReturn(cycling);
        CyclingController cyclingController = new CyclingController(
                new CyclingService(new CyclingMapperImpl(), cyclingRepository));

        CyclingDto cyclingDto = new CyclingDto();
        cyclingDto.setAverageCadency(10.0f);
        cyclingDto.setAveragePower(10.0f);
        cyclingDto.setCalories(10.0f);
        cyclingDto.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        cyclingDto.setDistance(10.0f);
        cyclingDto.setDoneDay(LocalDate.of(1970, 1, 1));
        cyclingDto.setDoneTime(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        UUID id = UUID.randomUUID();
        cyclingDto.setId(id);
        cyclingDto.setSpeed(10.0f);
        ResponseEntity<CyclingDto> actualCreateActivityResult = cyclingController.createActivity(cyclingDto);
        CyclingDto body = actualCreateActivityResult.getBody();
        assertEquals(cyclingDto, body);
        assertTrue(actualCreateActivityResult.getHeaders().isEmpty());
        assertEquals(201, actualCreateActivityResult.getStatusCodeValue());
        assertEquals(10.0f, body.getAverageCadency());
        assertEquals("1970-01-01", body.getDoneDay().toString());
        assertEquals(10.0f, body.getDistance());
        assertEquals("Z", body.getCreatedAt().getZone().toString());
        assertEquals(10.0f, body.getCalories());
        assertEquals(10.0f, body.getAveragePower());
        assertSame(id, body.getId());
        assertEquals(10.0f, body.getSpeed());
        assertEquals("Z", body.getDoneTime().getZone().toString());
        assertNull(body.getDuration());
        verify(cyclingRepository).save(Mockito.<Cycling>any());
    }

    @Test
    void testCreateActivity3() {
        CyclingDto cyclingDto = new CyclingDto();
        cyclingDto.setAverageCadency(10.0f);
        cyclingDto.setAveragePower(10.0f);
        cyclingDto.setCalories(10.0f);
        cyclingDto.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        cyclingDto.setDistance(10.0f);
        cyclingDto.setDoneDay(LocalDate.of(1970, 1, 1));
        cyclingDto.setDoneTime(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        cyclingDto.setId(UUID.randomUUID());
        cyclingDto.setSpeed(10.0f);
        CyclingService cyclingService = mock(CyclingService.class);
        when(cyclingService.createActivity(Mockito.<CyclingDto>any())).thenReturn(cyclingDto);
        CyclingController cyclingController = new CyclingController(cyclingService);

        CyclingDto cyclingDto2 = new CyclingDto();
        cyclingDto2.setAverageCadency(10.0f);
        cyclingDto2.setAveragePower(10.0f);
        cyclingDto2.setCalories(10.0f);
        cyclingDto2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        cyclingDto2.setDistance(10.0f);
        cyclingDto2.setDoneDay(LocalDate.of(1970, 1, 1));
        cyclingDto2.setDoneTime(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        cyclingDto2.setId(UUID.randomUUID());
        cyclingDto2.setSpeed(10.0f);
        ResponseEntity<CyclingDto> actualCreateActivityResult = cyclingController.createActivity(cyclingDto2);
        assertEquals(cyclingDto2, actualCreateActivityResult.getBody());
        assertTrue(actualCreateActivityResult.getHeaders().isEmpty());
        assertEquals(201, actualCreateActivityResult.getStatusCodeValue());
        verify(cyclingService).createActivity(Mockito.<CyclingDto>any());
    }

    /**
     * Method under test: {@link CyclingController#findAll()}
     */
    @Test
    void testFindAll() throws Exception {
        when(cyclingService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/cycling");
        MockMvcBuilders.standaloneSetup(cyclingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CyclingController#findById(UUID)}
     */
    @Test
    void testFindById() {
        User user = new User();
        user.setBirthDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setCyclingList(new ArrayList<>());
        user.setName("Name");
        user.setOverallDistanceCycling(10.0f);
        user.setOverallDistanceRunning(10.0f);
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        user.setRunningList(new ArrayList<>());
        user.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setUser_id(UUID.randomUUID());
        user.setUsername("janedoe");
        user.setWeight(10.0f);

        Cycling cycling = new Cycling();
        cycling.setAverageCadency(10.0f);
        cycling.setAveragePower(10.0f);
        cycling.setCalories(10.0f);
        cycling.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        cycling.setDistance(10.0f);
        cycling.setDoneDay(LocalDate.of(1970, 1, 1));
        cycling.setDoneTime(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        UUID id = UUID.randomUUID();
        cycling.setId(id);
        cycling.setSpeed(10.0f);
        cycling.setUser(user);
        Optional<Cycling> ofResult = Optional.of(cycling);
        CyclingRepository cyclingRepository = mock(CyclingRepository.class);
        when(cyclingRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
        CyclingController cyclingController = new CyclingController(
                new CyclingService(new CyclingMapperImpl(), cyclingRepository));
        CyclingDto actualFindByIdResult = cyclingController.findById(UUID.randomUUID());
        assertEquals(10.0f, actualFindByIdResult.getAverageCadency());
        assertEquals(10.0f, actualFindByIdResult.getSpeed());
        assertSame(id, actualFindByIdResult.getId());
        assertNull(actualFindByIdResult.getDuration());
        assertEquals(10.0f, actualFindByIdResult.getAveragePower());
        assertEquals("Z", actualFindByIdResult.getCreatedAt().getZone().toString());
        assertEquals(10.0f, actualFindByIdResult.getDistance());
        assertEquals(10.0f, actualFindByIdResult.getCalories());
        assertEquals("Z", actualFindByIdResult.getDoneTime().getZone().toString());
        assertEquals("1970-01-01", actualFindByIdResult.getDoneDay().toString());
        verify(cyclingRepository).findById(Mockito.<UUID>any());
    }

    @Test
    void testFindById4() {
        CyclingDto cyclingDto = new CyclingDto();
        cyclingDto.setAverageCadency(10.0f);
        cyclingDto.setAveragePower(10.0f);
        cyclingDto.setCalories(10.0f);
        cyclingDto.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        cyclingDto.setDistance(10.0f);
        cyclingDto.setDoneDay(LocalDate.of(1970, 1, 1));
        cyclingDto.setDoneTime(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        cyclingDto.setId(UUID.randomUUID());
        cyclingDto.setSpeed(10.0f);
        CyclingService cyclingService = mock(CyclingService.class);
        when(cyclingService.findById(Mockito.<UUID>any())).thenReturn(cyclingDto);
        CyclingController cyclingController = new CyclingController(cyclingService);
        assertSame(cyclingDto, cyclingController.findById(UUID.randomUUID()));
        verify(cyclingService).findById(Mockito.<UUID>any());
    }

    /**
     * Method under test: {@link CyclingController#updateCycling(UUID, CyclingDto)}
     */
    @Test
    void testUpdateCycling() {

        User user = new User();
        user.setBirthDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setCyclingList(new ArrayList<>());
        user.setName("Name");
        user.setOverallDistanceCycling(10.0f);
        user.setOverallDistanceRunning(10.0f);
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        user.setRunningList(new ArrayList<>());
        user.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setUser_id(UUID.randomUUID());
        user.setUsername("janedoe");
        user.setWeight(10.0f);

        Cycling cycling = new Cycling();
        cycling.setAverageCadency(10.0f);
        cycling.setAveragePower(10.0f);
        cycling.setCalories(10.0f);
        cycling.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        cycling.setDistance(10.0f);
        cycling.setDoneDay(LocalDate.of(1970, 1, 1));
        cycling.setDoneTime(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        cycling.setId(UUID.randomUUID());
        cycling.setSpeed(10.0f);
        cycling.setUser(user);
        CyclingRepository cyclingRepository = mock(CyclingRepository.class);
        when(cyclingRepository.save(Mockito.<Cycling>any())).thenReturn(cycling);
        when(cyclingRepository.existsById(Mockito.<UUID>any())).thenReturn(true);
        CyclingController cyclingController = new CyclingController(
                new CyclingService(new CyclingMapperImpl(), cyclingRepository));
        UUID id = UUID.randomUUID();

        CyclingDto cyclingDto = new CyclingDto();
        cyclingDto.setAverageCadency(10.0f);
        cyclingDto.setAveragePower(10.0f);
        cyclingDto.setCalories(10.0f);
        cyclingDto.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        cyclingDto.setDistance(10.0f);
        cyclingDto.setDoneDay(LocalDate.of(1970, 1, 1));
        cyclingDto.setDoneTime(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        cyclingDto.setId(UUID.randomUUID());
        cyclingDto.setSpeed(10.0f);
        CyclingDto actualUpdateCyclingResult = cyclingController.updateCycling(id, cyclingDto);
        assertEquals(10.0f, actualUpdateCyclingResult.getAverageCadency());
        assertEquals(10.0f, actualUpdateCyclingResult.getSpeed());
        assertSame(id, actualUpdateCyclingResult.getId());
        assertNull(actualUpdateCyclingResult.getDuration());
        assertEquals(10.0f, actualUpdateCyclingResult.getAveragePower());
        assertEquals("Z", actualUpdateCyclingResult.getCreatedAt().getZone().toString());
        assertEquals(10.0f, actualUpdateCyclingResult.getDistance());
        assertEquals(10.0f, actualUpdateCyclingResult.getCalories());
        assertEquals("Z", actualUpdateCyclingResult.getDoneTime().getZone().toString());
        assertEquals("1970-01-01", actualUpdateCyclingResult.getDoneDay().toString());
        verify(cyclingRepository).existsById(Mockito.<UUID>any());
        verify(cyclingRepository).save(Mockito.<Cycling>any());
    }

    /**
     * Method under test: {@link CyclingController#updateCycling(UUID, CyclingDto)}
     */

    @Test
    void testUpdateCycling3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   jakarta.persistence.EntityNotFoundException: No Cyclingactivity with id 55da676b-17e1-4a0d-bbab-2a1988f2e0e6
        //       at com.activityproject.activitytracker.service.CyclingService.updateCycling(CyclingService.java:62)
        //       at com.activityproject.activitytracker.controller.CyclingController.updateCycling(CyclingController.java:47)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = new User();
        user.setBirthDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setCyclingList(new ArrayList<>());
        user.setName("Name");
        user.setOverallDistanceCycling(10.0f);
        user.setOverallDistanceRunning(10.0f);
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        user.setRunningList(new ArrayList<>());
        user.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setUser_id(UUID.randomUUID());
        user.setUsername("janedoe");
        user.setWeight(10.0f);

        Cycling cycling = new Cycling();
        cycling.setAverageCadency(10.0f);
        cycling.setAveragePower(10.0f);
        cycling.setCalories(10.0f);
        cycling.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        cycling.setDistance(10.0f);
        cycling.setDoneDay(LocalDate.of(1970, 1, 1));
        cycling.setDoneTime(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        cycling.setId(UUID.randomUUID());
        cycling.setSpeed(10.0f);
        cycling.setUser(user);
        CyclingMapper mapper = mock(CyclingMapper.class);
        when(mapper.toEntity(Mockito.<CyclingDto>any())).thenReturn(cycling);

        User user2 = new User();
        user2.setBirthDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user2.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user2.setCyclingList(new ArrayList<>());
        user2.setName("Name");
        user2.setOverallDistanceCycling(10.0f);
        user2.setOverallDistanceRunning(10.0f);
        user2.setPassword("iloveyou");
        user2.setRoles(new ArrayList<>());
        user2.setRunningList(new ArrayList<>());
        user2.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user2.setUser_id(UUID.randomUUID());
        user2.setUsername("janedoe");
        user2.setWeight(10.0f);

        Cycling cycling2 = new Cycling();
        cycling2.setAverageCadency(10.0f);
        cycling2.setAveragePower(10.0f);
        cycling2.setCalories(10.0f);
        cycling2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        cycling2.setDistance(10.0f);
        cycling2.setDoneDay(LocalDate.of(1970, 1, 1));
        cycling2.setDoneTime(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        cycling2.setId(UUID.randomUUID());
        cycling2.setSpeed(10.0f);
        cycling2.setUser(user2);
        CyclingRepository cyclingRepository = mock(CyclingRepository.class);
        when(cyclingRepository.save(Mockito.<Cycling>any())).thenReturn(cycling2);
        when(cyclingRepository.existsById(Mockito.<UUID>any())).thenReturn(false);
        CyclingController cyclingController = new CyclingController(new CyclingService(mapper, cyclingRepository));
        UUID id = UUID.randomUUID();

        CyclingDto cyclingDto = new CyclingDto();
        cyclingDto.setAverageCadency(10.0f);
        cyclingDto.setAveragePower(10.0f);
        cyclingDto.setCalories(10.0f);
        cyclingDto.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        cyclingDto.setDistance(10.0f);
        cyclingDto.setDoneDay(LocalDate.of(1970, 1, 1));
        cyclingDto.setDoneTime(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        cyclingDto.setId(UUID.randomUUID());
        cyclingDto.setSpeed(10.0f);
        cyclingController.updateCycling(id, cyclingDto);
    }

    /**
     * Method under test: {@link CyclingController#delete(UUID)}
     */
    @Test
    void testDelete() throws Exception {
        CyclingDto cyclingDto = new CyclingDto();
        cyclingDto.setAverageCadency(10.0f);
        cyclingDto.setAveragePower(10.0f);
        cyclingDto.setCalories(10.0f);
        cyclingDto.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        cyclingDto.setDistance(10.0f);
        cyclingDto.setDoneDay(LocalDate.of(1970, 1, 1));
        cyclingDto.setDoneTime(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        cyclingDto.setId(UUID.randomUUID());
        cyclingDto.setSpeed(10.0f);
        when(cyclingService.deleteCycling(Mockito.<UUID>any())).thenReturn(cyclingDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/cycling/{id}",
                UUID.randomUUID());
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(cyclingController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link CyclingController#delete(UUID)}
     */
    @Test
    void testDelete2() throws Exception {
        CyclingDto cyclingDto = new CyclingDto();
        cyclingDto.setAverageCadency(10.0f);
        cyclingDto.setAveragePower(10.0f);
        cyclingDto.setCalories(10.0f);
        cyclingDto.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        cyclingDto.setDistance(10.0f);
        cyclingDto.setDoneDay(LocalDate.of(1970, 1, 1));
        cyclingDto.setDoneTime(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC));
        cyclingDto.setId(UUID.randomUUID());
        cyclingDto.setSpeed(10.0f);
        when(cyclingService.deleteCycling(Mockito.<UUID>any())).thenReturn(cyclingDto);
        SecurityMockMvcRequestBuilders.FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders
                .formLogin();
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(cyclingController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link CyclingController#testResponse()}
     */
    @Test
    void testTestResponse() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/cycling/test");
        MockMvcBuilders.standaloneSetup(cyclingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("chesterfield"));
    }

    /**
     * Method under test: {@link CyclingController#testResponse()}
     */
    @Test
    void testTestResponse2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/cycling/test");
        requestBuilder.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(cyclingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("chesterfield"));
    }
}

