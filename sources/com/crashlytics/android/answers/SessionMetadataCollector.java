package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public class SessionMetadataCollector {
    private final Context context;
    private final IdManager idManager;
    private final String versionCode;
    private final String versionName;

    public SessionMetadataCollector(Context context, IdManager idManager, String str, String str2) {
        this.context = context;
        this.idManager = idManager;
        this.versionCode = str;
        this.versionName = str2;
    }

    public SessionEventMetadata getMetadata() {
        Map<IdManager.DeviceIdentifierType, String> g2 = this.idManager.g();
        return new SessionEventMetadata(this.idManager.e(), UUID.randomUUID().toString(), this.idManager.f(), g2.get(IdManager.DeviceIdentifierType.ANDROID_ID), g2.get(IdManager.DeviceIdentifierType.ANDROID_ADVERTISING_ID), this.idManager.m(), g2.get(IdManager.DeviceIdentifierType.FONT_TOKEN), CommonUtils.n(this.context), this.idManager.l(), this.idManager.i(), this.versionCode, this.versionName);
    }
}
