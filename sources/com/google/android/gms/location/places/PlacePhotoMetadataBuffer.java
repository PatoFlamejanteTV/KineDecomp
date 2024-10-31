package com.google.android.gms.location.places;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.zzr;

/* loaded from: classes.dex */
public class PlacePhotoMetadataBuffer extends AbstractDataBuffer<PlacePhotoMetadata> {
    public PlacePhotoMetadataBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PlacePhotoMetadata a(int i) {
        return new zzr(this.f982a, i);
    }
}
