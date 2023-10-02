package com.casestudy.inventory.repository;

import com.casestudy.inventory.model.ResetInventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
//@EnableMongoRepositories
public interface ResetinvRepo extends MongoRepository<ResetInventory,String> {

    @Query("{'locationNbr': ?0, 'materialId': ?1}")
    public ResetInventory findByLocationAndMaterial(int locationNbr, String materialId);
}
