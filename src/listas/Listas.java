package listas;

public class Listas {


    Nodo raiz;

    //como el nombre lo dice, añade al inicio de la lista c:
    public void añadirInicio(int n) {
        Nodo nuevo = new Nodo();
        nuevo.num = n;
        nuevo.sig = raiz;
        raiz = nuevo;
    }

    //imprime toda la lista
    public void imprimir() {
        Nodo aux = raiz;
        while (aux != null) {
            System.out.print(aux.num + " ");
            aux = aux.sig;
        }
        System.out.println("");
    }

    //imprime el promedio conforme la informacion de la lista
    public void promedio() {
        Nodo aux = raiz;
        double promedio = 0;

        while (aux != null) {
            promedio = promedio + aux.num;
            aux = aux.sig;
        }
        System.out.println("promedio: "+promedio / tamaño());
    }

    //imprime el nodo de enmedio de la lista
    public void medio() {
        Nodo aux = raiz;
        int cont = tamaño();

        aux = raiz;

        int x = cont / 2 + cont % 2;

        for (int i = 1; i < x; i++) {
            aux = aux.sig;
        }
        
        
        if(cont % 2 == 1){
             System.out.println("medio: " + aux);
        }else{
             System.out.println("medio: " + aux + " " + aux.sig);
        }
    }

    //retorna el tamaño de la lista
    public int tamaño() {
        Nodo aux = raiz;
        int cont = 0;

        while (aux != null) {
            cont++;
            aux = aux.sig;
        }
        return cont;
    }


    //imprime el valor que mas se repite, mi version
    public void moda() {
        int moda[] = new int[tamaño()], cont = 0;

        Nodo aux1 = raiz, aux2;

        while (aux1 != null) {
            aux2 = aux1;
            while (aux2 != null) {
                if (aux1.num == aux2.num) {
                    moda[cont]++;
                }
                aux2 = aux2.sig;
            }
            aux1 = aux1.sig;
            cont++;
        }
        
        int m = 0;

        for (int i = 0; i < moda.length - 1; i++) {
            if (moda[i] > moda[i + 1]) {
                m = i;
            }

        }
        
        System.out.println("moda: " + imprimir(m));

    }
    
    //imprime el valor que mas se repite, version del profe...
    public void Moda(){
        Nodo aux = raiz;
        
        int cont = 0, mayor = -1, arreglo[] = new int[100];
        
        while(aux != null){
            arreglo[aux.num] = arreglo[aux.num] + 1;
            
            if(arreglo[aux.num] > cont){
                mayor = aux.num;
                cont = arreglo[aux.num];
            }
            aux = aux.sig;
        }
        
        System.out.println(mayor);
        
    }

    //imprime nodo con respecto a su posicion, x es la posicion
    public String imprimir(int x) {
        Nodo aux = raiz;

        int con = 1;

        while (aux != null && con != x) {
            aux = aux.sig;
            con++;
        }
        
        return "" + aux.sig;
    }

    //imprime los valores pares
    public void par() {
        Nodo aux = raiz;

        System.out.println("Par: ");
        while (aux != null) {
            if (aux.num % 2 == 0) {
                System.out.print(
                        aux.num + " ");
            }
            aux = aux.sig;
        }
        
        System.out.println("");
    }
    
    //imprime solo los valores impares
    public void impar(){
        Nodo aux = raiz;
        
        System.out.println("Impar: ");

        while (aux != null) {
            if (aux.num % 2 == 1) {
                System.out.print(
                        aux.num + " ");
            }
            aux = aux.sig;
        }
        System.out.println("");
    }

    //agrega al final de la lista
    public void agregarfin(int num) {
        Nodo x = new Nodo();
        x.num = num;
        if (raiz == null) {
            raiz = x;
        } else {
            Nodo aux = raiz;
            while (aux.sig != null) {
                aux = aux.sig;
            }

            aux.sig = x;
        }
    }

    //Parte a la mitad la lista, y los intercambia. Si la division no
    // es exacta, el de enmedio se va al final
    public void partiryvoltear(){
        Nodo auxIzq = raiz, auxDer;
    
        int con = 0, tamaño = tamaño();

        while (con != tamaño / 2) {
            raiz = raiz.sig;
            con++;
        }

        
        if (tamaño % 2 == 0) {
            auxDer = raiz;

            while (auxDer.sig != null) {
                auxDer = auxDer.sig;
            }

            auxDer.sig = auxIzq;

            while (auxIzq.sig != raiz) {
                auxIzq = auxIzq.sig;
            }

            auxIzq.sig = null;

        } else {

            Nodo medio = raiz;
            raiz = raiz.sig;
            medio.sig = null;

            auxDer = raiz;

            while (auxDer.sig != null) {
                auxDer = auxDer.sig;
            }

            auxDer.sig = medio;

            auxDer.sig.sig = auxIzq;
            
            con = 1;
            
            while(con != tamaño){
                auxIzq = auxIzq.sig;
                con++;
            }
            auxIzq.sig = null;
        }

    }

    //Inserta nodo con respecto a su posicion
    public void insertarEn(int pos, int num) {
        Nodo aux = raiz, aux2 = raiz.sig;

        if (pos == 1) {
            raiz = new Nodo();
            raiz.num = num;
            raiz.sig = aux;
        } else if (pos <= tamaño()) {
            int con = 1;

            while (con < pos - 1) {
                aux2 = aux2.sig;
                aux = aux.sig;
                con++;
            }

            aux.sig = new Nodo();
            aux.sig.num = num;

            aux.sig.sig = aux2;

        } else {
            System.out.println("Esa posicion no existe...");
        }

    }
    
    //elimina por posicion
    public void eliminarPos(int pos) {
        Nodo aux = raiz, aux2 = raiz.sig;

        if (pos == 1) {
            raiz = raiz.sig;
            
        } else if (pos < tamaño()) {
            int con = 2;
            while (con < pos) {
                aux2 = aux2.sig;
                aux = aux.sig;
                con++;
            }

            aux.sig = null;

            aux.sig = aux2.sig;
        } else {
            System.out.println("esa posicion no existe...");
        }

    }

    //elimina por informacion
    void eliminar(int num) {
        Nodo aux = raiz, aux2 = raiz.sig;
        
        
        while (aux.sig != null) {
            if (raiz.num == num) {
                raiz = raiz.sig;
                break;
            }else if(aux2.num == num){
                aux.sig = null;
                aux.sig = aux2.sig;
                break;
            } else if(aux2.sig == null){
                System.out.println("No existe " + num + " en la lista...");
            }
            aux = aux.sig;
            aux2 = aux2.sig;
        }

    }
    
    public void reversaRecursiva(){
        reversaRecursiva(raiz);
    }
    
    public void reversaRecursiva(Nodo x) {
        raiz = null;
        if (x.sig != null) {
            reversaRecursiva(x.sig);
        }                                     
        if (raiz == null) {
            raiz = x;
        } else {
            Nodo aux = raiz;
            while (aux.sig != null) {
                aux = aux.sig;
            }
            x.sig = null;
            aux.sig = x;
        }
    }
    
    public void recursiva(){
        recursiva(raiz);
        
    }

    public Nodo recursiva(Nodo x) {
        Nodo aux = null;
        raiz = null;
        if (x.sig != null) {
            aux = recursiva(x.sig);
        }
        x.sig = null;
        if (raiz == null) {
            raiz = x;
            return raiz;
        } else {
            aux.sig = x;
            return aux.sig;
        }
    }
    
    void mostrar1si1no(){
        Nodo aux = raiz;
        
        int con = 1;
        
        while(aux != null){
            if(con % 2 == 1){
                System.out.print(aux + " ");
            }
            
            con++;
            aux = aux.sig;
        }
        
        System.out.println("");
    }
    void eliminar1si1no() {
        Nodo aux = raiz, aux2 = null;

        if (raiz == aux) {
            raiz = raiz.sig;
            aux = raiz;
            aux2 = raiz.sig;
        }

        while (aux.sig != null) {
            if(aux2.sig == null){
                aux.sig = null;
                break;
            }
            
            aux.sig = null;
            aux.sig = aux2.sig;
            aux = aux.sig;
            aux2 = aux2.sig.sig;
        }

    }

    void mostrar1si2no() {
        Nodo aux = raiz;

        int con = 0;

        boolean b = true;

        while (aux != null) {
            if (aux == raiz) {
                System.out.print(aux + " ");
                con++;
            } else {
                for (int i = 0; i < con; i++) {
                    if (aux.sig == null) {

                        b = false;
                        break;
                    }
                    aux = aux.sig;

                }

                con++;

                if (b) {
                    System.out.print(aux + " ");
                }

            }

            aux = aux.sig;
        }
        System.out.println("");
    }

    void eliminar1si2no() {
        int con = 1;
        
        Nodo aux = raiz;
            Nodo aux2 = null;
            raiz = raiz.sig;
            

        while (aux.sig != null) {
            for (int i = 0; i < con; i++) {
                if(aux.sig == null){
                    break;
                }
                aux = aux.sig;
                aux2 = aux.sig;
            }

            con++;

            if (aux2 == null) {
                break;
            }
            aux.sig = aux2.sig;

        }

        System.out.println("");

    }
    
    
    void reversaIterativa() {
        //será mas facil con lista circular?
        Nodo raizAux = null;

        int tamaño = tamaño(), con;

        
        while (tamaño != 0) {
            Nodo auxRaiz = raiz;
            con = 1;
            while (con < tamaño) {
                auxRaiz = auxRaiz.sig;
                con++;
            }

            if (raizAux == null) {
                raizAux = auxRaiz;
                
            } else {
                Nodo aux = raizAux;
                while (aux.sig != null) {
                    aux = aux.sig;
                }

                aux.sig = auxRaiz;
                
                aux.sig.sig = null;
                
            }

            tamaño--;
        }
        
        raiz = raizAux;

    }
    
    
    Nodo auxiliar = null;
    Nodo reversa(Nodo x){
        Nodo aux = null;
        auxiliar = null;
        if (x.sig != null) {
            aux = reversa(x.sig);
        }
        x.sig = null;
        if (auxiliar == null) {
            auxiliar = x;
            return auxiliar;
        } else {
            aux.sig = x;
            return aux.sig;
        }
    }
    
    
    void fueraadentro(){
        Nodo aux = raiz.sig, nodo = raiz;
        
        int tamaño = tamaño(), con = 1;
        
        while(con < (tamaño / 2) + tamaño % 2){
            aux = aux.sig; 
            nodo = nodo.sig;
            con++;
        }
        
        nodo.sig = null;
        recursiva();
        
        boolean b  = true;
        
        if(tamaño % 2 == 0){
            b = false;
        }
        
        fueradentro(raiz, aux, b);

        
    }
    
    void dentrofuera(){
        Nodo nodo = raiz, aux = nodo;
        
        int tamaño = tamaño(), con = 1;
        raiz = raiz.sig;
        while(con<tamaño / 2 ){
            raiz = raiz.sig;
            aux = aux.sig;
            con++;
        }
        aux.sig = null;
        
        recursiva();
        boolean b = false;
        if(tamaño % 2 == 1){
            b = true;
        }
        
        fueradentro(raiz, nodo, b);
    }
    
        Nodo dentrofuera(Nodo nodo1, Nodo nodo2, boolean b) {
        Nodo aux = null;
        if (nodo1.sig != null) {
            aux = fueradentro(nodo1.sig, nodo2.sig, b);
        }
        if (b) {
            if (nodo1.sig == null) {
                raiz = nodo1;
                return raiz;
            } else {
                nodo1.sig = null;
                nodo2.sig = nodo1;
                aux.sig = nodo2;

                return aux.sig.sig; 
            }
        } else {
            if (nodo1.sig == null) {
                nodo1.sig = nodo2;
                raiz = nodo1;
                
        return raiz.sig;
            } else {
                nodo2.sig = null;
                nodo1.sig = nodo2;
                aux.sig = nodo1;
                return aux.sig.sig;
            }
        }

    }

    Nodo fueradentro(Nodo nodo1, Nodo nodo2, boolean b) {
        Nodo aux = null;
        if (nodo1.sig != null) {
            aux = fueradentro(nodo1.sig, nodo2.sig, b);
        }
        if (b) {
            if (nodo1.sig == null) {
                raiz = nodo1;
                return raiz;
            } else {
                nodo1.sig = null;
                nodo2.sig = nodo1;
                aux.sig = nodo2;

                return aux.sig.sig;
            }
        } else {
            if (nodo1.sig == null) {
                nodo1.sig = nodo2;
                raiz = nodo1;

                return raiz.sig;
            } else {
                nodo2.sig = null;
                nodo1.sig = nodo2;
                aux.sig = nodo1;
                return aux.sig.sig;
            }
        }

    }
    
    void cambia(){
        cambia(raiz, 2);
  
        recursiva();
    }
    
    Nodo cambia(Nodo nodo, int con){
        Nodo aux = null;
        
        raiz = null;
        
        if(nodo.sig != null){
            aux = cambia(nodo.sig, (con + 1));
        }
        
        if(con % 2 == 0){
            if(raiz == null){
                raiz = nodo;
                return raiz;
            }else if (raiz.sig != null){
                nodo.sig.sig = null;
                aux.sig.sig = nodo;
                return aux.sig.sig;
            } else{
                nodo.sig.sig = null;
                aux.sig = nodo;
                return aux.sig;
            }
        }
        
        return aux;
    }
    
}
