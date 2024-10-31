package com.nexstreaming.app.general.iab;

/* loaded from: classes2.dex */
public class InAppPurchaseData {
    private String developerPayload;
    private String orderId;
    private String packageName;
    private String productId;
    private String purchaseEndTime;
    private String purchaseState;
    private String purchaseTime;
    private String purchaseToken;

    public String a() {
        return this.developerPayload;
    }

    public String b() {
        return this.orderId;
    }

    public void c(String str) {
        this.packageName = str;
    }

    public void d(String str) {
        this.productId = str;
    }

    public String e() {
        return this.purchaseTime;
    }

    public void f(String str) {
        this.purchaseTime = str;
    }

    public String toString() {
        return "[IAPData productId=" + this.productId + " orderId=" + this.orderId + " packageName='" + this.packageName + "' purchaseTime='" + this.purchaseTime + "' purchaseState='" + this.purchaseState + "' purchaseToken='" + this.purchaseToken + "' developerPayload='" + this.developerPayload + "']";
    }

    public void a(String str) {
        this.developerPayload = str;
    }

    public void b(String str) {
        this.orderId = str;
    }

    public String c() {
        return this.productId;
    }

    public String d() {
        return this.purchaseState;
    }

    public void e(String str) {
        this.purchaseState = str;
    }

    public String f() {
        return this.purchaseToken;
    }
}
