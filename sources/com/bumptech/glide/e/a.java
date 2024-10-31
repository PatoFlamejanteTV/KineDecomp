package com.bumptech.glide.e;

import java.util.ArrayList;
import java.util.List;

/* compiled from: EncoderRegistry.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private final List<C0046a<?>> f8468a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EncoderRegistry.java */
    /* renamed from: com.bumptech.glide.e.a$a */
    /* loaded from: classes.dex */
    public static final class C0046a<T> {

        /* renamed from: a */
        private final Class<T> f8469a;

        /* renamed from: b */
        final com.bumptech.glide.load.a<T> f8470b;

        C0046a(Class<T> cls, com.bumptech.glide.load.a<T> aVar) {
            this.f8469a = cls;
            this.f8470b = aVar;
        }

        boolean a(Class<?> cls) {
            return this.f8469a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> com.bumptech.glide.load.a<T> a(Class<T> cls) {
        for (C0046a<?> c0046a : this.f8468a) {
            if (c0046a.a(cls)) {
                return (com.bumptech.glide.load.a<T>) c0046a.f8470b;
            }
        }
        return null;
    }

    public synchronized <T> void a(Class<T> cls, com.bumptech.glide.load.a<T> aVar) {
        this.f8468a.add(new C0046a<>(cls, aVar));
    }
}
