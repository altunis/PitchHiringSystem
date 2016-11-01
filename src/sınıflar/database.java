package sınıflar;
import hrs.HalisahalarController;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.*;


public class database {
   String url="jdbc:mysql://localhost:3306/";
   String dbname="rezervasyonsistemi";
   String driver="com.mysql.jdbc.Driver";
   String id="root";
   String pass="1228";
   Connection conn;
   PreparedStatement ps;
   ResultSet rs;
   
   public void baglan()
   {
       try 
       {
           Class.forName(driver).newInstance();
           conn=DriverManager.getConnection(url+dbname,id,pass);
       }
       catch (Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
   }
   public String giris(musteriler musteri)
   {
       try
       {
           baglan();
           String sorgu = "select MusteriAd from musteri where kullaniciadi = ? and sifre = ?";
           ps=conn.prepareStatement(sorgu);
           ps.setString(1, musteri.getKullaniciadi());
           ps.setString(2, musteri.getSifre());
           rs=ps.executeQuery();
           String ad=null;
           while (rs.next())
           {
            ad = rs.getString(1);
            JOptionPane.showMessageDialog(null, "Hoşgeldin "+ad);
           
           }
           return ad;
           
       }
       catch(Exception e)
       {
         JOptionPane.showMessageDialog(null, e);
         return null;
       }
       
   }
   public void kayitol(musteriler musteri)
   {
       try
       {
           baglan();
           String sorgu ="insert into musteri (MusteriAd,MusteriSoyad,DogumTarihi,TelefonNo,email,kullaniciadi,sifre)"
                   + "values (?,?,?,?,?,?,?)";
           ps=conn.prepareStatement(sorgu);
           ps.setString(1,musteri.getMusteriAd());
           ps.setString(2, musteri.getMusteriSoyad());
           ps.setString(3,musteri.getMusteriDogum());
           ps.setString(4,musteri.getMusteriTel());
           ps.setString(5, musteri.getMusteriEmail());
           ps.setString(6,musteri.getKullaniciadi());
           ps.setString(7,musteri.getSifre());
           ps.executeUpdate();
           JOptionPane.showMessageDialog(null, "Eklendi!!");
           
           
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
       
       
   }
   public ObservableList<String> ilcegonder (sehirler sehir)
       {
           try
           {
               baglan();
               ObservableList<String> ilceler = FXCollections.observableArrayList();
               String sorgu = "select IlceAd from ilce where SehirID=(select sehirID from sehir where sehirAd = ?)";
               ps = conn.prepareStatement(sorgu);
               ps.setString(1,sehir.sehirAd);
               rs = ps.executeQuery();
               while (rs.next())
               {
                   ilceler.add(rs.getString(1));
                                         
               }
           return ilceler;
           }
           catch (Exception e)
           {
               JOptionPane.showMessageDialog(null, e);
               return null;
           }
       }
       
       
       public ObservableList<String> ilgonder()
       {
           ObservableList<String> iller = FXCollections.observableArrayList();
           try
           {
               
               baglan();
               String sorgu = "select sehirad from sehir";
               ps=conn.prepareStatement(sorgu);
               rs=ps.executeQuery();
               while(rs.next())
               {
                   iller.add(rs.getString(1));
                   
               }
               return iller;
           }
           catch(Exception e)
           {
               JOptionPane.showMessageDialog(null, e);
               return iller;
           }
           
       }
       public String randevuBilgisiGetir(musteriler musteri)
       {
           String randevuBilgisi="";
           try
           {
               baglan();
               String sorgu = "select m.MusteriAd,m.MusteriSoyad,h.HalisahaAd,r.tarih,r.saat "
                       + "from musteri m,randevu r,halisaha h where m.KullaniciAdi= ?\n" 
                       + "and m.MusteriID=r.MusteriID and r.HalisahaID=h.HalisahaID";
               ps=conn.prepareStatement(sorgu);
               ps.setString(1,musteri.getKullaniciadi());
               rs=ps.executeQuery();
               while (rs.next())
               {
                   randevuBilgisi=randevuBilgisi+" "+rs.getString(1);
                   randevuBilgisi=randevuBilgisi+" "+rs.getString(2);
                   randevuBilgisi=randevuBilgisi+" "+rs.getString(3);
                   randevuBilgisi=randevuBilgisi+" "+rs.getString(4);
                   randevuBilgisi=randevuBilgisi+" "+rs.getString(5);
               }
               rs.close();
              ps.close();
               return randevuBilgisi;
           }
           catch (Exception e)
           {
               JOptionPane.showMessageDialog(null, e);
               return randevuBilgisi;
           }
       }
       public int sayi(){
           baglan();
           int i =0;
           try{
               ps=conn.prepareStatement("select * from halisaha");
               while (rs.next())
                   i+=1;
               
           }
           catch(Exception e){
               JOptionPane.showMessageDialog(null, "yapamadı");
           }
           return i;
       }
       public ObservableList<randevular> listele(){
           ObservableList<randevular> ol = FXCollections.observableArrayList();
           try{
               baglan();
               String sorgu="select m.musteriad,m.musterisoyad,h.halisahaad,s.sehirad,r.tarih,r.randevuid from randevu r, sehir s,musteri m,halisaha h,ilce i" +
" where m.musteriid=r.musteriid and h.halisahaid = r.halisahaid and i.sehirid = s.sehirid and h.ilceid = i.ilceid";
           ps=conn.prepareStatement(sorgu);
           rs=ps.executeQuery();
           while(rs.next()){
               ol.add(new randevular(rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5),rs.getString(6)));
           }}
           catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                   }
           
           return ol;
    
}
       public String idogren(String ilcead){
           String a="";
           try{
               baglan();
               ps=conn.prepareStatement("select ilceid from ilce where ilcead=?");
               ps.setString(1,ilcead);
               rs=ps.executeQuery();
               if(rs.next()){
               a=rs.getString("ilceid");}
               else {
                       JOptionPane.showMessageDialog(null,"ilçe sistemde kayıtlı değil");
                       }
           }
           catch(Exception e){
               JOptionPane.showMessageDialog(null,"ilçe sistemde kayıtlı değil");
           }
           return a;
       }
       public int halisahaSayisiOgren(ilceler ilce)
       {
             int sayi=0;
           try
           {
             
           baglan();
           String sorgu = "select count(HalisahaAd) from halisaha where IlceID = (select IlceID from ilce where IlceAd = ?)";
           ps=conn.prepareStatement(sorgu);
           ps.setString(1,ilce.getIlcead());
           rs=ps.executeQuery();
           while(rs.next())
           {
               sayi=rs.getInt(1);
           }
           rs.close();
              ps.close();
           return sayi;
           }
           catch(Exception e)
           {
               JOptionPane.showMessageDialog(null, e);
               return sayi;
           }
       }
       public String [] halisahaGetir(ilceler ilce)
       {
           
           ilce.setIlcead(HalisahalarController.seciliIlce);
           String[] halisahalar = new String[halisahaSayisiOgren(ilce)];
           try
           {
               baglan();
               String sorgu ="select halisahaad from halisaha where ilceid = (select ilceid from ilce where ilcead = ?)";
               ps=conn.prepareStatement(sorgu);
               ps.setString(1, ilce.getIlcead());
               rs=ps.executeQuery();
               int sayac = 0;
               while(rs.next())
               {
                   halisahalar[sayac]=rs.getString(1);
                   sayac++;
               }
               rs.close();
              ps.close();
               return halisahalar;
           }
           catch(Exception e)
           {
               JOptionPane.showMessageDialog(null, e);
               return halisahalar;
           }
       }
       public String[] halisahaBilgileri()
       {
           String[] bilgiler = new String[3];
           try
           {
           baglan();
           String sorgu = "select halisahaad,adres,servis from halisaha where halisahaad = ?";
           ps=conn.prepareStatement(sorgu);
           ps.setString(1,HalisahalarController.secilenhalisaha );
           rs=ps.executeQuery();
           while(rs.next())
           {
              bilgiler[0] = rs.getString(1);
              bilgiler[1] = rs.getString(2);
              bilgiler[2] = rs.getString(3);
           }
           return bilgiler;
           }
           catch(Exception e)
           {
               JOptionPane.showMessageDialog(null, e);
               return bilgiler;
           }
       }
      public ObservableList<randevular> randevu (String kullanici){
          ObservableList<randevular>  ol = FXCollections.observableArrayList();
                  
          try{
              baglan();     
              String sorgu ="select m.musteriad,m.musterisoyad,h.halisahaad,s.sehirad,r.tarih,r.randevuid from randevu r, sehir s,musteri m,halisaha h,ilce i" +
" where m.musteriid=r.musteriid and h.halisahaid = r.halisahaid and i.sehirid = s.sehirid and h.ilceid = i.ilceid and m.kullaniciadi = ?";
              PreparedStatement ps = conn.prepareStatement(sorgu);
              ps.setString(1,kullanici);
              
              rs = ps.executeQuery();
              while(rs.next()){
                  ol.add(new randevular(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6)));
                  
                  
              }
              rs.close();
              ps.close();
           
          }
          catch(Exception e ){
              JOptionPane.showMessageDialog(null,e);
          }
          
      return ol;
      }
      public void sil (String id){
          baglan();
          try{
              String sorgu="delete from randevu where randevuid=?";
              PreparedStatement ps = conn.prepareStatement(sorgu);
              ps.setString(1, id);
              ps.executeUpdate();
          }
          catch(Exception e){
              JOptionPane.showMessageDialog(null, e.getMessage());
          }
          
      }
      public void halisahaekle(String sehirad,String halisahaad,String adres,String servis){
    baglan();
   
   int ilceid = Integer.parseInt(idogren(sehirad));
    try{
        String sorgu="insert into halisaha(halisahaad,ilceid,adres,servis) values (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sorgu);
        
        
        
        ps.setString(1, halisahaad);
        ps.setInt(2,ilceid);
        ps.setString(3, adres);
        ps.setString(4, servis);
        ps.executeUpdate();
       JOptionPane.showMessageDialog(null,"Halısaha Başarıyla Eklenmiştir");
        
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,"İlçe sistemde kayıtlı değil");
    }
}
      
         public ObservableList<halisahalar> hlistele(){
             baglan();
             ObservableList<halisahalar> ol = FXCollections.observableArrayList();
             try{
                 ps=conn.prepareStatement("select *from halisaha");
                 rs=ps.executeQuery();
                 while(rs.next())
                     ol.add(new halisahalar(rs.getString("halisahaAd"),rs.getString("adres"),rs.getString("servis")));
             }
             catch(Exception e){
                 JOptionPane.showMessageDialog(null, e);
             }
             return ol;
         } 
         public void halisahasil(String ad){
             baglan();
             try{
                 ps=conn.prepareStatement("delete from halisaha where halisahaad=?");
                 ps.setString(1, ad);
                 ps.executeUpdate();
             }
             catch(Exception e ){
                 JOptionPane.showMessageDialog(null, e);
             }
         }
}
