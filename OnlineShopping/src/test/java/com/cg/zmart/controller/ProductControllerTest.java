package com.cg.zmart.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.cg.zmart.model.ProductModel;
import com.cg.zmart.service.ProductService;
@WebMvcTest(controllers = ProductController.class)
class ProductControllerTest {

	
	  @Autowired private MockMvc mockMvc;
	  
	  @MockBean private ProductService mockService;
	  
	  ProductModel mockProduct = new ProductModel(5, "NOISE", 1699, 50,
	  "Smart Fitness Band", "Men's Fashion",
	  "https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/10522922/2019/10/17/17e8bc37-920f-41ea-bd4a-921581099fe11571302942576-Noise-Unisex-Black-ColorFit-2-Smart-Fitness-Band-55215713029-1.jpg"
	  );
	  
	  @Test void testGetProductById() throws Exception {
	  Mockito.when(mockService.fetchProductById(Mockito.anyLong())).thenReturn(
	  mockProduct); RequestBuilder req =
	  MockMvcRequestBuilders.get("/product/5").accept(MediaType.APPLICATION_JSON);
	  MvcResult res = mockMvc.perform(req).andReturn(); String expected =
	  "{productName:NOISE,unitPrice:1699.0}"; JSONAssert.assertEquals(expected,
	  res.getResponse().getContentAsString(), false); }
	 

}
