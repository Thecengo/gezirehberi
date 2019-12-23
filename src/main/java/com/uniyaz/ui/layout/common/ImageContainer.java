package com.uniyaz.ui.layout.common;

import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;


import java.io.File;

public class ImageContainer extends VerticalLayout {



    public ImageContainer(String resourcePath, String username, String comment) {

        String basepath = VaadinService.getCurrent()
                .getBaseDirectory().getAbsolutePath();


        FileResource resource = new FileResource(new File(basepath + resourcePath));

        setSpacing(true);
        setMargin(true);

        Image image = new Image(username, resource);
        image.setWidth(250, Unit.PIXELS);
        image.setHeight(250, Unit.PIXELS);
        addComponent(image);

        Label commentLabel = new Label(comment);
        addComponent(commentLabel);

    }
}
