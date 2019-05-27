/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

/**
 *
 * @author jesus
 */
public class AplicacionException extends Exception {
    
    public AplicacionException(){
    }
    
    public AplicacionException(String msj){
    super(msj);
    }
}
