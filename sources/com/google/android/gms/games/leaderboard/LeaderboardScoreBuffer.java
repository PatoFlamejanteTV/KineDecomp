package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.AbstractDataBuffer;

/* loaded from: classes.dex */
public final class LeaderboardScoreBuffer extends AbstractDataBuffer<LeaderboardScore> {
    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LeaderboardScore a(int i) {
        return new LeaderboardScoreRef(this.f982a, i);
    }
}
