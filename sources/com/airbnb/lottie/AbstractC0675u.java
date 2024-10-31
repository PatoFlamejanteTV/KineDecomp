package com.airbnb.lottie;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: BaseAnimatableValue.java */
/* renamed from: com.airbnb.lottie.u */
/* loaded from: classes.dex */
public abstract class AbstractC0675u<V, O> implements InterfaceC0671s<O> {

    /* renamed from: a */
    final List<C0649ga<V>> f7828a;

    /* renamed from: b */
    final V f7829b;

    public AbstractC0675u(V v) {
        this(Collections.emptyList(), v);
    }

    /* JADX WARN: Multi-variable type inference failed */
    O a(V v) {
        return v;
    }

    public O b() {
        return a(this.f7829b);
    }

    public boolean c() {
        return !this.f7828a.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("parseInitialValue=");
        sb.append(this.f7829b);
        if (!this.f7828a.isEmpty()) {
            sb.append(", values=");
            sb.append(Arrays.toString(this.f7828a.toArray()));
        }
        return sb.toString();
    }

    public AbstractC0675u(List<C0649ga<V>> list, V v) {
        this.f7828a = list;
        this.f7829b = v;
    }
}
