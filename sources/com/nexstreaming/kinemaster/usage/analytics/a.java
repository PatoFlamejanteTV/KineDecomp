package com.nexstreaming.kinemaster.usage.analytics;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.kinemaster.usage.analytics.k;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.text.n;

/* compiled from: AnalyticsManager.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f23904a;

    /* renamed from: b, reason: collision with root package name */
    public static final C0117a f23905b = new C0117a(null);

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<k> f23906c;

    /* renamed from: d, reason: collision with root package name */
    private final d f23907d;

    /* renamed from: e, reason: collision with root package name */
    private final c f23908e;

    /* renamed from: f, reason: collision with root package name */
    private final l f23909f;

    /* compiled from: AnalyticsManager.kt */
    /* renamed from: com.nexstreaming.kinemaster.usage.analytics.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0117a {
        private C0117a() {
        }

        public final a a() {
            if (a.f23904a == null) {
                a.f23904a = new a(null);
            }
            a aVar = a.f23904a;
            if (aVar != null) {
                return aVar;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.nexstreaming.kinemaster.usage.analytics.AnalyticsManager");
        }

        public /* synthetic */ C0117a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    private a() {
        this.f23906c = new ArrayList<>();
        this.f23907d = new d();
        this.f23908e = new c();
        this.f23909f = new l();
        this.f23906c.add(this.f23907d);
        this.f23906c.add(this.f23908e);
        if (c()) {
            this.f23906c.add(this.f23909f);
        }
    }

    private final boolean b() {
        return (n.b("release", "debug", true) || n.b("release", UMModuleRegister.INNER, true)) ? false : true;
    }

    private final boolean c() {
        return c.d.b.m.e.f3850a.a();
    }

    public final void d(Context context, String str, String str2) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, NotificationCompat.CATEGORY_EVENT);
        kotlin.jvm.internal.h.b(str2, "tag");
        if (b() && c()) {
            this.f23909f.a(context, str, str2);
        }
    }

    public final void d(Context context, String str, Map<String, String> map) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, NotificationCompat.CATEGORY_EVENT);
        kotlin.jvm.internal.h.b(map, NativeProtocol.WEB_DIALOG_PARAMS);
    }

    public final void e(Context context, String str, Map<String, String> map) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, NotificationCompat.CATEGORY_EVENT);
        kotlin.jvm.internal.h.b(map, NativeProtocol.WEB_DIALOG_PARAMS);
        if (b() && c()) {
            this.f23909f.a(context, str, map);
        }
    }

    public final void f(Context context, String str, Map<String, String> map) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, NotificationCompat.CATEGORY_EVENT);
        kotlin.jvm.internal.h.b(map, NativeProtocol.WEB_DIALOG_PARAMS);
        if (b()) {
            Iterator<k> it = this.f23906c.iterator();
            while (it.hasNext()) {
                it.next().a(context, str, map);
            }
        }
    }

    public final void c(Context context, String str, String str2) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, NotificationCompat.CATEGORY_EVENT);
        kotlin.jvm.internal.h.b(str2, "tag");
        if (b()) {
            this.f23907d.a(context, str, str2);
        }
    }

    public final void a(Context context, String str, Bundle bundle) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, NotificationCompat.CATEGORY_EVENT);
        kotlin.jvm.internal.h.b(bundle, NativeProtocol.WEB_DIALOG_PARAMS);
        if (b()) {
            this.f23907d.a(context, str, bundle);
        }
    }

    public final void b(Context context, String str, String str2) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, NotificationCompat.CATEGORY_EVENT);
        kotlin.jvm.internal.h.b(str2, "tag");
        if (b()) {
            HashMap hashMap = new HashMap();
            hashMap.put("value", str2);
            this.f23908e.a(context, str, hashMap);
        }
    }

    public final void c(Context context, String str, Map<String, String> map) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, NotificationCompat.CATEGORY_EVENT);
        kotlin.jvm.internal.h.b(map, NativeProtocol.WEB_DIALOG_PARAMS);
        if (b()) {
            this.f23907d.a(context, str, map);
        }
    }

    public final void a(Context context, String str, String str2) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, NotificationCompat.CATEGORY_EVENT);
        kotlin.jvm.internal.h.b(str2, "tag");
        if (b()) {
            Iterator<k> it = this.f23906c.iterator();
            while (it.hasNext()) {
                it.next().a(context, str, str2);
            }
        }
    }

    public final void b(Context context, String str, Map<String, String> map) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, NotificationCompat.CATEGORY_EVENT);
        kotlin.jvm.internal.h.b(map, NativeProtocol.WEB_DIALOG_PARAMS);
        if (b()) {
            this.f23908e.a(context, str, map);
        }
    }

    public final void a(Context context, String str, Map<String, String> map) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, NotificationCompat.CATEGORY_EVENT);
        kotlin.jvm.internal.h.b(map, NativeProtocol.WEB_DIALOG_PARAMS);
        if (b()) {
            Iterator<k> it = this.f23906c.iterator();
            while (it.hasNext()) {
                it.next().a(context, str, map);
            }
        }
    }

    public final void b(Context context) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        if (b()) {
            Iterator<k> it = this.f23906c.iterator();
            while (it.hasNext()) {
                Object obj = (k) it.next();
                if (obj != null) {
                    ((k.c) obj).a(context);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.nexstreaming.kinemaster.usage.analytics.Tracker.TrackerSession");
                }
            }
        }
    }

    public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
        this();
    }

    public final void a(Context context, boolean z) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        Iterator<k> it = this.f23906c.iterator();
        while (it.hasNext()) {
            Object obj = (k) it.next();
            if (obj != null) {
                Context applicationContext = context.getApplicationContext();
                kotlin.jvm.internal.h.a((Object) applicationContext, "context.applicationContext");
                ((k.b) obj).a(applicationContext, z);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.nexstreaming.kinemaster.usage.analytics.Tracker.TrackerInit");
            }
        }
    }

    public final void a(Context context) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        if (b()) {
            Iterator<k> it = this.f23906c.iterator();
            while (it.hasNext()) {
                Object obj = (k) it.next();
                if (obj != null) {
                    ((k.c) obj).b(context);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.nexstreaming.kinemaster.usage.analytics.Tracker.TrackerSession");
                }
            }
        }
    }
}
