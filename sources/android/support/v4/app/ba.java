package android.support.v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/* compiled from: TaskStackBuilderHoneycomb.java */
/* loaded from: classes.dex */
class ba {
    public static PendingIntent a(Context context, int i, Intent[] intentArr, int i2) {
        return PendingIntent.getActivities(context, i, intentArr, i2);
    }
}
