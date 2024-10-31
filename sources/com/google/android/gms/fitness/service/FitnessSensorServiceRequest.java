package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.zzj;

/* loaded from: classes.dex */
public class FitnessSensorServiceRequest implements SafeParcelable {
    public static final Parcelable.Creator<FitnessSensorServiceRequest> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    private final int f1294a;
    private final DataSource b;
    private final zzj c;
    private final long d;
    private final long e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FitnessSensorServiceRequest(int i, DataSource dataSource, IBinder iBinder, long j, long j2) {
        this.f1294a = i;
        this.b = dataSource;
        this.c = zzj.zza.a(iBinder);
        this.d = j;
        this.e = j2;
    }

    private boolean a(FitnessSensorServiceRequest fitnessSensorServiceRequest) {
        return zzw.a(this.b, fitnessSensorServiceRequest.b) && this.d == fitnessSensorServiceRequest.d && this.e == fitnessSensorServiceRequest.e;
    }

    public DataSource a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f1294a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder c() {
        return this.c.asBinder();
    }

    public long d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof FitnessSensorServiceRequest) && a((FitnessSensorServiceRequest) obj));
    }

    public int hashCode() {
        return zzw.a(this.b, Long.valueOf(this.d), Long.valueOf(this.e));
    }

    public String toString() {
        return String.format("FitnessSensorServiceRequest{%s}", this.b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
