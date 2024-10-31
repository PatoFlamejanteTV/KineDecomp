package com.google.common.base;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Splitter.java */
/* loaded from: classes2.dex */
public class y implements Iterable<String> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CharSequence f2596a;
    final /* synthetic */ Splitter b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Splitter splitter, CharSequence charSequence) {
        this.b = splitter;
        this.f2596a = charSequence;
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        Iterator<String> b;
        b = this.b.b(this.f2596a);
        return b;
    }

    public String toString() {
        return Joiner.a(", ").a(new StringBuilder().append('['), this).append(']').toString();
    }
}
