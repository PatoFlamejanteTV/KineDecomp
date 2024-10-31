package g.a.b;

import kotlin.jvm.internal.h;
import kotlin.k;

/* compiled from: Module.kt */
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ org.koin.core.c.a a(boolean z, boolean z2, kotlin.jvm.a.b bVar, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        return a(z, z2, bVar);
    }

    public static final org.koin.core.c.a a(boolean z, boolean z2, kotlin.jvm.a.b<? super org.koin.core.c.a, k> bVar) {
        h.b(bVar, "moduleDeclaration");
        org.koin.core.c.a aVar = new org.koin.core.c.a(z, z2);
        bVar.invoke(aVar);
        return aVar;
    }
}
