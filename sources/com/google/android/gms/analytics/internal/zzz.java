package com.google.android.gms.analytics.internal;

import com.google.android.gms.analytics.internal.zzq;

/* loaded from: classes.dex */
public class zzz extends zzq<zzaa> {

    /* loaded from: classes.dex */
    private static class a implements zzq.zza<zzaa> {

        /* renamed from: a, reason: collision with root package name */
        private final zzf f753a;
        private final zzaa b = new zzaa();

        public a(zzf zzfVar) {
            this.f753a = zzfVar;
        }

        @Override // com.google.android.gms.analytics.internal.zzq.zza
        public void a(String str, int i) {
            if ("ga_dispatchPeriod".equals(str)) {
                this.b.d = i;
            } else {
                this.f753a.f().d("Int xml configuration name not recognized", str);
            }
        }

        @Override // com.google.android.gms.analytics.internal.zzq.zza
        public void a(String str, String str2) {
        }

        @Override // com.google.android.gms.analytics.internal.zzq.zza
        public void a(String str, boolean z) {
            if (!"ga_dryRun".equals(str)) {
                this.f753a.f().d("Bool xml configuration name not recognized", str);
            } else {
                this.b.e = z ? 1 : 0;
            }
        }

        @Override // com.google.android.gms.analytics.internal.zzq.zza
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public zzaa a() {
            return this.b;
        }

        @Override // com.google.android.gms.analytics.internal.zzq.zza
        public void b(String str, String str2) {
            if ("ga_appName".equals(str)) {
                this.b.f726a = str2;
                return;
            }
            if ("ga_appVersion".equals(str)) {
                this.b.b = str2;
            } else if ("ga_logLevel".equals(str)) {
                this.b.c = str2;
            } else {
                this.f753a.f().d("String xml configuration name not recognized", str);
            }
        }
    }

    public zzz(zzf zzfVar) {
        super(zzfVar, new a(zzfVar));
    }
}
