package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class ConnectionEvent extends zzf implements SafeParcelable {
    public static final Parcelable.Creator<ConnectionEvent> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    final int f1038a;
    private final long d;
    private int e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final long l;
    private final long m;
    private long n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConnectionEvent(int i, long j, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this.f1038a = i;
        this.d = j;
        this.e = i2;
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.i = str4;
        this.n = -1L;
        this.j = str5;
        this.k = str6;
        this.l = j2;
        this.m = j3;
    }

    public ConnectionEvent(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this(1, j, i, str, str2, str3, str4, str5, str6, j2, j3);
    }

    @Override // com.google.android.gms.common.stats.zzf
    public long a() {
        return this.d;
    }

    @Override // com.google.android.gms.common.stats.zzf
    public int b() {
        return this.e;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.h;
    }

    public String f() {
        return this.i;
    }

    public String g() {
        return this.j;
    }

    public String h() {
        return this.k;
    }

    @Override // com.google.android.gms.common.stats.zzf
    public long i() {
        return this.n;
    }

    public long j() {
        return this.m;
    }

    public long k() {
        return this.l;
    }

    @Override // com.google.android.gms.common.stats.zzf
    public String l() {
        return "\t" + c() + "/" + d() + "\t" + e() + "/" + f() + "\t" + (this.j == null ? "" : this.j) + "\t" + j();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
