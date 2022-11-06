package com.example.listviewshapes.Shapes;

import com.example.listviewshapes.App;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class DrawCircle extends Circle implements DrawShape {
    private static int idCount = 0;
    private final int id;

    public DrawCircle(MouseEvent e) {
        super(e.getX(), e.getY(), 0);
        id = ++idCount;
        setFill(Color.color((Math.random()*255)/255, (Math.random()*255)/255, (Math.random()*255)/255));
        setStroke(Color.BLACK);
        setStrokeWidth(3);
        setOnMousePressed(this::select);
        setOnMouseDragged(this::move);
    }

    @Override
    public void dragHandler(MouseEvent e) {
        setRadius(
                Math.sqrt(
                    (e.getX() - getCenterX()) * (e.getX() - getCenterX())+
                    (e.getY() - getCenterY()) * (e.getY() - getCenterY())
                )
        );
    }

    @Override
    public void move(MouseEvent e) {
        if( App.State.drawNext!=DrawType.SELECT ||
                App.State.selected==null
        ) return;
        setCenterX(e.getX());
        setCenterY(e.getY());
    }

    @Override
    public String toString() {
        return "Circle: "+id;
    }
}
