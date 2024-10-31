package com.squareup.picasso;

import android.os.Message;
import com.squareup.picasso.q;

/* compiled from: Dispatcher.java */
/* loaded from: classes3.dex */
class p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Message f25653a;

    /* renamed from: b */
    final /* synthetic */ q.a f25654b;

    public p(q.a aVar, Message message) {
        this.f25654b = aVar;
        this.f25653a = message;
    }

    @Override // java.lang.Runnable
    public void run() {
        throw new AssertionError("Unknown handler message received: " + this.f25653a.what);
    }
}
