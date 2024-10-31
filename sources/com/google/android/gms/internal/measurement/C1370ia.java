package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.measurement.ia, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1370ia {

    /* renamed from: a, reason: collision with root package name */
    private final zztv f13464a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f13465b;

    private C1370ia(int i) {
        this.f13465b = new byte[i];
        this.f13464a = zztv.zzj(this.f13465b);
    }

    public final zzte a() {
        if (this.f13464a.zzvj() == 0) {
            return new zzto(this.f13465b);
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public final zztv b() {
        return this.f13464a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C1370ia(int i, C1355da c1355da) {
        this(i);
    }
}
