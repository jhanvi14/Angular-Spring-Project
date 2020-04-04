package com.caseStudy.ShopAll.Repository;

import com.caseStudy.ShopAll.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends MongoRepository<Users,String> {
    public Users findByEmail(String email);
    public Users findByEmailAndPassword(String email,String password);
    public Users findByUserId(String userId);

}
