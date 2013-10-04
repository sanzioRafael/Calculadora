/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Rafael
 */
public class SampleController implements Initializable {

    @FXML
    private Button btnNove, btnOito, btnSete, btnSeis, btnCinco, btnQuatro, btnTres, btnDois, btnUm, btnZero;
    @FXML
    private Button btnCompleteClear, btnClear, btnPlus, btnMenos, btnMult, btnDiv, btnEquals, btnPonto;
    @FXML
    private Button btnOn, btnOff;
    @FXML
    private TextField fieldCampo;
    private String campo1 = "", campo2 = "";
    private double conta;
    private char sinal;

    @FXML
    private void actionPerfomance(ActionEvent evt) {

        campo1 = fieldCampo.getText();

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
        fieldCampo.setText(campo1);

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
        } else if (evt.getSource() == btnOn) {
            fieldCampo.setText("0");
        } else if (evt.getSource() == btnOff) {
            System.exit(0);
        } else if (evt.getSource() == btnPonto) {
            boolean ponto = temPonto(campo1);
            if (Integer.valueOf(campo1) >= 0) {
                if (!ponto) {
                    campo1 += '.';
                    fieldCampo.setText(campo1);
                }
            }
        }

    }

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
