package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Participatable;

/* loaded from: classes.dex */
public interface TurnBasedMatch extends Parcelable, Freezable<TurnBasedMatch>, Participatable {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f1391a = {0, 1, 2, 3};

    Game b();

    String c();

    String d();

    long e();

    int f();

    int g();

    String h();

    int i();

    String j();

    long k();

    String m();

    byte[] n();

    int o();

    String p();

    byte[] q();

    int r();

    Bundle s();

    int t();

    boolean u();

    String v();
}
