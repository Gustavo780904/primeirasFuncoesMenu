import java.util.Locale;
import java.util.Scanner;

public class Menu {
// apresenta o menu e l� a op�ao desejada.
	public static void menu() {
		Scanner leOpcao = new Scanner(System.in);
		int opcao;
		do {
			System.out.println("MENU");
			System.out.printf("%n1- N�MERO PRIMO%n");
			System.out.printf("%n2- FATORIAL DO N�MERO%n");
			System.out.printf("%n3- N�MERO PERFEITO%n");
			System.out.printf("%n4- SAIR%n");
			System.out.printf("%nDIGITE A OP��O: ");
			opcao = leOpcao.nextInt();
		} while (opcao < 1 || opcao > 4);		
		if (opcao == 1) {
			int valor = le();
			if (valor < 2)
				violacao(opcao);
			else
				primo(valor);
		}else if(opcao == 2) {
			int valor = le();
			if (valor < 0)
				violacao(opcao);
			else
				fatorial(valor);
		}else if(opcao == 3) {
			int valor = le();
			if(valor < 0)
				violacao(opcao);
			else
				perfeito(valor);
		}else {
			System.out.printf("%nFIM DO PROGRAMA%n");
			System.exit(0);
		}
	}

// l� o valor a ser processado
	public static int le() {
		Scanner leValor = new Scanner(System.in);
		System.out.printf("%nDIGITE UM VALOR: ");
		return leValor.nextInt();
	}

// informa o resultado da valida��o
	public static void violacao(int opcao) {
		if (opcao == 1) {
			exibe1();
		} else if (opcao == 2) {
			exibe2();
		} else if (opcao == 3) {
			exibe3();
		}
	}

// mostra porque n�o pode ser calculado
	public static void exibe1() {
		System.out.printf("Para verificar se o n�mero digitado � primo ou n�o, ele deve ser maior ou igual 2.%n");
		menu();
	}

	public static void exibe2() {
		System.out.printf("Para se calcular o fatorial, o n�mero digitado deve ser maior ou igual 0.%n");
		menu();
	}

	public static void exibe3() {
		System.out.printf("Para verificar se o n�mero digitado � perfeito ou n�o, ele deve ser maior ou igual 0.%n");
		menu();
	}

// calcula
	public static void primo(int valor) {
		boolean verdadeiro = false;
		if (valor >= 2)
			verdadeiro = true;
		for (int j = 2; j < valor; j++) {
			if (valor % j == 0) 
				verdadeiro = false;
			break;
		}
		exibePrimoOuNao(valor, verdadeiro);
	}

	public static void fatorial(int valor) {
		int fator = valor;
		int fatorial = fator;
		while (fator > 1) {
			fatorial = fatorial * (fator - 1);
			fator --;
		}
		exibeFatorial(valor, fatorial);
	}

	public static void perfeito(int valor) {
		/*int soma = 0, divisor = 1, metade = valor/2;
		while (divisor <= metade) {
			if (valor % divisor == 0) {
				soma += divisor;
				divisor = divisor + 1;
			}
		}*/
		int soma = 0, metade = valor/2;
		for (int i = 1; i <= metade; i++) {
			if(valor % i == 0) {
				soma += i;
			}
		}
		exibePerfeitoOuNao(valor, soma);
	}

//	resultados
	public static void exibePrimoOuNao(int valor, boolean verdadeiro) {
		String afirmativa;
		if (verdadeiro)
			afirmativa = "�";
		else
			afirmativa = "n�o �";
		System.out.println("O n�mero " + valor + " " + afirmativa + " primo.");
		menu();
	}

	public static void exibeFatorial(int valor, int fatorial) {
		System.out.printf("%nO fatorial do n�mero " + valor + " �: " + fatorial + ".%n");
		menu();
	}

	public static void exibePerfeitoOuNao(int valor, int soma) {
		String afirmativa;
		if (soma == valor)
			afirmativa = "� ";
		else
			afirmativa = "n�o � ";
		System.out.printf("%nO n�mero " + valor+ " " + afirmativa + "perfeito.%n");
		menu();
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		menu();

	}
}
