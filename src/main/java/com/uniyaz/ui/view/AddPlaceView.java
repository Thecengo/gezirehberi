package com.uniyaz.ui.view;

import com.uniyaz.dao.PlaceDao;
import com.uniyaz.domain.Place;
import com.uniyaz.domain.User;
import com.uniyaz.service.PlaceService;
import com.uniyaz.service.PlaceServiceImpl;
import com.uniyaz.ui.layout.welcomelayouts.SignInContainerLayout;
import com.vaadin.ui.*;

import java.util.Date;

public class AddPlaceView extends VerticalLayout {

    private FormLayout mainLayout;

    private TextField idField;
    private TextArea commentField;
    private DateField dateField;
    private TextField imagePathTextField;
    private TextField nameField ;
    private TextField puanField;

    private Button saveButton;

    public AddPlaceView() {
        mainLayout = new FormLayout();
        addComponent(mainLayout);

        idField = new TextField();
        idField.setCaption("id degeri");
        mainLayout.addComponent(idField);

        commentField = new TextArea();
        commentField.setCaption("comment ");
        mainLayout.addComponent(commentField);

        dateField = new DateField();
        dateField.setCaption("Date");
        mainLayout.addComponent(dateField);

        imagePathTextField = new TextField();
        imagePathTextField.setCaption("Image path");
        mainLayout.addComponent(imagePathTextField);

        nameField = new TextField();
        nameField.setCaption("Place name");
        mainLayout.addComponent(nameField);

        puanField = new TextField();
        puanField.setCaption("Puan");
        mainLayout.addComponent(puanField);

        saveButton = new Button();
        saveButton.setCaption("Save");
        saveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                PlaceDao placeDao = new PlaceDao();
                PlaceService placeService = new PlaceServiceImpl(placeDao);

                String imagePathValue = imagePathTextField.getValue();

                User saveUser = SignInContainerLayout.checkedUser;

                Place place = new Place();
                place.setName(nameField.getValue());
                place.setComment(commentField.getValue());
                place.setUser(saveUser);
                place.setCommentDate(new Date());
                place.setImagePath(imagePathValue);
                place.setPuan(Double.parseDouble(puanField.getValue()));

                placeService.savePlace(place);
                Notification.show(place.getName() + "basari ile kaydedilmistir.");
            }
        });
        addComponent(saveButton);
    }
}
