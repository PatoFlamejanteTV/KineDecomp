package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Player;

/* loaded from: classes.dex */
public interface Achievement extends Parcelable, Freezable<Achievement> {
    String b();

    int c();

    String d();

    String e();

    Uri f();

    @Deprecated
    String g();

    Uri h();

    @Deprecated
    String i();

    int j();

    String k();

    Player l();

    int m();

    int n();

    String o();

    long p();

    long q();
}
