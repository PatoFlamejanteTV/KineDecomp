package com.google.android.gms.internal.firebase_auth;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.firebase_auth.g */
/* loaded from: classes2.dex */
public final class C1250g extends AbstractC1254i {

    /* renamed from: a */
    private int f13029a = 0;

    /* renamed from: b */
    private final int f13030b;

    /* renamed from: c */
    private final /* synthetic */ zzeh f13031c;

    public C1250g(zzeh zzehVar) {
        this.f13031c = zzehVar;
        this.f13030b = this.f13031c.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f13029a < this.f13030b;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzeo
    public final byte nextByte() {
        int i = this.f13029a;
        if (i < this.f13030b) {
            this.f13029a = i + 1;
            return this.f13031c.zzl(i);
        }
        throw new NoSuchElementException();
    }
}
