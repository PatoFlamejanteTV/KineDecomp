package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.e;
import kotlin.jvm.internal.h;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes3.dex */
public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final kotlin.coroutines.e _context;

    /* renamed from: a, reason: collision with root package name */
    private transient kotlin.coroutines.b<Object> f28516a;

    public ContinuationImpl(kotlin.coroutines.b<Object> bVar, kotlin.coroutines.e eVar) {
        super(bVar);
        this._context = eVar;
    }

    @Override // kotlin.coroutines.b
    public kotlin.coroutines.e getContext() {
        kotlin.coroutines.e eVar = this._context;
        if (eVar != null) {
            return eVar;
        }
        h.a();
        throw null;
    }

    public final kotlin.coroutines.b<Object> intercepted() {
        kotlin.coroutines.b<Object> bVar = this.f28516a;
        if (bVar == null) {
            kotlin.coroutines.c cVar = (kotlin.coroutines.c) getContext().get(kotlin.coroutines.c.f28514c);
            if (cVar == null || (bVar = cVar.b(this)) == null) {
                bVar = this;
            }
            this.f28516a = bVar;
        }
        return bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    protected void releaseIntercepted() {
        kotlin.coroutines.b<?> bVar = this.f28516a;
        if (bVar != null && bVar != this) {
            e.b bVar2 = getContext().get(kotlin.coroutines.c.f28514c);
            if (bVar2 == null) {
                h.a();
                throw null;
            }
            ((kotlin.coroutines.c) bVar2).a(bVar);
        }
        this.f28516a = a.f28517a;
    }

    public ContinuationImpl(kotlin.coroutines.b<Object> bVar) {
        this(bVar, bVar != null ? bVar.getContext() : null);
    }
}
