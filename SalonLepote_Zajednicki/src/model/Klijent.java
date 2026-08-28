/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author comp
 */
public class Klijent implements ApstraktniDomenskiObjekat {
    private int idKlijent;
    private String ime;
    private String prezime;
    private String adresa;
    private String telefon;
    private String email;
    private Salon salon;

    public Klijent() {
    }

    public Klijent(int idKlijent, String ime, String prezime, String adresa, String telefon, String email, Salon salon) {
        this.idKlijent = idKlijent;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.telefon = telefon;
        this.email = email;
        this.salon = salon;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

   
    public int getIdKlijent() {
        return idKlijent;
    }

    public void setIdKlijent(int idKlijent) {
        this.idKlijent = idKlijent;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  ime + prezime ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Klijent other = (Klijent) obj;
        return this.idKlijent == other.idKlijent;
    }

    @Override
    public String vratiNazivTabele() {
        return "klijent";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
            while (rs.next()) {
                int idKlijent = rs.getInt("klijent.idKlijent");
                String ime = rs.getString("klijent.ime");
                String prezime = rs.getString("klijent.prezime");
                String adresa = rs.getString("klijent.adresa");
                String telefon = rs.getString("klijent.telefon");
                String email = rs.getString("klijent.email");

                int idSalon = rs.getInt("salon.idSalon");
                String nazivSalon = rs.getString("salon.naziv");
                Salon salon = new Salon(idSalon, nazivSalon);

                Klijent k = new Klijent(idKlijent, ime, prezime, adresa, telefon, email, salon);
                lista.add(k);
            }
            return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ime,prezime,adresa,telefon,email,salon";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + ime + "', '" + prezime + "', '" + adresa + "', '" + telefon + "', '" + email + "', '" + salon.getIdSalon() + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "klijent.idKlijent=" + idKlijent;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ime='" + ime + "', prezime='" + prezime + "', adresa='" + adresa 
         + "', telefon='" + telefon + "', email='" + email + "', salon='" + salon.getIdSalon() + "'";
    }
    
    
    
    
}
