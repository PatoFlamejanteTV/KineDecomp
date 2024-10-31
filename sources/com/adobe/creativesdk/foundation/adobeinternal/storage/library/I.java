package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.La;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na;
import com.adobe.creativesdk.foundation.storage.C0622wb;

/* compiled from: AdobeLibraryMutableElement.java */
/* loaded from: classes.dex */
public class I extends C0622wb {

    /* renamed from: b, reason: collision with root package name */
    La f4522b;

    public I(La la) {
        super(la);
        this.f4522b = null;
        this.f4522b = la;
    }

    public Object k() {
        throw null;
    }

    public void l() {
        if (k() instanceof La) {
            ((La) k()).a(Long.valueOf(ia.a()), "library#modified");
        } else if (k() instanceof Na) {
            ((Na) k()).a(Long.valueOf(ia.a()), "library#modified");
        }
    }

    public void m() {
        ((Na) k()).a(Long.valueOf(ia.a()), "library#removed");
    }
}
