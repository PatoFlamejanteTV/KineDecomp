package com.google.android.gms.games;

import com.google.android.gms.common.data.AbstractDataBuffer;

/* loaded from: classes.dex */
public final class GameBuffer extends AbstractDataBuffer<Game> {
    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Game a(int i) {
        return new GameRef(this.f982a, i);
    }
}
