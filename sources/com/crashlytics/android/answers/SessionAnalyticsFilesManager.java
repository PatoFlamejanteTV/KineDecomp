package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.a.b.c;
import io.fabric.sdk.android.a.b.d;
import io.fabric.sdk.android.services.common.m;
import io.fabric.sdk.android.services.settings.b;
import java.io.IOException;
import java.util.UUID;

/* loaded from: classes.dex */
class SessionAnalyticsFilesManager extends c<SessionEvent> {
    private static final String SESSION_ANALYTICS_TO_SEND_FILE_EXTENSION = ".tap";
    private static final String SESSION_ANALYTICS_TO_SEND_FILE_PREFIX = "sa";
    private b analyticsSettingsData;

    public SessionAnalyticsFilesManager(Context context, SessionEventTransform sessionEventTransform, m mVar, d dVar) throws IOException {
        super(context, sessionEventTransform, mVar, dVar, 100);
    }

    @Override // io.fabric.sdk.android.a.b.c
    protected String generateUniqueRollOverFileName() {
        return SESSION_ANALYTICS_TO_SEND_FILE_PREFIX + c.ROLL_OVER_FILE_NAME_SEPARATOR + UUID.randomUUID().toString() + c.ROLL_OVER_FILE_NAME_SEPARATOR + this.currentTimeProvider.a() + SESSION_ANALYTICS_TO_SEND_FILE_EXTENSION;
    }

    @Override // io.fabric.sdk.android.a.b.c
    public int getMaxByteSizePerFile() {
        b bVar = this.analyticsSettingsData;
        return bVar == null ? super.getMaxByteSizePerFile() : bVar.f26993c;
    }

    @Override // io.fabric.sdk.android.a.b.c
    public int getMaxFilesToKeep() {
        b bVar = this.analyticsSettingsData;
        return bVar == null ? super.getMaxFilesToKeep() : bVar.f26995e;
    }

    public void setAnalyticsSettingsData(b bVar) {
        this.analyticsSettingsData = bVar;
    }
}
