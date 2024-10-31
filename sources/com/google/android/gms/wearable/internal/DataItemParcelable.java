package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class DataItemParcelable implements SafeParcelable, DataItem {
    public static final Parcelable.Creator<DataItemParcelable> CREATOR = new zzae();

    /* renamed from: a, reason: collision with root package name */
    final int f2341a;
    private final Uri b;
    private final Map<String, DataItemAsset> c;
    private byte[] d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataItemParcelable(int i, Uri uri, Bundle bundle, byte[] bArr) {
        this.f2341a = i;
        this.b = uri;
        HashMap hashMap = new HashMap();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (String str : bundle.keySet()) {
            hashMap.put(str, (DataItemAssetParcelable) bundle.getParcelable(str));
        }
        this.c = hashMap;
        this.d = bArr;
    }

    public String a(boolean z) {
        StringBuilder sb = new StringBuilder("DataItemParcelable[");
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(",dataSz=" + (this.d == null ? "null" : Integer.valueOf(this.d.length)));
        sb.append(", numAssets=" + this.c.size());
        sb.append(", uri=" + this.b);
        if (!z) {
            sb.append("]");
            return sb.toString();
        }
        sb.append("]\n  assets: ");
        for (String str : this.c.keySet()) {
            sb.append("\n    " + str + ": " + this.c.get(str));
        }
        sb.append("\n  ]");
        return sb.toString();
    }

    @Override // com.google.android.gms.wearable.DataItem
    public Uri b() {
        return this.b;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public byte[] c() {
        return this.d;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public Map<String, DataItemAsset> d() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public DataItemParcelable a() {
        return this;
    }

    public Bundle f() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (Map.Entry<String, DataItemAsset> entry : this.c.entrySet()) {
            bundle.putParcelable(entry.getKey(), new DataItemAssetParcelable(entry.getValue()));
        }
        return bundle;
    }

    public String toString() {
        return a(Log.isLoggable("DataItem", 3));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzae.a(this, parcel, i);
    }
}
