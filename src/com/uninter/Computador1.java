package com.uninter;

import java.util.Random;

// Usando o objeto jogador iniciamos um
// jogador computador no modo Easy que executa jogadas randômicamente
// Extends a classe pai Jogador para usar os recursos da mesma

public class Computador1 extends Jogador{
    
    public Computador1(int jogador){
        super(jogador);
    }
    
    
   //Função que executa jogadas do computador modo easy
    @Override
    public void jogar(Tabuleiro tabuleiro){
        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    }
    
    // Valida tentativa de jogada válida e aciona marcação no tabuleiro
    @Override
    public void Tentativa(Tabuleiro tabuleiro){
    	Random rand = new Random();
        int randomLinha = rand.nextInt((3 - 1) + 1) + 1;
        
    	 do{
             do{
              
                 tentativa[0] =randomLinha;              
                 
             }while( tentativa[0] > 3 ||tentativa[0] < 1);
             
             do{
            	 int randoColuna = rand.nextInt((3 - 1) + 1) + 1;
                 
                 tentativa[1] = randoColuna;
                 
             }while(tentativa[1] > 3 ||tentativa[1] < 1);
             
             tentativa[0]--; 
             tentativa[1]--;
             
             if(!checaTentativa(tentativa, tabuleiro))
            	 Tentativa(tabuleiro);
         }while( !checaTentativa(tentativa, tabuleiro) );
    }
}