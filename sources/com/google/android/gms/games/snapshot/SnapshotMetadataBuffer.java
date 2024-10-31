package com.google.android.gms.games.snapshot;

import com.google.android.gms.common.data.AbstractDataBuffer;

/* loaded from: classes.dex */
public final class SnapshotMetadataBuffer extends AbstractDataBuffer<SnapshotMetadata> {
    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SnapshotMetadata a(int i) {
        return new SnapshotMetadataRef(this.f982a, i);
    }
}
