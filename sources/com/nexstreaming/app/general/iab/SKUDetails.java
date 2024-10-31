package com.nexstreaming.app.general.iab;

import com.nexstreaming.app.kinemasterfree.R;

/* loaded from: classes2.dex */
public class SKUDetails {
    private String description;
    private String freeTrialPeriod;
    private String introductoryPrice;
    private String introductoryPriceAmountMicros;
    private String introductoryPriceCycles;
    private String introductoryPricePeriod;
    private String originalJson;
    private String price;
    private long price_amount_micros;
    private String price_currency_code;
    private String[] productBenefits;
    private String productId;
    private boolean rewarded;
    private String subscriptionPeriod;
    private String title;
    private String type;
    private int productIndex = -1;
    private int productTitleResource = -1;
    private int productBuyTextResource = -1;
    private int display = -1;

    public void a(String str) {
        this.description = str;
    }

    public void b(int i) {
        this.productBuyTextResource = i;
    }

    public String c() {
        return this.price;
    }

    public long d() {
        return this.price_amount_micros;
    }

    public String[] e() {
        return this.productBenefits;
    }

    public int f() {
        int i = this.productBuyTextResource;
        return i == -1 ? R.string.buy_now : i;
    }

    public String g() {
        return this.productId;
    }

    public void h(String str) {
        this.price = str;
    }

    public void i(String str) {
        this.price_currency_code = str;
    }

    public void j(String str) {
        this.productId = str;
    }

    public String k() {
        return this.type;
    }

    public void l(String str) {
        this.title = str;
    }

    public void m(String str) {
        this.type = str;
    }

    public String toString() {
        return "SKUDetails{productId='" + this.productId + "', type='" + this.type + "', price='" + this.price + "', title='" + this.title + "', description='" + this.description + "', price_amount_micros=" + this.price_amount_micros + ", price_currency_code='" + this.price_currency_code + "', productIndex=" + this.productIndex + ", productTitleResource=" + this.productTitleResource + ", productBuyTextResource=" + this.productBuyTextResource + ", display=" + this.display + '}';
    }

    public void a(long j) {
        this.price_amount_micros = j;
    }

    public String b() {
        return this.originalJson;
    }

    public void c(int i) {
        this.productIndex = i;
    }

    public void d(int i) {
        this.productTitleResource = i;
    }

    public void e(String str) {
        this.introductoryPriceCycles = str;
    }

    public void f(String str) {
        this.introductoryPricePeriod = str;
    }

    public void g(String str) {
        this.originalJson = str;
    }

    public int h() {
        return this.productIndex;
    }

    public int i() {
        return this.productTitleResource;
    }

    public String j() {
        return this.title;
    }

    public void k(String str) {
        this.subscriptionPeriod = str;
    }

    public void a(String[] strArr) {
        this.productBenefits = strArr;
    }

    public void b(String str) {
        this.freeTrialPeriod = str;
    }

    public void c(String str) {
        this.introductoryPrice = str;
    }

    public void d(String str) {
        this.introductoryPriceAmountMicros = str;
    }

    public int a() {
        return this.display;
    }

    public void a(int i) {
        this.display = i;
    }

    public void a(boolean z) {
        this.rewarded = z;
    }
}
