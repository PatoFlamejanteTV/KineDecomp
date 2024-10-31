package g.a.a.a.a;

import android.content.ComponentCallbacks;
import kotlin.jvm.internal.h;
import org.koin.core.c;

/* compiled from: ComponentCallbackExt.kt */
/* loaded from: classes.dex */
public final class a {
    public static final org.koin.core.a a(ComponentCallbacks componentCallbacks) {
        h.b(componentCallbacks, "$this$getKoin");
        return componentCallbacks instanceof c ? ((c) componentCallbacks).a() : org.koin.core.a.a.a().c();
    }
}
