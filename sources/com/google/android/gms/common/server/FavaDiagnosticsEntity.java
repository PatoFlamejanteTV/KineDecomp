package com.google.android.gms.common.server;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class FavaDiagnosticsEntity implements SafeParcelable {
    public static final zza CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    final int f1029a;
    public final String b;
    public final int c;

    public FavaDiagnosticsEntity(int i, String str, int i2) {
        this.f1029a = i;
        this.b = str;
        this.c = i2;
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
