package com.casestudy.inventory.repository;

import com.casestudy.inventory.model.Inventory;
import com.casestudy.inventory.model.ResetInventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory,Integer> {
    @Query("{'locationNbr': ?0, 'materialId': ?1}")
    public Inventory findByLocationAndMaterial(int locationNbr, String materialId);

    @Query("{'locationNbr': ?0}")
    public Inventory findByLocationNbr(int locationNbr);
}
