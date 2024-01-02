package com.caglarbulgay.flightSearchAPI.Repository;

import com.caglarbulgay.flightSearchAPI.Modals.Ucus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UcusRepository extends JpaRepository<Ucus,Long> {
    List<Ucus> findByKalkisHavaAlani_SehirAndVarisHavaAlani_SehirAndKalkisTarihSaat(String kalkisYeri, String varisYeri, String kalkisTarihi);
    List<Ucus> findByKalkisHavaAlani_SehirAndVarisHavaAlani_SehirAndKalkisTarihSaatAndDonusTarihSaat(String kalkisYeri, String varisYeri, String kalkisTarihi, String donusTarihi);
}
