/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author comp
 */
public class Rezervacija implements ApstraktniDomenskiObjekat{
    private int idRezervacija;
    private String naziv;
    private Date datum;
    private double ukupanIznos;
    private String napomena;
    private Zaposleni zaposleni;
    private Klijent klijent;
    private List<StavkaRezervacije> stavke= new ArrayList<>();

    public Rezervacija() {
    }

    public Rezervacija(int idRezervacija, String naziv, Date datum, double ukupanIznos, String napomena, Zaposleni zaposleni, Klijent klijent) {
        this.idRezervacija = idRezervacija;
        this.naziv = naziv;
        this.datum = datum;
        this.ukupanIznos = ukupanIznos;
        this.napomena = napomena;
        this.zaposleni = zaposleni;
        this.klijent = klijent;
    }

    public int getIdRezervacija() {
        return idRezervacija;
    }

    public void setIdRezervacija(int idRezervacija) {
        this.idRezervacija = idRezervacija;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public List<StavkaRezervacije> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaRezervacije> stavke) {
        this.stavke = stavke;
    }

    @Override
    public String toString() {
        return "Rezervacija{" + "stavke=" + stavke + '}';
    }

    @Override
    public String vratiNazivTabele() {
        return "rezervacija";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
            while (rs.next()) {
                int idRezervacija = rs.getInt("rezervacija.idRezervacija");
                String naziv = rs.getString("rezervacija.naziv");
                Date datum = rs.getDate("rezervacija.datum");
                double ukupanIznos = rs.getDouble("rezervacija.ukupanIznos");
                String napomena = rs.getString("rezervacija.napomena");

                int idZaposleni = rs.getInt("zaposleni.idZaposleni");
                String imeZaposleni = rs.getString("zaposleni.ime");
                String prezimeZaposleni = rs.getString("zaposleni.prezime");
                String emailZaposleni = rs.getString("zaposleni.email");
                String korisnickoImeZaposleni = rs.getString("zaposleni.korisnickoIme");
                String lozinkaZaposleni = rs.getString("zaposleni.lozinka");
                Zaposleni zaposleni = new Zaposleni(idZaposleni, imeZaposleni, prezimeZaposleni, emailZaposleni, korisnickoImeZaposleni, lozinkaZaposleni);

                int idKlijent = rs.getInt("klijent.idKlijent");
                String imeKlijent = rs.getString("klijent.ime");
                String prezimeKlijent = rs.getString("klijent.prezime");
                String adresaKlijent = rs.getString("klijent.adresa");
                String telefonKlijent = rs.getString("klijent.telefon");
                String emailKlijent = rs.getString("klijent.email");

                int idSalon = rs.getInt("salon.idSalon");
                String nazivSalon = rs.getString("salon.naziv");
                Salon salon = new Salon(idSalon, nazivSalon);

                Klijent klijent = new Klijent(idKlijent, imeKlijent, prezimeKlijent, adresaKlijent, telefonKlijent, emailKlijent, salon);

                Rezervacija r = new Rezervacija(idRezervacija, naziv, datum, ukupanIznos, napomena, zaposleni, klijent);
                lista.add(r);
            }
            return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv,datum,ukupanIznos,napomena,zaposleni,klijent";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + naziv + "', '" + new java.sql.Date(datum.getTime()) + "', " 
         + ukupanIznos + ", '" + napomena + "', '" 
         + zaposleni.getIdZaposleni() + "', '" + klijent.getIdKlijent() + "'";    
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "rezervacija.idRezervacija=" + idRezervacija;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='" + naziv + "', datum='" + new java.sql.Date(datum.getTime()) 
         + "', ukupanIznos=" + ukupanIznos + ", napomena='" + napomena 
         + "', zaposleni='" + zaposleni.getIdZaposleni() + "', klijent='" + klijent.getIdKlijent() + "'";
    }

   
    
    
}
