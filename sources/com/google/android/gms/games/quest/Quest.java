package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import java.util.List;

/* loaded from: classes.dex */
public interface Quest extends Parcelable, Freezable<Quest> {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f1394a = {1, 2, 3, 4, 6, 5};
    public static final String[] b = {Integer.toString(1), Integer.toString(2), Integer.toString(3)};

    String b();

    String c();

    String d();

    Uri e();

    @Deprecated
    String f();

    Uri g();

    @Deprecated
    String h();

    List<Milestone> i();

    Game j();

    int k();

    int l();

    long m();

    long n();

    long o();

    long p();

    long q();
}
