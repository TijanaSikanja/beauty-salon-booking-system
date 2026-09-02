/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;

/**
 *
 * @author comp
 */
public interface Repository<T> {  //parametar t znaci da je genericki
    //ovde se smestaju sve CRUD operacije
    List<T> getAll(T param, String uslov) throws Exception; // pretraga

    void add(T param) throws Exception;

    void edit(T param) throws Exception;

    void delete(T param) throws Exception;

    List<T> getAll();

    int addReturnKey(T param) throws Exception; //ubacivanje el u bazu i vraca mi id tog el
}
