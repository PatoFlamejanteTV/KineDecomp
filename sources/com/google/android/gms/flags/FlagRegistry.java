package com.google.android.gms.flags;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.flags.Flag;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public class FlagRegistry {

    /* renamed from: a */
    private final Collection<Flag> f11336a = new ArrayList();

    /* renamed from: b */
    private final Collection<Flag.StringFlag> f11337b = new ArrayList();

    /* renamed from: c */
    private final Collection<Flag.StringFlag> f11338c = new ArrayList();

    public final void a(Flag flag) {
        this.f11336a.add(flag);
    }

    @KeepForSdk
    public static void a(Context context) {
        Singletons.b().a(context);
    }
}
