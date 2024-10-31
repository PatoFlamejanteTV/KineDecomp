package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpn;
import com.google.android.gms.internal.zzpo;
import com.google.android.gms.internal.zzpp;

/* loaded from: classes.dex */
public class EnableTargetRequest implements SafeParcelable {
    public static final zze CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    final int f2088a;
    private final String b;
    private final String c;
    private final zzpn d;
    private final zzpo e;
    private final zzpp f;
    private final byte g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EnableTargetRequest(int i, String str, String str2, byte b, IBinder iBinder, IBinder iBinder2, IBinder iBinder3) {
        this.f2088a = i;
        this.b = zzx.a(str);
        this.c = (String) zzx.a(str2);
        this.g = b;
        zzx.a(iBinder);
        this.d = zzpn.zza.zzdc(iBinder);
        zzx.a(iBinder2);
        this.e = zzpo.zza.zzdd(iBinder2);
        zzx.a(iBinder3);
        this.f = zzpp.zza.zzde(iBinder3);
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public byte c() {
        return this.g;
    }

    public IBinder d() {
        if (this.d == null) {
            return null;
        }
        return this.d.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zze zzeVar = CREATOR;
        return 0;
    }

    public IBinder e() {
        if (this.e == null) {
            return null;
        }
        return this.e.asBinder();
    }

    public IBinder f() {
        if (this.f == null) {
            return null;
        }
        return this.f.asBinder();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze zzeVar = CREATOR;
        zze.a(this, parcel, i);
    }
}
