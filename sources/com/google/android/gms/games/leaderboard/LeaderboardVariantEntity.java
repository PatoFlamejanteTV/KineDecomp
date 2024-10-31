package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;

/* loaded from: classes.dex */
public final class LeaderboardVariantEntity implements LeaderboardVariant {

    /* renamed from: a, reason: collision with root package name */
    private final int f1383a;
    private final int b;
    private final boolean c;
    private final long d;
    private final String e;
    private final long f;
    private final String g;
    private final String h;
    private final long i;
    private final String j;
    private final String k;
    private final String l;

    public LeaderboardVariantEntity(LeaderboardVariant leaderboardVariant) {
        this.f1383a = leaderboardVariant.b();
        this.b = leaderboardVariant.c();
        this.c = leaderboardVariant.d();
        this.d = leaderboardVariant.e();
        this.e = leaderboardVariant.f();
        this.f = leaderboardVariant.g();
        this.g = leaderboardVariant.h();
        this.h = leaderboardVariant.i();
        this.i = leaderboardVariant.j();
        this.j = leaderboardVariant.k();
        this.k = leaderboardVariant.l();
        this.l = leaderboardVariant.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(LeaderboardVariant leaderboardVariant) {
        return zzw.a(Integer.valueOf(leaderboardVariant.b()), Integer.valueOf(leaderboardVariant.c()), Boolean.valueOf(leaderboardVariant.d()), Long.valueOf(leaderboardVariant.e()), leaderboardVariant.f(), Long.valueOf(leaderboardVariant.g()), leaderboardVariant.h(), Long.valueOf(leaderboardVariant.j()), leaderboardVariant.k(), leaderboardVariant.m(), leaderboardVariant.l());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(LeaderboardVariant leaderboardVariant, Object obj) {
        if (!(obj instanceof LeaderboardVariant)) {
            return false;
        }
        if (leaderboardVariant == obj) {
            return true;
        }
        LeaderboardVariant leaderboardVariant2 = (LeaderboardVariant) obj;
        return zzw.a(Integer.valueOf(leaderboardVariant2.b()), Integer.valueOf(leaderboardVariant.b())) && zzw.a(Integer.valueOf(leaderboardVariant2.c()), Integer.valueOf(leaderboardVariant.c())) && zzw.a(Boolean.valueOf(leaderboardVariant2.d()), Boolean.valueOf(leaderboardVariant.d())) && zzw.a(Long.valueOf(leaderboardVariant2.e()), Long.valueOf(leaderboardVariant.e())) && zzw.a(leaderboardVariant2.f(), leaderboardVariant.f()) && zzw.a(Long.valueOf(leaderboardVariant2.g()), Long.valueOf(leaderboardVariant.g())) && zzw.a(leaderboardVariant2.h(), leaderboardVariant.h()) && zzw.a(Long.valueOf(leaderboardVariant2.j()), Long.valueOf(leaderboardVariant.j())) && zzw.a(leaderboardVariant2.k(), leaderboardVariant.k()) && zzw.a(leaderboardVariant2.m(), leaderboardVariant.m()) && zzw.a(leaderboardVariant2.l(), leaderboardVariant.l());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(LeaderboardVariant leaderboardVariant) {
        return zzw.a(leaderboardVariant).a("TimeSpan", TimeSpan.a(leaderboardVariant.b())).a("Collection", LeaderboardCollection.a(leaderboardVariant.c())).a("RawPlayerScore", leaderboardVariant.d() ? Long.valueOf(leaderboardVariant.e()) : "none").a("DisplayPlayerScore", leaderboardVariant.d() ? leaderboardVariant.f() : "none").a("PlayerRank", leaderboardVariant.d() ? Long.valueOf(leaderboardVariant.g()) : "none").a("DisplayPlayerRank", leaderboardVariant.d() ? leaderboardVariant.h() : "none").a("NumScores", Long.valueOf(leaderboardVariant.j())).a("TopPageNextToken", leaderboardVariant.k()).a("WindowPageNextToken", leaderboardVariant.m()).a("WindowPagePrevToken", leaderboardVariant.l()).toString();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public int b() {
        return this.f1383a;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public int c() {
        return this.b;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public boolean d() {
        return this.c;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public long e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public String f() {
        return this.e;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public long g() {
        return this.f;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public String h() {
        return this.g;
    }

    public int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public String i() {
        return this.h;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public long j() {
        return this.i;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public String k() {
        return this.j;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public String l() {
        return this.k;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public String m() {
        return this.l;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public LeaderboardVariant a() {
        return this;
    }

    public String toString() {
        return b(this);
    }
}
