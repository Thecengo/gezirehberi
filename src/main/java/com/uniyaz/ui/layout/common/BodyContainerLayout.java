package com.uniyaz.ui.layout.common;

import com.vaadin.ui.HorizontalLayout;

import java.util.ArrayList;
import java.util.List;

public class BodyContainerLayout extends HorizontalLayout {

    public List<ImageContainer> imageContainerList = new ArrayList<>();

    public BodyContainerLayout(String resourcePath, String username, String comment) {

    }

    private void buildImageContainer(String resourcePath, String username, String comment) {
        imageContainerList.add(new ImageContainer(resourcePath, username, comment));
    }

}


