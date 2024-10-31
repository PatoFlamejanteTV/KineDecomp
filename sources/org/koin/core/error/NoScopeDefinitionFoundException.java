package org.koin.core.error;

import com.umeng.commonsdk.proguard.e;
import kotlin.jvm.internal.h;

/* compiled from: NoScopeDefinitionFoundException.kt */
/* loaded from: classes3.dex */
public final class NoScopeDefinitionFoundException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoScopeDefinitionFoundException(String str) {
        super(str);
        h.b(str, e.ap);
    }
}
