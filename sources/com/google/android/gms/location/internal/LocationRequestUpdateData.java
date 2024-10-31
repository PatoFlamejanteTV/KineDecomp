package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.internal.zzg;
import com.google.android.gms.location.zzc;
import com.google.android.gms.location.zzd;

/* loaded from: classes.dex */
public class LocationRequestUpdateData implements SafeParcelable {
    public static final zzn CREATOR = new zzn();

    /* renamed from: a, reason: collision with root package name */
    int f1854a;
    LocationRequestInternal b;
    com.google.android.gms.location.zzd c;
    PendingIntent d;
    com.google.android.gms.location.zzc e;
    zzg f;
    private final int g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationRequestUpdateData(int i, int i2, LocationRequestInternal locationRequestInternal, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        this.g = i;
        this.f1854a = i2;
        this.b = locationRequestInternal;
        this.c = iBinder == null ? null : zzd.zza.a(iBinder);
        this.d = pendingIntent;
        this.e = iBinder2 == null ? null : zzc.zza.a(iBinder2);
        this.f = iBinder3 != null ? zzg.zza.a(iBinder3) : null;
    }

    public static LocationRequestUpdateData a(com.google.android.gms.location.zzc zzcVar, zzg zzgVar) {
        return new LocationRequestUpdateData(1, 2, null, null, null, zzcVar.asBinder(), zzgVar != null ? zzgVar.asBinder() : null);
    }

    public static LocationRequestUpdateData a(com.google.android.gms.location.zzd zzdVar, zzg zzgVar) {
        return new LocationRequestUpdateData(1, 2, null, zzdVar.asBinder(), null, null, zzgVar != null ? zzgVar.asBinder() : null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder b() {
        if (this.c == null) {
            return null;
        }
        return this.c.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder c() {
        if (this.e == null) {
            return null;
        }
        return this.e.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder d() {
        if (this.f == null) {
            return null;
        }
        return this.f.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzn.a(this, parcel, i);
    }
}
