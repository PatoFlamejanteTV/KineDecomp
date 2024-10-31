package com.google.firebase.auth.internal;

import android.content.Context;
import com.google.android.gms.flags.Flag;
import com.google.android.gms.flags.FlagRegistry;
import com.google.android.gms.flags.Singletons;

/* loaded from: classes2.dex */
public final class zzy {

    /* renamed from: a */
    public static final Flag<Boolean> f16554a = Flag.a(0, "firebase_auth_proactive_token_refresh_enabled", (Boolean) true);

    public static final void a(Context context) {
        Singletons.a();
        FlagRegistry.a(context);
    }
}
