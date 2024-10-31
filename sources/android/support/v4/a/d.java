package android.support.v4.a;

import android.content.ComponentName;
import android.content.Intent;

/* compiled from: IntentCompatHoneycomb.java */
/* loaded from: classes.dex */
class d {
    public static Intent a(ComponentName componentName) {
        return Intent.makeMainActivity(componentName);
    }

    public static Intent b(ComponentName componentName) {
        return Intent.makeRestartActivityTask(componentName);
    }
}
