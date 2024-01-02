package com.caglarbulgay.flightSearchAPI.Modals;

import jakarta.persistence.*;

@Entity
public class Ucus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "baslangic-lokasyon-id")
    private HavaAlani kalkisHavaAlani;
    @ManyToOne
    @JoinColumn(name = "varis_lokasyon_id")
    private HavaAlani varisHavaAlani;
    @Column
    private String kalkisTarihSaat;
    @Column
    private String donusTarihSaat;
    @Column
    private double fiyat;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HavaAlani getKalkisHavaAlani() {
        return kalkisHavaAlani;
    }

    public void setKalkisHavaAlani(HavaAlani kalkisHavaAlani) {
        this.kalkisHavaAlani = kalkisHavaAlani;
    }

    public HavaAlani getVarisHavaAlani() {
        return varisHavaAlani;
    }

    public void setVarisHavaAlani(HavaAlani varisHavaAlani) {
        this.varisHavaAlani = varisHavaAlani;
    }

    public String getKalkisTarihSaat() {
        return kalkisTarihSaat;
    }

    public void setKalkisTarihSaat(String kalkisTarihSaat) {
        this.kalkisTarihSaat = kalkisTarihSaat;
    }

    public String getDonusTarihSaat() {
        return donusTarihSaat;
    }

    public void setDonusTarihSaat(String donusTarihSaat) {
        this.donusTarihSaat = donusTarihSaat;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }
}
