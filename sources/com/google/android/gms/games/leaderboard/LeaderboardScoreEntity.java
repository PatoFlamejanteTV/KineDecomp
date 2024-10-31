package com.google.android.gms.games.leaderboard;

import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;

/* loaded from: classes.dex */
public final class LeaderboardScoreEntity implements LeaderboardScore {

    /* renamed from: a, reason: collision with root package name */
    private final long f1382a;
    private final String b;
    private final String c;
    private final long d;
    private final long e;
    private final String f;
    private final Uri g;
    private final Uri h;
    private final PlayerEntity i;
    private final String j;
    private final String k;
    private final String l;

    public LeaderboardScoreEntity(LeaderboardScore leaderboardScore) {
        this.f1382a = leaderboardScore.b();
        this.b = (String) zzx.a(leaderboardScore.c());
        this.c = (String) zzx.a(leaderboardScore.d());
        this.d = leaderboardScore.e();
        this.e = leaderboardScore.f();
        this.f = leaderboardScore.g();
        this.g = leaderboardScore.h();
        this.h = leaderboardScore.j();
        Player l = leaderboardScore.l();
        this.i = l == null ? null : (PlayerEntity) l.a();
        this.j = leaderboardScore.m();
        this.k = leaderboardScore.i();
        this.l = leaderboardScore.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(LeaderboardScore leaderboardScore) {
        return zzw.a(Long.valueOf(leaderboardScore.b()), leaderboardScore.c(), Long.valueOf(leaderboardScore.e()), leaderboardScore.d(), Long.valueOf(leaderboardScore.f()), leaderboardScore.g(), leaderboardScore.h(), leaderboardScore.j(), leaderboardScore.l());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(LeaderboardScore leaderboardScore, Object obj) {
        if (!(obj instanceof LeaderboardScore)) {
            return false;
        }
        if (leaderboardScore == obj) {
            return true;
        }
        LeaderboardScore leaderboardScore2 = (LeaderboardScore) obj;
        return zzw.a(Long.valueOf(leaderboardScore2.b()), Long.valueOf(leaderboardScore.b())) && zzw.a(leaderboardScore2.c(), leaderboardScore.c()) && zzw.a(Long.valueOf(leaderboardScore2.e()), Long.valueOf(leaderboardScore.e())) && zzw.a(leaderboardScore2.d(), leaderboardScore.d()) && zzw.a(Long.valueOf(leaderboardScore2.f()), Long.valueOf(leaderboardScore.f())) && zzw.a(leaderboardScore2.g(), leaderboardScore.g()) && zzw.a(leaderboardScore2.h(), leaderboardScore.h()) && zzw.a(leaderboardScore2.j(), leaderboardScore.j()) && zzw.a(leaderboardScore2.l(), leaderboardScore.l()) && zzw.a(leaderboardScore2.m(), leaderboardScore.m());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(LeaderboardScore leaderboardScore) {
        return zzw.a(leaderboardScore).a("Rank", Long.valueOf(leaderboardScore.b())).a("DisplayRank", leaderboardScore.c()).a("Score", Long.valueOf(leaderboardScore.e())).a("DisplayScore", leaderboardScore.d()).a("Timestamp", Long.valueOf(leaderboardScore.f())).a("DisplayName", leaderboardScore.g()).a("IconImageUri", leaderboardScore.h()).a("IconImageUrl", leaderboardScore.i()).a("HiResImageUri", leaderboardScore.j()).a("HiResImageUrl", leaderboardScore.k()).a("Player", leaderboardScore.l() == null ? null : leaderboardScore.l()).a("ScoreTag", leaderboardScore.m()).toString();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public long b() {
        return this.f1382a;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String c() {
        return this.b;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String d() {
        return this.c;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public long e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public long f() {
        return this.e;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String g() {
        return this.i == null ? this.f : this.i.c();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public Uri h() {
        return this.i == null ? this.g : this.i.g();
    }

    public int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String i() {
        return this.i == null ? this.k : this.i.h();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public Uri j() {
        return this.i == null ? this.h : this.i.i();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String k() {
        return this.i == null ? this.l : this.i.j();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public Player l() {
        return this.i;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String m() {
        return this.j;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public LeaderboardScore a() {
        return this;
    }

    public String toString() {
        return b(this);
    }
}
