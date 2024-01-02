package com.caglarbulgay.flightSearchAPI.Controller;

import com.caglarbulgay.flightSearchAPI.Modals.HavaAlani;
import com.caglarbulgay.flightSearchAPI.Repository.HavaAlaniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HavaAlaniController {
    @Autowired
    private HavaAlaniRepository havaAlaniRepo;

    @GetMapping(value = "/havaalanlari")
    public List<HavaAlani> getHavaAlanlari(){
        return havaAlaniRepo.findAll();
    }
    @PostMapping(value = "/havaalanlari/save")
    public String saveHavaalani(@RequestBody HavaAlani havaAlani){
        havaAlaniRepo.save(havaAlani);
        return "havaalani kaydedildi";
    }
    @PutMapping(value = "/havaalanlari/update/{id}")
    public String updateHavaalani(@PathVariable long id, @RequestBody HavaAlani havaAlani){
        HavaAlani updatedHavaalani = havaAlaniRepo.findById(id).orElseThrow();
        updatedHavaalani.setSehir(havaAlani.getSehir());
        havaAlaniRepo.save(updatedHavaalani);
        return "havaalani update edildi";
    }
    @DeleteMapping(value = "/havaalanlari/delete/{id}")
    public String deleteHavaalani(@PathVariable long id){
        HavaAlani deletedHavaalani = havaAlaniRepo.findById(id).orElseThrow();
        havaAlaniRepo.delete(deletedHavaalani);
        return "havaalani silindi";
    }
}
