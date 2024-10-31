package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Player;

/* loaded from: classes.dex */
public interface Participant extends Parcelable, Freezable<Participant> {
    int b();

    String c();

    int d();

    boolean e();

    String f();

    Uri g();

    @Deprecated
    String h();

    Uri i();

    @Deprecated
    String j();

    String k();

    Player l();

    ParticipantResult m();
}
