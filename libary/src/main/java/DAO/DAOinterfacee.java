/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entity.nguoidung;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface DAOinterfacee<T> {
    public T findByIdAndPassWork(T t);
    public T findById(T t);
    public List<T> getAll();
    public boolean deleteById(int id);
    
}
