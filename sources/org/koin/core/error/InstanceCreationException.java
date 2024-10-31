package org.koin.core.error;

import android.support.v4.app.NotificationCompat;
import kotlin.jvm.internal.h;

/* compiled from: InstanceCreationException.kt */
/* loaded from: classes3.dex */
public final class InstanceCreationException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstanceCreationException(String str, Exception exc) {
        super(str, exc);
        h.b(str, NotificationCompat.CATEGORY_MESSAGE);
        h.b(exc, "parent");
    }
}
