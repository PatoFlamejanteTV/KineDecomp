package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class ParcelableIndexReference implements SafeParcelable {
    public static final Parcelable.Creator<ParcelableIndexReference> CREATOR = new zzr();

    /* renamed from: a, reason: collision with root package name */
    final int f1175a;
    final String b;
    final int c;
    final boolean d;
    final int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParcelableIndexReference(int i, String str, int i2, boolean z, int i3) {
        this.f1175a = i;
        this.b = str;
        this.c = i2;
        this.d = z;
        this.e = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzr.a(this, parcel, i);
    }
}
