package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class ValueChangedDetails implements SafeParcelable {
    public static final Parcelable.Creator<ValueChangedDetails> CREATOR = new zzh();

    /* renamed from: a, reason: collision with root package name */
    final int f1183a;
    final int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ValueChangedDetails(int i, int i2) {
        this.f1183a = i;
        this.b = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.a(this, parcel, i);
    }
}
