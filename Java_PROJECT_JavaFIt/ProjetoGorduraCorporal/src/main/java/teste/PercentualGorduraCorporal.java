package teste;
import java.util.Scanner;
public class PercentualGorduraCorporal {
    // Atributos da classe
    private double cintura;
    private double pescoco;
    private double altura;
    private double peso;
    private double quadris;
    private String sexo;
    private int idade;

    // Construtor padrão
    public PercentualGorduraCorporal() {
        // Permite criar uma instância sem inicializar os atributos
    }

    // Construtor com parâmetros
    public PercentualGorduraCorporal(String sexo, int idade, double cintura, double pescoco, double altura, double peso, double quadris) {
        this.sexo = sexo;
        this.idade = idade;
        this.cintura = cintura;
        this.pescoco = pescoco;
        this.altura = altura;
        this.peso = peso;
        this.quadris = quadris;
    }

    public static void main(String[] args) {
        PercentualGorduraCorporal app = new PercentualGorduraCorporal();
        app.iniciar();
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

        // Solicitar todas as entradas ao usuário de uma só vez
        System.out.print("Digite o sexo (M/F): ");
        char sexoInput = scanner.next().toUpperCase().charAt(0);

        if (sexoInput == 'M') {
            sexo = "masculino";
        } else if (sexoInput == 'F') {
            sexo = "feminino";
        } else {
            System.out.println("Entrada inválida para o sexo. O programa será encerrado.");
            scanner.close();
            return;
        }

        System.out.print("Digite a idade (em anos): ");
        idade = scanner.nextInt();

        System.out.print("Digite a circunferência da cintura (em cm): ");
        cintura = scanner.nextDouble();

        System.out.print("Digite a circunferência do pescoço (em cm): ");
        pescoco = scanner.nextDouble();

        System.out.print("Digite a altura (em cm): ");
        altura = scanner.nextDouble();

        System.out.print("Digite o peso (em kg): ");
        peso = scanner.nextDouble();

        if (sexo.equals("feminino")) {
            System.out.print("Digite a circunferência dos quadris (em cm): ");
            quadris = scanner.nextDouble();
        }

        double percentualGordura = calcularGorduraCorporal();
        double imc = calcularIMC();
        double act = calcularACT();
        double tmb = calcularTMB();

        exibirResultados(percentualGordura, imc, act, tmb);

        scanner.close();
    }

    public double calcularGorduraCorporal() {
        if (sexo.equals("m")) {
            if (cintura <= pescoco) {
                throw new IllegalArgumentException("A circunferência da cintura deve ser maior que a circunferência do pescoço.");
            }
            double gorduraCorporal = 86.010 * Math.log10(cintura - pescoco) - 70.041 * Math.log10(altura) + 36.76;
            return gorduraCorporal >= 0 ? gorduraCorporal : 0;
        } else {
            if ((cintura + quadris) <= pescoco) {
                throw new IllegalArgumentException("A soma da circunferência da cintura e quadris deve ser maior que a circunferência do pescoço.");
            }
            double gorduraCorporal = 163.205 * Math.log10(cintura + quadris - pescoco) - 97.684 * Math.log10(altura) - 78.387;
            return gorduraCorporal >= 0 ? gorduraCorporal : 0;
        }
    }

    public double calcularIMC() {
        return peso / ((altura / 100) * (altura / 100));
    }

    public double calcularACT() {
        if (sexo.equals("masculino")) {
            return 2.447 - 0.09156 * idade + 0.1074 * altura + 0.3362 * peso;
        } else {
            return -2.097 + 0.1069 * altura + 0.2466 * peso;
        }
    }

    public double calcularTMB() {
        if (sexo.equals("masculino")) {
            return 88.362 + (13.397 * peso) + (4.799 * altura) - (5.677 * idade);
        } else {
            return 447.593 + (9.247 * peso) + (3.098 * altura) - (4.330 * idade);
        }
    }

    public void exibirResultados(double percentualGordura, double imc, double act, double tmb) {
        System.out.printf("A porcentagem de gordura corporal é: %.2f%%\n", percentualGordura);
        System.out.printf("O IMC calculado é: %.2f\n", imc);
        System.out.printf("A água corporal total (ACT) é: %.2f l\n", act);
        System.out.printf("A taxa metabólica basal (TMB) é: %.2f kcal/dia\n", tmb);
    }
}