package com.nexstreaming.kinemaster.usage.analytics;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import com.facebook.internal.NativeProtocol;
import java.util.Map;

/* compiled from: Tracker.kt */
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a */
    public static final a f23920a = new a(null);

    /* compiled from: Tracker.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final Bundle a(Map<String, String> map) {
            kotlin.jvm.internal.h.b(map, NativeProtocol.WEB_DIALOG_PARAMS);
            Bundle bundle = new Bundle();
            for (String str : map.keySet()) {
                bundle.putString(str, map.get(str));
            }
            return bundle;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: Tracker.kt */
    /* loaded from: classes.dex */
    public interface b {
        void a(Context context, boolean z);
    }

    /* compiled from: Tracker.kt */
    /* loaded from: classes.dex */
    public interface c {
        void a(Context context);

        void b(Context context);
    }

    public final void a(Context context, String str, Map<String, String> map) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, NotificationCompat.CATEGORY_EVENT);
        kotlin.jvm.internal.h.b(map, NativeProtocol.WEB_DIALOG_PARAMS);
        if (c.d.b.c.a.d(context)) {
            b(context, str, map);
        }
    }

    public abstract void b(Context context, String str, Bundle bundle);

    public abstract void b(Context context, String str, String str2);

    public abstract void b(Context context, String str, Map<String, String> map);

    public final void a(Context context, String str, Bundle bundle) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, NotificationCompat.CATEGORY_EVENT);
        kotlin.jvm.internal.h.b(bundle, NativeProtocol.WEB_DIALOG_PARAMS);
        if (c.d.b.c.a.d(context)) {
            b(context, str, bundle);
        }
    }

    public final void a(Context context, String str, String str2) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, NotificationCompat.CATEGORY_EVENT);
        kotlin.jvm.internal.h.b(str2, "value");
        if (c.d.b.c.a.d(context)) {
            b(context, str, str2);
        }
    }
}
