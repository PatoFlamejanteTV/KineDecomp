package com.adobe.creativesdk.foundation.internal.storage.controllers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetViewFragment.java */
/* loaded from: classes.dex */
public class Wa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f5880a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AbstractC0414hb f5881b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Wa(AbstractC0414hb abstractC0414hb, int i) {
        this.f5881b = abstractC0414hb;
        this.f5880a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5880a == 0) {
            this.f5881b.J.setVisibility(4);
            return;
        }
        this.f5881b.J.setVisibility(0);
        this.f5881b.J.setText("" + this.f5880a);
    }
}
