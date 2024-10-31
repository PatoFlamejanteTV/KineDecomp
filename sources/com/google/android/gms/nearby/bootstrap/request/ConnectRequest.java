package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpn;
import com.google.android.gms.internal.zzpo;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.nearby.bootstrap.Device;

/* loaded from: classes.dex */
public class ConnectRequest implements SafeParcelable {
    public static final zza CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    final int f2084a;
    private final Device b;
    private final String c;
    private final String d;
    private final zzpn e;
    private final zzpo f;
    private final zzpp g;
    private final byte h;
    private final long i;
    private final String j;
    private final byte k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConnectRequest(int i, Device device, String str, String str2, byte b, long j, String str3, byte b2, IBinder iBinder, IBinder iBinder2, IBinder iBinder3) {
        this.f2084a = i;
        this.b = (Device) zzx.a(device);
        this.c = zzx.a(str);
        this.d = (String) zzx.a(str2);
        this.h = b;
        this.i = j;
        this.k = b2;
        this.j = str3;
        zzx.a(iBinder);
        this.e = zzpn.zza.zzdc(iBinder);
        zzx.a(iBinder2);
        this.f = zzpo.zza.zzdd(iBinder2);
        zzx.a(iBinder3);
        this.g = zzpp.zza.zzde(iBinder3);
    }

    public Device a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public byte d() {
        return this.h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zza zzaVar = CREATOR;
        return 0;
    }

    public long e() {
        return this.i;
    }

    public String f() {
        return this.j;
    }

    public byte g() {
        return this.k;
    }

    public IBinder h() {
        if (this.e == null) {
            return null;
        }
        return this.e.asBinder();
    }

    public IBinder i() {
        if (this.f == null) {
            return null;
        }
        return this.f.asBinder();
    }

    public IBinder j() {
        if (this.g == null) {
            return null;
        }
        return this.g.asBinder();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza zzaVar = CREATOR;
        zza.a(this, parcel, i);
    }
}
