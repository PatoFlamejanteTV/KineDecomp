package com.squareup.picasso;

import android.os.Message;
import com.squareup.picasso.H;

/* compiled from: Stats.java */
/* loaded from: classes3.dex */
class G implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Message f25576a;

    /* renamed from: b */
    final /* synthetic */ H.a f25577b;

    public G(H.a aVar, Message message) {
        this.f25577b = aVar;
        this.f25576a = message;
    }

    @Override // java.lang.Runnable
    public void run() {
        throw new AssertionError("Unhandled stats message." + this.f25576a.what);
    }
}
