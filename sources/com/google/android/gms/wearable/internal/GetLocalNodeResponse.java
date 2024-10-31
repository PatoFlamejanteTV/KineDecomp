package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class GetLocalNodeResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetLocalNodeResponse> CREATOR = new zzat();

    /* renamed from: a, reason: collision with root package name */
    public final int f2355a;
    public final int b;
    public final NodeParcelable c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetLocalNodeResponse(int i, int i2, NodeParcelable nodeParcelable) {
        this.f2355a = i;
        this.b = i2;
        this.c = nodeParcelable;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzat.a(this, parcel, i);
    }
}
