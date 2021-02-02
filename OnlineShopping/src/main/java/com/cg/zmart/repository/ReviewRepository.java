package com.cg.zmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.zmart.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
}
