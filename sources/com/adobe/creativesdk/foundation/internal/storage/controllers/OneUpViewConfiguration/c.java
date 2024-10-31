package com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration;

import java.util.HashMap;

/* compiled from: AdobeOneUpViewerConfigurationFactory.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    private static int f5764a;

    /* renamed from: b */
    private static HashMap<Integer, d> f5765b = new HashMap<>();

    public static synchronized d a(int i) {
        d dVar;
        synchronized (c.class) {
            dVar = f5765b.get(Integer.valueOf(i));
        }
        return dVar;
    }

    public static synchronized int a(d dVar) {
        int i;
        synchronized (c.class) {
            f5764a++;
            f5765b.put(Integer.valueOf(f5764a), dVar);
            i = f5764a;
        }
        return i;
    }
}
