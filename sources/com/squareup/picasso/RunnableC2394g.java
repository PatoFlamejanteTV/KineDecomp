package com.squareup.picasso;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BitmapHunter.java */
/* renamed from: com.squareup.picasso.g */
/* loaded from: classes3.dex */
public class RunnableC2394g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ J f25636a;

    public RunnableC2394g(J j) {
        this.f25636a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        throw new IllegalStateException("Transformation " + this.f25636a.key() + " returned input Bitmap but recycled it.");
    }
}
