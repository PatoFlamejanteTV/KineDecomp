package com.google.android.gms.games.request;

import com.google.android.gms.common.data.AbstractDataBuffer;

/* loaded from: classes.dex */
public final class GameRequestSummaryBuffer extends AbstractDataBuffer<GameRequestSummary> {
    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public GameRequestSummary a(int i) {
        return new GameRequestSummaryRef(this.f982a, i);
    }
}
