/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.ComputadorDAOImpl;
import dao.CrudDAOable;
import java.util.ArrayList;
import java.util.Date;
import servicios.FactoriaServiciosImpl;
import vista.Menu;
import modelo.Computador;


/**
 *
 * @author Nacho
 */
public class Computador {
    
    private int codigo;
    private float procesador;
    private String marcaProce;
    private String placaMadre;
    private boolean fuentePoder;
    private Date fechaCreacion;
    private int Id_tarjetaVideo;
    
    private String tarjetaVideo;
    
    public Computador() {
    }

    public Computador(int codigo, float procesador, String marcaProce, String placaMadre, boolean fuentePoder, Date fechaCreacion, int Id_tarjetaVideo) {
//        this.codigo = codigo;
//        this.procesador = procesador;
//        this.marcaProce = marcaProce;
//        this.placaMadre = placaMadre;
//        this.fuentePoder = fuentePoder;
//        this.fechaCreacion = fechaCreacion;
//        this.tarjetaVideo = tarjetaVideo;
          this.setCodigo(codigo);
          this.setProcesador(procesador);
          this.setMarcaProce(marcaProce);
          this.setPlacaMadre(placaMadre);
          this.setFuentePoder(fuentePoder);
          this.setFechaCreacion(fechaCreacion);
          this.setId_TarjetaVideo(Id_tarjetaVideo);
    }
    
    public Computador(Menu aThis, boolean b) {
    }
    
        public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getProcesador() {
        return procesador;
    }

    public void setProcesador(float procesador) {
        this.procesador = procesador;
    }

    public String getMarcaProce() {
        return marcaProce;
    }

    public void setMarcaProce(String marcaProce) {
        this.marcaProce = marcaProce;
    }

    public String getPlacaMadre() {
        return placaMadre;
    }

    public void setPlacaMadre(String placaMadre) {
        this.placaMadre = placaMadre;
    }

    public boolean isFuentePoder() {
        return fuentePoder;
    }

    public void setFuentePoder(boolean fuentePoder) {
        this.fuentePoder = fuentePoder;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getId_TarjetaVideo() {
        return Id_tarjetaVideo;
    }

    public void setId_TarjetaVideo(int Id_tarjetaVideo) {
        this.Id_tarjetaVideo = Id_tarjetaVideo;
    }
    public String gettarjetaVideo() {
        return tarjetaVideo;
    }

    public void settarjetaVideo(String nombre) {
        this.tarjetaVideo = nombre;
    }

    @Override
    public String toString() {
        return "Computador{" + "codigo=" + codigo + ", procesador=" + procesador + ", marcaProce=" + marcaProce + ", placaMadre=" + placaMadre + ", fuentePoder=" + fuentePoder + ", fechaCreacion=" + fechaCreacion + ", Id_tarjetaVideo=" + Id_tarjetaVideo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.codigo;
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
        final Computador other = (Computador) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
    
    public void create(Computador c) throws InstantiationException, IllegalAccessException, Exception
    {
        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
            System.out.println(this.getClass().getCanonicalName() + " entrando a create()");
        }
        CrudDAOable<Computador> cDAO = new ComputadorDAOImpl();
        cDAO.create(c); 
    }
    
    
    public ArrayList<Computador> read() throws InstantiationException, IllegalAccessException, Exception{
        
        {
        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
            System.out.println(this.getClass().getCanonicalName() + " entrando a read()");
        }
        
        CrudDAOable<Computador> cDAO = new ComputadorDAOImpl();
        return cDAO.read(); 
        }
    }
    public ArrayList<Computador> readConWhere(String whereSQL) throws InstantiationException, IllegalAccessException, Exception{
        
        
        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
            System.out.println(this.getClass().getCanonicalName() + " entrando a read()");
        }
        
        CrudDAOable<Computador> cDAO = new ComputadorDAOImpl();
        return cDAO.readWhere(whereSQL);
        
      }
    
     public void update(Computador c) throws InstantiationException, IllegalAccessException, Exception
    {
        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
            System.out.println(this.getClass().getCanonicalName() + " entrando a update");
        }
        CrudDAOable<Computador> cDAO = new ComputadorDAOImpl();
        cDAO.update(c); 
    }
    
    public int getTarjetaVideoByCodigo(int codigo) throws IllegalAccessException, Exception
    {
        ComputadorDAOImpl cDAO = new ComputadorDAOImpl();
        return cDAO.getTarjetaVideoByCodigo(codigo);
     
    }
    
    public Computador getComputador(Computador com) throws InstantiationException, IllegalAccessException, Exception
    {
        ComputadorDAOImpl cDAO = new ComputadorDAOImpl();
        return cDAO.read(" where codigo='" + com.getCodigo()+ "'");
        
        
    }
    public void delete(Computador c) throws InstantiationException, IllegalAccessException, Exception
    {
        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
            System.out.println(this.getClass().getCanonicalName() + " Entrando a delete");
        }

        CrudDAOable<Computador> cDAO = new ComputadorDAOImpl();
        cDAO.delete(c);           
    }        
    
}

//    public ArrayList readConWhere(String string) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }