package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UMDBManager.java */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: b */
    private static SQLiteOpenHelper f25871b;

    /* renamed from: d */
    private static Context f25872d;

    /* renamed from: a */
    private AtomicInteger f25873a;

    /* renamed from: c */
    private SQLiteDatabase f25874c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UMDBManager.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a */
        private static final e f25875a = new e();

        private a() {
        }
    }

    /* synthetic */ e(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static e a(Context context) {
        if (f25872d == null && context != null) {
            f25872d = context.getApplicationContext();
            f25871b = d.a(f25872d);
        }
        return a.f25875a;
    }

    public synchronized void b() {
        try {
            if (this.f25873a.decrementAndGet() == 0) {
                this.f25874c.close();
            }
        } catch (Throwable unused) {
        }
    }

    private e() {
        this.f25873a = new AtomicInteger();
    }

    public synchronized SQLiteDatabase a() {
        if (this.f25873a.incrementAndGet() == 1) {
            this.f25874c = f25871b.getWritableDatabase();
        }
        return this.f25874c;
    }
}
