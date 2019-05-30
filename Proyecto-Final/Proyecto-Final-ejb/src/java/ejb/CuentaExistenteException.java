/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

/*

*/
public class CuentaExistenteException extends Exception {
    public CuentaExistenteException(){}
    
    public CuentaExistenteException(String msj){
        super(msj);
    }
}
