package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

/* loaded from: classes.dex */
public class zzdc {

    /* renamed from: a, reason: collision with root package name */
    private GoogleAnalytics f2237a;
    private Context b;
    private Tracker c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements Logger {
        a() {
        }

        private static int b(int i) {
            switch (i) {
                case 2:
                    return 0;
                case 3:
                case 4:
                    return 1;
                case 5:
                    return 2;
                case 6:
                default:
                    return 3;
            }
        }

        @Override // com.google.android.gms.analytics.Logger
        public int a() {
            return b(zzbg.a());
        }

        @Override // com.google.android.gms.analytics.Logger
        public void a(int i) {
            zzbg.b("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
        }

        @Override // com.google.android.gms.analytics.Logger
        public void a(String str) {
            zzbg.d(str);
        }

        @Override // com.google.android.gms.analytics.Logger
        public void b(String str) {
            zzbg.b(str);
        }

        @Override // com.google.android.gms.analytics.Logger
        public void c(String str) {
            zzbg.a(str);
        }
    }

    private synchronized void b(String str) {
        if (this.f2237a == null) {
            this.f2237a = GoogleAnalytics.a(this.b);
            this.f2237a.a(new a());
            this.c = this.f2237a.a(str);
        }
    }

    public Tracker a(String str) {
        b(str);
        return this.c;
    }
}
