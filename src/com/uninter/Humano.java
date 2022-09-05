package com.uninter;

import java.util.Scanner;


//Usando o objeto jogador iniciamos um jogador Humano 
//Extends a classe pai Jogador para usar os recursos da mesma

public class Humano extends Jogador{
    public Scanner entrada = new Scanner(System.in);
    
    public Humano(int jogador){
        super(jogador);
        this.jogador = jogador;
    }
    
    /*Fun��o interage com user jogador humano recebendo dados
     * e comunicando resultados do jogo
     */
    @Override
    public void jogar(Tabuleiro tabuleiro){
        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    }
    
    
	/* Realiza valida��es de jogadas do usu�rio	 e aciona marca��o no tabuleiro*/
    @Override
    public void Tentativa(Tabuleiro tabuleiro){
        do{
            do{
                System.out.print("Linha: ");
                tentativa[0] = entrada.nextInt();
                
                if( tentativa[0] > 3 ||tentativa[0] < 1)
                    System.out.println("Linha inv�lida. � 1, 2 ou 3");
                
            }while( tentativa[0] > 3 ||tentativa[0] < 1);
            
            do{
                System.out.print("Coluna: ");
                tentativa[1] = entrada.nextInt();
                
                if(tentativa[1] > 3 ||tentativa[1] < 1)
                    System.out.println("Coluna inv�lida. � 1, 2 ou 3");
                
            }while(tentativa[1] > 3 ||tentativa[1] < 1);
            
            tentativa[0]--; 
            tentativa[1]--;
            
            if(!checaTentativa(tentativa, tabuleiro))
                System.out.println("Esse local j� foi marcado. Tente outro.");
        }while( !checaTentativa(tentativa, tabuleiro) );
    }
}