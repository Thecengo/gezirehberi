package com.uniyaz.ui.layout.welcomelayouts;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class HeaderContainerLayout extends VerticalLayout {

    public HeaderContainerLayout() {

        Label labelGeziRehberiYazisi = buildGeziYazisiLabel();
        addComponent(labelGeziRehberiYazisi);

        Label labelIcMetin = new Label("Gezi rehberi, gezilecek yerler ile ilgili bilgi edinebileceğiniz bir platformdur");
        labelIcMetin.addStyleName(ValoTheme.LABEL_HUGE);
        addComponent(labelIcMetin);

        setSpacing(true);
        setMargin(true);

        SignInContainerLayout signInContainerLayout = new SignInContainerLayout();
        addComponent(signInContainerLayout);

        Button signUpButton = new Button();
        signUpButton.setCaption("Sign Up");
        signUpButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                SıgnUpContainerLayout sıgnUpContainerLayout = new SıgnUpContainerLayout();
                setContent(sıgnUpContainerLayout);
            }
        });
        addComponent(signUpButton);

    }

    private Label buildGeziYazisiLabel() {
        Label labelGeziRehberiYazisi = new Label("Gezi rehberine hosgeldiniz..");
        labelGeziRehberiYazisi.addStyleName(ValoTheme.LABEL_HUGE);
        labelGeziRehberiYazisi.addStyleName(ValoTheme.LABEL_BOLD);
        labelGeziRehberiYazisi.addStyleName(ValoTheme.LABEL_H1);
        return labelGeziRehberiYazisi;
    }

    public void setContent(Component component){
        removeAllComponents();
        addComponent(component);
    }
}
