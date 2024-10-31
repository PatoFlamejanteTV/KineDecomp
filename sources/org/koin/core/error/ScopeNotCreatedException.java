package org.koin.core.error;

import android.support.v4.app.NotificationCompat;
import kotlin.jvm.internal.h;

/* compiled from: ScopeNotCreatedException.kt */
/* loaded from: classes3.dex */
public final class ScopeNotCreatedException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScopeNotCreatedException(String str) {
        super(str);
        h.b(str, NotificationCompat.CATEGORY_MESSAGE);
    }
}
