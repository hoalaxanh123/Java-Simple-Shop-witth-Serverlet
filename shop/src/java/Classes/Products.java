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
public class Products {

    private int _ID;
    private String _Name;
    private String _ShortDes;
    private String _DES;
    private long _Price;
    private String _releasedate;
    private String _screenresolution;
    private String _cpu;
    private String _ram;
    private String _internalmemory;
    private String _GPU;
    private int _ID_CAT;
    private int _ID_BRAND;
    private boolean _InHome;

    public Products() {

    }

    public Products(int ID, String Name, String DES, long Price, String releasedate,
            String screenresolution, String cpu, String ram, String internalmemory, String GPU, int ID_CAT, int ID_BRAND, boolean InHome, String ShortDes) {
        this._ID = ID;
        this._Name = Name;
        this._ShortDes = ShortDes;
        this._DES = DES;
        this._Price = Price;
        this._releasedate = releasedate;
        this._screenresolution = screenresolution;
        this._cpu = cpu;
        this._ram = ram;
        this._internalmemory = internalmemory;
        this._GPU = GPU;
        this._ID_CAT = ID_CAT;
        this._ID_BRAND = ID_BRAND;
        this._InHome = InHome;
    }

    public void setShortDes(String _ShortDes) {
        this._ShortDes = _ShortDes;
    }

    public String getShortDes() {
        return _ShortDes;
    }

    public void setScreenresolution(String _screenresolution) {
        this._screenresolution = _screenresolution;
    }

    public void setReleasedate(String _releasedate) {
        this._releasedate = _releasedate;
    }

    public void setRam(String _ram) {
        this._ram = _ram;
    }

    public void setPrice(long _Price) {
        this._Price = _Price;
    }

    public void setName(String _Name) {
        this._Name = _Name;
    }

    public void setInternalmemory(String _internalmemory) {
        this._internalmemory = _internalmemory;
    }

    public void setInHome(boolean _InHome) {
        this._InHome = _InHome;
    }

    public void setID_CAT(int _ID_CAT) {
        this._ID_CAT = _ID_CAT;
    }

    public void setID_BRAND(int _ID_BRAND) {
        this._ID_BRAND = _ID_BRAND;
    }

    public void setID(int _ID) {
        this._ID = _ID;
    }

    public void setGPU(String _GPU) {
        this._GPU = _GPU;
    }

    public void setDES(String _DES) {
        this._DES = _DES;
    }
    
    public void setCpu(String _cpu) {
        this._cpu = _cpu;
    }

    public String getScreenresolution() {
        return _screenresolution;
    }

    public String getReleasedate() {
        return _releasedate;
    }

    public String getRam() {
        return _ram;
    }

    public long getPrice() {
        return _Price;
    }

    public String getName() {
        if (_Name.length() >= 15) {
            return _Name.substring(0, 15) + "....";
        }
        return _Name;
    }

    public String getFullName() {
        return _Name;
    }

    public String getInternalmemory() {
        return _internalmemory;
    }

    public int getID_CAT() {
        return _ID_CAT;
    }

    public int getID_BRAND() {
        return _ID_BRAND;
    }

    public int getID() {
        return _ID;
    }

    public String getGPU() {
        return _GPU;
    }

    public String getDES() {
        return _DES;
    }

    public String getCpu() {
        return _cpu;
    }

}
