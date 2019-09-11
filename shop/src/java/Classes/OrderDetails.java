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
public class OrderDetails {

    private int _ID;
    private int _IDOrder;
    private String _ProductName;
    private int _Quantity;
    private float _Price;
    private float _Total;

    public OrderDetails(int _ID, int _IDOrder, String _ProductName, int _Quantity, float _Price, float _Total) {
        this._ID = _ID;
        this._IDOrder = _IDOrder;
        this._ProductName = _ProductName;
        this._Quantity = _Quantity;
        this._Price = _Price;
        this._Total = _Total;
    }

    public OrderDetails() {
    }

    public int getID() {
        return _ID;
    }

    public int getIDOrder() {
        return _IDOrder;
    }

    public String getProductName() {
        return _ProductName;
    }

    public int getQuantity() {
        return _Quantity;
    }

    public float getPrice() {
        return _Price;
    }

    public float getTotal() {
        return _Total;
    }

    public void setID(int _ID) {
        this._ID = _ID;
    }

    public void setIDOrder(int _IDOrder) {
        this._IDOrder = _IDOrder;
    }

    public void setProductName(String _ProductName) {
        this._ProductName = _ProductName;
    }

    public void setQuantity(int _Quantity) {
        this._Quantity = _Quantity;
    }

    public void setPrice(float _Price) {
        this._Price = _Price;
    }

    public void setTotal(float _Total) {
        this._Total = _Total;
    }

}
