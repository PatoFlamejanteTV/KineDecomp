package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* loaded from: classes.dex */
public final class LeaderboardsImpl implements Leaderboards {

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static abstract class SubmitScoreImpl extends Games.BaseGamesApiMethodImpl<Leaderboards.SubmitScoreResult> {
        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Leaderboards.SubmitScoreResult zzb(Status status) {
            return new a(this, status);
        }
    }
}
