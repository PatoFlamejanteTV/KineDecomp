package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.AbstractDataBuffer;

/* loaded from: classes.dex */
public final class GameBadgeBuffer extends AbstractDataBuffer<GameBadge> {
    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public GameBadge a(int i) {
        return new GameBadgeRef(this.f982a, i);
    }
}
