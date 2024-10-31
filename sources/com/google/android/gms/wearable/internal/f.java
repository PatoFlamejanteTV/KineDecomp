package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb;

/* loaded from: classes.dex */
final class f {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class a<T> extends zza {

        /* renamed from: a, reason: collision with root package name */
        private zzlb.zzb<T> f2369a;

        public a(zzlb.zzb<T> zzbVar) {
            this.f2369a = zzbVar;
        }

        public void a(T t) {
            zzlb.zzb<T> zzbVar = this.f2369a;
            if (zzbVar != null) {
                zzbVar.zzp(t);
                this.f2369a = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends zza {
        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void a(Status status) {
        }
    }
}
