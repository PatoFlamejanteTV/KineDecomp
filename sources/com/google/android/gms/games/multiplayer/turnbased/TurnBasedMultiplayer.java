package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

/* loaded from: classes.dex */
public interface TurnBasedMultiplayer {

    /* loaded from: classes.dex */
    public interface CancelMatchResult extends Result {
    }

    /* loaded from: classes.dex */
    public interface InitiateMatchResult extends Result {
    }

    /* loaded from: classes.dex */
    public interface LeaveMatchResult extends Result {
    }

    /* loaded from: classes.dex */
    public interface LoadMatchResult extends Result {
    }

    /* loaded from: classes.dex */
    public interface LoadMatchesResult extends Releasable, Result {
    }

    /* loaded from: classes.dex */
    public interface UpdateMatchResult extends Result {
    }
}
