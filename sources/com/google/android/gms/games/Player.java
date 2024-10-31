package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;

/* loaded from: classes.dex */
public interface Player extends Parcelable, Freezable<Player> {
    String b();

    String c();

    String d();

    String e();

    boolean f();

    Uri g();

    @Deprecated
    String h();

    Uri i();

    @Deprecated
    String j();

    long k();

    long l();

    int m();

    boolean n();

    String o();

    PlayerLevelInfo p();

    MostRecentGameInfo q();
}
