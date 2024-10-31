package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.DataItemAsset;

/* loaded from: classes.dex */
public class DataItemAssetParcelable implements SafeParcelable, DataItemAsset {
    public static final Parcelable.Creator<DataItemAssetParcelable> CREATOR = new zzab();

    /* renamed from: a, reason: collision with root package name */
    final int f2340a;
    private final String b;
    private final String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataItemAssetParcelable(int i, String str, String str2) {
        this.f2340a = i;
        this.b = str;
        this.c = str2;
    }

    public DataItemAssetParcelable(DataItemAsset dataItemAsset) {
        this.f2340a = 1;
        this.b = (String) com.google.android.gms.common.internal.zzx.a(dataItemAsset.b());
        this.c = (String) com.google.android.gms.common.internal.zzx.a(dataItemAsset.c());
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public String b() {
        return this.b;
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public String c() {
        return this.c;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public DataItemAsset a() {
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DataItemAssetParcelable[");
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        if (this.b == null) {
            sb.append(",noid");
        } else {
            sb.append(",");
            sb.append(this.b);
        }
        sb.append(", key=");
        sb.append(this.c);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzab.a(this, parcel, i);
    }
}
