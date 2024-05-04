package org.example.banco;

import java.util.LinkedList;
import java.util.Queue;

public class ColaBanco {
    private Queue<Cliente>filaClientes;
    private int capacidadMaxima;
    public ColaBanco(int MaxCapacity){
        this.filaClientes = new LinkedList<>();
        this.capacidadMaxima = MaxCapacity;
    }

    public  void agregarCliente(Cliente cliente){
        if (filaClientes.size()< capacidadMaxima){
            filaClientes.offer(cliente);//un nuevo cliente entro a la agencia
            System.out.println("cliente"+cliente.getNombre()+"se ha unido a la fila");
        }else {
            System.out.println("lo siento la fila esta llena vallase a la gaver");
        }
    }
    public Cliente atenderSiguienteCliente() {
        if (!filaClientes.isEmpty()) { // verifica que la cola no este vacia
            Cliente clienteAtendido = filaClientes.poll();//eleimina y retorna el nombre del cliente
            System.out.println("cliente" + clienteAtendido.getNombre() + "fue atendido");
            return clienteAtendido;//retorna el nombre del cliente
        } else {
            System.out.println("no hay mara en la fila");
            return null;
        }
    }
        public int cantidadClientesEnFila(){
            return filaClientes.size();
        }
    }

