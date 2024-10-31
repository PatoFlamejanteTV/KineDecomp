package com.bumptech.glide.load.engine.c;

import com.bumptech.glide.load.engine.c.b;

/* compiled from: GlideExecutor.java */
/* loaded from: classes.dex */
class e implements b.InterfaceC0056b {
    @Override // com.bumptech.glide.load.engine.c.b.InterfaceC0056b
    public void a(Throwable th) {
        if (th != null) {
            throw new RuntimeException("Request threw uncaught throwable", th);
        }
    }
}
