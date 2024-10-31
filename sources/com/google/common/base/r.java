package com.google.common.base;

import java.util.Iterator;

/* compiled from: Splitter.java */
/* loaded from: classes2.dex */
public class r implements Iterable<String> {

    /* renamed from: a */
    final /* synthetic */ CharSequence f15147a;

    /* renamed from: b */
    final /* synthetic */ Splitter f15148b;

    public r(Splitter splitter, CharSequence charSequence) {
        this.f15148b = splitter;
        this.f15147a = charSequence;
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        Iterator<String> c2;
        c2 = this.f15148b.c(this.f15147a);
        return c2;
    }

    public String toString() {
        Joiner a2 = Joiner.a(", ");
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        StringBuilder a3 = a2.a(sb, this);
        a3.append(']');
        return a3.toString();
    }
}
