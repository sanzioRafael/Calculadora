/*
 * Cuiabá, dia 09 de Outubro de 2013
 */
package calculadora;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Rafael Sanzio Macedo Porto
 * @professor Ruy de Oliveira
 * @classe 4° semestre de sistemas para internet, matutino
 */
public class SampleController implements Initializable {
    /*
     *Controle de objetos que estão presente no layou da calculadora.
     * Estes componetes como : AnchorPane, Button, TextField e outros precisam ser controlados.
     * Pois precisatemos dele mara manipularmos os seus metodos, caracteristicas, textos e outros.
     */
    @FXML
    private AnchorPane painel;
    @FXML
    private Button btnNove, btnOito, btnSete, btnSeis, btnCinco, btnQuatro, btnTres, btnDois, btnUm, btnZero;
    @FXML
    private Button btnCompleteClear, btnClear, btnPlus, btnMenos, btnMult, btnDiv, btnEquals, btnPonto;
    @FXML
    private Button btnOn, btnOff;
    @FXML
    private TextField fieldCampo;
    
    /*  As variaveis String craiadas para capturar os valores dos TextField: fieldCampo, para realizar calculos
     *  A variavel boolean foi criado para verificar se o campo está permitido para realizar equações
     *  A variavel do tipo char captura o sinal para saber qual tipo de equação será feita
     */
    private String campo1 = "", campo2 = "";
    private double conta;
    private char sinal;
    
    @FXML
    private void actionPerfomance(ActionEvent evt) {
        //o campo um está capturando valores TexField: fieldCampo
        campo1 = fieldCampo.getText();
        
        /*  O campo1 recebe um metodo que retorna uma String mais este metodo retornará qual botão foi apertado
         *  Se o botao for btnZero o zero se anexara ao campo pois, dependendo da situação o texto será incrementado com o valor em String
         *  E em outras ocasiões, substituirá texto atual
         */
        campo1 = inserirNumeros(campo1, (evt.getSource() == btnZero), "0");
        campo1 = inserirNumeros(campo1, (evt.getSource() == btnUm), "1");
        campo1 = inserirNumeros(campo1, (evt.getSource() == btnDois), "2");
        campo1 = inserirNumeros(campo1, (evt.getSource() == btnTres), "3");
        campo1 = inserirNumeros(campo1, (evt.getSource() == btnQuatro), "4");
        campo1 = inserirNumeros(campo1, (evt.getSource() == btnCinco), "5");
        campo1 = inserirNumeros(campo1, (evt.getSource() == btnSeis), "6");
        campo1 = inserirNumeros(campo1, (evt.getSource() == btnSete), "7");
        campo1 = inserirNumeros(campo1, (evt.getSource() == btnOito), "8");
        campo1 = inserirNumeros(campo1, (evt.getSource() == btnNove), "9");
        //E o campo receberá o texto alterado, como se fosse uma atualização dele
        fieldCampo.setText(campo1);
        
        /*  Nas condições abaixo serão verificados quais botões que realizam as operações desta calculadora
         *  Desde limpeza total(onde é limpo duas vezes os campos) e o limpeza que lima o campo atual, e eles setam o valor para 0;
         *  Os botões das operações matematicas também setam os valores para zero, mais adicionão a operação no char sinal
         *  E por ultimo os botões que ligam e desligam a calculadora o on e o off, um que fecha o aplicatico (btnOff) e o que inicializa-o com 0 (btnOn)
         *  Porem alguns botões usam metodos que realizar a função ou ação do botão, como o btnPonto e o btnEquals
         */
        if (evt.getSource() == btnCompleteClear) {
            
            campo1 = "0";
            campo2 = "0";
            fieldCampo.setText(campo1);
            
        } else if (evt.getSource() == btnClear) {
            
            campo1 = "0";
            fieldCampo.setText(campo1);
            
        } else if (evt.getSource() == btnPlus) {
            
            campo2 = campo1;
            campo1 = "0";
            sinal = '+';
            fieldCampo.setText(campo1);
            
        } else if (evt.getSource() == btnMenos) {
            
            campo2 = campo1;
            campo1 = "0";
            sinal = '-';
            fieldCampo.setText(campo1);
            
        } else if (evt.getSource() == btnMult) {
           
            campo2 = campo1;
            campo1 = "0";
            sinal = 'x';
            fieldCampo.setText(campo1);
            
        } else if (evt.getSource() == btnDiv) {
            
            campo2 = campo1;
            campo1 = "0";
            sinal = ':';
            fieldCampo.setText(campo1);
            
        } else if (evt.getSource() == btnEquals) {
            
            conta = operacaoCalculadora(sinal, Double.valueOf(campo2), Double.valueOf(campo1));
            fieldCampo.setText(String.valueOf(conta));
            
        } else if (evt.getSource() == btnOn) 
            
            fieldCampo.setText("0");
            
          else if (evt.getSource() == btnOff)
            
              System.exit(0);
          
          else if (evt.getSource() == btnPonto) {
              
            boolean ponto = temPonto(campo1);
            if (Integer.valueOf(campo1) >= 0) {
                if (!ponto) {
                    campo1 += '.';
                    fieldCampo.setText(campo1);
                }
            }
            
        }
    }
    
    /*
     * Este metodo que retorna um double realiza o calculo dos valores que estão na referência
     * caso realize uma soma, subtração, multiplicação e divisão.
     * Ultilizado pelio igual, pois o metodo igual é o unico que realiza a conta, pois a equação é dividida em dois valores
     * E estes dois valores são divididos pelo sinal.
     */
    private double operacaoCalculadora(char sinal, double v1, double v2) {
        double result = 0;

        if (sinal == '+') {
            result = v1 + v2;
        } else if (sinal == '-') {
            result = v1 - v2;
        } else if (sinal == ':') {
            result = v1 / v2;
        } else if (sinal == 'x') {
            result = v1 * v2;
        }

        return result;
    }
    
    /*
     * Método responsavel para retornar o valor do botão em que ele digitou, realizando assim a parte da atualização do campo
     * Isto é importante pois a equação deste programa é dividia o primeiro valor vem antes do sinal e o segundo depois,
     * Portanto o primeiro + segundo ou primeiro - segundo ou primeiro x segundo ou primeiro / segundo
     */
    private String inserirNumeros(String campo, boolean valor, String s) {
        boolean ponto = temPonto(campo);
        if (valor) {
            if (ponto) {
                campo += s;
            } else {
                if (Double.valueOf(campo) == 0) {
                    campo = s;
                } else if (Double.valueOf(campo) > 0) {
                    campo += s;
                }
            }
        }
        return campo;
    }
    
    /*
     * Metodo reponsavel para verificar se existe um ponto na letra.
     * Caso sim retorna verdadeiro e não falso.
     * Portanto dependendo do resultado o usuário poderá inserir um ponto ou não
     * Pois o ponto é para que ele possa inserir numeros facionários
     * Como exemplo: 1.990998, 434353.99878 e demais outros
     */
    private boolean temPonto(String s) {
        boolean ponto = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                ponto = true;
                break;
            }
        }
        return ponto;
    }
    
    //Inicializa valores, mas já estão carregados, fica mais simples
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
