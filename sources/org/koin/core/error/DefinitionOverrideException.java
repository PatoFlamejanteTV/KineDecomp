package org.koin.core.error;

import android.support.v4.app.NotificationCompat;
import kotlin.jvm.internal.h;

/* compiled from: DefinitionOverrideException.kt */
/* loaded from: classes3.dex */
public final class DefinitionOverrideException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefinitionOverrideException(String str) {
        super(str);
        h.b(str, NotificationCompat.CATEGORY_MESSAGE);
    }
}
