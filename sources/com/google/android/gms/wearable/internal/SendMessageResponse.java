package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class SendMessageResponse implements SafeParcelable {
    public static final Parcelable.Creator<SendMessageResponse> CREATOR = new zzbi();

    /* renamed from: a, reason: collision with root package name */
    public final int f2363a;
    public final int b;
    public final int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SendMessageResponse(int i, int i2, int i3) {
        this.f2363a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbi.a(this, parcel, i);
    }
}
