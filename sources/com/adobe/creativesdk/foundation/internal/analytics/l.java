package com.adobe.creativesdk.foundation.internal.analytics;

import com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams;
import com.facebook.internal.AnalyticsEvents;

/* compiled from: AdobeAnalyticsETSPhotoEvent.java */
/* loaded from: classes.dex */
public class l extends e {
    public l(String str) {
        super(str);
        this.f4730c.put(AdobeAnalyticsEventParams.Environment.AdobeEventPropertyComponentName.getValue(), "asset_headless");
        this.f4730c.put(AdobeAnalyticsEventParams.Environment.AdobeEventPropertyComponentVersion.getValue(), c.a.a.a.a.d());
        this.f4730c.put(AdobeAnalyticsEventParams.Content.AdobeEventPropertyContentType.getValue(), AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
    }
}
