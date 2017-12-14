package com.slipquack.taxiuser.model;

import java.util.List;

/**
 * Created by Alex on 13.12.2017.
 */

public class Artist {
    private int id;
    private String name;
    private List<String> genres;
    //private int tracks;
    //private int albums;
    private String description;
    //private String link;
    private String phone;
    private String price;
    private cover cover;


    public Artist(int id, String price, String name, List<String> genres, String phone, String description, cover cover) {
        this.id = id;
        this.name = name;
        this.genres = genres;
        //this.tracks = tracks;
        //this.albums = albums;
        this.description = description;
        this.phone = phone;
        this.price = price;
        //this.link = link;
        this.cover = cover;

    }

    public Artist() {
    }

    public cover getCover() {
        return cover;
    }

    public void setCover(cover cover) {
        this.cover = cover;
    }

    public void cover(cover cover) {

    }

    public String getPrice() { return price; }

    public void  setPrice(String price) { this.price = price; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    /********
    public int getAlbums() {
        return albums;
    }

    public void setAlbums(int albums) {
        this.albums = albums;
    }

     public String getLink() {
     return link;
     }

     public void setLink(String link) {
     this.link = link;
     }

    public int getTracks() {
        return tracks;
    }

    public void setTracks(int tracks) {
        this.tracks = tracks;
    }

     *************/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String style() {
        String style = "";
        for (int i = 0; i < genres.size(); i++) {
            if (i == 0) {
                style += genres.get(i);
            } else {
                style += " " + genres.get(i);
            }
        }
        return style;
    }

    /********
    public String music(){
        String track;
        if ((tracks%100 >9 && tracks%100<21) || (tracks%10>4 && tracks%10<=9) || (tracks%10==0)){
            track=" песен";
        } else if (tracks%10>1 && tracks%10<5) track=" песни";
        else track=" песня";

        String album;
        if ((albums%100 >9 && albums%100<21) || (albums%10>4 && albums%10<=9) || (albums%10==0)){
            album=" альбомов, ";
        } else if (albums%10>1 && albums%10<5) album=" альбома, ";
        else album=" альбом, ";

        return albums + album + tracks + track;
    }
    *******/
}
