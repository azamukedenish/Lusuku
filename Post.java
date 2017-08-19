package com.example.bifam.lusuku;


public class Post {

    int _id;
    String _phonenumber;
    String _postname;
    String _featureone;
    String _featuretwo;
    String _featurethree;
    String _description;

    // Empty constructor
    public Post(){

    }
    // constructor
    public Post(int id, String phonenumber, String postname,String featureone,String featuretwo, String featurethree,String description){
        this._id = id;
        this._phonenumber = phonenumber;
        this._postname = postname;
        this._featureone = featureone;
        this._featuretwo = featuretwo;
        this._featurethree = featurethree;
        this._description = description;
    }

    // constructor
    public Post(String phonenumber, String postname, String featureone,String featuretwo, String featurethree,String description){

        this._phonenumber = phonenumber;
        this._postname = postname;
        this._featureone = featureone;
        this._featuretwo = featuretwo;
        this._featurethree = featurethree;
        this._description = description;
    }

    public String get_postname() {
        return _postname;
    }

    public String get_phonenumber() {
        return _phonenumber;
    }

    public int get_id() {
        return _id;
    }

    public String get_featuretwo() {
        return _featuretwo;
    }

    public String get_featurethree() {
        return _featurethree;
    }

    public String get_featureone() {
        return _featureone;
    }

    public String get_description() {
        return _description;
    }


    public void set_postname(String _postname) {
        this._postname = _postname;
    }

    public void set_phonenumber(String _phonenumber) {
        this._phonenumber = _phonenumber;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_featuretwo(String _featuretwo) {
        this._featuretwo = _featuretwo;
    }

    public void set_featurethree(String _featurethree) {
        this._featurethree = _featurethree;
    }

    public void set_featureone(String _featureone) {
        this._featureone = _featureone;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

}
