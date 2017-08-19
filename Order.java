package com.example.bifam.lusuku;


public class Order {
    int _id;
    String _phonenumber;
    String _producename;
    String _quntity;
    String _ndate;
    String _odate;
    String _unitprice;

    public Order(String _ndate, String _odate, String _phonenumber, String _producename, String _quntity, String _unitprice) {
        this._ndate = _ndate;
        this._odate = _odate;
        this._phonenumber = _phonenumber;
        this._producename = _producename;
        this._quntity = _quntity;
        this._unitprice = _unitprice;
    }

    public Order(int _id, String _ndate, String _odate, String _phonenumber, String _producename, String _quntity, String _unitprice) {
        this._id = _id;
        this._ndate = _ndate;
        this._odate = _odate;
        this._phonenumber = _phonenumber;
        this._producename = _producename;
        this._quntity = _quntity;
        this._unitprice = _unitprice;
    }

    public Order(){}

    public int get_id() {
        return _id;
    }

    public String get_ndate() {
        return _ndate;
    }

    public String get_odate() {
        return _odate;
    }

    public String get_phonenumber() {
        return _phonenumber;
    }

    public String get_producename() {
        return _producename;
    }

    public String get_quntity() {
        return _quntity;
    }

    public String get_unitprice() {
        return _unitprice;
    }


    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_ndate(String _ndate) {
        this._ndate = _ndate;
    }

    public void set_odate(String _odate) {
        this._odate = _odate;
    }

    public void set_producename(String _producename) {
        this._producename = _producename;
    }

    public void set_phonenumber(String _phonenumber) {
        this._phonenumber = _phonenumber;
    }

    public void set_quntity(String _quntity) {
        this._quntity = _quntity;
    }

    public void set_unitprice(String _unitprice) {
        this._unitprice = _unitprice;
    }
}
