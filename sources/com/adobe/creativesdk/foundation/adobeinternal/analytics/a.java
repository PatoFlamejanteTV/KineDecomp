package com.adobe.creativesdk.foundation.adobeinternal.analytics;

import com.adobe.creativesdk.foundation.internal.analytics.g;

/* compiled from: AdobeAnalyticsEvent.java */
/* loaded from: classes.dex */
public class a extends g {
    public a(String str) {
        super(str);
    }

    public void a(AdobeAnalyticsEventParams adobeAnalyticsEventParams, String str) {
        this.f4730c.put(adobeAnalyticsEventParams.getValue(), str);
    }
}
