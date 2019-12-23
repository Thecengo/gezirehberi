package com.uniyaz.ui.layout.userinteractionslayout;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class HeaderLayout extends VerticalLayout {
    Label label;

    public HeaderLayout(String placeName) {
        setMargin(true);
        setSpacing(true);
        label = new Label(placeName);
        label.addStyleName(ValoTheme.LABEL_HUGE);
        addComponent(label);

    }
}
