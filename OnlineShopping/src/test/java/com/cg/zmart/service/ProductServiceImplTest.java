package com.cg.zmart.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.zmart.entity.Product;
import com.cg.zmart.repository.ProductRepository;
@SpringBootTest
class ProductServiceImplTest {

	@Autowired
	private ProductService service;

	@MockBean
	private ProductRepository prodRepo;

	@Test
	void testGetAllProducts() {
		when(prodRepo.findAll()).thenReturn(Stream.of(new Product(5, "NOISE", 1699, 50, "Smart Fitness Band",
				"Men's Fashion",
				"https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/10522922/2019/10/17/17e8bc37-920f-41ea-bd4a-921581099fe11571302942576-Noise-Unisex-Black-ColorFit-2-Smart-Fitness-Band-55215713029-1.jpg"),
				new Product(5, "Invictus", 934, 120, "Red Formal Design Shirt", "Men's Fashion",
						"https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/10887578/2020/7/22/71cd6b48-8c57-48a2-b853-328229a9d0071595418499780-INVICTUS-Men-Navy-Blue--Red-Slim-Fit-Self-Design-Formal-Shir-1.jpg"))
				.collect(Collectors.toList()));
		assertEquals(2, service.getAllProducts().size());
	}

	@Test
	void testCreateProduct() {
		Product product = new Product(5, "NOISE", 1699, 50, "Smart Fitness Band", "Men's Fashion",
				"https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/10522922/2019/10/17/17e8bc37-920f-41ea-bd4a-921581099fe11571302942576-Noise-Unisex-Black-ColorFit-2-Smart-Fitness-Band-55215713029-1.jpg");
		when(prodRepo.save(product)).thenReturn(product);
		assertEquals(product, service.createProduct(product));
	}

	@Test
	void testFilterByCategory() {
		String category = "Men's Fashion";
		when(prodRepo.findByProductCategory(category)).thenReturn(Stream.of(new Product(5, "Invictus", 934, 120,
				"Red Formal Design Shirt", "Men's Fashion",
				"https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/10887578/2020/7/22/71cd6b48-8c57-48a2-b853-328229a9d0071595418499780-INVICTUS-Men-Navy-Blue--Red-Slim-Fit-Self-Design-Formal-Shir-1.jpg"))
				.collect(Collectors.toList()));
		assertEquals(1, service.filterByCategory(category).size());
	}

}
