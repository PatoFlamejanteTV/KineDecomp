package com.squareup.okhttp.a;

/* compiled from: NamedRunnable.java */
/* loaded from: classes3.dex */
public abstract class j implements Runnable {

    /* renamed from: a */
    protected final String f25193a;

    public j(String str, Object... objArr) {
        this.f25193a = String.format(str, objArr);
    }

    protected abstract void c();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f25193a);
        try {
            c();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
