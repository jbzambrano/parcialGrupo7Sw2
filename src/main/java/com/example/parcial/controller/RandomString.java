package com.example.parcial.controller;

public class RandomString {

    static String getStringLetras(int m) {

        String aleatorioletras = "ABCDEFGHIJKLMÑOPQRSTUVWXYZ" + "abcdefghijklmnñopqrstuvwxyz";

        StringBuilder sbl = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int index = (int) (aleatorioletras.length() * Math.random());
            sbl.append(aleatorioletras.charAt(index));
        }

        return sbl.toString();
    }

    static String getStringNumeros(int n) {

        String aleatorionumeros = "1234567890";

        StringBuilder sbn = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int index = (int) (aleatorionumeros.length() * Math.random());
            sbn.append(aleatorionumeros.charAt(index));
        }

        return sbn.toString();
    }


    static int validarTarjeta(Integer tarjeta) {

        String tarjetaString = Integer.toString(tarjeta);
        int cantidadDigitos = tarjetaString.length();

        if (cantidadDigitos == 16) {
            int verificador = tarjeta % 10;
            int tarjetaoperada = tarjeta / 10;
            int invertido = 0;
            int resto;

            while (tarjetaoperada > 0) {
                resto = tarjetaoperada % 10;
                invertido = invertido * 10 + resto;
                tarjetaoperada = tarjetaoperada / 10;
            }

            String tarjetaoperadaS = Integer.toString(tarjetaoperada);
            int arreglodigitos[] = new int[tarjetaoperadaS.length()];

            for (int i = 0; i < tarjetaoperadaS.length(); i++) {
                arreglodigitos[i] = tarjetaoperadaS.charAt(i) - '0';
            }


            for (int j = 0; j < arreglodigitos.length; j++) {
                if ((j % 2) != 0) {
                    arreglodigitos[j] = arreglodigitos[j] * 2;
                }
            }

            for (int k = 0; k < arreglodigitos.length; k++) {
                if (arreglodigitos[k] > 9) {
                    arreglodigitos[k] = arreglodigitos[k] - 9;
                }
            }

            int suma = 0;
            for (int c = 0; c < arreglodigitos.length; c++) {
                suma = suma + arreglodigitos[c];
            }

            int x = suma % 10;
            int y = 10 - x;
            int z = y % 10;
            if (z == verificador) {
                return 1; //Significa que la tarjeta ingresada es correcta
            }

        }
        return 0; //Significa que no es correcta la tarjeta
    }
}
