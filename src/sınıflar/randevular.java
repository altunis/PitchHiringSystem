/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sınıflar;

/**
 *
 * @author ismail
 */
public class randevular {
    private String ad;
    private String soyad;
    private String sehir;
    private String halisaha;
    private String tarih;
    private String randevuid;
    public randevular(String ad,String soyad,String sehir,String halisaha,String tarih,String randevuid){
        this.ad=ad;
        this.soyad=soyad;
        this.sehir=sehir;
        this.halisaha=halisaha;
        this.tarih=tarih;
        this.randevuid=randevuid;
    }

    /**
     * @return the ad
     */
    public String getAd() {
        return ad;
    }

    /**
     * @param ad the ad to set
     */
    public void setAd(String ad) {
        this.ad = ad;
    }

    /**
     * @return the soyad
     */
    public String getSoyad() {
        return soyad;
    }

    /**
     * @param soyad the soyad to set
     */
    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    /**
     * @return the sehir
     */
    public String getSehir() {
        return sehir;
    }

    /**
     * @param sehir the sehir to set
     */
    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    /**
     * @return the halisaha
     */
    public String getHalisaha() {
        return halisaha;
    }

    public String getRandevuid() {
        return randevuid;
    }

    public void setRandevuid(String randevuid) {
        this.randevuid = randevuid;
    }

    /**
     * @param halisaha the halisaha to set
     */
    public void setHalisaha(String halisaha) {
        this.halisaha = halisaha;
    }

    /**
     * @return the tarih
     */
    public String getTarih() {
        return tarih;
    }

    /**
     * @param tarih the tarih to set
     */
    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
    
}
