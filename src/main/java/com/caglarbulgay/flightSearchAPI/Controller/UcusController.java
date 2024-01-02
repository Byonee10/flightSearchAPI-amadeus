package com.caglarbulgay.flightSearchAPI.Controller;

import com.caglarbulgay.flightSearchAPI.Modals.HavaAlani;
import com.caglarbulgay.flightSearchAPI.Modals.Ucus;
import com.caglarbulgay.flightSearchAPI.Repository.UcusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UcusController {
    @Autowired
    private UcusRepository ucusRepo;

    @GetMapping(value = "/ucuslar")
    public List<Ucus> getUcuslar(){
        return ucusRepo.findAll();
    }
    @PostMapping(value = "/ucuslar/save")
    public String saveUcuslar(@RequestBody Ucus ucus){
        ucusRepo.save(ucus);
        return "ucus kaydedildi";
    }
    @GetMapping(value = "/ucuslar/arama")
    public List<Ucus> aramaUcuslar(@RequestParam String kalkisYeri,
                                   @RequestParam String varisYeri,
                                   @RequestParam String kalkisTarihi,
                                   @RequestParam(required = false) String donusTarihi){
        if(donusTarihi == null) {
            return ucusRepo.findByKalkisHavaAlani_SehirAndVarisHavaAlani_SehirAndKalkisTarihSaat(kalkisYeri, varisYeri, kalkisTarihi);
        } else {
            return ucusRepo.findByKalkisHavaAlani_SehirAndVarisHavaAlani_SehirAndKalkisTarihSaatAndDonusTarihSaat(kalkisYeri, varisYeri, kalkisTarihi, donusTarihi);
        }
    }
    @PutMapping(value = "/ucuslar/update/{id}")
    public String updateUcus(@PathVariable long id, @RequestBody Ucus ucus){
        Ucus updatedUcus = ucusRepo.findById(id).orElseThrow();
        updatedUcus.setFiyat(ucus.getFiyat());
        updatedUcus.setDonusTarihSaat(ucus.getDonusTarihSaat());
        updatedUcus.setKalkisHavaAlani(ucus.getKalkisHavaAlani());
        updatedUcus.setVarisHavaAlani(ucus.getVarisHavaAlani());
        updatedUcus.setKalkisTarihSaat(ucus.getKalkisTarihSaat());
        ucusRepo.save(updatedUcus);
        return "ucus update edildi";
    }
    @DeleteMapping(value = "/ucuslar/delete/{id}")
    public String deleteUcus(@PathVariable long id){
        Ucus deleteUcus = ucusRepo.findById(id).orElseThrow();
        ucusRepo.delete(deleteUcus);
        return "ucus silindi";
    }
}
