package org.koin.android.error;

import com.umeng.commonsdk.proguard.e;
import kotlin.jvm.internal.h;

/* compiled from: MissingAndroidContextException.kt */
/* loaded from: classes3.dex */
public final class MissingAndroidContextException extends Throwable {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MissingAndroidContextException(String str) {
        super(str);
        h.b(str, e.ap);
    }
}
