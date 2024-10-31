package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Iterator<String> {

    /* renamed from: a, reason: collision with root package name */
    Iterator<String> f2022a;
    final /* synthetic */ EventParams b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(EventParams eventParams) {
        Bundle bundle;
        this.b = eventParams;
        bundle = this.b.b;
        this.f2022a = bundle.keySet().iterator();
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String next() {
        return this.f2022a.next();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f2022a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
