/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Admin
 */
public class Brands {

    private int _ID;
    private String _Name;
    private String _Description;
    private String _Logo;

    public Brands() {

    }

    public Brands(int ID, String Name, String Des, String Logo) {
        this._ID = ID;
        this._Name = Name;
        this._Description = Des;
        this._Logo = Logo;
    }

    public String getDescription() {
        return _Description;
    }

    public int getID() {
        return _ID;
    }

    public String getLogo() {
        return _Logo;
    }

    public String getName() {
        return _Name;
    }

    public void setDescription(String _Description) {
        this._Description = _Description;
    }

    public void setID(int _ID) {
        this._ID = _ID;
    }

    public void setLogo(String _Logo) {
        this._Logo = _Logo;
    }

    public void setName(String _Name) {
        this._Name = _Name;
    }

}
