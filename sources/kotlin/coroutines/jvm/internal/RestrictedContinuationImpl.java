package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.EmptyCoroutineContext;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes3.dex */
public abstract class RestrictedContinuationImpl extends BaseContinuationImpl {
    public RestrictedContinuationImpl(kotlin.coroutines.b<Object> bVar) {
        super(bVar);
        if (bVar != null) {
            if (!(bVar.getContext() == EmptyCoroutineContext.INSTANCE)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
            }
        }
    }

    @Override // kotlin.coroutines.b
    public kotlin.coroutines.e getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }
}
