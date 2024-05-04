package org.example.banco;

import java.util.Random;

public class Cliente {
    private String nombre;
    private int tiempoAtencion;//tiempo que se tardar en atender al cliente

    public Cliente(String nombre){
        this.nombre = nombre;
        Random rand = new Random();
        this.tiempoAtencion = rand.nextInt(10)+1;
    }
    public String getNombre (){
    return nombre;
    }
    public int getTiempoAtencion(){
        return tiempoAtencion;
    }
    public String toString(){
        return "Cliente{nombre ="+ nombre+ ", tiempo Atencion ="+tiempoAtencion+"minutos";
    }
}
