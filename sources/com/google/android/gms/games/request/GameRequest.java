package com.google.android.gms.games.request;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import java.util.List;

/* loaded from: classes.dex */
public interface GameRequest extends Parcelable, Freezable<GameRequest> {
    int a(String str);

    String d();

    Game e();

    Player f();

    byte[] h();

    int i();

    long j();

    long k();

    int l();

    List<Player> n();
}
