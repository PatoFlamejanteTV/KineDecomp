package com.google.android.gms.appinvite;

import android.content.Intent;

@Deprecated
/* loaded from: classes.dex */
public class AppInviteReferral {
    private AppInviteReferral() {
    }

    public static boolean a(Intent intent) {
        return (intent == null || intent.getBundleExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE") == null) ? false : true;
    }
}
