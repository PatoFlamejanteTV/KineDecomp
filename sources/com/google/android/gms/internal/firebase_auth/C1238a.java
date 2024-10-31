package com.google.android.gms.internal.firebase_auth;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase_auth.a */
/* loaded from: classes2.dex */
public final class C1238a<E> extends bb<E> {

    /* renamed from: c */
    private final zzz<E> f13010c;

    public C1238a(zzz<E> zzzVar, int i) {
        super(zzzVar.size(), i);
        this.f13010c = zzzVar;
    }

    @Override // com.google.android.gms.internal.firebase_auth.bb
    protected final E a(int i) {
        return this.f13010c.get(i);
    }
}
