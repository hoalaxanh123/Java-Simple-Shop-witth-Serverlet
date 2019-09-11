/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Carts {

    private List<Item> cartItems;

    public Carts() {
        cartItems = new ArrayList<>();
    }

    public List<Item> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<Item> cartItems) {
        this.cartItems = cartItems;
    }

    Item KiemTraDaCo(Item itemIn) {
        for (Item item : cartItems) {
            if (item.getProduct().getID() == itemIn.getProduct().getID()) {
                return item;
            }
        }
        return null;
    }

    public List<Item> insertToCart(Item item, int Quantity, List<Item> cartItems) {

        List<Item> lstGioHang = cartItems;
        //Kiểm tra xem sản phẩm đã có trong session giỏ hàng hay chưa
        Item gioHang = KiemTraDaCo(item);
        //Nếu chưa -->tạo
        if (gioHang == null) {
            gioHang = new Item(item.getProduct(), 1);
            lstGioHang.add(gioHang);
        } else {
            int SL = gioHang.getQuantity() + Quantity;
            if (SL < 0) {
                SL = 1;
            }
            if (SL > 5) {
                SL = 5;
            }
            gioHang.setQuantity(SL);
            int i = 0;
            for (Item temp : cartItems) {
                if (temp.getProduct().getID() == item.getProduct().getID()) {
                    lstGioHang.remove(i);
                    lstGioHang.add(gioHang);
                    return lstGioHang;
                }
                i++;
            }

        }
        return lstGioHang;
    }

    public List<Item> Remove(Item item, int Quantity, List<Item> cartItems) {

        List<Item> lstGioHang = cartItems;
        //Kiểm tra xem sản phẩm đã có trong session giỏ hàng hay chưa
        Item gioHang = KiemTraDaCo(item);
        //Nếu chưa -->tạo
        if (gioHang != null) {
            int i = 0;
            for (Item temp : cartItems) {
                if (temp.getProduct().getID() == item.getProduct().getID()) {
                    lstGioHang.remove(i);
                    return lstGioHang;
                }
                i++;
            }
        }
        return lstGioHang;
    }

    public int countItem() {
        int count = 0;
        for (Item temp : cartItems) {
            count += temp.getQuantity();
        }
        return count;
    }

    public double total() {
        int sum = 0;
        for (Item temp : cartItems) {
            sum += temp.getProduct().getPrice() * temp.getQuantity();
        }
        return sum;
    }

    public static void main(String[] args) {
        Carts c = new Carts();
        System.out.println(c.getCartItems());
    }

}
