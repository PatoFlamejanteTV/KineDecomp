package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.zza;
import com.google.android.gms.fitness.request.zzn;
import com.google.android.gms.internal.zzoj;

/* loaded from: classes.dex */
public class StopBleScanRequest implements SafeParcelable {
    public static final Parcelable.Creator<StopBleScanRequest> CREATOR = new zzab();

    /* renamed from: a, reason: collision with root package name */
    private final int f1275a;
    private final zzn b;
    private final zzoj c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StopBleScanRequest(int i, IBinder iBinder, IBinder iBinder2) {
        this.f1275a = i;
        this.b = zzn.zza.a(iBinder);
        this.c = zzoj.zza.zzbJ(iBinder2);
    }

    public StopBleScanRequest(BleScanCallback bleScanCallback, zzoj zzojVar) {
        this(zza.C0033zza.a().a(bleScanCallback), zzojVar);
    }

    public StopBleScanRequest(zzn zznVar, zzoj zzojVar) {
        this.f1275a = 3;
        this.b = zznVar;
        this.c = zzojVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f1275a;
    }

    public IBinder b() {
        return this.b.asBinder();
    }

    public IBinder c() {
        if (this.c == null) {
            return null;
        }
        return this.c.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzab.a(this, parcel, i);
    }
}
