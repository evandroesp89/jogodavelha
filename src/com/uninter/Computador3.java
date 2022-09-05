package com.uninter;

import java.util.Random;

//Usando o objeto jogador iniciamos um
//jogador computador no modo hard com validação de jogada do oponente
//e possibilidades de vitória própria
//Extends a classe pai Jogador para usar os recursos da mesma

public class Computador3 extends Jogador {

	public Computador3(int jogador) {
		super(jogador);
	}

	//Função que executa jogadas do computador modo hard
	@Override
	public void jogar(Tabuleiro tabuleiro) {
		Tentativa(tabuleiro);
		tabuleiro.setPosicao(tentativa, jogador);
	}

	/* Realiza tentativa de jogada primeiramente
	 * validando se o oponente está com chance de vitória 
	 * eminente para em seguida validar se está a ponto de vencer o jogo
	 * e aciona marcação no tabuleiro
	 */
	@Override
	public void Tentativa(Tabuleiro tabuleiro) {
		int[] tentativa = new int[2];
		if (jogador == -1) {
			this.tentativa = tabuleiro.validaJogadaMedium(1);
		} else {
			this.tentativa = tabuleiro.validaJogadaMedium(jogador);
		}
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