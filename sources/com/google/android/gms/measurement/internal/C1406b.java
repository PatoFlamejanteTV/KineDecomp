package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Iterator;

/* renamed from: com.google.android.gms.measurement.internal.b */
/* loaded from: classes2.dex */
public final class C1406b implements Iterator<String> {

    /* renamed from: a */
    private Iterator<String> f13746a;

    /* renamed from: b */
    private final /* synthetic */ zzad f13747b;

    public C1406b(zzad zzadVar) {
        Bundle bundle;
        this.f13747b = zzadVar;
        bundle = this.f13747b.f13896a;
        this.f13746a = bundle.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f13746a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f13746a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
