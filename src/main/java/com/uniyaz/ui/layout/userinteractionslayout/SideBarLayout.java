package com.uniyaz.ui.layout.userinteractionslayout;

import com.uniyaz.dao.PlaceDao;
import com.uniyaz.domain.Place;
import com.uniyaz.service.PlaceService;
import com.uniyaz.service.PlaceServiceImpl;
import com.uniyaz.ui.component.MenuButton;
import com.uniyaz.ui.layout.common.BodyContainerLayout;
import com.uniyaz.ui.layout.common.ImageContainer;
import com.uniyaz.ui.view.AddPlaceView;
import com.vaadin.data.Property;
import com.vaadin.ui.*;



import java.util.List;

public class SideBarLayout extends VerticalLayout {

    private BodyContainerLayout bodyContainerLayout;
    private ComboBox comboBoxPlace;
    private MenuButton menuPlaceAddButton;

    public SideBarLayout(ContentContainerLayout contentContainerLayout, BodyContainerLayout bodyContainerLayout) {

        this.bodyContainerLayout = bodyContainerLayout;

        TextField searchTextField = new TextField("Search");
        addComponent(searchTextField);

        MenuButton menuSearchButton = new MenuButton("Ara");
        menuSearchButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                bodyContainerLayout.imageContainerList.clear();
                bodyContainerLayout.removeAllComponents();

                String getTextFieldValue = searchTextField.getValue();

                addPlaceImageContainer(getTextFieldValue);

                contentContainerLayout.setContent(bodyContainerLayout);

            }
        });
        addComponent(menuSearchButton);


        menuPlaceAddButton = new MenuButton("Place add");
        menuPlaceAddButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                AddPlaceView addPlaceView = new AddPlaceView();
                contentContainerLayout.setContent(addPlaceView);
            }
        });
        addComponent(menuPlaceAddButton);

        fillPlaceComboBox();

        comboBoxPlace.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {

                bodyContainerLayout.imageContainerList.clear();
                bodyContainerLayout.removeAllComponents();

                Place comboBoxPlaceValue = (Place) comboBoxPlace.getValue();

                addPlaceImageContainer(comboBoxPlaceValue.getName());

                contentContainerLayout.setContent(bodyContainerLayout);

            }
        });
        addComponent(comboBoxPlace);
    }


    public void fillPlaceComboBox() {

        PlaceDao placeDao = new PlaceDao();
        PlaceService placeService = new PlaceServiceImpl(placeDao);
        List<Place> allPlacesList = placeService.getAllPlaces();

        comboBoxPlace = new ComboBox("select place",allPlacesList);

    }

    private void addPlaceImageContainer(String placeName){

        PlaceDao placeDao = new PlaceDao();

        PlaceService placeService = new PlaceServiceImpl(placeDao);
        List<Place> placesByName = placeService.getPlacesByName(placeName);

        int index = 0;

        for (Place place : placesByName) {

            String userName = place.getUser().getName();
            String imagePath = place.getImagePath();
            String comment = place.getComment();

            bodyContainerLayout.imageContainerList.add(new ImageContainer(imagePath,userName,comment));
            bodyContainerLayout.addComponent(bodyContainerLayout.imageContainerList.get(index));

            index++;
        }
    }
}
