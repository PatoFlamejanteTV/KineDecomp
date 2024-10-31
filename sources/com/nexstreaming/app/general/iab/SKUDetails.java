package com.nexstreaming.app.general.iab;

/* loaded from: classes.dex */
public class SKUDetails {
    private String description;
    private String price;
    private long price_amount_micros;
    private String price_currency_code;
    private String productId;
    private String title;
    private String type;
    private int productIndex = -1;
    private int productTitleResource = -1;
    private int productBuyTextResource = -1;
    private int display = -1;

    public String a() {
        return this.productId;
    }

    public void a(String str) {
        this.productId = str;
    }

    public String b() {
        return this.type;
    }

    public void b(String str) {
        this.type = str;
    }

    public String c() {
        return this.price;
    }

    public void c(String str) {
        this.price = str;
    }

    public String d() {
        return this.title;
    }

    public void d(String str) {
        this.title = str;
    }

    public long e() {
        return this.price_amount_micros;
    }

    public String f() {
        return this.price_currency_code;
    }

    public int g() {
        return this.productIndex;
    }

    public void a(int i) {
        this.productIndex = i;
    }

    public int h() {
        return this.productTitleResource;
    }

    public void b(int i) {
        this.productTitleResource = i;
    }

    public int i() {
        return this.productBuyTextResource;
    }

    public void c(int i) {
        this.productBuyTextResource = i;
    }

    public int j() {
        return this.display;
    }

    public void d(int i) {
        this.display = i;
    }

    public String toString() {
        return "SKUDetails{productId='" + this.productId + "', type='" + this.type + "', price='" + this.price + "', title='" + this.title + "', description='" + this.description + "', price_amount_micros=" + this.price_amount_micros + ", price_currency_code='" + this.price_currency_code + "', productIndex=" + this.productIndex + ", productTitleResource=" + this.productTitleResource + ", productBuyTextResource=" + this.productBuyTextResource + ", display=" + this.display + '}';
    }
}
