package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.clearcut.zzaa;
import com.google.android.gms.internal.clearcut.zzge;
import com.google.android.gms.internal.clearcut.zzha;
import com.google.android.gms.internal.clearcut.zzj;
import com.google.android.gms.internal.clearcut.zzp;
import com.google.android.gms.internal.clearcut.zzr;
import com.google.android.gms.phenotype.ExperimentTokens;
import java.util.ArrayList;
import java.util.TimeZone;
import javax.annotation.Nullable;

@KeepForSdk
/* loaded from: classes.dex */
public final class ClearcutLogger {

    /* renamed from: a, reason: collision with root package name */
    private static final Api.ClientKey<zzj> f10618a = new Api.ClientKey<>();

    /* renamed from: b, reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zzj, Api.ApiOptions.NoOptions> f10619b = new a();

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> f10620c = new Api<>("ClearcutLogger.API", f10619b, f10618a);

    /* renamed from: d, reason: collision with root package name */
    private static final ExperimentTokens[] f10621d = new ExperimentTokens[0];

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f10622e = new String[0];

    /* renamed from: f, reason: collision with root package name */
    private static final byte[][] f10623f = new byte[0];

    /* renamed from: g, reason: collision with root package name */
    private final Context f10624g;

    /* renamed from: h, reason: collision with root package name */
    private final String f10625h;
    private final int i;
    private String j;
    private int k;
    private String l;
    private String m;
    private final boolean n;
    private zzge.zzv.zzb o;
    private final com.google.android.gms.clearcut.zzb p;
    private final Clock q;
    private zzc r;
    private final zza s;

    /* loaded from: classes.dex */
    public class LogEventBuilder {

        /* renamed from: a, reason: collision with root package name */
        private int f10626a;

        /* renamed from: b, reason: collision with root package name */
        private String f10627b;

        /* renamed from: c, reason: collision with root package name */
        private String f10628c;

        /* renamed from: d, reason: collision with root package name */
        private String f10629d;

        /* renamed from: e, reason: collision with root package name */
        private zzge.zzv.zzb f10630e;

        /* renamed from: f, reason: collision with root package name */
        private final zzb f10631f;

        /* renamed from: g, reason: collision with root package name */
        private ArrayList<Integer> f10632g;

        /* renamed from: h, reason: collision with root package name */
        private ArrayList<String> f10633h;
        private ArrayList<Integer> i;
        private ArrayList<ExperimentTokens> j;
        private ArrayList<byte[]> k;
        private boolean l;
        private final zzha m;
        private boolean n;

        private LogEventBuilder(ClearcutLogger clearcutLogger, byte[] bArr) {
            this(bArr, (zzb) null);
        }

        private LogEventBuilder(byte[] bArr, zzb zzbVar) {
            this.f10626a = ClearcutLogger.this.k;
            this.f10627b = ClearcutLogger.this.j;
            this.f10628c = ClearcutLogger.this.l;
            ClearcutLogger clearcutLogger = ClearcutLogger.this;
            this.f10629d = null;
            this.f10630e = clearcutLogger.o;
            this.f10632g = null;
            this.f10633h = null;
            this.i = null;
            this.j = null;
            this.k = null;
            this.l = true;
            this.m = new zzha();
            this.n = false;
            this.f10628c = ClearcutLogger.this.l;
            this.f10629d = null;
            this.m.zzbkc = zzaa.zze(ClearcutLogger.this.f10624g);
            this.m.zzbjf = ClearcutLogger.this.q.a();
            this.m.zzbjg = ClearcutLogger.this.q.c();
            zzha zzhaVar = this.m;
            zzc unused = ClearcutLogger.this.r;
            zzhaVar.zzbju = TimeZone.getDefault().getOffset(this.m.zzbjf) / 1000;
            if (bArr != null) {
                this.m.zzbjp = bArr;
            }
            this.f10631f = null;
        }

        /* synthetic */ LogEventBuilder(ClearcutLogger clearcutLogger, byte[] bArr, a aVar) {
            this(clearcutLogger, bArr);
        }

        @KeepForSdk
        public void a() {
            if (this.n) {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
            this.n = true;
            zze zzeVar = new zze(new zzr(ClearcutLogger.this.f10625h, ClearcutLogger.this.i, this.f10626a, this.f10627b, this.f10628c, this.f10629d, ClearcutLogger.this.n, this.f10630e), this.m, null, null, ClearcutLogger.a((ArrayList) null), null, ClearcutLogger.a((ArrayList) null), null, null, this.l);
            if (ClearcutLogger.this.s.zza(zzeVar)) {
                ClearcutLogger.this.p.zzb(zzeVar);
            } else {
                PendingResults.a(Status.f10704a, (GoogleApiClient) null);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface zza {
        boolean zza(zze zzeVar);
    }

    /* loaded from: classes.dex */
    public interface zzb {
        byte[] zza();
    }

    /* loaded from: classes.dex */
    public static class zzc {
    }

    @VisibleForTesting
    private ClearcutLogger(Context context, int i, String str, String str2, String str3, boolean z, com.google.android.gms.clearcut.zzb zzbVar, Clock clock, zzc zzcVar, zza zzaVar) {
        this.k = -1;
        this.o = zzge.zzv.zzb.DEFAULT;
        this.f10624g = context;
        this.f10625h = context.getPackageName();
        this.i = a(context);
        this.k = -1;
        this.j = str;
        this.l = str2;
        this.m = null;
        this.n = z;
        this.p = zzbVar;
        this.q = clock;
        this.r = new zzc();
        this.o = zzge.zzv.zzb.DEFAULT;
        this.s = zzaVar;
        if (z) {
            Preconditions.a(str2 == null, "can't be anonymous with an upload account");
        }
    }

    @KeepForSdk
    public ClearcutLogger(Context context, String str, @Nullable String str2) {
        this(context, -1, str, str2, null, false, com.google.android.gms.internal.clearcut.zze.zzb(context), DefaultClock.d(), null, new zzp(context));
    }

    private static int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.wtf("ClearcutLogger", "This can't happen.", e2);
            return 0;
        }
    }

    static /* synthetic */ int[] a(ArrayList arrayList) {
        return b((ArrayList<Integer>) null);
    }

    private static int[] b(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            Integer num = arrayList.get(i);
            i++;
            iArr[i2] = num.intValue();
            i2++;
        }
        return iArr;
    }

    @KeepForSdk
    public final LogEventBuilder a(@Nullable byte[] bArr) {
        return new LogEventBuilder(this, bArr, (a) null);
    }
}
