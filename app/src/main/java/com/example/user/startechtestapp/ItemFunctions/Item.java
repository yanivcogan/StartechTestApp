package com.example.user.startechtestapp.ItemFunctions;

import android.content.Context;
import android.widget.ImageView;

import com.example.user.startechtestapp.Graphics.ImageViewDrawer;
import com.example.user.startechtestapp.Parallax.ParallaxView;
import com.example.user.startechtestapp.Parallax.ParallaxViewDrawer;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Item {
    @Expose @SerializedName("title") private String title;
    @Expose @SerializedName("author_id") private int authorId;
    @Expose @SerializedName("author_name") private String authorName;
    @Expose @SerializedName("series_id") private Integer seriesId;
    @Expose @SerializedName("series_name") private String seriesName;
    @Expose @SerializedName("publication_year") private int publicationYear;
    @Expose @SerializedName("ISBN") private String isbn;
    @Expose @SerializedName("language") private String language;
    @Expose @SerializedName("thumbnail_path") private String thumbnailPath;
    @Expose @SerializedName("cover_image_path") private String coverImgPath;
    @Expose @SerializedName("parallax_thumbnail") private ParallaxView parallaxThumbnail;
    private ImageViewDrawer canvasDisplay = null;

    public Item(String title, int authorId, String authorName, Integer seriesId, String seriesName, int publicationYear, String isbn, String language, String thumbnailPath, String coverImgPath) {
        this.title = title;
        this.authorId = authorId;
        this.authorName = authorName;
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.language = language;
        this.thumbnailPath = thumbnailPath;
        this.coverImgPath = coverImgPath;
    }

    public String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }
    public String getAuthorName() {
        return authorName;
    }

    void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    Integer getSeriesId() {
        return seriesId;
    }

    void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    String getSeriesName() {
        return seriesName;
    }

    void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    int getPublicationYear() {
        return publicationYear;
    }

    void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    String getIsbn() {
        return isbn;
    }

    void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    String getLanguage() {
        return language;
    }

    void setLanguage(String language) {
        this.language = language;
    }

    String getThumbnailPath() {
        return thumbnailPath;
    }

    void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    String getCoverImgPath() {
        return coverImgPath;
    }

    void setCoverImgPath(String coverImgPath) {
        this.coverImgPath = coverImgPath;
    }

    ImageViewDrawer getCanvasDisplay() {
        return canvasDisplay;
    }

    void setCanvasDisplay(ImageViewDrawer canvasDisplay) {
        this.canvasDisplay = canvasDisplay;
    }

    int getAuthorId() {
        return authorId;
    }

    void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setImageView (ImageView iv)
    {
        if(canvasDisplay==null)
        {
            canvasDisplay=new ImageViewDrawer(iv, 1000, 1000);
        }
    }

    public ImageViewDrawer getImageView ()
    {
        return canvasDisplay;
    }
    public void loadParallaxLayersImages(Context context)
    {
        parallaxThumbnail.loadLayerImages(context);
    }
    public void draw(double[] tilt)
    {
        if(canvasDisplay!=null)
        {
            ParallaxViewDrawer.draw(canvasDisplay.getCanvas(),parallaxThumbnail,tilt);
            canvasDisplay.updateViews();
        }
    }

    public void goToPage (Context origin)
    {
        ItemPageDirector.goToItemPage(this, origin);
    }

    public String toString ()
    {
        return "{"+this.title+"/"+this.authorName+"}";
    }
}
