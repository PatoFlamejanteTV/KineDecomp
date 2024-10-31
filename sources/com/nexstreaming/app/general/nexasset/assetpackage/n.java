package com.nexstreaming.app.general.nexasset.assetpackage;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;

/* compiled from: AssetPackageReader.java */
/* loaded from: classes2.dex */
class n implements Iterator<String> {

    /* renamed from: a */
    final /* synthetic */ Enumeration f19542a;

    /* renamed from: b */
    final /* synthetic */ o f19543b;

    public n(o oVar, Enumeration enumeration) {
        this.f19543b = oVar;
        this.f19542a = enumeration;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f19542a.hasMoreElements();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public String next() {
        return ((ZipEntry) this.f19542a.nextElement()).getName();
    }
}
