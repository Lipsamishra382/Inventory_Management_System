package com.casestudy.inventory.controller;

import com.casestudy.inventory.model.Inventory;
import com.casestudy.inventory.model.ResetInventory;
import com.casestudy.inventory.service.ResetInvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ResetInventoryController {

    @Autowired
    private ResetInvService resetInvService;

    @PostMapping("/saveresetqty")
    public ResponseEntity<ResetInventory> saveInventory(@RequestBody ResetInventory resetInventory) throws Exception{

        int locationNbr =resetInventory.getLocationNbr();
        String materialId=resetInventory.getMaterialId();

        if(!(resetInvService.isInventoryPresent(locationNbr,materialId))){
            throw new Exception("Please add inventory first");
        }

        ResetInventory resetObj=resetInvService.findResetInventory(locationNbr,materialId);

        if(resetObj!=null) {
            throw new Exception("Reset Quantity already added");
        }


        else{

        return  new ResponseEntity<>(resetInvService.save(resetInventory), HttpStatus.CREATED);
        }


    }

    @PostMapping("/search")
    public ResetInventory findByLocationAndMaterial(@RequestBody ResetInventory resetInventory) throws Exception{

        int locationNbr =resetInventory.getLocationNbr();
        String materialId=resetInventory.getMaterialId();

        ResetInventory resetObj=null;
        if(locationNbr !=0 && materialId!=null) {
            resetObj = resetInvService.findResetInventory(locationNbr,materialId);

        }
        if(resetObj==null) {
            throw new Exception("Inventory not available. Pls add inventory");
        }
        return resetObj;
    }

    @GetMapping("/getresetqty")
    public ResponseEntity<List<ResetInventory>> getResetQty(){
        return new ResponseEntity<>(resetInvService.getResetInv(),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-material/{materialId}")
    public void deleteResetInvByMaterialId(@PathVariable String materialId){
        resetInvService.deleteResetInvByMaterialId(materialId);
    }


}
