package com.bumptech.glide.e;

import com.bumptech.glide.load.i;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ResourceEncoderRegistry.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a */
    private final List<a<?>> f8482a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ResourceEncoderRegistry.java */
    /* loaded from: classes.dex */
    public static final class a<T> {

        /* renamed from: a */
        private final Class<T> f8483a;

        /* renamed from: b */
        final i<T> f8484b;

        a(Class<T> cls, i<T> iVar) {
            this.f8483a = cls;
            this.f8484b = iVar;
        }

        boolean a(Class<?> cls) {
            return this.f8483a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(Class<Z> cls, i<Z> iVar) {
        this.f8482a.add(new a<>(cls, iVar));
    }

    public synchronized <Z> i<Z> a(Class<Z> cls) {
        int size = this.f8482a.size();
        for (int i = 0; i < size; i++) {
            a<?> aVar = this.f8482a.get(i);
            if (aVar.a(cls)) {
                return (i<Z>) aVar.f8484b;
            }
        }
        return null;
    }
}
