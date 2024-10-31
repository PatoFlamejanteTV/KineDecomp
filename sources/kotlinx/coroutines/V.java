package kotlinx.coroutines;

import kotlin.TypeCastException;
import kotlinx.coroutines.P;

/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public abstract class V<J extends P> extends AbstractC2544m implements E, L {

    /* renamed from: d, reason: collision with root package name */
    public final J f28602d;

    public V(J j) {
        kotlin.jvm.internal.h.b(j, "job");
        this.f28602d = j;
    }

    @Override // kotlinx.coroutines.L
    public aa a() {
        return null;
    }

    @Override // kotlinx.coroutines.E
    public void dispose() {
        J j = this.f28602d;
        if (j == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
        }
        ((W) j).a((V<?>) this);
    }

    @Override // kotlinx.coroutines.L
    public boolean isActive() {
        return true;
    }
}
