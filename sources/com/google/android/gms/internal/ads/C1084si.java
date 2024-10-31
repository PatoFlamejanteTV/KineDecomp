package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.si, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1084si implements InterfaceC0932hi {

    /* renamed from: a, reason: collision with root package name */
    private final zzbsl f12529a;

    /* renamed from: b, reason: collision with root package name */
    private final String f12530b;

    /* renamed from: c, reason: collision with root package name */
    private final Object[] f12531c;

    /* renamed from: d, reason: collision with root package name */
    private final int f12532d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1084si(zzbsl zzbslVar, String str, Object[] objArr) {
        this.f12529a = zzbslVar;
        this.f12530b = str;
        this.f12531c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f12532d = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 < 55296) {
                this.f12532d = i | (charAt2 << i2);
                return;
            } else {
                i |= (charAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0932hi
    public final boolean a() {
        return (this.f12532d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0932hi
    public final zzbsl b() {
        return this.f12529a;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0932hi
    public final int c() {
        return (this.f12532d & 1) == 1 ? zzbrd.zze.zzfqj : zzbrd.zze.zzfqk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d() {
        return this.f12530b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] e() {
        return this.f12531c;
    }
}
