package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class ValuesRemovedDetails implements SafeParcelable {
    public static final Parcelable.Creator<ValuesRemovedDetails> CREATOR = new zzj();

    /* renamed from: a, reason: collision with root package name */
    final int f1185a;
    final int b;
    final int c;
    final int d;
    final String e;
    final int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ValuesRemovedDetails(int i, int i2, int i3, int i4, String str, int i5) {
        this.f1185a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = str;
        this.f = i5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.a(this, parcel, i);
    }
}
