package com.Free;

public class Villano {
    int vida, atrapado;

    public Villano(int vida, int rescatados) {
        this.vida = vida;
        this.atrapado = rescatados;
    }

    boolean atrapados(){
        if (this.atrapado >= 10){
            this.vida++;
            this.atrapado = 0;
            return true;
        }
        return false;
    }

    int herir(){return 1;}
}