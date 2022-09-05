package com.uninter;

import java.util.Random;

/*Usando o objeto jogador iniciamos um
 *jogador computador no modo Medium que executa jogadas validando 
 *possibilidade de vencer a partida como a funcção (validaJogadaMedium)
 *Extends a classe pai Jogador para usar os recursos da mesma
*/

public class Computador2 extends Jogador {

	public Computador2(int jogador) {
		super(jogador);
	}

	 //Função que executa jogadas do computador modo medium
	@Override
	public void jogar(Tabuleiro tabuleiro) {
		Tentativa(tabuleiro);
		tabuleiro.setPosicao(tentativa, jogador);
	}

	// Valida tentativa de jogada válida e aciona marcação no tabuleiro
	@Override
	public void Tentativa(Tabuleiro tabuleiro) {
		int[] tentativa = new int[2];
		this.tentativa = tabuleiro.validaJogadaMedium(jogador);
		do {
			if (this.tentativa == null) {
				this.tentativa = new int[2];
				Random rand = new Random();
				int randomLinha = rand.nextInt((3 - 2) + 1) + 1;

				do {

					this.tentativa[0] = randomLinha;

				} while (this.tentativa[0] > 3 || this.tentativa[0] < 1);

				do {
					int randoColuna = rand.nextInt((3 - 2) + 1) + 1;

					this.tentativa[1] = randoColuna;

				} while (this.tentativa[1] > 3 || this.tentativa[1] < 1);
				if(!checaTentativa(this.tentativa, tabuleiro));
			}
		} while (!checaTentativa(this.tentativa, tabuleiro));
	}
}