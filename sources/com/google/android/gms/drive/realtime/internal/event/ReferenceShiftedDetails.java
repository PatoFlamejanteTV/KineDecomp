package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class ReferenceShiftedDetails implements SafeParcelable {
    public static final Parcelable.Creator<ReferenceShiftedDetails> CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    final int f1180a;
    final String b;
    final String c;
    final int d;
    final int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReferenceShiftedDetails(int i, String str, String str2, int i2, int i3) {
        this.f1180a = i;
        this.b = str;
        this.c = str2;
        this.d = i2;
        this.e = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.a(this, parcel, i);
    }
}
