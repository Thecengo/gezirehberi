package com.uniyaz.ui.component;

import com.vaadin.ui.Button;

public class MenuButton extends Button {

    public MenuButton(String caption) {
        setCaption(caption);
        setWidth(100,Unit.PERCENTAGE);
    }
}
