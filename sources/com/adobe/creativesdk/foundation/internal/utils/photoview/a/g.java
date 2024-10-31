package com.adobe.creativesdk.foundation.internal.utils.photoview.a;

import android.content.Context;
import android.os.Build;

/* compiled from: VersionedGestureDetector.java */
/* loaded from: classes.dex */
public final class g {
    public static e a(Context context, f fVar) {
        e dVar;
        int i = Build.VERSION.SDK_INT;
        if (i < 5) {
            dVar = new a(context);
        } else if (i < 8) {
            dVar = new b(context);
        } else {
            dVar = new d(context);
        }
        dVar.a(fVar);
        return dVar;
    }
}
