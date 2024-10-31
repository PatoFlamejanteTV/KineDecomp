package com.adobe.creativesdk.foundation.internal.analytics;

import com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams;

/* compiled from: AdobeAnalyticsETSAssetBrowserViewEvent.java */
/* loaded from: classes.dex */
public class c extends a {
    public c(String str, String str2) {
        super(AdobeAnalyticsEventParams.Type.AdobeEventTypeAppView.getValue(), str2);
        this.f4730c.put(AdobeAnalyticsEventParams.UI.AdobeEventPropertyUiViewType.getValue(), str);
    }
}
