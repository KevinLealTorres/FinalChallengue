package com.Free;

public class Heroe {
    int vida, rescatados;

    //Constructor
    public Heroe(int vida, int rescatados) {
        this.vida = vida;
        this.rescatados = rescatados;
    }

    //This action is for add more life
    boolean rescatados(){
        if (this.rescatados >= 10){
            this.vida++;
            this.rescatados = 0;
            return true;
        }
        return false;
    }

    //This action is for be punched
    void recibirDanio(int danio){
        System.out.printf("¡Has recibido %d de daño!\n", danio);
        this.vida -= danio;
    }
}