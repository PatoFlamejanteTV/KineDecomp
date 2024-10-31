package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ConnectionConfiguration;

/* loaded from: classes.dex */
public class GetConfigsResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetConfigsResponse> CREATOR = new zzap();

    /* renamed from: a, reason: collision with root package name */
    public final int f2351a;
    public final int b;
    public final ConnectionConfiguration[] c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetConfigsResponse(int i, int i2, ConnectionConfiguration[] connectionConfigurationArr) {
        this.f2351a = i;
        this.b = i2;
        this.c = connectionConfigurationArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzap.a(this, parcel, i);
    }
}
