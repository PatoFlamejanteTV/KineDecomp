package com.adobe.creativesdk.foundation.internal.analytics;

import com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams;

/* compiled from: AdobeAnalyticsETSLibraryEvent.java */
/* loaded from: classes.dex */
public class k extends e {
    public k(String str) {
        super(str);
        this.f4730c.put(AdobeAnalyticsEventParams.Environment.AdobeEventPropertyComponentName.getValue(), "asset_headless");
        this.f4730c.put(AdobeAnalyticsEventParams.Environment.AdobeEventPropertyComponentVersion.getValue(), c.a.a.a.a.d());
    }
}
