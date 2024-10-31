package io.fabric.sdk.android.a.a;

import android.content.Context;

/* compiled from: MemoryValueCache.java */
/* loaded from: classes3.dex */
public class b<T> extends a<T> {

    /* renamed from: b */
    private T f26815b;

    public b() {
        this(null);
    }

    @Override // io.fabric.sdk.android.a.a.a
    protected T a(Context context) {
        return this.f26815b;
    }

    public b(c<T> cVar) {
        super(cVar);
    }

    @Override // io.fabric.sdk.android.a.a.a
    protected void a(Context context, T t) {
        this.f26815b = t;
    }
}
