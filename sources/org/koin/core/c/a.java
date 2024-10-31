package org.koin.core.c;

import java.util.ArrayList;
import kotlin.jvm.internal.h;
import org.koin.core.definition.b;
import org.koin.core.definition.d;

/* compiled from: Module.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a */
    private final ArrayList<b<?>> f29355a = new ArrayList<>();

    /* renamed from: b */
    private final ArrayList<g.a.b.b> f29356b = new ArrayList<>();

    /* renamed from: c */
    private final boolean f29357c;

    /* renamed from: d */
    private final boolean f29358d;

    public a(boolean z, boolean z2) {
        this.f29357c = z;
        this.f29358d = z2;
    }

    public final ArrayList<b<?>> a() {
        return this.f29355a;
    }

    public final ArrayList<g.a.b.b> b() {
        return this.f29356b;
    }

    private final void b(b<?> bVar, d dVar) {
        bVar.c().a(dVar.b() || this.f29357c);
        bVar.c().b(dVar.a() || this.f29358d);
    }

    public final <T> void a(b<T> bVar, d dVar) {
        h.b(bVar, "definition");
        h.b(dVar, "options");
        b(bVar, dVar);
        this.f29355a.add(bVar);
    }
}
