package kotlinx.coroutines;

import com.facebook.internal.ServerProtocol;
import kotlin.TypeCastException;

/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class aa extends kotlinx.coroutines.internal.i implements L {
    public final String a(String str) {
        kotlin.jvm.internal.h.b(str, ServerProtocol.DIALOG_PARAM_STATE);
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        Object b2 = b();
        if (b2 != null) {
            boolean z = true;
            for (kotlinx.coroutines.internal.k kVar = (kotlinx.coroutines.internal.k) b2; !kotlin.jvm.internal.h.a(kVar, this); kVar = kVar.c()) {
                if (kVar instanceof V) {
                    V v = (V) kVar;
                    if (z) {
                        z = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(v);
                }
            }
            sb.append("]");
            String sb2 = sb.toString();
            kotlin.jvm.internal.h.a((Object) sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    @Override // kotlinx.coroutines.L
    public aa a() {
        return this;
    }

    @Override // kotlinx.coroutines.L
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.k
    public String toString() {
        return a("Active");
    }
}
