package com.example.parcial.controller;

public class RandomString {

    static String getStringLetras (int m){

        String aleatorioletras= "ABCDEFGHIJKLMÑOPQRSTUVWXYZ" + "abcdefghijklmnñopqrstuvwxyz";

        StringBuilder sbl = new StringBuilder();
        for (int i=0; i<m; i++){
            int index = (int)(aleatorioletras.length()*Math.random());
            sbl.append(aleatorioletras.charAt(index));
        }

        return sbl.toString();
    }

    static String getStringNumeros (int n){

        String aleatorionumeros= "1234567890";

        StringBuilder sbn = new StringBuilder();
        for (int i=0; i<n; i++){
            int index = (int)(aleatorionumeros.length()*Math.random());
            sbn.append(aleatorionumeros.charAt(index));
        }

        return sbn.toString();
    }


    static int validarTarjeta (Integer tarjeta ){



        return 0;

    }


}
