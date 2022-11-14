package edu.UdA.TaskApp.exception;

public class taskNotFoundException  extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public taskNotFoundException(){
        super();
    }

    public  taskNotFoundException(String customMessage){
        super (customMessage);
    }
}
