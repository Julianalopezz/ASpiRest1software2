package com.software2ex.apiRest.MODEL;

public class user {
    private long id;
    private String producto;
    private String codigoproducto;
    public user() {
    }
    public user(long id, String producto, String codigoproducto) {
        this.id = id;
        this.producto = producto;
        this.codigoproducto = codigoproducto;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getproducto() {
        return producto;
    }
    public void setproducto(String producto) {
        this.producto = producto;
    }
    public String getcodigoproducto() {
        return codigoproducto;
    }
    public void setcodigoproducto(String codigoproducto) {
        this.codigoproducto = codigoproducto;


    

    

}

    
}
