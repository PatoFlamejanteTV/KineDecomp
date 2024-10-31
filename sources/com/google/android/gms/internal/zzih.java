package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzm;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

@zzgr
/* loaded from: classes.dex */
public class zzih {
    private static zzl zzIZ;
    private static final Object zzpy = new Object();
    public static final zza<Void> zzJa = new dx();

    /* loaded from: classes.dex */
    private static class a<T> extends zzk<InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final zza<T> f1725a;
        private final zzm.zzb<T> b;

        public a(String str, zza<T> zzaVar, zzm.zzb<T> zzbVar) {
            super(0, str, new ea(zzbVar, zzaVar));
            this.f1725a = zzaVar;
            this.b = zzbVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzk
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void zza(InputStream inputStream) {
            this.b.zzb(this.f1725a.zzh(inputStream));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzk
        public zzm<InputStream> zza(zzi zziVar) {
            return zzm.zza(new ByteArrayInputStream(zziVar.data), zzx.zzb(zziVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b<T> extends zzin<T> implements zzm.zzb<T> {
        private b() {
        }

        /* synthetic */ b(zzih zzihVar, dx dxVar) {
            this();
        }

        @Override // com.google.android.gms.internal.zzm.zzb
        public void zzb(T t) {
            super.zzf(t);
        }
    }

    /* loaded from: classes.dex */
    public interface zza<T> {
        T zzfF();

        T zzh(InputStream inputStream);
    }

    public zzih(Context context) {
        zzIZ = zzP(context);
    }

    private static zzl zzP(Context context) {
        zzl zzlVar;
        synchronized (zzpy) {
            if (zzIZ == null) {
                zzIZ = zzac.zza(context.getApplicationContext());
            }
            zzlVar = zzIZ;
        }
        return zzlVar;
    }

    public <T> zziq<T> zza(String str, zza<T> zzaVar) {
        b bVar = new b(this, null);
        zzIZ.zze(new a(str, zzaVar, bVar));
        return bVar;
    }

    public zziq<String> zza(String str, Map<String, String> map) {
        b bVar = new b(this, null);
        zzIZ.zze(new dz(this, str, bVar, new dy(this, str, bVar), map));
        return bVar;
    }
}
