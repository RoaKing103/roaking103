/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Computador;
import modelo.TarjetaVideo;
import servicios.FactoriaServiciosImpl;
import vista.ComputadorModificar;

/**
 *
 * @author Nacho
 */
public class ControladorComputadorModificar {
    //private Vista vista;
    ComputadorModificar vista;
    private Computador modelo;

    public ControladorComputadorModificar(ComputadorModificar v, Computador m)
    {
        this.vista = v;
        this.modelo = m;        
    }
    
     public void inicializar() throws InstantiationException, IllegalAccessException, Exception
    {
        //this.read();
        this.vista.setVisible(true);
        
        TarjetaVideo tv = new TarjetaVideo();
        ArrayList TarjetaVideo = tv.read();
        this.vista.cargartarjetaVideo(TarjetaVideo,this.modelo.getTarjetaVideoByCodigo(this.modelo.getCodigo()) ); 
        this.vista.setearComputador(modelo.getComputador(modelo));
          
        this.vista.getjButton1().addActionListener( e-> {
            try {
                System.out.println("Agregando listener y evento");
                update();
            } catch (Exception ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        });        
    }
     
       public void update() throws IllegalAccessException, Exception{
           if (!validarProce()){
             return;
         }
           if (!validarPlacaMadre()){
             return;
         }
           if (!validarFecha()){
             return;
         }
           
         
        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
            System.out.println(this.getClass().getCanonicalName() + " entrando a read()");
        }

       
            int codigo = Integer.parseInt(this.vista.getjTextField1().getText());
            float procesador = Float.parseFloat(this.vista.getjTextField3().getText());
            String marcaProce = null;
            if (this.vista.getjRadioButton1().isSelected())
            {
                marcaProce = "I";
            }
            else
            {
               marcaProce = "A"; 
            }
            String placaMadre = this.vista.getjTextField4().getText();
            if (placaMadre.isEmpty())
            {
                this.vista.mostrarMensajePlacaMadre();
            }
            else
            {
            
            
            
                String fechaCreacionString = this.vista.getjTextField6().getText();
                SimpleDateFormat procesadorDeFechasStringChilensis = new SimpleDateFormat ("dd-MM-yyyy");
                Date fechaCreacionTipoDate = procesadorDeFechasStringChilensis.parse(fechaCreacionString);
                boolean fuentePoder = false;
                if (this.vista.getjCheckBox1().isSelected())
                {
                    fuentePoder = true;
                }
                String tarjetaVideo = null;
                int Id_tarjetaVideo = 0;
                String nombre = null;
                if (this.vista.getjComboBox1().getModel().getSize()!=0)
                {
                    tarjetaVideo = (String)this.vista.getjComboBox1().getSelectedItem();
                    String corcheteAbiertoADerecha="[";
                    String corcheteAbiertoAIzquierda="]";

                    int dondeCorcheteAbiertoADerecha = tarjetaVideo.indexOf(corcheteAbiertoADerecha);
                    int dondeCorcheteAbiertoAIzquierda = tarjetaVideo.indexOf(corcheteAbiertoAIzquierda);

                    String codigoDentroDeLosCorchetes = tarjetaVideo.substring(dondeCorcheteAbiertoADerecha+1, dondeCorcheteAbiertoAIzquierda);
                    Id_tarjetaVideo = Integer.parseInt(codigoDentroDeLosCorchetes);

                    nombre = tarjetaVideo.substring(0, dondeCorcheteAbiertoADerecha).trim();
                }

                Computador c = new Computador();
                c.setCodigo(codigo);
                c.setProcesador(procesador);
                c.setMarcaProce(marcaProce);
                c.setPlacaMadre(placaMadre);
                c.setFechaCreacion(fechaCreacionTipoDate);
                c.setFuentePoder(fuentePoder);
                c.setId_TarjetaVideo(Id_tarjetaVideo);
                c.settarjetaVideo(nombre);

                this.modelo.update(c);

                JOptionPane.showMessageDialog(null, "Registro modificado exitosamente");
                this.vista.dispose();
            }
        }
          
  
        
       public boolean validarProce(){
         boolean validarProce = true;

         if ( this.vista.getjTextField3().getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "Ingrese los ghz del procesador");
             validarProce = false;
            }
        return validarProce;
     }
       
        public boolean validarPlacaMadre(){
         boolean validarPlacaMadre = true;

         if ( this.vista.getjTextField4().getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "Ingrese el nombre de la Placa Madre");
             validarPlacaMadre = false;
            }
        return validarPlacaMadre;
     }
       
         public boolean validarFecha(){
         boolean validarFecha = true;

         if ( this.vista.getjTextField6().getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "Ingrese una fecha de creación (DD-MM-YY)");
             validarFecha = false;
            }
        return validarFecha;
     }
           
       

}