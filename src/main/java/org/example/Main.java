package org.example;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private Queue<String> filaPacientes;

    public Main() {
        filaPacientes = new LinkedList<>();
    }


    public void agendarCita(String nombrePaciente) {
        filaPacientes.offer(nombrePaciente);
        System.out.println("Cita agendada para " + nombrePaciente + ". Se ha agregado a la lista de espera.");
    }


    public void atenderPaciente() {
        if (filaPacientes.isEmpty()) {
            System.out.println("No hay pacientes para atender.");
        } else {
            String paciente = filaPacientes.poll();
            System.out.println("Atendiendo a " + paciente + ". Por favor, pase al consultorio.");
        }
    }

    // Mostrar todos los pacientes en espera
    public void mostrarPacientes() {
        if (filaPacientes.isEmpty()) {
            System.out.println("No hay pacientes en espera.");
        } else {
            System.out.println("Pacientes en espera: " + filaPacientes);
        }
    }


    public void proximaCita() {
        if (filaPacientes.isEmpty()) {
            System.out.println("No hay próximas citas registradas.");
        } else {
            System.out.println("Próxima cita: " + filaPacientes.peek());
        }
    }


    public void cancelarCita(String nombrePaciente) {
        if (filaPacientes.remove(nombrePaciente)) {
            System.out.println("La cita de " + nombrePaciente + " ha sido cancelada.");
        } else {
            System.out.println("No se encontró una cita para " + nombrePaciente + ".");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main sistema = new Main();

        int opcion;
        do {
            System.out.println("\n--- Sistema de Citas Médicas ---");
            System.out.println("1. Agendar nueva cita");
            System.out.println("2. Atender siguiente paciente");
            System.out.println("3. Mostrar pacientes en espera");
            System.out.println("4. Consultar próxima cita");
            System.out.println("5. Cancelar cita");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del paciente: ");
                    String nombre = scanner.nextLine();
                    sistema.agendarCita(nombre);
                    break;
                case 2:
                    sistema.atenderPaciente();
                    break;
                case 3:
                    sistema.mostrarPacientes();
                    break;
                case 4:
                    sistema.proximaCita();
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del paciente a cancelar cita: ");
                    String cancelar = scanner.nextLine();
                    sistema.cancelarCita(cancelar);
                    break;
                case 6:
                    System.out.println("Saliendo del sistema. ¡Gracias por usar el servicio de citas médicas!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 6);

        scanner.close();
    }
}
