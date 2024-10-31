package com.nexstreaming.kinemaster.usage.analytics;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.nexstreaming.kinemaster.usage.analytics.k;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.n;

/* compiled from: FirebaseTracker.kt */
/* loaded from: classes.dex */
public final class d extends k implements k.b, k.c {

    /* renamed from: b, reason: collision with root package name */
    public static final a f23910b = new a(null);

    /* compiled from: FirebaseTracker.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public final void a(Context context, String str, String str2) {
            kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
            kotlin.jvm.internal.h.b(str, "property");
            if (c.d.b.c.a.d(context)) {
                FirebaseAnalytics.getInstance(context).a(n.a(str, " ", "", false, 4, (Object) null), str2);
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final void a(Context context, boolean z) {
            kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
            FirebaseAnalytics.getInstance(context).a(z);
        }
    }

    @Override // com.nexstreaming.kinemaster.usage.analytics.k.c
    public void a(Context context) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
    }

    @Override // com.nexstreaming.kinemaster.usage.analytics.k.b
    public void a(Context context, boolean z) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        if (z) {
            f23910b.a(context, c.d.b.c.a.d(context));
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
        FirebaseAnalytics.getInstance(context).a(str, k.f23920a.a(map));
    }

    @Override // com.nexstreaming.kinemaster.usage.analytics.k
    public void b(Context context, String str, Bundle bundle) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, NotificationCompat.CATEGORY_EVENT);
        kotlin.jvm.internal.h.b(bundle, NativeProtocol.WEB_DIALOG_PARAMS);
        FirebaseAnalytics.getInstance(context).a(str, bundle);
    }

    @Override // com.nexstreaming.kinemaster.usage.analytics.k
    public void b(Context context, String str, String str2) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, NotificationCompat.CATEGORY_EVENT);
        kotlin.jvm.internal.h.b(str2, "value");
        HashMap hashMap = new HashMap();
        hashMap.put(str2, str2);
        FirebaseAnalytics.getInstance(context).a(str, k.f23920a.a(hashMap));
    }
}
