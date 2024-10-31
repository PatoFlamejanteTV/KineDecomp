package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.measurement.ab, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1347ab implements Qa {

    /* renamed from: a, reason: collision with root package name */
    private final zzvv f13414a;

    /* renamed from: b, reason: collision with root package name */
    private final String f13415b;

    /* renamed from: c, reason: collision with root package name */
    private final Object[] f13416c;

    /* renamed from: d, reason: collision with root package name */
    private final int f13417d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1347ab(zzvv zzvvVar, String str, Object[] objArr) {
        this.f13414a = zzvvVar;
        this.f13415b = str;
        this.f13416c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f13417d = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 < 55296) {
                this.f13417d = i | (charAt2 << i2);
                return;
            } else {
                i |= (charAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.Qa
    public final zzvv a() {
        return this.f13414a;
    }

    @Override // com.google.android.gms.internal.measurement.Qa
    public final boolean b() {
        return (this.f13417d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.measurement.Qa
    public final int c() {
        return (this.f13417d & 1) == 1 ? zzuo.zze.zzbys : zzuo.zze.zzbyt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d() {
        return this.f13415b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] e() {
        return this.f13416c;
    }
}
