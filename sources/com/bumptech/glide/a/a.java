package com.bumptech.glide.a;

import java.io.Writer;
import java.util.concurrent.Callable;

/* compiled from: DiskLruCache.java */
/* loaded from: classes.dex */
public class a implements Callable<Void> {

    /* renamed from: a */
    final /* synthetic */ b f8346a;

    public a(b bVar) {
        this.f8346a = bVar;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        Writer writer;
        boolean c2;
        synchronized (this.f8346a) {
            writer = this.f8346a.i;
            if (writer == null) {
                return null;
            }
            this.f8346a.v();
            c2 = this.f8346a.c();
            if (c2) {
                this.f8346a.u();
                this.f8346a.k = 0;
            }
            return null;
        }
    }
}
