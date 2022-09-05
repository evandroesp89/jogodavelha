package com.uninter;

/*Class Jogador utilizada para criar o jogador humano  
 * 
 *A classe � abstrata pois na aplica��o temos filhas que utilizar�o seu
 *recursos*/

public abstract class Jogador {

	protected int[] tentativa = new int[2];
	protected int jogador;
	protected String nome;

	public Jogador(int jogador) {
		this.jogador = jogador;
	}

	public abstract void jogar(Tabuleiro tabuleiro);

	public abstract void Tentativa(Tabuleiro tabuleiro);

	public boolean checaTentativa(int[] tentativa, Tabuleiro tabuleiro) {
		int posicao = tabuleiro.getPosicao(tentativa);
		if (posicao == 0)
			return true;
		else
			return false;

	}

}
