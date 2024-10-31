package com.google.android.gms.games.internal.data;

import android.net.Uri;

/* loaded from: classes.dex */
public final class GamesDataChangeUris {
    private static final Uri c = Uri.parse("content://com.google.android.gms.games/").buildUpon().appendPath("data_change").build();

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f1371a = c.buildUpon().appendPath("invitations").build();
    public static final Uri b = c.buildUpon().appendEncodedPath("players").build();
}
