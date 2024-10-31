package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class GetCloudSyncSettingResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetCloudSyncSettingResponse> CREATOR = new zzan();

    /* renamed from: a, reason: collision with root package name */
    public final int f2349a;
    public final int b;
    public final boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetCloudSyncSettingResponse(int i, int i2, boolean z) {
        this.f2349a = i;
        this.b = i2;
        this.c = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzan.a(this, parcel, i);
    }
}
