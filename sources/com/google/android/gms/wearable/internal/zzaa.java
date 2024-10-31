package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

/* loaded from: classes.dex */
public class zzaa implements DataItemAsset {

    /* renamed from: a, reason: collision with root package name */
    private final String f2381a;
    private final String b;

    public zzaa(DataItemAsset dataItemAsset) {
        this.f2381a = dataItemAsset.b();
        this.b = dataItemAsset.c();
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public String b() {
        return this.f2381a;
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public String c() {
        return this.b;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public DataItemAsset a() {
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DataItemAssetEntity[");
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        if (this.f2381a == null) {
            sb.append(",noid");
        } else {
            sb.append(",");
            sb.append(this.f2381a);
        }
        sb.append(", key=");
        sb.append(this.b);
        sb.append("]");
        return sb.toString();
    }
}
