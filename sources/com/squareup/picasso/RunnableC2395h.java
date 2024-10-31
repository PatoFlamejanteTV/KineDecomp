package com.squareup.picasso;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BitmapHunter.java */
/* renamed from: com.squareup.picasso.h */
/* loaded from: classes3.dex */
public class RunnableC2395h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ J f25637a;

    public RunnableC2395h(J j) {
        this.f25637a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        throw new IllegalStateException("Transformation " + this.f25637a.key() + " mutated input Bitmap but failed to recycle the original.");
    }
}
