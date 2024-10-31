package com.adobe.creativesdk.foundation.internal.cache;

import android.util.LruCache;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: AdobeMemCache.java */
/* loaded from: classes.dex */
public class p extends LruCache<String, Object> {
    public p(int i) {
        super(i);
    }

    @Override // android.util.LruCache
    /* renamed from: a */
    public void entryRemoved(boolean z, String str, Object obj, Object obj2) {
        super.entryRemoved(z, str, obj, obj2);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, p.class.getName(), "Removing entry " + str + " from mem cache.");
    }
}
