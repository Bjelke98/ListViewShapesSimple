package com.example.listviewshapes;

import com.example.listviewshapes.Panes.DrawPane;
import com.example.listviewshapes.Panes.InfoPane;
import com.example.listviewshapes.Shapes.DrawShape;
import com.example.listviewshapes.Shapes.DrawType;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    public static class State {
        public static DrawType drawNext = DrawType.SELECT;
        public static DrawShape selected = null;
    }

    @Override
    public void start(Stage stage) throws IOException {

        DrawPane drawPane = new DrawPane();
        InfoPane infoPane = new InfoPane(drawPane);

        BorderPane root = new BorderPane();

        root.setCenter(drawPane);
        root.setRight(infoPane);

        Scene scene = new Scene(root, 1200, 800);
        stage.setTitle("Dynamic LV Sample");
        stage.setScene(scene);
        stage.show();

        scene.setOnKeyPressed(this::keyPressHandler);
    }

    private void keyPressHandler(KeyEvent e){

        switch (e.getCode()){
            case DIGIT1 -> State.drawNext = DrawType.SELECT;
            case DIGIT2 -> State.drawNext = DrawType.CIRCLE;
            case DIGIT3 -> State.drawNext = DrawType.RECTANGLE;
        }

    }

    public static void main(String[] args) {
        launch();
    }
}