package com.example.bifam.lusuku;


public class Farmer {
    int _id;
    String _name;
    String _gender;
    String _phonenumber;
    String _district;
    String _subcounty;
    String _parish;

    public Farmer(int _id,String _name,String _gender,String _phonenumber,String _district,String _subcounty,String _parish) {
        this._district = _district;
        this._gender = _gender;
        this._id = _id;
        this._name = _name;
        this._parish = _parish;
        this._phonenumber = _phonenumber;
        this._subcounty = _subcounty;
    }

    public Farmer(String _name,String _gender,String _phonenumber,String _district,String _subcounty,String _parish) {
        this._district = _district;
        this._gender = _gender;
        this._name = _name;
        this._parish = _parish;
        this._phonenumber = _phonenumber;
        this._subcounty = _subcounty;
    }

    public Farmer(){}

    public String get_district() {
        return _district;
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

    public String get_parish() {
        return _parish;
    }

    public String get_phonenumber() {
        return _phonenumber;
    }

    public String get_subcounty() {
        return _subcounty;
    }

    public void set_district(String _district) {
        this._district = _district;
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

    public void set_phonenumber(String _phonenumber) {
        this._phonenumber = _phonenumber;
    }

    public void set_parish(String _parish) {
        this._parish = _parish;
    }

    public void set_subcounty(String _subcounty) {
        this._subcounty = _subcounty;
    }
}
