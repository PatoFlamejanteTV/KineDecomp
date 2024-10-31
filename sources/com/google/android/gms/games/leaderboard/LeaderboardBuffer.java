package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.zzf;

/* loaded from: classes.dex */
public final class LeaderboardBuffer extends zzf<Leaderboard> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Leaderboard a(int i, int i2) {
        return new LeaderboardRef(this.f982a, i, i2);
    }

    @Override // com.google.android.gms.common.data.zzf
    protected String b() {
        return "external_leaderboard_id";
    }
}
