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
public class Usluga implements ApstraktniDomenskiObjekat{
    private int idUsluga;
    private String naziv;
    private double cena;

    public Usluga() {
    }

    public Usluga(int idUsluga, String naziv, double cena) {
        this.idUsluga = idUsluga;
        this.naziv = naziv;
        this.cena = cena;
    }

    public int getIdUsluga() {
        return idUsluga;
    }

    public void setIdUsluga(int idUsluga) {
        this.idUsluga = idUsluga;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return naziv ;
    }

    @Override
    public String vratiNazivTabele() {
        return "usluga";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
            while (rs.next()) {
                int idUsluga = rs.getInt("usluga.idUsluga");
                String naziv = rs.getString("usluga.naziv");
                double cena = rs.getDouble("usluga.cena");
                
                Usluga u = new Usluga(idUsluga, naziv, cena);
                lista.add(u);
            }
            return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv,cena";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + naziv + "', " + cena;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "usluga.idUsluga=" + idUsluga;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='" + naziv + "', cena=" + cena;
    }
    
    
    
}
