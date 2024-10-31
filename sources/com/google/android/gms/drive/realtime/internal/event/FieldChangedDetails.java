package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class FieldChangedDetails implements SafeParcelable {
    public static final Parcelable.Creator<FieldChangedDetails> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    final int f1176a;
    final int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldChangedDetails(int i, int i2) {
        this.f1176a = i;
        this.b = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
