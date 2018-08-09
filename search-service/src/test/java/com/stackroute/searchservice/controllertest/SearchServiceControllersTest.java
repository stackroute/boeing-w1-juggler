package com.stackroute.searchservice.controllertest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.stackroute.searchservice.controller.SearchServiceControllers;
import com.stackroute.searchservice.services.SearchServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(SearchServiceControllers.class)
public class SearchServiceControllersTest {
    
         @Autowired
         private MockMvc eventMockMvc;
         
         @MockBean
         private SearchServiceImpl searchServiceImpl;
         
         @InjectMocks
         private SearchServiceControllers searchServiceController = new SearchServiceControllers(searchServiceImpl);
         
        //Event event = new Event("name","poster");
         
        @Before
        public void setUp() throws Exception {
            MockitoAnnotations.initMocks(this);   
        } 
        
        

}