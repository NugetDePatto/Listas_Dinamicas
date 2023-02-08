package listas;

public class Nodo {
    int num;
    Nodo sig;
    
    public Nodo(){
        num = 0;
        sig = null;
    }

    @Override
    public String toString() {
        return num + "";
    }
    
    
}
