/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 *
 * @author comp
 */
public class ZaposleniTermin implements ApstraktniDomenskiObjekat{
    private Zaposleni zaposleni;
    private Termin termin;
    private Date datum;

    public ZaposleniTermin() {
    }

    public ZaposleniTermin(Zaposleni zaposleni, Termin termin, Date datum) {
        this.zaposleni = zaposleni;
        this.termin = termin;
        this.datum = datum;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Override
    public String vratiNazivTabele() {
        return "zaposlenitermin";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "zaposleni,termin,datum";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + zaposleni.getIdZaposleni() + "', '" + termin.getIdTermin() + "', '" 
         + new java.sql.Date(datum.getTime()) + "'";    
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "zaposlenitermin.zaposleni=" + zaposleni.getIdZaposleni() 
         + " AND zaposlenitermin.termin=" + termin.getIdTermin();
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "zaposleni='" + zaposleni.getIdZaposleni() + "', termin='" + termin.getIdTermin() 
         + "', datum='" + new java.sql.Date(datum.getTime()) + "'";    
    }
    
    
}
