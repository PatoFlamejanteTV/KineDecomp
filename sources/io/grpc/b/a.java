package io.grpc.b;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.DoNotMock;
import io.grpc.AbstractC2407f;
import io.grpc.C2406e;
import io.grpc.b.a;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: AbstractStub.java */
@DoNotMock
@ThreadSafe
/* loaded from: classes3.dex */
public abstract class a<S extends a<S>> {

    /* renamed from: a */
    private final AbstractC2407f f27160a;

    /* renamed from: b */
    private final C2406e f27161b;

    public a(AbstractC2407f abstractC2407f) {
        this(abstractC2407f, C2406e.f27183a);
    }

    public final C2406e a() {
        return this.f27161b;
    }

    public final AbstractC2407f b() {
        return this.f27160a;
    }

    protected a(AbstractC2407f abstractC2407f, C2406e c2406e) {
        Preconditions.a(abstractC2407f, "channel");
        this.f27160a = abstractC2407f;
        Preconditions.a(c2406e, "callOptions");
        this.f27161b = c2406e;
    }
}
