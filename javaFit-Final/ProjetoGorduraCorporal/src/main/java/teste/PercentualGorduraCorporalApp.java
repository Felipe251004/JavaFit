package teste;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PercentualGorduraCorporalApp extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtSexo, txtIdade, txtCintura, txtPescoco, txtAltura, txtPeso, txtQuadris;
    private JTextArea txtResultados;

    public PercentualGorduraCorporalApp() {
        setTitle("Calculadora de Percentual de Gordura Corporal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLayout(null);

        // Labels e Campos de Texto
        JLabel lblSexo = new JLabel("Sexo (M/F):");
        lblSexo.setBounds(10, 10, 100, 25);
        add(lblSexo);

        txtSexo = new JTextField();
        txtSexo.setBounds(150, 10, 50, 25);
        add(txtSexo);

        JLabel lblIdade = new JLabel("Idade (anos):");
        lblIdade.setBounds(10, 50, 100, 25);
        add(lblIdade);

        txtIdade = new JTextField();
        txtIdade.setBounds(150, 50, 100, 25);
        add(txtIdade);

        JLabel lblCintura = new JLabel("Cintura (cm):");
        lblCintura.setBounds(10, 90, 100, 25);
        add(lblCintura);

        txtCintura = new JTextField();
        txtCintura.setBounds(150, 90, 100, 25);
        add(txtCintura);

        JLabel lblPescoco = new JLabel("Pescoço (cm):");
        lblPescoco.setBounds(10, 130, 100, 25);
        add(lblPescoco);

        txtPescoco = new JTextField();
        txtPescoco.setBounds(150, 130, 100, 25);
        add(txtPescoco);

        JLabel lblAltura = new JLabel("Altura (cm):");
        lblAltura.setBounds(10, 170, 100, 25);
        add(lblAltura);

        txtAltura = new JTextField();
        txtAltura.setBounds(150, 170, 100, 25);
        add(txtAltura);

        JLabel lblPeso = new JLabel("Peso (kg):");
        lblPeso.setBounds(10, 210, 100, 25);
        add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(150, 210, 100, 25);
        add(txtPeso);

        JLabel lblQuadris = new JLabel("Quadris (cm):");
        lblQuadris.setBounds(10, 250, 100, 25);
        add(lblQuadris);

        txtQuadris = new JTextField();
        txtQuadris.setBounds(150, 250, 100, 25);
        add(txtQuadris);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(10, 290, 150, 30);
        add(btnCalcular);

        txtResultados = new JTextArea();
        txtResultados.setBounds(10, 330, 360, 120);
        txtResultados.setEditable(false);
        add(txtResultados);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Captura os valores dos campos de texto
                    String sexo = txtSexo.getText().toLowerCase().trim();
                    if (!sexo.equals("m") && !sexo.equals("f")) {
                        throw new IllegalArgumentException("Sexo deve ser 'M' ou 'F'.");
                    }

                    int idade = Integer.parseInt(txtIdade.getText().trim());
                    double cintura = Double.parseDouble(txtCintura.getText().trim());
                    double pescoco = Double.parseDouble(txtPescoco.getText().trim());
                    double altura = Double.parseDouble(txtAltura.getText().trim());
                    double peso = Double.parseDouble(txtPeso.getText().trim());

                    if (sexo.equals("f")) {
                        double quadris = Double.parseDouble(txtQuadris.getText().trim());
                        // Cria uma instância do backend com os dados do usuário
                        PercentualGorduraCorporal calculadora = new PercentualGorduraCorporal(sexo, idade, cintura, pescoco, altura, peso, quadris);
                        calcularEExibirResultados(calculadora);
                    } else {
                        PercentualGorduraCorporal calculadora = new PercentualGorduraCorporal(sexo, idade, cintura, pescoco, altura, peso, 0);
                        calcularEExibirResultados(calculadora);
                    }
                } catch (NumberFormatException ex) {
                    txtResultados.setText("Erro: Dados numéricos inválidos.");
                } catch (IllegalArgumentException ex) {
                    txtResultados.setText("Erro: " + ex.getMessage());
                } catch (Exception ex) {
                    txtResultados.setText("Erro: " + ex.getMessage());
                }
            }

            private void calcularEExibirResultados(PercentualGorduraCorporal calculadora) {
                try {
                    double gorduraCorporal = calculadora.calcularGorduraCorporal();
                    double imc = calculadora.calcularIMC();
                    double act = calculadora.calcularACT();
                    double tmb = calculadora.calcularTMB();

                    txtResultados.setText(String.format(
                        "Percentual de Gordura Corporal: %.2f%%\nIMC: %.2f\nACT: %.2f litros\nTMB: %.2f kcal/dia",
                        gorduraCorporal, imc, act, tmb
                    ));
                } catch (IllegalArgumentException ex) {
                    txtResultados.setText("Erro nos cálculos: " + ex.getMessage());
                } catch (Exception ex) {
                    txtResultados.setText("Erro inesperado: " + ex.getMessage());
                }
            }

        });
    }}

