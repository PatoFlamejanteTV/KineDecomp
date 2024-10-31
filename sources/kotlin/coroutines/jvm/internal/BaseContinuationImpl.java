package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Result;
import kotlin.jvm.internal.h;
import kotlin.k;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes3.dex */
public abstract class BaseContinuationImpl implements kotlin.coroutines.b<Object>, b, Serializable {
    private final kotlin.coroutines.b<Object> completion;

    public BaseContinuationImpl(kotlin.coroutines.b<Object> bVar) {
        this.completion = bVar;
    }

    public kotlin.coroutines.b<k> create(kotlin.coroutines.b<?> bVar) {
        h.b(bVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // kotlin.coroutines.jvm.internal.b
    public b getCallerFrame() {
        kotlin.coroutines.b<Object> bVar = this.completion;
        if (!(bVar instanceof b)) {
            bVar = null;
        }
        return (b) bVar;
    }

    public final kotlin.coroutines.b<Object> getCompletion() {
        return this.completion;
    }

    @Override // kotlin.coroutines.jvm.internal.b
    public StackTraceElement getStackTraceElement() {
        return d.a(this);
    }

    protected abstract Object invokeSuspend(Object obj);

    protected void releaseIntercepted() {
    }

    @Override // kotlin.coroutines.b
    public final void resumeWith(Object obj) {
        Object a2;
        Object obj2 = obj;
        BaseContinuationImpl baseContinuationImpl = this;
        while (true) {
            e.b(baseContinuationImpl);
            kotlin.coroutines.b<Object> bVar = baseContinuationImpl.completion;
            if (bVar != null) {
                try {
                    obj2 = baseContinuationImpl.invokeSuspend(obj2);
                    a2 = kotlin.coroutines.intrinsics.c.a();
                } catch (Throwable th) {
                    Result.a aVar = Result.Companion;
                    obj2 = kotlin.h.a(th);
                    Result.m23constructorimpl(obj2);
                }
                if (obj2 == a2) {
                    return;
                }
                Result.a aVar2 = Result.Companion;
                Result.m23constructorimpl(obj2);
                baseContinuationImpl.releaseIntercepted();
                if (bVar instanceof BaseContinuationImpl) {
                    baseContinuationImpl = (BaseContinuationImpl) bVar;
                } else {
                    bVar.resumeWith(obj2);
                    return;
                }
            } else {
                h.a();
                throw null;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public kotlin.coroutines.b<k> create(Object obj, kotlin.coroutines.b<?> bVar) {
        h.b(bVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
