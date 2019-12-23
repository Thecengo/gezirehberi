package com.uniyaz;

import javax.servlet.annotation.WebServlet;

import com.uniyaz.dao.PlaceDao;
import com.uniyaz.dao.UserDao;
import com.uniyaz.domain.Place;
import com.uniyaz.domain.User;
import com.uniyaz.service.PlaceService;
import com.uniyaz.service.PlaceServiceImpl;
import com.uniyaz.service.UserService;
import com.uniyaz.service.UserServiceImpl;
import com.uniyaz.ui.layout.PageContainer;
import com.uniyaz.ui.layout.common.ImageContainer;
import com.uniyaz.ui.layout.welcomelayouts.GeneralContainer;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

import java.util.Date;
import java.util.List;

/**
 *
 */
@Theme("mytheme")
@Widgetset("com.uniyaz.MyAppWidgetset")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        String resourcePath = "/WEB-INF/images/image2.jpg";
        String username = "cengiz";
        String comment = "mükemmel";

        PlaceDao placeDao = new PlaceDao();
        PlaceService placeService = new PlaceServiceImpl(placeDao);
        List<Place> treePlacesOrderByMaxPoint = placeService.getTreePlacesOrderByMaxPoint();

        GeneralContainer generalContainer = new GeneralContainer(resourcePath,username,comment);
        int index = 0;

        for (Place place : treePlacesOrderByMaxPoint) {

            String userName = place.getUser().getName();
            String imagePath = place.getImagePath();
            String comment1 = place.getComment();

            generalContainer.getBodyContainerLayout().imageContainerList.add(new ImageContainer(imagePath,userName,comment1));
            generalContainer.getBodyContainerLayout().addComponent(generalContainer.getBodyContainerLayout().imageContainerList.get(index));

            index++;
        }

        PageContainer pageContainer = PageContainer.getPageContainer();
        pageContainer.setContent(generalContainer);

        setContent(pageContainer);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
