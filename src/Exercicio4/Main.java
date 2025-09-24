package Exercicio4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<IMeioTransporte> meioDeTransporte = new ArrayList<>();

        meioDeTransporte.add(new Carro());
        meioDeTransporte.add(new Bicicleta());
        meioDeTransporte.add(new Trem());
        meioDeTransporte.add(new Trem());
        meioDeTransporte.add(new Bicicleta());
        meioDeTransporte.add(new Carro());
        meioDeTransporte.add(new Carro());

        for(IMeioTransporte meioTransporte : meioDeTransporte){
            try{
                meioTransporte.acelerar();
            } catch (IllegalStateException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
