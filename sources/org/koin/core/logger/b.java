package org.koin.core.logger;

import android.support.v4.app.NotificationCompat;
import kotlin.jvm.internal.h;

/* compiled from: Logger.kt */
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a */
    private Level f29382a;

    public b(Level level) {
        h.b(level, "level");
        this.f29382a = level;
    }

    public final Level a() {
        return this.f29382a;
    }

    public abstract void a(Level level, String str);

    public final void b(String str) {
        h.b(str, NotificationCompat.CATEGORY_MESSAGE);
        a(Level.ERROR, str);
    }

    public final void c(String str) {
        h.b(str, NotificationCompat.CATEGORY_MESSAGE);
        a(Level.INFO, str);
    }

    public final void a(String str) {
        h.b(str, NotificationCompat.CATEGORY_MESSAGE);
        a(Level.DEBUG, str);
    }

    public final boolean a(Level level) {
        h.b(level, "lvl");
        return this.f29382a.compareTo(level) <= 0;
    }
}
