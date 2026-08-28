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
public class StavkaRezervacije implements ApstraktniDomenskiObjekat{
    private int idRezervacija;
    private int rb;
    private double iznos;
    private String vreme;
    private int broj;
    private double cena;
    private Usluga usluga;

    public StavkaRezervacije() {
    }

    public StavkaRezervacije(int idRezervacija, int rb, double iznos, String vreme, int broj, double cena, Usluga usluga) {
        this.idRezervacija = idRezervacija;
        this.rb = rb;
        this.iznos = iznos;
        this.vreme = vreme;
        this.broj = broj;
        this.cena = cena;
        this.usluga = usluga;
    }

    public int getIdRezervacija() {
        return idRezervacija;
    }

    public void setIdRezervacija(int idRezervacija) {
        this.idRezervacija = idRezervacija;
    }

    
    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

    @Override
    public String toString() {
        return usluga + " x" + broj + " - " + iznos + " din.";
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final StavkaRezervacije other = (StavkaRezervacije) obj;
        return this.rb == other.rb;
    }

    @Override
    public String vratiNazivTabele() {
        return "stavkarezervacije";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
            while (rs.next()) {
                int idRezervacija = rs.getInt("stavkarezervacije.idRezervacija");
                int rb = rs.getInt("stavkarezervacije.rb");
                double iznos = rs.getDouble("stavkarezervacije.iznos");
                String vreme = rs.getString("stavkarezervacije.vreme");
                int broj = rs.getInt("stavkarezervacije.broj");
                double cena = rs.getDouble("stavkarezervacije.cena");

                // Podrazumevane vrednosti za uslugu
                int idUsluga = 0;
                String nazivUsluga = "N/A";
                double cenaUsluga = 0;

                // Proveravamo da li kolone iz usluga postoje u ResultSet-u
                // (ako upit nema JOIN sa tabelom usluga)
                try {
                    idUsluga = rs.getInt("usluga.idUsluga");
                    nazivUsluga = rs.getString("usluga.naziv");
                    cenaUsluga = rs.getDouble("usluga.cena");
                } catch (java.sql.SQLException e) {
                    // Kolone ne postoje jer upit nema JOIN - nastavljamo dalje
                }

                Usluga usluga = new Usluga(idUsluga, nazivUsluga, cenaUsluga);
                StavkaRezervacije stavka = new StavkaRezervacije(idRezervacija, rb, iznos, vreme, broj, cena, usluga);

                lista.add(stavka);
            }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "rb,iznos,vreme,broj,cena,usluga";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return rb + ", " + iznos + ", '" + vreme + "', " 
         + broj + ", " + cena + ", '" + usluga.getIdUsluga() + "'";    
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "stavkarezervacije.rb=" + rb + " AND stavkarezervacije.idRezervacija=" + idRezervacija;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "iznos=" + iznos + ", vreme='" + vreme + "', broj=" + broj 
         + ", cena=" + cena + ", usluga='" + usluga.getIdUsluga() + "'";  
    }
    
    
}
