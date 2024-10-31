package com.facebook.places.internal;

/* compiled from: BleScannerImpl.java */
/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Object f9458a;

    /* renamed from: b */
    final /* synthetic */ BleScannerImpl f9459b;

    public a(BleScannerImpl bleScannerImpl, Object obj) {
        this.f9459b = bleScannerImpl;
        this.f9458a = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            synchronized (this.f9458a) {
                this.f9458a.notify();
            }
        } catch (Exception e2) {
            BleScannerImpl.logException("Exception waiting for main looper", e2);
        }
    }
}
