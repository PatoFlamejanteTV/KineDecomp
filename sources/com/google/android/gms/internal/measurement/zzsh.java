package com.google.android.gms.internal.measurement;

import android.net.Uri;

/* loaded from: classes2.dex */
public final class zzsh {
    public static Uri zzfq(String str) {
        String valueOf = String.valueOf(Uri.encode(str));
        return Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/"));
    }
}
