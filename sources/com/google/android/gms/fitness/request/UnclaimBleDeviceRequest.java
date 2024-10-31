package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzoj;

/* loaded from: classes.dex */
public class UnclaimBleDeviceRequest implements SafeParcelable {
    public static final Parcelable.Creator<UnclaimBleDeviceRequest> CREATOR = new zzad();

    /* renamed from: a, reason: collision with root package name */
    private final int f1277a;
    private final String b;
    private final zzoj c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnclaimBleDeviceRequest(int i, String str, IBinder iBinder) {
        this.f1277a = i;
        this.b = str;
        this.c = zzoj.zza.zzbJ(iBinder);
    }

    public UnclaimBleDeviceRequest(String str, zzoj zzojVar) {
        this.f1277a = 5;
        this.b = str;
        this.c = zzojVar;
    }

    public String a() {
        return this.b;
    }

    public IBinder b() {
        if (this.c == null) {
            return null;
        }
        return this.c.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f1277a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("UnclaimBleDeviceRequest{%s}", this.b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzad.a(this, parcel, i);
    }
}
