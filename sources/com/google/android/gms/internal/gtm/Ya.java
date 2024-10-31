package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Ya implements Oa {

    /* renamed from: a, reason: collision with root package name */
    private final zzsk f13193a;

    /* renamed from: b, reason: collision with root package name */
    private final String f13194b;

    /* renamed from: c, reason: collision with root package name */
    private final Object[] f13195c;

    /* renamed from: d, reason: collision with root package name */
    private final int f13196d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ya(zzsk zzskVar, String str, Object[] objArr) {
        this.f13193a = zzskVar;
        this.f13194b = str;
        this.f13195c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f13196d = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 < 55296) {
                this.f13196d = i | (charAt2 << i2);
                return;
            } else {
                i |= (charAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.Oa
    public final zzsk a() {
        return this.f13193a;
    }

    @Override // com.google.android.gms.internal.gtm.Oa
    public final boolean b() {
        return (this.f13196d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.gtm.Oa
    public final int c() {
        return (this.f13196d & 1) == 1 ? zzrc.zze.zzbaz : zzrc.zze.zzbba;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d() {
        return this.f13194b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] e() {
        return this.f13195c;
    }
}
