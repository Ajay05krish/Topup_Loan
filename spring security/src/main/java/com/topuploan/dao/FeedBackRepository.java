package com.topuploan.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.topuploan.entity.FeedBackModule;

public interface FeedBackRepository extends JpaRepository<FeedBackModule,Integer> {
}
