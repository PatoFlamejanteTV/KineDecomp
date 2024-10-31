package com.adobe.creativesdk.foundation.internal.analytics;

import com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams;

/* compiled from: AdobeAnalyticsETSAuthEvent.java */
/* loaded from: classes.dex */
public class f extends g {
    public f(String str) {
        super(str);
    }

    @Override // com.adobe.creativesdk.foundation.internal.analytics.g
    public void a() {
        this.f4730c.put(AdobeAnalyticsEventParams.Environment.AdobeEventPropertyComponentName.getValue(), "auth");
        this.f4730c.put(AdobeAnalyticsEventParams.Environment.AdobeEventPropertyComponentVersion.getValue(), c.a.a.a.a.d());
        super.a();
    }
}
