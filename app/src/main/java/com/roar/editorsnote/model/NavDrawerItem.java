package com.roar.editorsnote.model;

public class NavDrawerItem {

    private String title;
    private int startIcon;
    private int endIcon;
    // boolean to set visiblity of the icon
    private boolean isStartIconVisible = false;
    private boolean isEndIconVisible = false;



    public NavDrawerItem(String title, int startIcon, int endIcon, boolean startIconVisiblity, boolean endIconVisiblity){
        this.title = title;
        this.startIcon = startIcon;
        this.endIcon = endIcon;
        isStartIconVisible = startIconVisiblity;
        isEndIconVisible = endIconVisiblity;
    }


    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public int getStartIcon(){
        return this.startIcon;
    }

    public void setStartIcon(int startIcon){
        this.startIcon = startIcon;
    }

    public int getEndIcon(){
        return this.endIcon;
    }

    public void setEndIcon(int endIcon){
        this.endIcon = endIcon;
    }

    public boolean getStartIconVisibility(){
        return this.isStartIconVisible;
    }

    public boolean getEndIconVisibility(){
        return this.isEndIconVisible;
    }

    public void setStartIconVisibility(boolean isStartIconVisible){
        this.isStartIconVisible = isStartIconVisible;
    }

    public void setEndIconVisibility(boolean isEndIconVisible){
        this.isEndIconVisible = isEndIconVisible;
    }
}