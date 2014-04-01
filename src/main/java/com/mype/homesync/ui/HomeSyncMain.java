package com.mype.homesync.ui;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mype.homesync.bt.BitTorrentModule;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Vitaliy Gerya
 */
public class HomeSyncMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("homesync.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BitTorrentModule());
        launch(args);
    }
}
