package com.uniyaz.ui.layout.welcomelayouts;

import com.uniyaz.ui.layout.common.BodyContainerLayout;
import com.vaadin.ui.VerticalLayout;

public class GeneralContainer extends VerticalLayout {
    private BodyContainerLayout bodyContainerLayout;

    public GeneralContainer(String resourcePath, String username, String comment) {
        HeaderContainerLayout headerContainerLayout = new HeaderContainerLayout();
        addComponent(headerContainerLayout);

        bodyContainerLayout= new BodyContainerLayout(resourcePath, username, comment);
        addComponent(bodyContainerLayout);
    }

    public BodyContainerLayout getBodyContainerLayout() {
        return bodyContainerLayout;
    }

    public void setBodyContainerLayout(BodyContainerLayout bodyContainerLayout) {
        this.bodyContainerLayout = bodyContainerLayout;
    }
}
