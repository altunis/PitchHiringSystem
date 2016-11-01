/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sınıflar;

/**
 *
 * @author Bilgin
 */
public class halisahalar {
    
    String halisahaAd;
    String adres;
    String servis;
        public halisahalar(String halisahaAd,String adres,String servis){
            this.halisahaAd=halisahaAd;
            this.adres=adres;
            this.servis=servis;
        }
    public String getHalisahaAd() {
        return halisahaAd;
    }

    public void setHalisahaAd(String halisahaAd) {
        this.halisahaAd = halisahaAd;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getServis() {
        return servis;
    }

    public void setServis(String servis) {
        this.servis = servis;
    }
    
}
