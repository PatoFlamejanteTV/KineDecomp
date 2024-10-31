package com.google.android.gms.games.leaderboard;

import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class LeaderboardEntity implements Leaderboard {

    /* renamed from: a, reason: collision with root package name */
    private final String f1381a;
    private final String b;
    private final Uri c;
    private final int d;
    private final ArrayList<LeaderboardVariantEntity> e;
    private final Game f;
    private final String g;

    public LeaderboardEntity(Leaderboard leaderboard) {
        this.f1381a = leaderboard.b();
        this.b = leaderboard.c();
        this.c = leaderboard.d();
        this.g = leaderboard.e();
        this.d = leaderboard.f();
        Game h = leaderboard.h();
        this.f = h == null ? null : new GameEntity(h);
        ArrayList<LeaderboardVariant> g = leaderboard.g();
        int size = g.size();
        this.e = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.e.add((LeaderboardVariantEntity) g.get(i).a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Leaderboard leaderboard) {
        return zzw.a(leaderboard.b(), leaderboard.c(), leaderboard.d(), Integer.valueOf(leaderboard.f()), leaderboard.g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Leaderboard leaderboard, Object obj) {
        if (!(obj instanceof Leaderboard)) {
            return false;
        }
        if (leaderboard == obj) {
            return true;
        }
        Leaderboard leaderboard2 = (Leaderboard) obj;
        return zzw.a(leaderboard2.b(), leaderboard.b()) && zzw.a(leaderboard2.c(), leaderboard.c()) && zzw.a(leaderboard2.d(), leaderboard.d()) && zzw.a(Integer.valueOf(leaderboard2.f()), Integer.valueOf(leaderboard.f())) && zzw.a(leaderboard2.g(), leaderboard.g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Leaderboard leaderboard) {
        return zzw.a(leaderboard).a("LeaderboardId", leaderboard.b()).a("DisplayName", leaderboard.c()).a("IconImageUri", leaderboard.d()).a("IconImageUrl", leaderboard.e()).a("ScoreOrder", Integer.valueOf(leaderboard.f())).a("Variants", leaderboard.g()).toString();
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public String b() {
        return this.f1381a;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public String c() {
        return this.b;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public Uri d() {
        return this.c;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public String e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public int f() {
        return this.d;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public ArrayList<LeaderboardVariant> g() {
        return new ArrayList<>(this.e);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public Game h() {
        return this.f;
    }

    public int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Leaderboard a() {
        return this;
    }

    public String toString() {
        return b(this);
    }
}
