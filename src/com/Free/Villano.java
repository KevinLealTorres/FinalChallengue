package com.Free;

public class Villano {
    int vida, atrapado;

    //Constructor
    public Villano(int vida, int rescatados) {
        this.vida = vida;
        this.atrapado = rescatados;
    }

    //Is for add more life
    boolean atrapados(){
        if (this.atrapado >= 10){
            this.vida++;
            this.atrapado = 0;
            return true;
        }
        return false;
    }

    //Is for hit someone
    int herir(){return 1;}
}