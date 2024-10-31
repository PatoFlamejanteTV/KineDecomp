package com.bumptech.glide.request.b;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.b.f;

/* compiled from: NoTransition.java */
/* loaded from: classes.dex */
public class e<R> implements f<R> {

    /* renamed from: a */
    static final e<?> f9108a = new e<>();

    /* renamed from: b */
    private static final g<?> f9109b = new a();

    /* compiled from: NoTransition.java */
    /* loaded from: classes.dex */
    public static class a<R> implements g<R> {
        @Override // com.bumptech.glide.request.b.g
        public f<R> a(DataSource dataSource, boolean z) {
            return e.f9108a;
        }
    }

    public static <R> f<R> a() {
        return f9108a;
    }

    public static <R> g<R> b() {
        return (g<R>) f9109b;
    }

    @Override // com.bumptech.glide.request.b.f
    public boolean a(Object obj, f.a aVar) {
        return false;
    }
}
