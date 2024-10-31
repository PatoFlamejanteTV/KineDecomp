package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class GetCloudSyncOptInStatusResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetCloudSyncOptInStatusResponse> CREATOR = new zzam();

    /* renamed from: a, reason: collision with root package name */
    public final int f2348a;
    public final int b;
    public final boolean c;
    public final boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetCloudSyncOptInStatusResponse(int i, int i2, boolean z, boolean z2) {
        this.f2348a = i;
        this.b = i2;
        this.c = z;
        this.d = z2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzam.a(this, parcel, i);
    }
}
