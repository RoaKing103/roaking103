/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import servicios.FactoriaServiciosImpl;
import modelo.Computador;
import modelo.TarjetaVideo;
import modelo.Usuario;

/**
 *
 * @author Nacho
 */
public class ComputadorDAOImpl implements CrudDAOable<Computador>{

    @Override
    public void create(Computador t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        String sql = "insert into componentes values (?,?, ?, ?, ?, ?, ?);";
                
        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        ps.setInt(1, t.getCodigo());
        ps.setFloat(2, t.getProcesador());
        ps.setString(3, t.getMarcaProce());
        ps.setString(4, t.getPlacaMadre());
        ps.setBoolean(5, t.isFuentePoder());
        ps.setDate(6, new java.sql.Date(t.getFechaCreacion().getTime()));
        ps.setInt(7, t.getId_TarjetaVideo());
        ps.executeUpdate();
    }

    @Override
    public boolean read(Computador t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Computador> read() throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
                if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
            System.out.println(this.getClass().getCanonicalName() + " entrando a read()");
        }
        ArrayList<Computador> al = new ArrayList();
        String sql = "select * from componentes com "
                +"inner join tarjetaVideo tar on com.Id_tarjetavideo = tar.id;";
        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            int codigo = rs.getInt("codigo");
            float procesador = rs.getFloat("procesador");
            String marcaProce = rs.getString("marcaProce");
            String placaMadre = rs.getString("placaMadre");
            boolean fuentePoder = rs.getBoolean("fuentePoder");
            Date fechaCreacion = rs.getDate("fechaCreacion");
            int Id_tarjetaVideo = rs.getInt("Id_tarjetaVideo");
            String tarjetaVideo = rs.getNString("tar.nombre");
            
            
            Computador computador = new Computador();
             
            computador.setCodigo(codigo);
            computador.setProcesador(procesador);
            computador.setMarcaProce(marcaProce);
            computador.setPlacaMadre(placaMadre);
            computador.setFuentePoder(fuentePoder);
            computador.setFechaCreacion(fechaCreacion);
            computador.setId_TarjetaVideo(Id_tarjetaVideo);
            computador.settarjetaVideo(tarjetaVideo);
    
            al.add(computador);
        }        
        return al;
    }

    @Override
    public ArrayList<Computador> readWhere(String whereSQL) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        ArrayList<Computador> al = new ArrayList();
        String sql = "select com.*,  tar.nombre as tarjetaVideo " 
                +"from componentes com "
                +"inner join tarjetaVideo tar on com.Id_tarjetavideo = tar.id "
                + whereSQL + ";";

        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
            System.out.println(this.getClass().getCanonicalName() + " entrando a readWhere()");
            System.out.println(sql);
        }
       
        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            int codigo = rs.getInt("codigo");
            float procesador = rs.getFloat("procesador");
            String marcaProce = rs.getString("marcaProce");
            String placaMadre = rs.getString("placaMadre");
            boolean fuentePoder = rs.getBoolean("fuentePoder");
            Date fechaCreacion = rs.getDate("fechaCreacion");
            int Id_tarjetaVideo = rs.getInt("Id_tarjetaVideo");
            String tarjetaVideo = rs.getNString("tarjetaVideo");
            
            
            Computador computador = new Computador();
             
            computador.setCodigo(codigo);
            computador.setProcesador(procesador);
            computador.setMarcaProce(marcaProce);
            computador.setPlacaMadre(placaMadre);
            computador.setFuentePoder(fuentePoder);
            computador.setFechaCreacion(fechaCreacion);
            computador.setId_TarjetaVideo(Id_tarjetaVideo);
            computador.settarjetaVideo(tarjetaVideo);
            

            al.add(computador);
        }        
        return al; 
    }
    
     public Computador read(String whereSQL) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception 
     {
         Computador computador = null;
         
        String sql = "select com.*,  tar.nombre as tarjetaVideo " 
                +"from componentes com "
                +"inner join tarjetaVideo tar on com.Id_tarjetavideo = tar.id " + whereSQL + ";";

        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
            System.out.println(this.getClass().getCanonicalName() + " entrando a read(String whereSQL)");
            System.out.println(sql);
        }
       
        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            int codigo = rs.getInt("codigo");
            float procesador = rs.getFloat("procesador");
            String marcaProce = rs.getString("marcaProce");
            String placaMadre = rs.getString("placaMadre");
            boolean fuentePoder = rs.getBoolean("fuentePoder");
            Date fechaCreacion = rs.getDate("fechaCreacion");
            int Id_tarjetaVideo = rs.getInt("Id_tarjetaVideo");
            String tarjetaVideo = rs.getNString("tarjetaVideo");
            
            
            computador = new Computador();
             
            computador.setCodigo(codigo);
            computador.setProcesador(procesador);
            computador.setMarcaProce(marcaProce);
            computador.setPlacaMadre(placaMadre);
            computador.setFuentePoder(fuentePoder);
            computador.setFechaCreacion(fechaCreacion);
            computador.setId_TarjetaVideo(Id_tarjetaVideo);
            computador.settarjetaVideo(tarjetaVideo);
            
//            Computador computador = new Computador();
            
        }        
        return computador;
     }

    @Override
    public void update(Computador t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
           String sql = "update componentes set procesador=? , marcaProce=? ,placaMadre=?,fuentePoder=?,fechaCreacion=?,Id_tarjetaVideo=? where codigo=?;";
          /* "update cliente set nombre=?, sexo=?, fecha_nacimiento=?, edad=?, peso=?, vip=?, id_comuna=? where rut=?;"; 
                codigo int ,
                procesador real,
                marcaProce varchar(1),
                placaMadre varchar(20),
                fuentePoder bit(1),
                fechaCreacion DATE,
                Id_tarjetaVideo int,*/
                
        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        
        ps.setFloat(1, t.getProcesador());
        ps.setString(2, t.getMarcaProce());
        ps.setString(3, t.getPlacaMadre());
        ps.setBoolean(4, t.isFuentePoder());
        ps.setDate(5, new java.sql.Date(t.getFechaCreacion().getTime()));
        ps.setInt(6, t.getId_TarjetaVideo());
        ps.setInt(7, t.getCodigo());
        
        
        ps.executeUpdate(); 
    }

    @Override
    public void delete(Computador t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        String sql = "delete from  componentes where codigo=?;";
        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        ps.setInt(1, t.getCodigo());
        
        
        ps.executeUpdate();
    }
    
    public int getTarjetaVideoByCodigo(int codigo) throws InstantiationException, IllegalAccessException, Exception
    {   
        Computador computador = this.read(" where codigo='" + codigo + "'");
        if (computador==null)
        {
            return 0;
        }
        else
        {
            return computador.getId_TarjetaVideo();
        }
        
    }
    
    

}
