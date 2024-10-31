package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

/* loaded from: classes.dex */
public interface Leaderboards {

    /* loaded from: classes.dex */
    public interface LeaderboardMetadataResult extends Releasable, Result {
    }

    /* loaded from: classes.dex */
    public interface LoadPlayerScoreResult extends Result {
    }

    /* loaded from: classes.dex */
    public interface LoadScoresResult extends Releasable, Result {
    }

    /* loaded from: classes.dex */
    public interface SubmitScoreResult extends Releasable, Result {
    }
}
