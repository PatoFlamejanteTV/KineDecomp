package com.nexstreaming.app.general.iab;

/* compiled from: DeveloperPayLoad.kt */
/* loaded from: classes2.dex */
public final class DeveloperPayLoad {
    private String payload;
    private String preSku;
    private int remainingDays;

    public final int a() {
        return this.remainingDays;
    }

    public final void b(String str) {
        this.preSku = str;
    }

    public String toString() {
        return "DeveloperPayLoad{preSku='" + this.preSku + "', remainingDays=" + this.remainingDays + ", payload='" + this.payload + "'}";
    }

    public final void a(int i) {
        this.remainingDays = i;
    }

    public final void a(String str) {
        this.payload = str;
    }
}
