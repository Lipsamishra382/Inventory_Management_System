package com.casestudy.inventory.service;

import com.casestudy.inventory.model.Inventory;

import java.util.List;

public interface InventoryService {

    public Inventory save(Inventory inventory) throws Exception;
    public List<Inventory> getInventories();
    public Inventory getInventoryById(int id);
    public void delete(int id);
    public Inventory findByLocationNbr(int locationNbr);


    //changed
    public Inventory updateInventoryAferOrder(Inventory inventory);




}
