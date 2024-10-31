package com.adobe.creativesdk.foundation.internal.analytics;

import com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams;

/* compiled from: AdobeAnalyticsETSAssetBrowserBaseEvent.java */
/* loaded from: classes.dex */
public abstract class a extends g {
    public a(String str, String str2) {
        super(str);
        this.f4730c.put(AdobeAnalyticsEventParams.Content.AdobeEventPropertyContentType.getValue(), str2);
        this.f4730c.put(AdobeAnalyticsEventParams.Environment.AdobeEventPropertyComponentName.getValue(), "asset_browser");
        this.f4730c.put(AdobeAnalyticsEventParams.Environment.AdobeEventPropertyComponentVersion.getValue(), c.a.a.a.a.d());
    }
}
