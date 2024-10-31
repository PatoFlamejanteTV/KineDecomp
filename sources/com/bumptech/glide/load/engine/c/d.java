package com.bumptech.glide.load.engine.c;

import android.util.Log;
import com.bumptech.glide.load.engine.c.b;

/* compiled from: GlideExecutor.java */
/* loaded from: classes.dex */
class d implements b.InterfaceC0056b {
    @Override // com.bumptech.glide.load.engine.c.b.InterfaceC0056b
    public void a(Throwable th) {
        if (th == null || !Log.isLoggable("GlideExecutor", 6)) {
            return;
        }
        Log.e("GlideExecutor", "Request threw uncaught throwable", th);
    }
}
