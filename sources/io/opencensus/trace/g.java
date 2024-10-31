package io.opencensus.trace;

import io.opencensus.trace.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: EndSpanOptions.java */
@Immutable
/* loaded from: classes3.dex */
public abstract class g {

    /* renamed from: a */
    public static final g f28073a = a().a();

    /* compiled from: EndSpanOptions.java */
    /* loaded from: classes3.dex */
    public static abstract class a {
        public abstract a a(Status status);

        public abstract a a(boolean z);

        public abstract g a();
    }

    public static a a() {
        b.a aVar = new b.a();
        aVar.a(false);
        return aVar;
    }

    public abstract boolean b();

    @Nullable
    public abstract Status c();
}
