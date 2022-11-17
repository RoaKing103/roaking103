/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.CrudDAOable;
import dao.TarjetaVideoDAOImpl;
import java.util.ArrayList;
import servicios.FactoriaServiciosImpl;

/**
 *
 * @author Usuario-113
 */
public class TarjetaVideo {
    
    private int id;
    private String nombre;

    public TarjetaVideo() {
    }

    public TarjetaVideo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nombre + "[" + id + "]";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
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
        final TarjetaVideo other = (TarjetaVideo) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
        public ArrayList read() throws InstantiationException, IllegalAccessException, Exception
    {
        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
            System.out.println(this.getClass().getCanonicalName() + " Entrando a read");
        }
        
        TarjetaVideoDAOImpl cDAO = new TarjetaVideoDAOImpl();
        return cDAO.read();        
    }
    
}
