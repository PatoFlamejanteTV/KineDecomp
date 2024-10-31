package com.crashlytics.android.beta;

import android.content.Context;
import io.fabric.sdk.android.a.c.c;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.m;
import io.fabric.sdk.android.services.network.f;
import io.fabric.sdk.android.services.settings.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public interface UpdatesController {
    void initialize(Context context, Beta beta, IdManager idManager, g gVar, BuildProperties buildProperties, c cVar, m mVar, f fVar);

    boolean isActivityLifecycleTriggered();
}
