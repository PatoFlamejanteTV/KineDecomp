package com.google.api.client.util;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Types.java */
/* loaded from: classes.dex */
final class j<T> implements Iterable<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f2558a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Object obj) {
        this.f2558a = obj;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new k(this);
    }
}
