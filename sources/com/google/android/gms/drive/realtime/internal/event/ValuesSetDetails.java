package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class ValuesSetDetails implements SafeParcelable {
    public static final Parcelable.Creator<ValuesSetDetails> CREATOR = new zzk();

    /* renamed from: a, reason: collision with root package name */
    final int f1186a;
    final int b;
    final int c;
    final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ValuesSetDetails(int i, int i2, int i3, int i4) {
        this.f1186a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.a(this, parcel, i);
    }
}
