package com.bumptech.glide.load.engine.b;

import android.content.Context;

/* compiled from: InternalCacheDiskCacheFactory.java */
/* loaded from: classes.dex */
public final class g extends d {
    public g(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public g(Context context, String str, long j) {
        super(new f(context, str), j);
    }
}
