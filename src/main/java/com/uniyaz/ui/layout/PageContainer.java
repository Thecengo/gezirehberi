package com.uniyaz.ui.layout;

import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

public class PageContainer extends VerticalLayout {

    private static PageContainer pageContainer;

    private PageContainer() {
    }

    public static PageContainer getPageContainer(){
        if(pageContainer == null){
            pageContainer = new PageContainer();
            return pageContainer;
        }
        else
            return pageContainer;
    }
    public void setContent(Component component) {
        this.removeAllComponents();
        addComponent(component);
    }

}
