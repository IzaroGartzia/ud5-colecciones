package com.izaro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// CREAR ARRAY DE LAS EMPRESAS
        List<Empresa> empresas = new ArrayList<>();

    // DATOS DEL USUARIO
	int opcion = 0;

        do {
            System.out.print("1.    Crear nueva empresa.\n" +
                    "2.    Añadir empleado a empresa ya existente.\n" +
                    "3.    Listado de empresas.\n" +
                    "4.    Listado detallado de empresas y empleados.\n" +
                    "5.    Salir\n");
            System.out.println("Opción:");
            opcion = Integer.parseInt(br.readLine());

            switch(opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = br.readLine();
                    System.out.print("Año de fundación: ");
                    String anyo = br.readLine();

                    // CREAR LA EMPRESA
                    Empresa empresa = new Empresa(nombre,anyo);

                   // AÑADIR LA EMPRESA AL ARRAY
                    empresas.add(empresa);

                    break;

                case 2:
                    System.out.print("Empresa: ");
                    String nombreEmpresa = br.readLine();

                    int i  = 0;

                    while(i < empresas.size() && !nombreEmpresa.equalsIgnoreCase(empresas.get(i).getNombre()))
                    {
                        i++;
                    }

                    if(i < empresas.size())
                    {
                        System.out.print("Añadir empleado. ");
                        System.out.print("Nombre: ");
                        String nombreEmple = br.readLine();
                        System.out.print("Apellidos: ");
                        String apeEmple = br.readLine();
                        System.out.print("Fecha de nacimiento: ");
                        String fechaNac = br.readLine();
                        System.out.print("Fecha de contrato: ");
                        String fechaCon = br.readLine();

                        // CREAR EL EMPLEADO
                        Empleado empleado = new Empleado(nombreEmple, apeEmple, fechaNac, fechaCon);

                        // AÑADIR EL EMPLEADO EN LA LISTA DE EMPRESAS
                        empresas.get(i).getEmpleados().add(empleado);

                    }
                    break;

                case 3:
                    for (int j = 0; j < empresas.size(); j++) {
                        System.out.println("Empresa: ");
                        System.out.println(empresas.get(j).getNombre());
                        System.out.println();
                    }
                    break;

                case 4:
                    for (int j = 0; j < empresas.size(); j++) {
                        System.out.println("Empresa: "+empresas.get(j).getNombre());
                        for (int k = 0; k < empresas.get(j).getEmpleados().size(); k++) {

                            System.out.println(empresas.get(j).getEmpleados().get(k).getNombre());
                            System.out.println(empresas.get(j).getEmpleados().get(k).getApellidos());
                            System.out.println(empresas.get(j).getEmpleados().get(k).getFechaNacimiento());
                            System.out.println(empresas.get(j).getEmpleados().get(k).getFechaContrato());




                            System.out.println();

                        }

                    }
                    break;

                default:
            }
        } while (opcion != 5);


        if(opcion == 5)
        {
            System.out.println("Has salido del super programa.");
        }


    }
}
