package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes.dex */
public final class WakeLockEvent extends zzf implements SafeParcelable {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzh();

    /* renamed from: a, reason: collision with root package name */
    final int f1039a;
    private final long d;
    private int e;
    private final String f;
    private final int g;
    private final List<String> h;
    private final String i;
    private final long j;
    private int k;
    private final String l;
    private final String m;
    private final float n;
    private final long o;
    private long p;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3) {
        this.f1039a = i;
        this.d = j;
        this.e = i2;
        this.f = str;
        this.l = str3;
        this.g = i3;
        this.p = -1L;
        this.h = list;
        this.i = str2;
        this.j = j2;
        this.k = i4;
        this.m = str4;
        this.n = f;
        this.o = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3) {
        this(1, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3);
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
        return this.l;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.g;
    }

    public List<String> f() {
        return this.h;
    }

    public String g() {
        return this.i;
    }

    public long h() {
        return this.j;
    }

    @Override // com.google.android.gms.common.stats.zzf
    public long i() {
        return this.p;
    }

    public int j() {
        return this.k;
    }

    public String k() {
        return this.m;
    }

    @Override // com.google.android.gms.common.stats.zzf
    public String l() {
        return "\t" + c() + "\t" + e() + "\t" + (f() == null ? "" : TextUtils.join(",", f())) + "\t" + j() + "\t" + (d() == null ? "" : d()) + "\t" + (k() == null ? "" : k()) + "\t" + m();
    }

    public float m() {
        return this.n;
    }

    public long n() {
        return this.o;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.a(this, parcel, i);
    }
}
