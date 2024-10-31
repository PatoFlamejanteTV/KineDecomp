package com.nextreaming.a.a;

import java.io.Writer;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiskLruCache.java */
/* loaded from: classes.dex */
public class b implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f4451a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f4451a = aVar;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws Exception {
        Writer writer;
        boolean g;
        synchronized (this.f4451a) {
            writer = this.f4451a.i;
            if (writer != null) {
                this.f4451a.i();
                g = this.f4451a.g();
                if (g) {
                    this.f4451a.f();
                    this.f4451a.k = 0;
                }
            }
        }
        return null;
    }
}
