package com.mttch.admin.client.utils;

import com.google.gwt.user.client.ui.*;
import com.sencha.gxt.cell.core.client.TextButtonCell;
import com.sencha.gxt.core.client.Style;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.core.client.resources.CommonStyles;
import com.sencha.gxt.fx.client.FxElement;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.info.Info;


public class UiFactory {

    public static void alert(String head, String message, DialogHideEvent.DialogHideHandler handler) {
        AlertMessageBox messageBox = new AlertMessageBox(head, message);
        messageBox.addDialogHideHandler(handler);
        messageBox.show();
    }

    public static void alert(String head, String message) {
        AlertMessageBox messageBox = new AlertMessageBox(head, message);
        messageBox.show();
    }

    public static void displayInfo(String head, String msg) {
        Info.display(head, msg);
    }

    public static <T> ColumnConfig <T, String> createDeleteButtonColumn(Class<T> model, TextButtonCell button) {
        ValueProvider<T, String> buttonValue = new ValueProvider<T, String>() {
            @Override
            public String getValue(T object) {
                return "x";
            }
            @Override
            public void setValue(T object, String value) {}

            @Override
            public String getPath() {return null;}
        };

        ColumnConfig<T, String> buttonColumn =
                new ColumnConfig<>(buttonValue, 37, "X");
        button.setHeight(18);
        buttonColumn.setFixed(true);
        buttonColumn.setColumnTextClassName(CommonStyles.get().inlineBlock());
        buttonColumn.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        buttonColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        buttonColumn.setCell(button);
        return buttonColumn;
    }

    public static void showInfo(String heading, String text) {
        ContentPanel cp = new ContentPanel();
        cp.getHeader().setText(heading);
        RootPanel.get().add(cp);
        cp.getElement().<FxElement>cast().slideOut(Style.Direction.UP);
    }

    public static Widget createHorizontalSpacer(int width) {
        SimpleContainer simpleContainer = new SimpleContainer();
        simpleContainer.setWidth(width);
        return simpleContainer;
    }

    public static Widget createVerticalSpacer(int height) {
        SimpleContainer simpleContainer = new SimpleContainer();
        simpleContainer.setHeight(height);
        return simpleContainer;
    }

    public static Widget createBlackLabel(String text, int sizePx) {
        return createLabel(text, sizePx, "black");
    }

    public static Widget createWhiteLabel(String text) {
        return createWhiteLabel(text, 12);
    }

    public static Widget createWhiteLabel(String text, int sizePx) {
        return createLabel(text, sizePx, "white");
    }

    public static Widget createLabel(String text, int sizePx, String color) {
        String style =
                "color: " + color + "; " +
                        "font-family: helvetica,arial,verdana,sans-serif;" +
                        "font-weight: bold" +
                        "font-size: " + sizePx + "px";
        HTML htmlLabel = new HTML("<span style='" + style + "'>" + text + "</span>");
        return htmlLabel;
    }
}
