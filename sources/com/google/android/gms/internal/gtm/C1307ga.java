package com.google.android.gms.internal.gtm;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.gtm.ga, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1307ga {

    /* renamed from: a, reason: collision with root package name */
    private final zzqj f13233a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f13234b;

    private C1307ga(int i) {
        this.f13234b = new byte[i];
        this.f13233a = zzqj.zzg(this.f13234b);
    }

    public final zzps a() {
        if (this.f13233a.zzoi() == 0) {
            return new zzqc(this.f13234b);
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public final zzqj b() {
        return this.f13233a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C1307ga(int i, C1293ba c1293ba) {
        this(i);
    }
}
