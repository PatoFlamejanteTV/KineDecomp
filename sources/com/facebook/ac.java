package com.facebook;

import android.content.Intent;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;

/* compiled from: ProfileManager.java */
/* loaded from: classes.dex */
public final class ac {

    /* renamed from: a */
    private static volatile ac f240a;
    private final android.support.v4.a.f b;
    private final ab c;
    private Profile d;

    ac(android.support.v4.a.f fVar, ab abVar) {
        Validate.notNull(fVar, "localBroadcastManager");
        Validate.notNull(abVar, "profileCache");
        this.b = fVar;
        this.c = abVar;
    }

    public static ac a() {
        if (f240a == null) {
            synchronized (ac.class) {
                if (f240a == null) {
                    f240a = new ac(android.support.v4.a.f.a(FacebookSdk.getApplicationContext()), new ab());
                }
            }
        }
        return f240a;
    }

    public Profile b() {
        return this.d;
    }

    public boolean c() {
        Profile a2 = this.c.a();
        if (a2 == null) {
            return false;
        }
        a(a2, false);
        return true;
    }

    public void a(Profile profile) {
        a(profile, true);
    }

    private void a(Profile profile, boolean z) {
        Profile profile2 = this.d;
        this.d = profile;
        if (z) {
            if (profile != null) {
                this.c.a(profile);
            } else {
                this.c.b();
            }
        }
        if (!Utility.areObjectsEqual(profile2, profile)) {
            a(profile2, profile);
        }
    }

    private void a(Profile profile, Profile profile2) {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", profile);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", profile2);
        this.b.a(intent);
    }
}
