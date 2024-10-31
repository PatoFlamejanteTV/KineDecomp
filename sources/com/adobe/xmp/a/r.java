package com.adobe.xmp.a;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: XMPNode.java */
/* loaded from: classes.dex */
public class r implements Iterator {

    /* renamed from: a */
    final /* synthetic */ s f7549a;

    /* renamed from: b */
    private final /* synthetic */ Iterator f7550b;

    public r(s sVar, Iterator it) {
        this.f7549a = sVar;
        this.f7550b = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f7550b.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        return this.f7550b.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is not allowed due to the internal contraints");
    }
}
