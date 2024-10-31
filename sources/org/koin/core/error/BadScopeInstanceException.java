package org.koin.core.error;

import com.umeng.commonsdk.proguard.e;
import kotlin.jvm.internal.h;

/* compiled from: BadScopeInstanceException.kt */
/* loaded from: classes3.dex */
public final class BadScopeInstanceException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BadScopeInstanceException(String str) {
        super(str);
        h.b(str, e.ap);
    }
}
