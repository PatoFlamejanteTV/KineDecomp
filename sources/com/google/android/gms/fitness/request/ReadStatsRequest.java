package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzog;

/* loaded from: classes.dex */
public class ReadStatsRequest implements SafeParcelable {
    public static final Parcelable.Creator<ReadStatsRequest> CREATOR = new zzr();

    /* renamed from: a, reason: collision with root package name */
    private final int f1260a;
    private final zzog b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReadStatsRequest(int i, IBinder iBinder) {
        this.f1260a = i;
        this.b = zzog.zza.zzbG(iBinder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f1260a;
    }

    public IBinder b() {
        return this.b.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("ReadStatsRequest", new Object[0]);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzr.a(this, parcel, i);
    }
}
