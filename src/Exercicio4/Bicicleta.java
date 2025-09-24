package Exercicio4;

public class Bicicleta  implements IMeioTransporte{
    private int velocidade;
    private final int limiteVelocidade;

    public Bicicleta(){
        this.velocidade = 0;
        this.limiteVelocidade = 180;
    }

    @Override
    public void acelerar(){
        if(this.velocidade < this.limiteVelocidade){
            this.velocidade += 3;
            System.out.println("Carro acelerando, velocidade atual: "+this.velocidade);
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public void frear(){
        if(this.velocidade > 0){
            this.velocidade -= 1;
            System.out.println("Carro freando, velocidade atual: "+this.velocidade);
        } else {
            throw new IllegalStateException();
        }
    }
}