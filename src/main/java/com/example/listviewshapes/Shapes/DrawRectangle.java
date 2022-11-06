package com.example.listviewshapes.Shapes;

import com.example.listviewshapes.App;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DrawRectangle extends Rectangle implements DrawShape {
    private static int idCount = 0;
    private final int id;
    private final double INITIAL_X;
    private final double INITIAL_Y;

    public DrawRectangle(MouseEvent e) {
        super(e.getX(), e.getY(), 0, 0);
        id = ++idCount;
        INITIAL_X = e.getX();
        INITIAL_Y = e.getY();
        setFill(Color.color((Math.random()*255)/255, (Math.random()*255)/255, (Math.random()*255)/255));
        setStroke(Color.BLACK);
        setStrokeWidth(3);
        setOnMousePressed(this::select);
        setOnMouseDragged(this::move);
    }

    @Override
    public void dragHandler(MouseEvent e) {
        double deltaX = e.getX() - INITIAL_X;
        double deltaY = e.getY() - INITIAL_Y;
        if(deltaX < 0) {
            setX(e.getX());
            setWidth(-deltaX);
        } else {
            setX(INITIAL_X);
            setWidth(deltaX);
        }
        if(deltaY < 0) {
            setY( e.getY() );
            setHeight(-deltaY);
        } else {
            setY(INITIAL_Y);
            setHeight(deltaY);
        }
    }

    @Override
    public void move(MouseEvent e) {
        if( App.State.drawNext!=DrawType.SELECT ||
            App.State.selected==null
        ) return;
        setX(e.getX()-getWidth()/2);
        setY(e.getY()-getHeight()/2);
    }

    @Override
    public String toString() {
        return "Rectangle: "+id;
    }
}
