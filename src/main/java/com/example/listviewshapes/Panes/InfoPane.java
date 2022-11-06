package com.example.listviewshapes.Panes;

import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.Collections;
import java.util.List;

public class InfoPane extends VBox {

    static class LVItem {
        private final Node node;
        LVItem(Node node){
            this.node = node;
        }
        @Override
        public String toString() {
            return node.toString();
        }
    }

    private final Pane pane;
    private final ListView<LVItem> listView = new ListView<>();
    public InfoPane(Pane pane) {
        this.pane = pane;
        setBackground(new Background(new BackgroundFill(Color.WHEAT, CornerRadii.EMPTY, Insets.EMPTY)));
        setPadding(new Insets(10));

        getChildren().add(listView);

        pane.getChildren().addListener((ListChangeListener<Node>) c -> {
            listView.getItems().clear();
            for (Node n: c.getList()){
                listView.getItems().add(new LVItem(n));
            }
        });

    }

}
