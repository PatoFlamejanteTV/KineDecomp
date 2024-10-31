package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.clearcut.ma, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1212ma implements InterfaceC1192ca {

    /* renamed from: a, reason: collision with root package name */
    private final zzdo f12857a;

    /* renamed from: b, reason: collision with root package name */
    private final String f12858b;

    /* renamed from: c, reason: collision with root package name */
    private final C1214na f12859c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1212ma(zzdo zzdoVar, String str, Object[] objArr) {
        this.f12857a = zzdoVar;
        this.f12858b = str;
        this.f12859c = new C1214na(zzdoVar.getClass(), str, objArr);
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC1192ca
    public final int a() {
        int i;
        i = this.f12859c.f12863d;
        return (i & 1) == 1 ? zzcg.zzg.zzkl : zzcg.zzg.zzkm;
    }

    public final int b() {
        int i;
        i = this.f12859c.f12864e;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final C1214na c() {
        return this.f12859c;
    }

    public final int d() {
        int i;
        i = this.f12859c.f12867h;
        return i;
    }

    public final int e() {
        int i;
        i = this.f12859c.i;
        return i;
    }

    public final int f() {
        int i;
        i = this.f12859c.j;
        return i;
    }

    public final int g() {
        int i;
        i = this.f12859c.m;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int[] h() {
        int[] iArr;
        iArr = this.f12859c.n;
        return iArr;
    }

    public final int i() {
        int i;
        i = this.f12859c.l;
        return i;
    }

    public final int j() {
        int i;
        i = this.f12859c.k;
        return i;
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC1192ca
    public final boolean zzcg() {
        int i;
        i = this.f12859c.f12863d;
        return (i & 2) == 2;
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC1192ca
    public final zzdo zzch() {
        return this.f12857a;
    }
}
