package com.uniyaz.ui.layout.welcomelayouts;

import com.uniyaz.dao.UserDao;
import com.uniyaz.domain.User;
import com.uniyaz.service.UserService;
import com.uniyaz.service.UserServiceImpl;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class SıgnUpContainerLayout extends VerticalLayout {

    public SıgnUpContainerLayout() {
        TextField textNameField = buildTextField("User name");
        addComponent(textNameField);

        TextField textEmailField = buildTextField("E mail");
        addComponent(textEmailField);

        TextField passwordField = buildTextField("Password");
        addComponent(passwordField);

        Button saveUserButton = buildSaveButton(textNameField, textEmailField, passwordField);
        addComponent(saveUserButton);

        Button sigInButton = buildSignInButton();
        addComponent(sigInButton);
    }

    private TextField buildTextField(String password) {
        TextField passwordField = new TextField();
        passwordField.setCaption(password);
        return passwordField;
    }

    private Button buildSignInButton() {
        Button sigInButton = new Button();
        sigInButton.setCaption("sign in");
        sigInButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

            }
        });
        return sigInButton;
    }

    private Button buildSaveButton(TextField textNameField, TextField textEmailField, TextField passwordField) {
        Button saveUserButton = new Button();
        saveUserButton.setCaption("Save user");
        saveUserButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                String nameFieldValue = textNameField.getValue();
                String passwordFieldValue = passwordField.getValue();
                String textEmailFieldValue = textEmailField.getValue();

                User user = new User();
                user.setEmail(textEmailFieldValue);
                user.setPassword(passwordFieldValue);
                user.setName(nameFieldValue);

                try {
                    UserDao userDao = new UserDao();
                    UserService userService = new UserServiceImpl(userDao);
                    userService.saveUser(user);
                    Notification.show("Basari ile kaydedilmistir");

                }catch (Exception ex){
                    Notification.show(ex.getMessage());
                }

            }
        });
        return saveUserButton;
    }
}
