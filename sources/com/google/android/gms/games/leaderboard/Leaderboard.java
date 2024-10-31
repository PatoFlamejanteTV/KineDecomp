package com.google.android.gms.games.leaderboard;

import android.net.Uri;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import java.util.ArrayList;

/* loaded from: classes.dex */
public interface Leaderboard extends Freezable<Leaderboard> {
    String b();

    String c();

    Uri d();

    @Deprecated
    String e();

    int f();

    ArrayList<LeaderboardVariant> g();

    Game h();
}
