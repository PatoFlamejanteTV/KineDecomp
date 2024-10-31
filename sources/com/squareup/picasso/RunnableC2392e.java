package com.squareup.picasso;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BitmapHunter.java */
/* renamed from: com.squareup.picasso.e */
/* loaded from: classes3.dex */
public class RunnableC2392e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ J f25633a;

    /* renamed from: b */
    final /* synthetic */ RuntimeException f25634b;

    public RunnableC2392e(J j, RuntimeException runtimeException) {
        this.f25633a = j;
        this.f25634b = runtimeException;
    }

    @Override // java.lang.Runnable
    public void run() {
        throw new RuntimeException("Transformation " + this.f25633a.key() + " crashed with exception.", this.f25634b);
    }
}
