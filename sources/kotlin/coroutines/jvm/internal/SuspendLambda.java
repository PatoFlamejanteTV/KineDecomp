package kotlin.coroutines.jvm.internal;

import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes3.dex */
public abstract class SuspendLambda extends ContinuationImpl implements kotlin.jvm.internal.g<Object>, g {
    private final int arity;

    public SuspendLambda(int i, kotlin.coroutines.b<Object> bVar) {
        super(bVar);
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.g
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public String toString() {
        if (getCompletion() == null) {
            String a2 = j.a(this);
            h.a((Object) a2, "Reflection.renderLambdaToString(this)");
            return a2;
        }
        return super.toString();
    }

    public SuspendLambda(int i) {
        this(i, null);
    }
}
