package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.internal.api.LeaderboardsImpl;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* loaded from: classes.dex */
class a implements Leaderboards.SubmitScoreResult {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Status f1369a;
    final /* synthetic */ LeaderboardsImpl.SubmitScoreImpl b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(LeaderboardsImpl.SubmitScoreImpl submitScoreImpl, Status status) {
        this.b = submitScoreImpl;
        this.f1369a = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f1369a;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
    }
}
