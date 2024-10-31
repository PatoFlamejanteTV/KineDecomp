package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Player;

/* loaded from: classes.dex */
public interface Event extends Parcelable, Freezable<Event> {
    String b();

    String c();

    String d();

    Uri e();

    @Deprecated
    String f();

    Player g();

    long h();

    String i();

    boolean j();
}
