package com.google.android.gms.games.stats;

import com.google.android.gms.common.data.AbstractDataBuffer;

/* loaded from: classes.dex */
public final class PlayerStatsBuffer extends AbstractDataBuffer<PlayerStats> {
    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PlayerStats a(int i) {
        return new PlayerStatsRef(this.f982a, i);
    }
}
