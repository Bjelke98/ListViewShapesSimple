package com.example.listviewshapes.Shapes;

import com.example.listviewshapes.App;
import javafx.scene.input.MouseEvent;

public interface DrawShape {
    void dragHandler(MouseEvent e);
    void move(MouseEvent e);
    default void select(MouseEvent e){
        if(App.State.drawNext!=DrawType.SELECT)return;
        App.State.selected = this;
    }

}
