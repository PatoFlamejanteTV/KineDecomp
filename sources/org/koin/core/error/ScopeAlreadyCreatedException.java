package org.koin.core.error;

import com.umeng.commonsdk.proguard.e;
import kotlin.jvm.internal.h;

/* compiled from: ScopeAlreadyCreatedException.kt */
/* loaded from: classes3.dex */
public final class ScopeAlreadyCreatedException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScopeAlreadyCreatedException(String str) {
        super(str);
        h.b(str, e.ap);
    }
}
