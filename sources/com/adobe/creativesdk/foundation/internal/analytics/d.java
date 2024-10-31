package com.adobe.creativesdk.foundation.internal.analytics;

import com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams;

/* compiled from: AdobeAnalyticsETSAssetFileEvent.java */
/* loaded from: classes.dex */
public class d extends e {
    public d(String str, String str2) {
        super(str);
        this.f4730c.put(AdobeAnalyticsEventParams.Environment.AdobeEventPropertyComponentName.getValue(), "asset_headless");
        this.f4730c.put(AdobeAnalyticsEventParams.Environment.AdobeEventPropertyComponentVersion.getValue(), c.a.a.a.a.d());
        this.f4730c.put(AdobeAnalyticsEventParams.Content.AdobeEventPropertyContentType.getValue(), str2);
    }
}
