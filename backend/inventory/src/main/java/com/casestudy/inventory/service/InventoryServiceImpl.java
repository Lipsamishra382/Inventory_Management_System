package com.casestudy.inventory.service;

import com.casestudy.inventory.model.Inventory;
import com.casestudy.inventory.model.ResetInventory;
import com.casestudy.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    private InventoryRepository inventoryRepository;


    //ResetInventory resetInventory=new ResetInventory();

    @Override
    public Inventory save(Inventory inventory)  {
        //inventory.setResetQty(resetInventory.getResetQty());
//        inventory.setOrderQty(0);

//        inventory.setAvailableQuantity(inventory.getResetQty()-inventory.getOrderQty());
//        inventory.setUpdateDateTime(new Date());
        return inventoryRepository.save(inventory);
    }

    @Override
    public List<Inventory> getInventories() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory getInventoryById(int id) {
        return inventoryRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        inventoryRepository.deleteById(id);
    }

    public Inventory findByLocationNbr(int locationNbr) {
        return inventoryRepository.findByLocationNbr(locationNbr);
    }


    //changed
    public Inventory updateInventoryAferOrder(Inventory inventory) {

        Inventory inv=inventoryRepository.findByLocationNbr(inventory.getLocationNbr());
        inv.setId(inventory.getId());
        inv.setOrderQty(inventory.getOrderQty());
        inv.setLocationNbr(inventory.getLocationNbr());
        inv.setMaterialId(inventory.getMaterialId());

        return inventoryRepository.save(inv);
    }

}
