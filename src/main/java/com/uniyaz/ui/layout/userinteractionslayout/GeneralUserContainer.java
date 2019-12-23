package com.uniyaz.ui.layout.userinteractionslayout;


import com.vaadin.ui.HorizontalLayout;


public class GeneralUserContainer extends HorizontalLayout {

    SideBarLayout sideBarLayout;
    private ContentContainerLayout contentContainerLayout;

    private static GeneralUserContainer generalUserContainer;

    private GeneralUserContainer() {

        setSpacing(true);
        setMargin(true);


        String resourcePath = "/WEB-INF/images/image.jpeg";
        String userName = "cengiz";
        String comment = "icerik güzelll";
        String placeName = "Istanbul";

       contentContainerLayout = new ContentContainerLayout(resourcePath, userName, comment, placeName);
       sideBarLayout = new SideBarLayout(contentContainerLayout, contentContainerLayout.getBodyContainerLayout());
       addComponent(sideBarLayout);
    }

    public static GeneralUserContainer getGeneralUserContainerInstance(){
        if(generalUserContainer == null){
            generalUserContainer = new GeneralUserContainer();
            return generalUserContainer;
        }

        else return generalUserContainer;

    }


    public ContentContainerLayout getContentContainerLayout() {
        return contentContainerLayout;
    }

    public void setContentContainerLayout(ContentContainerLayout contentContainerLayout) {
        this.contentContainerLayout = contentContainerLayout;
    }


}
