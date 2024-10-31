package com.google.android.gms.games.leaderboard;

import android.net.Uri;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Player;

/* loaded from: classes.dex */
public interface LeaderboardScore extends Freezable<LeaderboardScore> {
    long b();

    String c();

    String d();

    long e();

    long f();

    String g();

    Uri h();

    @Deprecated
    String i();

    Uri j();

    @Deprecated
    String k();

    Player l();

    String m();
}
