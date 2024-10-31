package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

/* loaded from: classes.dex */
public final class LeaderboardVariantRef extends zzc implements LeaderboardVariant {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LeaderboardVariantRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public int b() {
        return c("timespan");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public int c() {
        return c("collection");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public boolean d() {
        return !i("player_raw_score");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public long e() {
        if (i("player_raw_score")) {
            return -1L;
        }
        return b("player_raw_score");
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return LeaderboardVariantEntity.a(this, obj);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public String f() {
        return e("player_display_score");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public long g() {
        if (i("player_rank")) {
            return -1L;
        }
        return b("player_rank");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public String h() {
        return e("player_display_rank");
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return LeaderboardVariantEntity.a(this);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public String i() {
        return e("player_score_tag");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public long j() {
        if (i("total_scores")) {
            return -1L;
        }
        return b("total_scores");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public String k() {
        return e("top_page_token_next");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public String l() {
        return e("window_page_token_prev");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public String m() {
        return e("window_page_token_next");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public LeaderboardVariant a() {
        return new LeaderboardVariantEntity(this);
    }

    public String toString() {
        return LeaderboardVariantEntity.b(this);
    }
}
