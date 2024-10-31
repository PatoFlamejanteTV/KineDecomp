package com.google.android.gms.common.stats;

import com.google.android.gms.internal.zzlr;

/* loaded from: classes.dex */
public final class zzc {

    /* renamed from: a, reason: collision with root package name */
    public static zzlr<Integer> f1041a = zzlr.zza("gms:common:stats:max_num_of_events", (Integer) 100);

    /* loaded from: classes.dex */
    public static final class zza {

        /* renamed from: a, reason: collision with root package name */
        public static zzlr<Integer> f1042a = zzlr.zza("gms:common:stats:connections:level", Integer.valueOf(zzd.b));
        public static zzlr<String> b = zzlr.zzu("gms:common:stats:connections:ignored_calling_processes", "");
        public static zzlr<String> c = zzlr.zzu("gms:common:stats:connections:ignored_calling_services", "");
        public static zzlr<String> d = zzlr.zzu("gms:common:stats:connections:ignored_target_processes", "");
        public static zzlr<String> e = zzlr.zzu("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
        public static zzlr<Long> f = zzlr.zza("gms:common:stats:connections:time_out_duration", (Long) 600000L);
    }

    /* loaded from: classes.dex */
    public static final class zzb {

        /* renamed from: a, reason: collision with root package name */
        public static zzlr<Integer> f1043a = zzlr.zza("gms:common:stats:wakeLocks:level", Integer.valueOf(zzd.b));
        public static zzlr<Long> b = zzlr.zza("gms:common:stats:wakelocks:time_out_duration", (Long) 600000L);
    }
}
