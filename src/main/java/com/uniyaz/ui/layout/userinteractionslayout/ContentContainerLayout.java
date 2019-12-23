package com.uniyaz.ui.layout.userinteractionslayout;

import com.uniyaz.ui.layout.common.BodyContainerLayout;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

public class ContentContainerLayout extends VerticalLayout {

    private BodyContainerLayout bodyContainerLayout;
    private HeaderLayout headerLayout;


    public ContentContainerLayout(String resourcePath, String username, String comment, String placeName) {

        headerLayout = new HeaderLayout(placeName);
        addComponent(headerLayout);

        bodyContainerLayout = new BodyContainerLayout(resourcePath, username, comment);
        addComponent(bodyContainerLayout);

    }


    public BodyContainerLayout getBodyContainerLayout() {
        return bodyContainerLayout;
    }


    public void setContent(Component component) {
        this.removeAllComponents();
        addComponent(component);
    }

}
