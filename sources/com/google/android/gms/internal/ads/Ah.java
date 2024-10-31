package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Ah {

    /* renamed from: a, reason: collision with root package name */
    private final zzbqk f11378a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f11379b;

    private Ah(int i) {
        this.f11379b = new byte[i];
        this.f11378a = zzbqk.zzt(this.f11379b);
    }

    public final zzbpu a() {
        this.f11378a.zzalv();
        return new zzbqd(this.f11379b);
    }

    public final zzbqk b() {
        return this.f11378a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ Ah(int i, C1139wh c1139wh) {
        this(i);
    }
}
