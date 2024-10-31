package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.internal.zzoj;

/* loaded from: classes.dex */
public class SensorUnregistrationRequest implements SafeParcelable {
    public static final Parcelable.Creator<SensorUnregistrationRequest> CREATOR = new zzt();

    /* renamed from: a, reason: collision with root package name */
    private final int f1264a;
    private final com.google.android.gms.fitness.data.zzj b;
    private final PendingIntent c;
    private final zzoj d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SensorUnregistrationRequest(int i, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2) {
        this.f1264a = i;
        this.b = iBinder == null ? null : zzj.zza.a(iBinder);
        this.c = pendingIntent;
        this.d = zzoj.zza.zzbJ(iBinder2);
    }

    public SensorUnregistrationRequest(com.google.android.gms.fitness.data.zzj zzjVar, PendingIntent pendingIntent, zzoj zzojVar) {
        this.f1264a = 4;
        this.b = zzjVar;
        this.c = pendingIntent;
        this.d = zzojVar;
    }

    public PendingIntent a() {
        return this.c;
    }

    public IBinder b() {
        if (this.d == null) {
            return null;
        }
        return this.d.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f1264a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder d() {
        if (this.b == null) {
            return null;
        }
        return this.b.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("SensorUnregistrationRequest{%s}", this.b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzt.a(this, parcel, i);
    }
}
