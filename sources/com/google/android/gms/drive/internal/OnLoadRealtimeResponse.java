package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class OnLoadRealtimeResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnLoadRealtimeResponse> CREATOR = new zzbg();

    /* renamed from: a, reason: collision with root package name */
    final int f1109a;
    final boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnLoadRealtimeResponse(int i, boolean z) {
        this.f1109a = i;
        this.b = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbg.a(this, parcel, i);
    }
}
