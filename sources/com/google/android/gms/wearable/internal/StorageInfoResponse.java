package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes.dex */
public class StorageInfoResponse implements SafeParcelable {
    public static final Parcelable.Creator<StorageInfoResponse> CREATOR = new zzbl();

    /* renamed from: a, reason: collision with root package name */
    public final int f2364a;
    public final int b;
    public final long c;
    public final List<PackageStorageInfo> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StorageInfoResponse(int i, int i2, long j, List<PackageStorageInfo> list) {
        this.f2364a = i;
        this.b = i2;
        this.c = j;
        this.d = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbl.a(this, parcel, i);
    }
}
