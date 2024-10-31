package com.crashlytics.android.answers;

import com.crashlytics.android.answers.SessionEvent;
import io.fabric.sdk.android.a.b.f;
import io.fabric.sdk.android.services.settings.b;

/* loaded from: classes.dex */
interface SessionAnalyticsManagerStrategy extends f {
    void deleteAllEvents();

    void processEvent(SessionEvent.Builder builder);

    void sendEvents();

    void setAnalyticsSettingsData(b bVar, String str);
}
