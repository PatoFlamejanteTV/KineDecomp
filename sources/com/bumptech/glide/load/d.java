package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.E;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: MultiTransformation.java */
/* loaded from: classes.dex */
public class d<T> implements j<T> {

    /* renamed from: a */
    private final Collection<? extends j<T>> f8735a;

    @SafeVarargs
    public d(j<T>... jVarArr) {
        if (jVarArr.length != 0) {
            this.f8735a = Arrays.asList(jVarArr);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    @Override // com.bumptech.glide.load.j
    public E<T> a(Context context, E<T> e2, int i, int i2) {
        Iterator<? extends j<T>> it = this.f8735a.iterator();
        E<T> e3 = e2;
        while (it.hasNext()) {
            E<T> a2 = it.next().a(context, e3, i, i2);
            if (e3 != null && !e3.equals(e2) && !e3.equals(a2)) {
                e3.b();
            }
            e3 = a2;
        }
        return e3;
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f8735a.equals(((d) obj).f8735a);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f8735a.hashCode();
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest messageDigest) {
        Iterator<? extends j<T>> it = this.f8735a.iterator();
        while (it.hasNext()) {
            it.next().a(messageDigest);
        }
    }
}
