package com.topuploan.controller;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.topuploan.dao.FeedBackRepository;
import com.topuploan.entity.FeedBackModule;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class FeedBackControllerTest 
{
	@Autowired
	FeedBackRepository feed;
	
	@Test
	@Order(1)
	void testSaveFeedback()
	{
		FeedBackModule feedback=new FeedBackModule(1,"test","good","5");
		feed.save(feedback);
		assertNotNull(feed.findById(1).get());
	}
	@Test
	@Order(2)
	void testReadFeedback()
	{
		List<FeedBackModule> feedback=feed.findAll();
		assertThat(feedback).size().isGreaterThan(0);
	}

}
