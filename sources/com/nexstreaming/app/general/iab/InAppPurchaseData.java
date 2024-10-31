package com.nexstreaming.app.general.iab;

/* loaded from: classes.dex */
public class InAppPurchaseData {
    private String developerPayload;
    private String orderId;
    private String packageName;
    private String productId;
    private String purchaseState;
    private String purchaseTime;
    private String purchaseToken;

    public String a() {
        return this.orderId;
    }

    public void a(String str) {
        this.orderId = str;
    }

    public String b() {
        return this.packageName;
    }

    public void b(String str) {
        this.packageName = str;
    }

    public String c() {
        return this.productId;
    }

    public void c(String str) {
        this.productId = str;
    }

    public String d() {
        return this.purchaseTime;
    }

    public void d(String str) {
        this.purchaseTime = str;
    }

    public String e() {
        return this.purchaseState;
    }

    public void e(String str) {
        this.purchaseState = str;
    }

    public String f() {
        return this.developerPayload;
    }

    public void f(String str) {
        this.developerPayload = str;
    }

    public String g() {
        return this.purchaseToken;
    }

    public String toString() {
        return "[IAPData productId=" + this.productId + " orderId=" + this.orderId + " packageName='" + this.packageName + "' purchaseTime='" + this.purchaseTime + "' purchaseState='" + this.purchaseState + "' purchaseToken='" + this.purchaseToken + "' developerPayload='" + this.developerPayload + "']";
    }
}
