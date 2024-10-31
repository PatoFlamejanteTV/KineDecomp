package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.AbstractDataBuffer;

/* loaded from: classes.dex */
public final class GameInstanceBuffer extends AbstractDataBuffer<GameInstance> {
    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public GameInstance a(int i) {
        return new GameInstanceRef(this.f982a, i);
    }
}
