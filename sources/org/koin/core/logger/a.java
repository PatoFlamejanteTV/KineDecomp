package org.koin.core.logger;

import android.support.v4.app.NotificationCompat;
import kotlin.jvm.internal.h;

/* compiled from: EmptyLogger.kt */
/* loaded from: classes3.dex */
public final class a extends b {
    public a() {
        super(Level.ERROR);
    }

    @Override // org.koin.core.logger.b
    public void a(Level level, String str) {
        h.b(level, "level");
        h.b(str, NotificationCompat.CATEGORY_MESSAGE);
    }
}
