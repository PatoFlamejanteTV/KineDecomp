package com.google.android.gms.games.leaderboard;

import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class LeaderboardRef extends zzc implements Leaderboard {
    private final int c;
    private final Game d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LeaderboardRef(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.c = i2;
        this.d = new GameRef(dataHolder, i);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public String b() {
        return e("external_leaderboard_id");
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public String c() {
        return e("name");
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public Uri d() {
        return h("board_icon_image_uri");
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public String e() {
        return e("board_icon_image_url");
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return LeaderboardEntity.a(this, obj);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public int f() {
        return c("score_order");
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public ArrayList<LeaderboardVariant> g() {
        ArrayList<LeaderboardVariant> arrayList = new ArrayList<>(this.c);
        for (int i = 0; i < this.c; i++) {
            arrayList.add(new LeaderboardVariantRef(this.a_, this.b_ + i));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public Game h() {
        return this.d;
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return LeaderboardEntity.a(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Leaderboard a() {
        return new LeaderboardEntity(this);
    }

    public String toString() {
        return LeaderboardEntity.b(this);
    }
}
