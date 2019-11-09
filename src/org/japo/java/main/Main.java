/* 
 * Copyright 2019 Adrián Pérez Rodríguez - adrianp899@gmail.com .
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static void main(String[] args) {

        // REFERENCIAS
        final int PLANTA_INI = 1;   // Para numero de planta
        final int PLANTA_FIN = 10;  // Para numero de planta
        final int CUENTA_INI = 1;   // Para numero de personas
        final int CUENTA_FIN = 5;   // Para numero de personas
        int pisoAct = 0;

        // CABECERA
        System.out.println("A que planta desean ir?");
        System.out.println("-----------------------");

        // BUCLE cuenta de personas
        for (int persona = CUENTA_INI; persona < CUENTA_FIN; persona++) {

            // CONTROL DE PLANTA
            boolean plantaOK;
            do {

                // CONTROL DE ENTRADA
                boolean testOK = false;
                do {
                    try {
                        System.out.printf("Persona %d: ", persona);
                        pisoAct = SCN.nextInt();
                        testOK = true;

                    } catch (Exception e) {
                        // MENSAJE ENTRADA INCORRECTA
                        System.out.println("ERROR: entrada incorrecta");
                    } finally {
                        SCN.nextLine();
                    }

                } while (!testOK);
                
                // CONTROL RANGO DE PLANTA
                plantaOK = pisoAct >= PLANTA_INI && pisoAct <= PLANTA_FIN;

                // MENSAJE DE ERROR
                if (!plantaOK) {
                    System.out.println("Error: entrada incorrecta");
                }

            } while (!plantaOK);
            
            // MENSAJE SALIDA ALINTRODUCIR PLANTA CORRECTA
            System.out.println("Ud. ha seleccionado la planta " + pisoAct);
        }
        // MENSAJE PROCESO COMPLETADO
        System.out.println("------------------------------------");
        System.out.println("Las plantas seleccionadas son correctas, ascensor en camino.");
    }
}
