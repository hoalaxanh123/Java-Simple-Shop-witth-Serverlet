/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Orders {

    private int _ID;
    private String _Creator;
    private Date _DateCreate;
    private String _Address;
    private String _Email;
    private String _Note;
    private String _UserName;
    private String _PayMethod;
    private float _Total;

    public Orders(int _ID, String _Creator, Date _DateCreate, String _Address, String _Email, String _Note, String _UserName, String _PayMethod, float _Total) {
        this._ID = _ID;
        this._Creator = _Creator;
        this._DateCreate = _DateCreate;
        this._Address = _Address;
        this._Email = _Email;
        this._Note = _Note;
        this._UserName = _UserName;
        this._PayMethod = _PayMethod;
        this._Total = _Total;
    }

    public Orders() {
    }

    public int getID() {
        return _ID;
    }

    public String getCreator() {
        return _Creator;
    }

    public Date getDateCreate() {
        return _DateCreate;
    }

    public String getAddress() {
        return _Address;
    }

    public String getEmail() {
        return _Email;
    }

    public String getNote() {
        return _Note;
    }

    public String getUserName() {
        return _UserName;
    }

    public String getPayMethod() {
        return _PayMethod;
    }

    public float getTotal() {
        return _Total;
    }

    public void setID(int _ID) {
        this._ID = _ID;
    }

    public void setCreator(String _Creator) {
        this._Creator = _Creator;
    }

    public void setDateCreate(Date _DateCreate) {
        this._DateCreate = _DateCreate;
    }

    public void setAddress(String _Address) {
        this._Address = _Address;
    }

    public void setEmail(String _Email) {
        this._Email = _Email;
    }

    public void setNote(String _Note) {
        this._Note = _Note;
    }

    public void setUserName(String _UserName) {
        this._UserName = _UserName;
    }

    public void setPayMethod(String _PayMethod) {
        this._PayMethod = _PayMethod;
    }

    public void setTotal(float _Total) {
        this._Total = _Total;
    }
    
    
}
