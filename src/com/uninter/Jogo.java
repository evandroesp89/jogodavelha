
package com.uninter;

import java.util.Scanner;


/*Class repons�vel por concentrar a din�mica do jogo
 *respons�vle pela comunica��o com o user, aciona servi�os core
 *do monitoramento de tabuleiro */


public class Jogo {
	private Tabuleiro tabuleiro;
	private int rodada = 1, vez = 1;
	private Jogador jogador1;
	private Jogador jogador2;
	private Jogador jogadorNivel;
	public Scanner entrada = new Scanner(System.in);

	// inicia o jogo e tabuleiro
	public Jogo() {
		tabuleiro = new Tabuleiro();
		iniciarJogadores();

		while (Jogar())
			;
	}

	
	/*inicia os jogadores e elege quem ser� o primeiro a jogar 
      e o n�vel do dificuldade do jogo*/
	
	public void iniciarJogadores() {

		System.out.println("Quem joga primeiro 1=Humano e 2=Computador?");
		int opcao = entrada.nextInt();
		
		if (opcao == 1) {
			this.jogador1 = new Humano(1);
			this.jogador1.nome = "Humano";
			System.out.println("-----------------------------\n");
			this.jogador2 =  escolherNivel(2);
			this.jogador2.nome = "Computador";
			
		} else {
			this.jogador2 =  new Humano(2);
			this.jogador2.nome = "Humano";
			System.out.println("-----------------------------\n");
			this.jogador1 =  escolherNivel(1);
			this.jogador1.nome = "Computador";
			

		}

	}

	/*fun��o que elege o n�vel do dificuldade do jogo*/
	
	public Jogador escolherNivel(int opcao) {

		System.out.println("Escolha o n�vel do jogo: \n 1 = EASY \n 2 = MEDIUM \n 3 = HARD:");
		
		
		do {
			int nivel = entrada.nextInt();

			if (opcao != 1 && opcao != 2  && opcao != 3) {
				System.out.println("Op��o inv�lida! Tente novamente");
			}else if(nivel == 1){
				this.jogadorNivel = new Computador1(opcao);
				System.out.println("N�vel EASY iniciado!!!");
			}else if(nivel == 2){
				this.jogadorNivel = new Computador2(opcao);
				System.out.println("N�vel MEDIUM iniciado!!!");
			}else {
				this.jogadorNivel = new Computador3(opcao);
				System.out.println("N�vel HARD iniciado!!!");
			}
			
			
		} while (opcao != 1 && opcao != 2 && opcao != 3);

		return this.jogadorNivel;
	}

	/*fun��o que monitora as a��es do jogadores*/
	
	public boolean Jogar() {
		if (ganhou() == 0) {
			System.out.println("----------------------");
			System.out.println("\nRodada " + rodada);
			System.out.println("� a vez do jogador " + vez());

			if (vez() == 1)
				jogador1.jogar(tabuleiro);
			else
				jogador2.jogar(tabuleiro);

			if (tabuleiro.tabuleiroCompleto()) {
				int fim = this.ganhou();
				if(fim ==1 || fim == -1) {
					System.out.println(jogador1.nome +" ganhou!");
				}else {
					System.out.println("Tabuleiro Completo. Jogo empatado");
				}
				
				return false;
			}
			vez++;
			rodada++;

			return true;
		} else {
			if (ganhou() == -1)
				System.out.println(jogador1.nome +" ganhou!");
			else
				System.out.println(jogador2.nome +" ganhou!");
			return false;
		}

	}

	public int vez() {
		if (vez % 2 == 1)
			return 1;
		else
			return 2;
	}

	public int ganhou() {
		if (tabuleiro.checaLinhas() == 1)
			return 1;
		if (tabuleiro.checaColunas() == 1)
			return 1;
		if (tabuleiro.checaDiagonais() == 1)
			return 1;

		if (tabuleiro.checaLinhas() == -1)
			return -1;
		if (tabuleiro.checaColunas() == -1)
			return -1;
		if (tabuleiro.checaDiagonais() == -1)
			return -1;

		return 0;
	}

}