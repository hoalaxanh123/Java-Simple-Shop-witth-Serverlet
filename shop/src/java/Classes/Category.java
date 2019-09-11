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
public class Category {

    private int _ID;
    private String _Name;
    private String _Description;
    private String _Logo;
    private int _IDParent;

    public int getIDParent() {
        return _IDParent;
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

    public String getLogoHtml() {
        String Logo = this._Logo;
        Logo = Logo.replace("<", "&lt;");
        Logo = Logo.replace(">", "&gt;");
        return Logo;
    }
    public static void main(String[] args) {
        Category cat = new Category(0, "name", "des", "<i class=\"fas fa-tablet-alt\"></i>", 0);
        System.out.println(cat.getLogoHtml())   ;
    }
    public String getName() {
        return _Name;
    }

    public void setIDParent(int _IDParent) {
        this._IDParent = _IDParent;
    }

    public void setDescription(String Description) {
        this._Description = Description;
    }

    public void setID(int _ID) {
        this._ID = _ID;
    }

    public void setLogo(String Logo) {
        this._Logo = Logo;
    }

    public void setName(String _Name) {
        this._Name = _Name;
    }

    public Category() {
    }

    public Category(int ID, String Name, String Description, String Logo, int IDParent) {
        this._ID = ID;
        this._Name = Name;
        this._Description = Description;
        this._Logo = Logo;
        this._IDParent = IDParent;
    }

}
