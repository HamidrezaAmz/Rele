package com.vasl.recyclerlibrary.globalObjects;

public class RowModel  {

    String ImageUrl ;
    String Title ;

    public RowModel(String image, String title) {
        ImageUrl = image;
        Title = title;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }


}
