package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

@KeepForSdk
/* loaded from: classes.dex */
public class ListenerHolders {

    /* renamed from: a */
    private final Set<ListenerHolder<?>> f10781a = Collections.newSetFromMap(new WeakHashMap());

    public final void a() {
        Iterator<ListenerHolder<?>> it = this.f10781a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f10781a.clear();
    }

    @KeepForSdk
    public static <L> ListenerHolder<L> a(L l, Looper looper, String str) {
        Preconditions.a(l, "Listener must not be null");
        Preconditions.a(looper, "Looper must not be null");
        Preconditions.a(str, (Object) "Listener type must not be null");
        return new ListenerHolder<>(looper, l, str);
    }
}
