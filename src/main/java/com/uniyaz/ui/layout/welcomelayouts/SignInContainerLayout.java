package com.uniyaz.ui.layout.welcomelayouts;

import com.uniyaz.dao.UserDao;
import com.uniyaz.domain.User;
import com.uniyaz.service.UserService;
import com.uniyaz.service.UserServiceImpl;
import com.uniyaz.ui.layout.PageContainer;
import com.uniyaz.ui.layout.userinteractionslayout.ContentContainerLayout;
import com.uniyaz.ui.layout.userinteractionslayout.GeneralUserContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;


public class SignInContainerLayout extends HorizontalLayout {
    public static User checkedUser;

    public SignInContainerLayout() {

        TextField emailTextField = buildTextField();
        addComponent(emailTextField);

        PasswordField passwordField = new PasswordField("Password");
        addComponent(passwordField);

        setMargin(new MarginInfo(10));

        Button signInButton = buildButton(emailTextField, passwordField);
        addComponent(signInButton);

        setSpacing(true);
        setMargin(true);
    }

    private TextField buildTextField() {
        TextField emailTextField = new TextField();
        emailTextField.setCaption("Email");
        return emailTextField;
    }

    private Button buildButton(TextField emailTextField, PasswordField passwordField) {
        Button signInButton = new Button();
        signInButton.setIcon(FontAwesome.SIGN_IN);
        signInButton.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_RIGHT);
        signInButton.setCaption("Sign In");


        signInButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UserDao userDao = new UserDao();
                UserService userService = new UserServiceImpl(userDao);

                String userName = emailTextField.getValue();
                String password = passwordField.getValue();

                try{
                    checkedUser = userService.checkExistUser(userName, password);

                    PageContainer pageContainer = PageContainer.getPageContainer();

                    GeneralUserContainer generalUserContainer = GeneralUserContainer.getGeneralUserContainerInstance();

                    ContentContainerLayout contentContainerLayout = generalUserContainer.getContentContainerLayout();
                    generalUserContainer.addComponent(contentContainerLayout);

                    pageContainer.setContent(generalUserContainer);
                }
                catch (Exception ex){
                    Notification.show(ex.getMessage());
                }
            }
        });
        return signInButton;
    }
}
