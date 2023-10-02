package com.casestudy.inventory.controller;

import com.casestudy.inventory.model.Inventory;
import com.casestudy.inventory.model.ResetInventory;
import com.casestudy.inventory.service.InventoryService;
import com.casestudy.inventory.service.ResetInvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class InventoryController {
//    URLS:-
//    http://localhost:8081/save
//    http://localhost:8081/inventories
//    http://localhost:8081/inventories/1
//    http://localhost:8081/delete/0
//    http://localhost:8081/update/2
//    http://localhost:8081/search/19
    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private ResetInvService resetInvService;


    @PostMapping("/save")
    public ResponseEntity<Inventory> saveInventory(@RequestBody Inventory inventory) throws Exception{
        int locationNbr=inventory.getLocationNbr();
        String materialId= inventory.getMaterialId();

        if(resetInvService.isInventoryPresent(locationNbr,materialId)){
            throw new Exception("Inventory with same Location No & Material Id already added");
        }

        else {
            return  new ResponseEntity<>(inventoryService.save(inventory), HttpStatus.CREATED);
        }
    }

    @GetMapping("/inventories")
    public ResponseEntity<List<Inventory>> saveInventory(){
        return  new ResponseEntity<>(inventoryService.getInventories(), HttpStatus.OK);
    }

    @GetMapping("/inventories/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable int id){
        return  new ResponseEntity<>(inventoryService.getInventoryById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventory,@PathVariable int id) throws Exception {
        if(!(resetInvService.isInventoryPresent(inventory.getLocationNbr(),inventory.getMaterialId()))){
            throw new Exception("Error !");
        }
        else{
            inventoryService.delete(id);
//            Inventory inv=new Inventory();
//            inventory.setOrderQty(inventory.getOrderQty()+inv.getOrderQty());
            return new ResponseEntity<>(inventoryService.save(inventory), HttpStatus.ACCEPTED);
        }
    }

    @DeleteMapping("delete/{id}")
    public void deleteInventory(@PathVariable int id){
        inventoryService.delete(id);
    }

    @GetMapping("/search/{locationNbr}")
    public Inventory findByLocationNbr(@PathVariable int locationNbr) throws Exception{
        Inventory inventoryObj=inventoryService.findByLocationNbr(locationNbr);

        if(inventoryObj==null){
            throw new Exception("Invalid Location No");
        }
        else return inventoryObj;

    }

    //changed
    @PostMapping("/orderupdate")
    public Inventory updateInventoryAfterOrder(@RequestBody Inventory inventory)
    {

        return inventoryService.updateInventoryAferOrder(inventory);
    }




}
