package com.google.android.gms.games.multiplayer;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;

/* loaded from: classes.dex */
public interface Invitation extends Parcelable, Freezable<Invitation>, Participatable {
    Game d();

    String e();

    Participant f();

    long g();

    int h();

    int i();

    int j();
}
