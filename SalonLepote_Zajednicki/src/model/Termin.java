/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author comp
 */
public class Termin implements ApstraktniDomenskiObjekat{
    private int idTermin;
    private int trajanje;
    private String danUNedelji;

    public Termin() {
    }

    public Termin(int idTermin, int trajanje, String danUNedelji) {
        this.idTermin = idTermin;
        this.trajanje = trajanje;
        this.danUNedelji = danUNedelji;
    }

    public int getIdTermin() {
        return idTermin;
    }

    public void setIdTermin(int idTermin) {
        this.idTermin = idTermin;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public String getDanUNedelji() {
        return danUNedelji;
    }

    public void setDanUNedelji(String danUNedelji) {
        this.danUNedelji = danUNedelji;
    }

    @Override
    public String toString() {
        return "Termin";
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Termin other = (Termin) obj;
        return Objects.equals(this.danUNedelji, other.danUNedelji);
    }

    @Override
    public String vratiNazivTabele() {
        return "termin";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
            while (rs.next()) {
                int idTermin = rs.getInt("termin.idTermin");
                int trajanje = rs.getInt("termin.trajanje");
                String danUNedelji = rs.getString("termin.danUNedelji");
                
                Termin t = new Termin(idTermin, trajanje, danUNedelji);
                lista.add(t);
            }
            return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "trajanje,danUNedelji";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return trajanje + ", '" + danUNedelji + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "termin.idTermin=" + idTermin;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "trajanje=" + trajanje + ", danUNedelji='" + danUNedelji + "'";
    }
    
    
}
