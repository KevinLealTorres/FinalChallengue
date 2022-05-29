package com.Free;

public class Heroe {
    int vida, rescatados;

    public Heroe(int vida, int rescatados) {
        this.vida = vida;
        this.rescatados = rescatados;
    }

    boolean rescatados(){
        if (this.rescatados >= 10){
            this.vida++;
            this.rescatados = 0;
            return true;
        }
        return false;
    }

    void recibirDanio(int danio){
        System.out.printf("¡Has recibido %d de daño!\n", danio);
        this.vida -= danio;
    }
}