package com.google.android.gms.internal.measurement;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public abstract class zzsi<T> {
    private final String name;
    private volatile T zzalj;
    private final zzso zzbro;
    private final T zzbrp;
    private volatile int zzbrr;
    private static final Object zzbrm = new Object();

    @SuppressLint({"StaticFieldLeak"})
    private static Context zzri = null;
    private static boolean zzbrn = false;
    private static final AtomicInteger zzbrq = new AtomicInteger();

    private zzsi(zzso zzsoVar, String str, T t) {
        Uri uri;
        this.zzbrr = -1;
        uri = zzsoVar.zzbrt;
        if (uri != null) {
            this.zzbro = zzsoVar;
            this.name = str;
            this.zzbrp = t;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    public static zzsi<Long> zza(zzso zzsoVar, String str, long j) {
        return new O(zzsoVar, str, Long.valueOf(j));
    }

    public static void zzae(Context context) {
        synchronized (zzbrm) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzri != context) {
                synchronized (zzrx.class) {
                    zzrx.zzbrb.clear();
                }
                synchronized (zzsp.class) {
                    zzsp.zzbrz.clear();
                }
                synchronized (L.class) {
                    L.f13379a = null;
                }
                zzbrq.incrementAndGet();
                zzri = context;
            }
        }
    }

    private final String zzfr(String str) {
        if (str != null && str.isEmpty()) {
            return this.name;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.name);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public static void zztq() {
        zzbrq.incrementAndGet();
    }

    @Nullable
    private final T zzts() {
        Uri uri;
        K zzi;
        Object zzfn;
        Uri uri2;
        zzso zzsoVar = this.zzbro;
        String str = (String) L.a(zzri).zzfn("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
        if (!(str != null && zzru.zzbqo.matcher(str).matches())) {
            uri = this.zzbro.zzbrt;
            if (uri != null) {
                ContentResolver contentResolver = zzri.getContentResolver();
                uri2 = this.zzbro.zzbrt;
                zzi = zzrx.zza(contentResolver, uri2);
            } else {
                Context context = zzri;
                zzso zzsoVar2 = this.zzbro;
                zzi = zzsp.zzi(context, null);
            }
            if (zzi != null && (zzfn = zzi.zzfn(zztr())) != null) {
                return zzs(zzfn);
            }
        } else {
            String valueOf = String.valueOf(zztr());
            Log.w("PhenotypeFlag", valueOf.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(valueOf) : new String("Bypass reading Phenotype values for flag: "));
        }
        return null;
    }

    @Nullable
    private final T zztt() {
        String str;
        zzso zzsoVar = this.zzbro;
        L a2 = L.a(zzri);
        str = this.zzbro.zzbru;
        Object zzfn = a2.zzfn(zzfr(str));
        if (zzfn != null) {
            return zzs(zzfn);
        }
        return null;
    }

    public final T get() {
        int i = zzbrq.get();
        if (this.zzbrr < i) {
            synchronized (this) {
                if (this.zzbrr < i) {
                    if (zzri != null) {
                        zzso zzsoVar = this.zzbro;
                        T zzts = zzts();
                        if (zzts == null && (zzts = zztt()) == null) {
                            zzts = this.zzbrp;
                        }
                        this.zzalj = zzts;
                        this.zzbrr = i;
                    } else {
                        throw new IllegalStateException("Must call PhenotypeFlag.init() first");
                    }
                }
            }
        }
        return this.zzalj;
    }

    public final T getDefaultValue() {
        return this.zzbrp;
    }

    abstract T zzs(Object obj);

    public final String zztr() {
        String str;
        str = this.zzbro.zzbrv;
        return zzfr(str);
    }

    public static zzsi<Integer> zza(zzso zzsoVar, String str, int i) {
        return new P(zzsoVar, str, Integer.valueOf(i));
    }

    public static zzsi<Boolean> zza(zzso zzsoVar, String str, boolean z) {
        return new Q(zzsoVar, str, Boolean.valueOf(z));
    }

    public static zzsi<Double> zza(zzso zzsoVar, String str, double d2) {
        return new S(zzsoVar, str, Double.valueOf(d2));
    }

    public static zzsi<String> zza(zzso zzsoVar, String str, String str2) {
        return new T(zzsoVar, str, str2);
    }

    public /* synthetic */ zzsi(zzso zzsoVar, String str, Object obj, O o) {
        this(zzsoVar, str, obj);
    }
}
