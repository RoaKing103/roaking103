/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.TarjetaVideo;
import servicios.FactoriaServiciosImpl;

/**
 *
 * @author Usuario-113
 */
public class TarjetaVideoDAOImpl implements CrudDAOable <TarjetaVideo>{
    @Override
    public void create(TarjetaVideo t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean read(TarjetaVideo t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TarjetaVideo> readWhere(String whereSQL) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(TarjetaVideo t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(TarjetaVideo t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TarjetaVideo> read() throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        ArrayList<TarjetaVideo> al = new ArrayList();
        String sql = "select * from tarjetaVideo;";
        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            
            TarjetaVideo tarjetaVideo = new TarjetaVideo(id, nombre);
            al.add(tarjetaVideo);
        }        
        return al;
    }
    
}
