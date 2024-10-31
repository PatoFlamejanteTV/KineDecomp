package com.google.android.gms.games;

import com.google.android.gms.common.data.AbstractDataBuffer;

/* loaded from: classes.dex */
public final class PlayerBuffer extends AbstractDataBuffer<Player> {
    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Player a(int i) {
        return new PlayerRef(this.f982a, i);
    }
}
