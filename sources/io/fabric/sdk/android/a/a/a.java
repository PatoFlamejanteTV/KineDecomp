package io.fabric.sdk.android.a.a;

import android.content.Context;

/* compiled from: AbstractValueCache.java */
/* loaded from: classes3.dex */
public abstract class a<T> implements c<T> {

    /* renamed from: a */
    private final c<T> f26814a;

    public a(c<T> cVar) {
        this.f26814a = cVar;
    }

    private void b(Context context, T t) {
        if (t != null) {
            a(context, (Context) t);
            return;
        }
        throw new NullPointerException();
    }

    protected abstract T a(Context context);

    @Override // io.fabric.sdk.android.a.a.c
    public final synchronized T a(Context context, d<T> dVar) throws Exception {
        T a2;
        a2 = a(context);
        if (a2 == null) {
            a2 = this.f26814a != null ? this.f26814a.a(context, dVar) : dVar.load(context);
            b(context, a2);
        }
        return a2;
    }

    protected abstract void a(Context context, T t);
}
