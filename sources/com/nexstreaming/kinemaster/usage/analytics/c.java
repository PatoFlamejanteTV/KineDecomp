package com.nexstreaming.kinemaster.usage.analytics;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.CustomEvent;
import com.crashlytics.android.core.CrashlyticsCore;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.kinemaster.usage.analytics.k;
import io.fabric.sdk.android.f;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FabricTracker.kt */
/* loaded from: classes2.dex */
public final class c extends k implements k.b, k.c {
    @Override // com.nexstreaming.kinemaster.usage.analytics.k.c
    public void a(Context context) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
    }

    @Override // com.nexstreaming.kinemaster.usage.analytics.k.b
    public void a(Context context, boolean z) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        if (z) {
            Crashlytics build = new Crashlytics.Builder().core(new CrashlyticsCore.Builder().disabled(false).build()).build();
            f.a aVar = new f.a(context);
            aVar.a(build);
            aVar.a(false);
            io.fabric.sdk.android.f.c(aVar.a());
        }
    }

    @Override // com.nexstreaming.kinemaster.usage.analytics.k.c
    public void b(Context context) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
    }

    @Override // com.nexstreaming.kinemaster.usage.analytics.k
    public void b(Context context, String str, Map<String, String> map) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, NotificationCompat.CATEGORY_EVENT);
        kotlin.jvm.internal.h.b(map, NativeProtocol.WEB_DIALOG_PARAMS);
        CustomEvent customEvent = new CustomEvent(str);
        if (!map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                customEvent.putCustomAttribute(entry.getKey(), entry.getValue());
            }
        }
        Answers.getInstance().logCustom(customEvent);
        Log.d("Fabric", customEvent.toString());
    }

    @Override // com.nexstreaming.kinemaster.usage.analytics.k
    public void b(Context context, String str, String str2) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, NotificationCompat.CATEGORY_EVENT);
        kotlin.jvm.internal.h.b(str2, "value");
        HashMap hashMap = new HashMap();
        hashMap.put("value", str2);
        b(context, str, hashMap);
    }

    @Override // com.nexstreaming.kinemaster.usage.analytics.k
    public void b(Context context, String str, Bundle bundle) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, NotificationCompat.CATEGORY_EVENT);
        kotlin.jvm.internal.h.b(bundle, NativeProtocol.WEB_DIALOG_PARAMS);
        throw new IllegalArgumentException("can not access params");
    }
}
