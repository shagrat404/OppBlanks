/*
 * @(#)MainApp.java 1.0 10.03.2017
 */

package ru.solpro.asutp.oppblanksparser;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import ru.solpro.asutp.oppblanksparser.controller.parser.SettingsXmlParser;

/**
 * @author Protsvetov Danila
 * @version 1.0
 */
public class MainApp extends Application {

    private static final String VERSION = "v1.0.7";
    private static final Logger LOG = Logger.getLogger(MainApp.class);
    private Stage primaryStage;
    private AnchorPane rootLayout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        new SettingsXmlParser().loadFromFile("data/setting.xml");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        LOG.info("Приложение запущено.");
        this.primaryStage = primaryStage;
        this.rootLayout = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));

        this.primaryStage.setTitle("Парсер бланков ОПП " + VERSION);
        this.primaryStage.setScene(new Scene(rootLayout, 350, 300));
        this.primaryStage.setResizable(false);
        this.primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        LOG.info("Приложение остановлено.");
    }
}
