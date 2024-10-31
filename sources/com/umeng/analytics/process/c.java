package com.umeng.analytics.process;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: UMProcessDBManager.java */
/* loaded from: classes3.dex */
class c {

    /* renamed from: a */
    private static c f26019a;

    /* renamed from: b */
    private ConcurrentHashMap<String, a> f26020b = new ConcurrentHashMap<>();

    /* renamed from: c */
    private Context f26021c;

    private c() {
    }

    public static c a(Context context) {
        if (f26019a == null) {
            synchronized (c.class) {
                if (f26019a == null) {
                    f26019a = new c();
                }
            }
        }
        c cVar = f26019a;
        cVar.f26021c = context;
        return cVar;
    }

    private a c(String str) {
        if (this.f26020b.get(str) == null) {
            a a2 = a.a(this.f26021c, str);
            this.f26020b.put(str, a2);
            return a2;
        }
        return this.f26020b.get(str);
    }

    public synchronized void b(String str) {
        c(str).b();
    }

    /* compiled from: UMProcessDBManager.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a */
        private AtomicInteger f26022a = new AtomicInteger();

        /* renamed from: b */
        private SQLiteOpenHelper f26023b;

        /* renamed from: c */
        private SQLiteDatabase f26024c;

        private a() {
        }

        static a a(Context context, String str) {
            Context appContext = UMGlobalContext.getAppContext(context);
            a aVar = new a();
            aVar.f26023b = b.a(appContext, str);
            return aVar;
        }

        synchronized void b() {
            try {
                if (this.f26022a.decrementAndGet() == 0) {
                    this.f26024c.close();
                }
            } catch (Throwable unused) {
            }
        }

        synchronized SQLiteDatabase a() {
            if (this.f26022a.incrementAndGet() == 1) {
                this.f26024c = this.f26023b.getWritableDatabase();
            }
            return this.f26024c;
        }
    }

    public synchronized SQLiteDatabase a(String str) {
        return c(str).a();
    }
}
