package com.example.bifam.lusuku;


public class Comment {

    int _id;
    String _phonenumber;
    String _subject;
    String _comment;

    public Comment(int _id, String _phonenumber, String _subject,String _comment) {
        this._comment = _comment;
        this._id = _id;
        this._phonenumber = _phonenumber;
        this._subject = _subject;
    }

    public Comment(String _phonenumber, String _subject,String _comment) {
        this._comment = _comment;
        this._phonenumber = _phonenumber;
        this._subject = _subject;
    }

    public Comment(){}

    public String get_comment() {
        return _comment;
    }

    public int get_id() {
        return _id;
    }

    public String get_phonenumber() {
        return _phonenumber;
    }

    public String get_subject() {
        return _subject;
    }

    public void set_comment(String _comment) {
        this._comment = _comment;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_phonenumber(String _phonenumber) {
        this._phonenumber = _phonenumber;
    }

    public void set_subject(String _subject) {
        this._subject = _subject;
    }
}
