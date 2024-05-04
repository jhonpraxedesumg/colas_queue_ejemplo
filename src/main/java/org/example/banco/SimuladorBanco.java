package org.example.banco;

import java.util.Random;

public class SimuladorBanco {
    private ColaBanco filaBanco; // Cola de clientes en el banco
    private int intervaloLlegadaClientes; // Tiempo en segundos entre la llegada de clientes
    private int intervaloAtencionClientes; // Tiempo en segundos para atender a un cliente

    public SimuladorBanco(int capacidadMaxima, int intervaloLlegadaClientes, int intervaloAtencionClientes) {
        this.filaBanco = new ColaBanco(capacidadMaxima);
        this.intervaloLlegadaClientes = intervaloLlegadaClientes;
        this.intervaloAtencionClientes = intervaloAtencionClientes;
    }

    public void simular(int duracion) {
        int tiempoTranscurrido = 0;
        Random rand = new Random();

        while (tiempoTranscurrido < duracion) {
            // Simular llegada de clientes
            //verifica si el tiempo transcurrido es un múltiplo exacto del intervalo de llegada de clientes.
            if (tiempoTranscurrido % intervaloLlegadaClientes == 0) {
                String nombreCliente = "Cliente " + (filaBanco.cantidadClientesEnFila() + 1);
                Cliente nuevoCliente = new Cliente(nombreCliente);
                filaBanco.agregarCliente(nuevoCliente);
            }

            // Simular atención de clientes
            //verifica si el tiempo transcurrido es un múltiplo exacto del intervalo de llegada de clientes.
            //(tiempoTranscurrido % intervaloAtencionClientes == 0) verifica si el tiempo transcurrido es un múltiplo exacto del intervalo de atención de clientes.
            if (tiempoTranscurrido % intervaloAtencionClientes == 0 && filaBanco.cantidadClientesEnFila() > 0) {
                Cliente clienteAtendido = filaBanco.atenderSiguienteCliente();
                System.out.println("Tiempo transcurrido: " + tiempoTranscurrido + " segundos");
                System.out.println("Clientes en fila: " + filaBanco.cantidadClientesEnFila());
                System.out.println(clienteAtendido + " ha sido atendido.\n");
            }

            tiempoTranscurrido++;
            try {
                Thread.sleep(1000); // Pausar la ejecución por 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SimuladorBanco simulador = new SimuladorBanco(5, 5, 10);
        simulador.simular(60); // Simular durante 60 segundos
    }
}
