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
public class Users {

    private int _ID;
    private String _UserName;
    private String _PassWord;
    private String _Email;
    private int _Role;
    private String _RealName;
    private String _Address;

    public String getAddress() {
        return _Address;
    }

    public void setAddress(String _Address) {
        this._Address = _Address;
    }

    public String getRealName() {
        return _RealName;
    }

    public void setRealName(String _RealName) {
        this._RealName = _RealName;
    }

    public void setID(int _ID) {
        this._ID = _ID;
    }

    public void setUserName(String _UserName) {
        this._UserName = _UserName;
    }

    public void setPassWord(String _PassWord) {
        this._PassWord = _PassWord;
    }

    public void setEmail(String _Email) {
        this._Email = _Email;
    }

    public void setRole(int _Role) {
        this._Role = _Role;
    }

    public int getID() {
        return _ID;
    }

    public String getUserName() {
        return _UserName;
    }

    public String getPassWord() {
        return _PassWord;
    }

    public String getEmail() {
        return _Email;
    }

    public int getRole() {
        return _Role;
    }

    public Users() {
    }

    public Users(int _ID, String _UserName, String _PassWord, String _Email, int _Role, String _RealName, String _Address) {
        this._ID = _ID;
        this._UserName = _UserName;
        this._PassWord = _PassWord;
        this._Email = _Email;
        this._Role = _Role;
        this._RealName = _RealName;
        this._Address = _Address;
    }
}
