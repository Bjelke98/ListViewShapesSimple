package com.example.listviewshapes.Panes;

import com.example.listviewshapes.App;
import com.example.listviewshapes.Shapes.DrawCircle;
import com.example.listviewshapes.Shapes.DrawRectangle;
import com.example.listviewshapes.Shapes.DrawShape;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class DrawPane extends Pane {

    private DrawShape shape;

    public DrawPane() {
        setOnMousePressed(this::pressHandler);
        setOnMouseDragged(this::dragHandler);
        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    private void pressHandler(MouseEvent e){
        switch (App.State.drawNext){
            case CIRCLE -> shape = new DrawCircle(e);
            case RECTANGLE -> shape = new DrawRectangle(e);
        }

        switch (App.State.drawNext){
            case CIRCLE , RECTANGLE -> getChildren().add((Shape)shape);
        }
    }

    private void dragHandler(MouseEvent e){
        switch (App.State.drawNext){
            case CIRCLE , RECTANGLE -> shape.dragHandler(e);
        }
    }
}
