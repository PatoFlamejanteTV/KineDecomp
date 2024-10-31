package com.adobe.creativesdk.foundation.internal.analytics;

import com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;

/* compiled from: AdobeAnalyticsETSAssetsBaseEvent.java */
/* loaded from: classes.dex */
public class e extends g {
    public e(String str) {
        super(str);
    }

    public void a(AdobeCloud adobeCloud) {
        this.f4730c.put(AdobeAnalyticsEventParams.Core.AdobeEventPropertyCloud.getValue(), adobeCloud.getHref());
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        this.f4730c.put(AdobeAnalyticsEventParams.Content.AdobeEventPropertyContentId.getValue(), str);
        this.f4730c.put(AdobeAnalyticsEventParams.Content.AdobeEventPropertyContentName.getValue(), str2);
        this.f4730c.put(AdobeAnalyticsEventParams.Content.AdobeEventPropertyContentExtension.getValue(), str3);
        this.f4730c.put(AdobeAnalyticsEventParams.Content.AdobeEventPropertyContentType.getValue(), str4);
        this.f4730c.put(AdobeAnalyticsEventParams.Content.AdobeEventPropertyContentSize.getValue(), str5);
    }
}
