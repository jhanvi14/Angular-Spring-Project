package com.caseStudy.ShopAll.Repository;

import com.caseStudy.ShopAll.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface productRepository extends MongoRepository<Products,String> {

    List<Products> findByCategory(String category);
    List<Products> findByCategoryAndPriceBetween(String category, double min, double max);
    List<Products> findByPriceBetween(double min, double max);
    Products findByProductId(String productId);
}
