package com.squareup.okhttp.a;

import com.squareup.okhttp.J;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: RouteDatabase.java */
/* loaded from: classes3.dex */
public final class m {

    /* renamed from: a */
    private final Set<J> f25214a = new LinkedHashSet();

    public synchronized void a(J j) {
        this.f25214a.remove(j);
    }

    public synchronized void b(J j) {
        this.f25214a.add(j);
    }

    public synchronized boolean c(J j) {
        return this.f25214a.contains(j);
    }
}
