package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase_auth.ha, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1253ha implements W {

    /* renamed from: a, reason: collision with root package name */
    private final zzhc f13034a;

    /* renamed from: b, reason: collision with root package name */
    private final String f13035b;

    /* renamed from: c, reason: collision with root package name */
    private final Object[] f13036c;

    /* renamed from: d, reason: collision with root package name */
    private final int f13037d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1253ha(zzhc zzhcVar, String str, Object[] objArr) {
        this.f13034a = zzhcVar;
        this.f13035b = str;
        this.f13036c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f13037d = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 < 55296) {
                this.f13037d = i | (charAt2 << i2);
                return;
            } else {
                i |= (charAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.W
    public final boolean a() {
        return (this.f13037d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.firebase_auth.W
    public final zzhc b() {
        return this.f13034a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String c() {
        return this.f13035b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] d() {
        return this.f13036c;
    }

    @Override // com.google.android.gms.internal.firebase_auth.W
    public final int zzin() {
        return (this.f13037d & 1) == 1 ? zzft.zze.zzxn : zzft.zze.zzxo;
    }
}
