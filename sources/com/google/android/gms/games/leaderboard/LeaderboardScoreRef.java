package com.google.android.gms.games.leaderboard;

import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

/* loaded from: classes.dex */
public final class LeaderboardScoreRef extends zzc implements LeaderboardScore {
    private final PlayerRef c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LeaderboardScoreRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.c = new PlayerRef(dataHolder, i);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public long b() {
        return b("rank");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String c() {
        return e("display_rank");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String d() {
        return e("display_score");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public long e() {
        return b("raw_score");
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return LeaderboardScoreEntity.a(this, obj);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public long f() {
        return b("achieved_timestamp");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String g() {
        return i("external_player_id") ? e("default_display_name") : this.c.c();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public Uri h() {
        return i("external_player_id") ? h("default_display_image_uri") : this.c.g();
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return LeaderboardScoreEntity.a(this);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String i() {
        return i("external_player_id") ? e("default_display_image_url") : this.c.h();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public Uri j() {
        if (i("external_player_id")) {
            return null;
        }
        return this.c.i();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String k() {
        if (i("external_player_id")) {
            return null;
        }
        return this.c.j();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public Player l() {
        if (i("external_player_id")) {
            return null;
        }
        return this.c;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String m() {
        return e("score_tag");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public LeaderboardScore a() {
        return new LeaderboardScoreEntity(this);
    }

    public String toString() {
        return LeaderboardScoreEntity.b(this);
    }
}
