package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzok;

/* loaded from: classes.dex */
public class GetSyncInfoRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetSyncInfoRequest> CREATOR = new zzm();

    /* renamed from: a, reason: collision with root package name */
    private final int f1256a;
    private final zzok b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetSyncInfoRequest(int i, IBinder iBinder) {
        this.f1256a = i;
        this.b = zzok.zza.zzbK(iBinder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f1256a;
    }

    public IBinder b() {
        return this.b.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("GetSyncInfoRequest {%d, %s, %s}", Integer.valueOf(this.f1256a), this.b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm.a(this, parcel, i);
    }
}
