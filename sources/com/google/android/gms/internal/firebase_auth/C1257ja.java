package com.google.android.gms.internal.firebase_auth;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase_auth.ja, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1257ja extends AbstractC1254i {

    /* renamed from: a, reason: collision with root package name */
    private final C1261la f13038a;

    /* renamed from: b, reason: collision with root package name */
    private zzeo f13039b = a();

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzhs f13040c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1257ja(zzhs zzhsVar) {
        this.f13040c = zzhsVar;
        this.f13038a = new C1261la(this.f13040c, null);
    }

    private final zzeo a() {
        if (this.f13038a.hasNext()) {
            return (zzeo) ((zzeq) this.f13038a.next()).iterator();
        }
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f13039b != null;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzeo
    public final byte nextByte() {
        zzeo zzeoVar = this.f13039b;
        if (zzeoVar != null) {
            byte nextByte = zzeoVar.nextByte();
            if (!this.f13039b.hasNext()) {
                this.f13039b = a();
            }
            return nextByte;
        }
        throw new NoSuchElementException();
    }
}
