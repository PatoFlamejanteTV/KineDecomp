package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzoj;

/* loaded from: classes.dex */
public class DisableFitRequest implements SafeParcelable {
    public static final Parcelable.Creator<DisableFitRequest> CREATOR = new zzl();

    /* renamed from: a, reason: collision with root package name */
    private final int f1255a;
    private final zzoj b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DisableFitRequest(int i, IBinder iBinder) {
        this.f1255a = i;
        this.b = zzoj.zza.zzbJ(iBinder);
    }

    public DisableFitRequest(zzoj zzojVar) {
        this.f1255a = 2;
        this.b = zzojVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f1255a;
    }

    public IBinder b() {
        return this.b.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("DisableFitRequest", new Object[0]);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzl.a(this, parcel, i);
    }
}
