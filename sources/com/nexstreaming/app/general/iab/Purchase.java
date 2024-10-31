package com.nexstreaming.app.general.iab;

import java.util.Date;

/* loaded from: classes.dex */
public class Purchase {
    private InAppPurchaseData purchaseData;
    private Date purchaseTime;
    private long serverTime = 0;
    private String signature;
    private String sku;
    private int v;

    /* loaded from: classes.dex */
    public enum PurchaseState {
        Purchased,
        Canceled,
        Refunded,
        Unknown
    }

    public String a() {
        return this.purchaseData.c();
    }

    public String b() {
        return this.purchaseData.b();
    }

    public Date c() {
        return new Date(Long.parseLong(this.purchaseData.d()));
    }

    public String d() {
        return this.purchaseData.g();
    }

    public String e() {
        return this.purchaseData.f();
    }

    public String f() {
        return this.purchaseData.a();
    }

    public String g() {
        return this.sku;
    }

    public void a(String str) {
        this.sku = str;
    }

    public InAppPurchaseData h() {
        return this.purchaseData;
    }

    public void a(InAppPurchaseData inAppPurchaseData) {
        this.purchaseData = inAppPurchaseData;
    }

    public void b(String str) {
        this.signature = str;
    }

    public void a(int i) {
        this.v = i;
    }

    public void a(Date date) {
        this.purchaseTime = date;
    }

    public long i() {
        return this.serverTime;
    }

    public void a(long j) {
        this.serverTime = j;
    }

    public int j() {
        return this.v ^ 79225;
    }

    public PurchaseState k() {
        PurchaseState purchaseState;
        if (this.purchaseData.e() == null) {
            return PurchaseState.Unknown;
        }
        try {
            switch (Integer.parseInt(this.purchaseData.e())) {
                case 0:
                    purchaseState = PurchaseState.Purchased;
                    break;
                case 1:
                    purchaseState = PurchaseState.Canceled;
                    break;
                case 2:
                    purchaseState = PurchaseState.Refunded;
                    break;
                default:
                    purchaseState = PurchaseState.Unknown;
                    break;
            }
            return purchaseState;
        } catch (NumberFormatException e) {
            return PurchaseState.Unknown;
        }
    }

    public String toString() {
        return "[P" + Integer.toHexString(this.v) + " " + Integer.toHexString(this.v ^ IABHelper.f3141a) + " sku=" + this.sku + " pucrhaseData=" + this.purchaseData + " signature='" + this.signature + "']";
    }
}
