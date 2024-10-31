package kotlinx.coroutines;

import kotlinx.coroutines.P;

/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public abstract class Q<J extends P> extends V<J> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q(J j) {
        super(j);
        kotlin.jvm.internal.h.b(j, "job");
    }
}
