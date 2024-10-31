package org.koin.android.ext.koin;

import android.content.Context;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import org.koin.android.error.MissingAndroidContextException;

/* compiled from: ModuleExt.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final Context a(org.koin.core.scope.a aVar) {
        h.b(aVar, "$this$androidContext");
        try {
            return (Context) aVar.a(j.a(Context.class), (org.koin.core.e.a) null, (kotlin.jvm.a.a<org.koin.core.d.a>) null);
        } catch (Exception unused) {
            throw new MissingAndroidContextException("Can't resolve Context instance. Please use androidContext() function in your KoinApplication configuration.");
        }
    }
}
