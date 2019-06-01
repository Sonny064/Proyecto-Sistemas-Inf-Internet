package backend;

public class CuentaExistenteException extends Exception {
    public CuentaExistenteException(){}
    
    public CuentaExistenteException(String msj){
        super(msj);
    }
}
