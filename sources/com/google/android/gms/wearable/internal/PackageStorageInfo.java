package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class PackageStorageInfo implements SafeParcelable {
    public static final Parcelable.Creator<PackageStorageInfo> CREATOR = new zzbe();

    /* renamed from: a, reason: collision with root package name */
    public final int f2359a;
    public final String b;
    public final String c;
    public final long d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PackageStorageInfo(int i, String str, String str2, long j) {
        this.f2359a = i;
        this.b = str;
        this.c = str2;
        this.d = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbe.a(this, parcel, i);
    }
}
