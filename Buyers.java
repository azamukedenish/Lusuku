package com.example.bifam.lusuku;


public class Buyers {

    int _id;
    String _name;
    String _email;
    String _gender;
    String _phoneNumber;
    String _district;

    public Buyers(){

    }

    public Buyers(String _name, String _email, String _gender, String _phoneNumber, String _district) {
        this._district = _district;
        this._email = _email;
        this._gender = _gender;
        this._name = _name;
        this._phoneNumber = _phoneNumber;
    }

    public Buyers(int _id, String _name, String _email, String _gender, String _phoneNumber, String _district) {
        this._id = _id;
        this._district = _district;
        this._email = _email;
        this._gender = _gender;
        this._name = _name;
        this._phoneNumber = _phoneNumber;
    }

    public String get_district() {
        return _district;
    }

    public String get_email() {
        return _email;
    }

    public String get_gender() {
        return _gender;
    }

    public int get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }

    public String get_phoneNumber() {
        return _phoneNumber;
    }


    public void set_district(String _district) {
        this._district = _district;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public void set_gender(String _gender) {
        this._gender = _gender;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_phoneNumber(String _phoneNumber) {
        this._phoneNumber = _phoneNumber;
    }
}
