package com.casestudy.inventory.service;

import com.casestudy.inventory.model.ResetInventory;

import java.util.List;

public interface ResetInvService {
    public ResetInventory save(ResetInventory resetInventory);
    public List<ResetInventory> getResetInv();

    public ResetInventory findResetInventory(int locationNbr, String materialId);

    public boolean isInventoryPresent(int locationNbr, String materialId);

    public void deleteResetInvByMaterialId(String materialId);



}
