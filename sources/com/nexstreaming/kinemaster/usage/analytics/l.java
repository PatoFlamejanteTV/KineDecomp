package com.nexstreaming.kinemaster.usage.analytics;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.kinemaster.usage.analytics.k;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import java.util.Map;

/* compiled from: UmengTracker.kt */
/* loaded from: classes2.dex */
public final class l extends k implements k.b, k.c {
    @Override // com.nexstreaming.kinemaster.usage.analytics.k.b
    public void a(Context context, boolean z) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        UMConfigure.init(context, "59efe79d8f4a9d4f58000090", "googlePlay", 1, null);
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);
    }

    @Override // com.nexstreaming.kinemaster.usage.analytics.k
    public void b(Context context, String str, Map<String, String> map) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, NotificationCompat.CATEGORY_EVENT);
        kotlin.jvm.internal.h.b(map, NativeProtocol.WEB_DIALOG_PARAMS);
        if (UMConfigure.getInitStatus()) {
            MobclickAgent.onEvent(context, str, map);
        }
    }

    @Override // com.nexstreaming.kinemaster.usage.analytics.k
    public void b(Context context, String str, Bundle bundle) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, NotificationCompat.CATEGORY_EVENT);
        kotlin.jvm.internal.h.b(bundle, NativeProtocol.WEB_DIALOG_PARAMS);
        throw new IllegalArgumentException("UmengTracker don't support this operation");
    }

    @Override // com.nexstreaming.kinemaster.usage.analytics.k.c
    public void a(Context context) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        if (UMConfigure.getInitStatus()) {
            MobclickAgent.onPause(context);
        }
    }

    @Override // com.nexstreaming.kinemaster.usage.analytics.k
    public void b(Context context, String str, String str2) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, NotificationCompat.CATEGORY_EVENT);
        kotlin.jvm.internal.h.b(str2, "value");
        if (UMConfigure.getInitStatus()) {
            MobclickAgent.onEvent(context, str, str2);
        }
    }

    @Override // com.nexstreaming.kinemaster.usage.analytics.k.c
    public void b(Context context) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        if (UMConfigure.getInitStatus()) {
            MobclickAgent.onResume(context);
        }
    }
}
