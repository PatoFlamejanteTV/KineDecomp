package com.nexstreaming.app.general.iab;

import com.nexstreaming.app.general.iab.Utils.IABConstant;
import java.util.Date;

/* loaded from: classes2.dex */
public class Purchase {
    private InAppPurchaseData purchaseData;
    private Date purchaseTime;
    private long serverTime = 0;
    private String signature;
    private String sku;
    private int v;

    /* loaded from: classes2.dex */
    public enum PurchaseState {
        Purchased,
        Canceled,
        Refunded,
        Unknown
    }

    public String a() {
        return this.purchaseData.a();
    }

    public void b(String str) {
        this.sku = str;
    }

    public String c() {
        return this.purchaseData.b();
    }

    public String d() {
        return this.purchaseData.c();
    }

    public InAppPurchaseData e() {
        return this.purchaseData;
    }

    public PurchaseState f() {
        if (this.purchaseData.d() == null) {
            return PurchaseState.Unknown;
        }
        try {
            int parseInt = Integer.parseInt(this.purchaseData.d());
            if (parseInt == 0) {
                return PurchaseState.Purchased;
            }
            if (parseInt == 1) {
                return PurchaseState.Canceled;
            }
            if (parseInt != 2) {
                return PurchaseState.Unknown;
            }
            return PurchaseState.Refunded;
        } catch (NumberFormatException unused) {
            return PurchaseState.Unknown;
        }
    }

    public Date g() {
        return new Date(Long.parseLong(this.purchaseData.e()));
    }

    public String h() {
        return this.purchaseData.f();
    }

    public long i() {
        return this.serverTime;
    }

    public String j() {
        return this.sku;
    }

    public String toString() {
        return "[P" + Integer.toHexString(this.v) + " " + Integer.toHexString(this.v ^ IABConstant.o()) + " sku=" + this.sku + " pucrhaseData=" + this.purchaseData + " signature='" + this.signature + "']";
    }

    public void a(InAppPurchaseData inAppPurchaseData) {
        this.purchaseData = inAppPurchaseData;
    }

    public int b() {
        return this.v ^ 79225;
    }

    public void a(String str) {
        this.signature = str;
    }

    public void a(int i) {
        this.v = i;
    }

    public void a(Date date) {
        this.purchaseTime = date;
    }

    public void a(long j) {
        this.serverTime = j;
    }
}
