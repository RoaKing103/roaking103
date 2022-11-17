/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Computador;
import servicios.FactoriaServiciosImpl;
import vista.ComputadorModificar;
import vista.MenuComputador;

/**
 *
 * @author Nacho
 */
public class ControladorComputador {
    //private Vista vista;
    MenuComputador vista;
    private Computador modelo;

    public ControladorComputador(MenuComputador v, Computador m)
    {
        this.vista = v;
        this.modelo = m;        
    }
    
     public void inicializar() throws InstantiationException, IllegalAccessException, Exception
    {
        //this.read();
        this.vista.setVisible(true);       
          
        this.vista.getjButton2().addActionListener( e-> {
            try {
                read();
            } catch (Exception ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        this.vista.getjButton4().addActionListener( e-> {
            try {
                update();
            } catch (Exception ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.vista.getjButton5().addActionListener( e-> {
            try {
                delete();
            } catch (Exception ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        this.read();
        
    }
//     public void read() throws IllegalAccessException, Exception
//     {
//         
//        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
//        {
//            System.out.println(this.getClass().getCanonicalName() + " entrando a read()");
//        }
//        try
//        {
//            ArrayList al = this.modelo.read();
//            this.vista.llenarJTable(al);
//        }
//        catch (com.mysql.jdbc.exceptions.jdbc4.CommunicationsException ex)
//        {
//            JOptionPane.showMessageDialog(null,"Posible falla de la BBDD" );
//        }
//          
//        catch(Exception ex)
//        {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        }    
//           
//    }
// 
       public void read() throws IllegalAccessException, Exception{
        
        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
            System.out.println(this.getClass().getCanonicalName() + " entrando a read()");
        }

        try
        {
            ArrayList al = null;
            if (this.vista.getjTextField1().getText().isEmpty())
          {
            al = this.modelo.read();
          }
            else
          {
            String placaMadre = this.vista.getjTextField1().getText().trim();
            al = this.modelo.readConWhere(" where placaMadre like '%" + placaMadre + "%'");
            
          }
           this.vista.llenarJTable(al);
        }
          
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }    
           
       }
       
       public void update()
       {
             DefaultTableModel m = (DefaultTableModel) this.vista.getjTable1().getModel();
        int filas = m.getRowCount();
        if (filas>0)
        {
            if (this.vista.getjTable1().getSelectedRow()==-1)
            {
                JOptionPane.showMessageDialog(null, "Debe elejir una fila", "Informacion", JOptionPane.INFORMATION_MESSAGE + JOptionPane.OK_OPTION);
            }
            else
            {
                int fila = this.vista.getjTable1().getSelectedRow();
                
                int codigo = (int) m.getValueAt(fila, 0);
           

                ComputadorModificar unaVista = new ComputadorModificar(null,false,codigo);
                Computador comModelo = new Computador();
                comModelo.setCodigo(codigo);
                ControladorComputadorModificar c = new ControladorComputadorModificar(unaVista,comModelo);
        
 
                try {
                    c.inicializar();
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ControladorComputador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ControladorComputador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No hay registros", "Información", JOptionPane.INFORMATION_MESSAGE + JOptionPane.OK_OPTION);    
        }
          
       }
       public void delete()
       {
        DefaultTableModel m = (DefaultTableModel) this.vista.getjTable1().getModel();
        int filas = m.getRowCount();
        if (filas>0)
        {
            if (this.vista.getjTable1().getSelectedRow()==-1)
            {
                JOptionPane.showMessageDialog(null, "Debe elejir una fila", "Informacion", JOptionPane.INFORMATION_MESSAGE + JOptionPane.OK_OPTION);
            }
            else
            {
                int fila = this.vista.getjTable1().getSelectedRow();
                
                int codigo = (int) m.getValueAt(fila, 0);
           

                ComputadorModificar unaVista = new ComputadorModificar(null,false,codigo);
                Computador comModelo = new Computador();
                comModelo.setCodigo(codigo);
                ControladorComputadorModificar c = new ControladorComputadorModificar(unaVista,comModelo);
        
 
                try {
                    if (JOptionPane.showConfirmDialog(null, "¿Seguro de eliminar codigo=" + comModelo.getCodigo()+"?", "Delete", JOptionPane.WARNING_MESSAGE +  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                    {
                        comModelo.delete(comModelo);
                        this.read();
                    }
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ControladorComputador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ControladorComputador.class.getName()).log(Level.SEVERE, null, ex);
                }    
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No hay registros", "Información", JOptionPane.INFORMATION_MESSAGE + JOptionPane.OK_OPTION);    
        }
          
       }
}