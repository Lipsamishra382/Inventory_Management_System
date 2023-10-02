package com.casestudy.inventory.service;

import com.casestudy.inventory.model.Inventory;
import com.casestudy.inventory.model.ResetInventory;
import com.casestudy.inventory.repository.InventoryRepository;
import com.casestudy.inventory.repository.ResetinvRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Component
public class ResetInvServiceImpl implements ResetInvService{

    @Autowired
    private ResetinvRepo resetinvRepo;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public ResetInventory save(ResetInventory resetInventory) {
        resetInventory.setResetDateTime(new Date());
        return resetinvRepo.save(resetInventory);
    }

    @Override
    public List<ResetInventory> getResetInv() {
        return resetinvRepo.findAll();
    }

    @Override
//    isInventoryPresent
    public ResetInventory findResetInventory(int locationNbr, String materialId) {
        ResetInventory resetInventory=resetinvRepo.findByLocationAndMaterial(locationNbr, materialId);
        return resetInventory;

    }


    @Override
    public boolean isInventoryPresent(int locationNbr, String materialId) {
        boolean isPresent=false;
        Inventory inventory=inventoryRepository.findByLocationAndMaterial(locationNbr,materialId);
        if(inventory!=null){
            isPresent=true;
        }
        return isPresent;
    }

    @Override
    public void deleteResetInvByMaterialId(String materialId) {
        resetinvRepo.deleteById(materialId);
    }



}
