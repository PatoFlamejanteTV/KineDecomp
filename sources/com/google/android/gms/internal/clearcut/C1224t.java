package com.google.android.gms.internal.clearcut;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.clearcut.t, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1224t {

    /* renamed from: a, reason: collision with root package name */
    private final zzbn f12893a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f12894b;

    private C1224t(int i) {
        this.f12894b = new byte[i];
        this.f12893a = zzbn.zzc(this.f12894b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C1224t(int i, C1219q c1219q) {
        this(i);
    }

    public final zzbb a() {
        if (this.f12893a.zzag() == 0) {
            return new zzbi(this.f12894b);
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public final zzbn b() {
        return this.f12893a;
    }
}
