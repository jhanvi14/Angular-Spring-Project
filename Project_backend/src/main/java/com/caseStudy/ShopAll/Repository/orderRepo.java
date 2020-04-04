package com.caseStudy.ShopAll.Repository;

import com.caseStudy.ShopAll.model.OrderHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface orderRepo extends MongoRepository<OrderHistory,String> {
    List<OrderHistory> findByUserId(String userId);
}
