package com.caseStudy.ShopAll.Repository;

import com.caseStudy.ShopAll.model.Cart;
import com.caseStudy.ShopAll.model.Products;
import com.caseStudy.ShopAll.model.Users;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface cartRepository extends MongoRepository<Cart,String> {
    public Cart findByUsersAndProducts(Users user ,Products product);
    public Cart findByProducts(Products prod);
    public List<Cart> findByUsers(Users user);
       String deleteByUsersAndProducts(Users user, Products prod);
}
