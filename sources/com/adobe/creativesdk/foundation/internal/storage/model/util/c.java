package com.adobe.creativesdk.foundation.internal.storage.model.util;

import com.adobe.creativesdk.foundation.storage.C0578la;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import java.net.URI;

/* compiled from: AdobeStorageAssetFileUtils.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    public static final C0582ma f6621a = new C0582ma(0.0f, 0.0f);

    /* renamed from: b */
    public static final C0582ma f6622b = new C0582ma(250.0f, 0.0f);

    public static boolean a(C0578la c0578la) {
        String uri;
        URI href = c0578la.getHref();
        return (href == null || (uri = href.toString()) == null || !uri.equalsIgnoreCase("/files/")) ? false : true;
    }
}
