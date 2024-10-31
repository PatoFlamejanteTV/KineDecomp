package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItemAsset;

/* loaded from: classes.dex */
public class zzac extends com.google.android.gms.common.data.zzc implements DataItemAsset {
    public zzac(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public String b() {
        return e("asset_id");
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public String c() {
        return e("asset_key");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public DataItemAsset a() {
        return new zzaa(this);
    }
}
