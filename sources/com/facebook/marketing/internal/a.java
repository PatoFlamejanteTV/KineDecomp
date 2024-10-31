package com.facebook.marketing.internal;

/* compiled from: ButtonIndexer.java */
/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ButtonIndexer f9442a;

    public a(ButtonIndexer buttonIndexer) {
        this.f9442a = buttonIndexer;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9442a.processViews();
    }
}
