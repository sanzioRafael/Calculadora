/*
 * Cuiabá, dia 09 de Outubro de 2013
 */
package calculadora;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Rafael Sanzio Macedo Porto
 * @professor Ruy de Oliveira
 * @classe 4° semestre de sistemas para internet, matutino
 */
public class Calculadora extends Application {
    
    /*
     * Carrega o arquivo FXML, que possio o design gráfico, para ser carregado no aplicativo java
     * E determina ele o painel ou a cena padrão para o layout, do GUI do aplicativo
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Este metodo main() é ingnorado na implantação do aplicativo do JavaFX
     * Ele serve para reservar o caso do pedido não poder ser lançado
     * Através de artefatos de implementação
     */
    public static void main(String[] args) {
        launch(args);
    }
}