
package com.uninter;

/*Class Tabuleiro utilizada para gerenciar 
 * e amrazenar as marcações do jogo */

public class Tabuleiro {
	private int[][] tabuleiro = new int[3][3];
	

	/* Inicializa tabuleiro com marcações zeradas 
	 * onde cada jogador terá como lance 1/-1
	 */
	
	public Tabuleiro() {
		zerarTabuleiro();
	}

	public void zerarTabuleiro() {
		for (int linha = 0; linha < 3; linha++)
			for (int coluna = 0; coluna < 3; coluna++)
				tabuleiro[linha][coluna] = 0;
	}

	
	/* Desenha estado do  tabuleiro dando ao user visão das
	 * possibilidades
	 */
	public void exibeTabuleiro() {
		System.out.println();
		for (int linha = 0; linha < 3; linha++) {

			for (int coluna = 0; coluna < 3; coluna++) {

				if (tabuleiro[linha][coluna] == -1) {
					System.out.print(" X ");
				}
				if (tabuleiro[linha][coluna] == 1) {
					System.out.print(" O ");
				}
				if (tabuleiro[linha][coluna] == 0) {
					System.out.print("   ");
				}

				if (coluna == 0 || coluna == 1)
					System.out.print("|");
			}
			System.out.println();
		}

	}

	
	public int getPosicao(int[] tentativa) {
		return tabuleiro[tentativa[0]][tentativa[1]];
	}

	public void setPosicao(int[] tentativa, int jogador) {
		if (jogador == 1)
			tabuleiro[tentativa[0]][tentativa[1]] = -1;
		else
			tabuleiro[tentativa[0]][tentativa[1]] = 1;

		exibeTabuleiro();
	}

	
	/*
	 * Valida as marcações do computador dentro das linhas e retorna 
	 * valor válido para possível vitória
	 */
	public int[] checaLinhasComputador(int jogador) {
		int[] opcao = new int[2];
		for (int linha = 0; linha < 3; linha++) {

			if (jogador == 1) {
				if (((tabuleiro[linha][0] + tabuleiro[linha][1]) == -2) && tabuleiro[linha][2] != 1) {
					opcao[0] = linha;
					opcao[1] = 2;
					return opcao;

				} else if ((tabuleiro[linha][1] + tabuleiro[linha][2]) == -2 && tabuleiro[linha][0] != 1) {
					opcao[0] = linha;
					opcao[1] = 0;
					return opcao;

				} else if ((tabuleiro[linha][0] + tabuleiro[linha][2]) == -2 && tabuleiro[linha][1] != 1) {
					opcao[0] = linha;
					opcao[1] = 1;
					return opcao;
				}
			} else {
				if (((tabuleiro[linha][0] + tabuleiro[linha][1]) == 2) && tabuleiro[linha][2] != -1) {

					opcao[0] = linha;
					opcao[1] = 2;
					return opcao;

				}
				if ((tabuleiro[linha][1] + tabuleiro[linha][2]) == 2 && tabuleiro[linha][0] != -1) {
					opcao[0] = linha;
					opcao[1] = 0;
					return opcao;

				} else if ((tabuleiro[linha][0] + tabuleiro[linha][2]) == 2 && tabuleiro[linha][1] != -1) {

					opcao[0] = linha;
					opcao[1] = 1;
					return opcao;
				}
			}
		}
		return opcao = null;
	}

	/*
	 * Valida as marcações do computador dentro das colunas e retorna 
	 * valor válido para possível vitória
	 */
	public int[] checaColunasComputador(int jogador) {
		int[] opcao = new int[2];
		for (int coluna = 0; coluna < 3; coluna++) {

			if (jogador == 1) {
				if (((tabuleiro[0][coluna] + tabuleiro[1][coluna]) == -1) && tabuleiro[2][coluna] != 1) {
					opcao[0] = 2;
					opcao[1] = coluna;
					return opcao;

				} else if ((tabuleiro[1][coluna] + tabuleiro[2][coluna]) == -2 && tabuleiro[0][coluna] != 1) {
					opcao[0] = 0;
					opcao[1] = coluna;
					return opcao;

				} else if ((tabuleiro[0][coluna] + tabuleiro[2][coluna]) == -2 && tabuleiro[1][coluna] != 1) {
					opcao[0] = 1;
					opcao[1] = coluna;
					return opcao;
				}
			} else {
				if (((tabuleiro[0][coluna] + tabuleiro[1][coluna]) == 2) && tabuleiro[2][coluna] != -1) {

					opcao[0] = 2;
					opcao[1] = coluna;
					return opcao;

				}
				if (((tabuleiro[1][coluna] + tabuleiro[2][coluna]) == 2) && (tabuleiro[0][coluna] != -1)) {
					opcao[0] = 0;
					opcao[1] = coluna;
					return opcao;

				} else if ((tabuleiro[0][coluna] + tabuleiro[2][coluna]) == 2 && tabuleiro[1][coluna] != -1) {

					opcao[0] = 1;
					opcao[1] = coluna;
					return opcao;
				}
			}
		}
		return opcao = null;

	}

	/*
	 * Valida as marcações do computador dentro das diagonais e retorna 
	 * valor válido para possível vitória
	 */
	public int[] checaDiagonaisComputador(int jogador) {
		int[] opcao = new int[2];
		if (jogador == 1) {
			if ((tabuleiro[0][0] + tabuleiro[1][1] == -2) && tabuleiro[2][2] != 1) {
				opcao[0] = 2;
				opcao[1] = 2;
				return opcao;

			} else if ((tabuleiro[2][2] + tabuleiro[1][1] == -2) && tabuleiro[0][0] != 1) {
				opcao[0] = 0;
				opcao[1] = 0;
				return opcao;

			} else if ((tabuleiro[2][2] + tabuleiro[0][0] == -2) && tabuleiro[1][1] != 1) {
				opcao[0] = 1;
				opcao[1] = 1;
				return opcao;

			} else if ((tabuleiro[0][2] + tabuleiro[1][1] == -2) && tabuleiro[2][0] != 1) {
				opcao[0] = 2;
				opcao[1] = 0;
				return opcao;

			} else if ((tabuleiro[2][0] + tabuleiro[1][1] == -2) && tabuleiro[0][2] != 1) {
				opcao[0] = 0;
				opcao[1] = 2;
				return opcao;

			} else if ((tabuleiro[0][2] + tabuleiro[2][0] == -2) && tabuleiro[1][1] != 1) {
				opcao[0] = 1;
				opcao[1] = 1;
				return opcao;

			}
			return opcao = null;
		} else {
			if ((tabuleiro[0][0] + tabuleiro[1][1] == 2) && tabuleiro[2][2] != -1) {
				opcao[0] = 2;
				opcao[1] = 2;
				return opcao;

			} else if ((tabuleiro[2][2] + tabuleiro[1][1] == 2) && tabuleiro[0][0] != -1) {
				opcao[0] = 0;
				opcao[1] = 0;
				return opcao;

			} else if ((tabuleiro[2][2] + tabuleiro[0][0] == 2) && tabuleiro[1][1] != -1) {
				opcao[0] = 1;
				opcao[1] = 1;
				return opcao;

			} else if ((tabuleiro[0][2] + tabuleiro[1][1] == 2) && tabuleiro[2][0] != -1) {
				opcao[0] = 2;
				opcao[1] = 0;
				return opcao;

			} else if ((tabuleiro[2][0] + tabuleiro[1][1] == 2) && tabuleiro[0][2] != -1) {
				opcao[0] = 0;
				opcao[1] = 2;
				return opcao;

			} else if ((tabuleiro[0][2] + tabuleiro[2][0] == 2) && tabuleiro[1][1] != -1) {
				opcao[0] = 1;
				opcao[1] = 1;
				return opcao;

			}
			return opcao = null;
		}

	}

	/*
	 * Valida as marcações de linhas do jogador humano 
	 * retorna true se ele está tentando jogar em lugar já marcado
	 */
	public int checaLinhas() {
		for (int linha = 0; linha < 3; linha++) {

			if ((tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == -3)
				return -1;
			if ((tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == 3)
				return 1;
		}

		return 0;

	}
	
	
	/*
	 * Valida as marcações de colunas do jogador humano 
	 * retorna true se ele está tentando jogar em lugar já marcado
	 */

	public int checaColunas() {
		for (int coluna = 0; coluna < 3; coluna++) {

			if ((tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == -3)
				return -1;
			if ((tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == 3)
				return 1;
		}

		return 0;

	}

	/*
	 * Valida as marcações diagonais do jogador humano 
	 * retorna true se ele está tentando jogar em lugar já marcado
	 */
	public int checaDiagonais() {
		if ((tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == -3)
			return -1;
		if ((tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == 3)
			return 1;
		if ((tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == -3)
			return -1;
		if ((tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == 3)
			return 1;

		return 0;
	}

	
	/* 
	 * Função que realiza a varredura do tabuleiro retornando 
	 * opção de jogada para o jogador computador
	 */
	public int[] validaJogadaMedium(int jogador) {
		int[] jogada = new int[2];

		jogada = checaLinhasComputador(jogador);
		if (jogada != null) {
			return jogada;
		} else {
			jogada = checaColunasComputador(jogador);
			if (jogada != null) {
				return jogada;
			} else {
				jogada = checaDiagonaisComputador(jogador);
				if (jogada != null) {
					return jogada;
				} else {
					return null;
				}
			}
		}
	}

	public boolean tabuleiroCompleto() {
		for (int linha = 0; linha < 3; linha++)
			for (int coluna = 0; coluna < 3; coluna++)
				if (tabuleiro[linha][coluna] == 0)
					return false;
		return true;
	}

}
