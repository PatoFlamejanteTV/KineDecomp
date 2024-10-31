package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzrx;
import com.google.android.gms.internal.measurement.zzsh;
import com.google.android.gms.internal.measurement.zzsi;
import com.google.android.gms.internal.measurement.zzso;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzai {

    /* renamed from: a, reason: collision with root package name */
    static zzn f13901a;

    /* renamed from: h, reason: collision with root package name */
    private static volatile zzbw f13908h;

    @VisibleForTesting
    private static Boolean i;

    /* renamed from: b, reason: collision with root package name */
    static List<zza<Integer>> f13902b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    static List<zza<Long>> f13903c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    static List<zza<Boolean>> f13904d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    static List<zza<String>> f13905e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    static List<zza<Double>> f13906f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private static final zzso f13907g = new zzso(zzsh.zzfq("com.google.android.gms.measurement"));
    private static zza<Boolean> j = zza.a("measurement.log_third_party_store_events_enabled", false, false);
    private static zza<Boolean> k = zza.a("measurement.log_installs_enabled", false, false);
    private static zza<Boolean> l = zza.a("measurement.log_upgrades_enabled", false, false);
    public static zza<Boolean> m = zza.a("measurement.log_androidId_enabled", false, false);
    public static zza<Boolean> n = zza.a("measurement.upload_dsid_enabled", false, false);
    public static zza<String> o = zza.a("measurement.log_tag", "FA", "FA-SVC");
    public static zza<Long> p = zza.a("measurement.ad_id_cache_time", 10000L, 10000L);
    public static zza<Long> q = zza.a("measurement.monitoring.sample_period_millis", 86400000L, 86400000L);
    public static zza<Long> r = zza.a("measurement.config.cache_time", 86400000L, 3600000L);
    public static zza<String> s = zza.a("measurement.config.url_scheme", "https", "https");
    public static zza<String> t = zza.a("measurement.config.url_authority", "app-measurement.com", "app-measurement.com");
    public static zza<Integer> u = zza.a("measurement.upload.max_bundles", 100, 100);
    public static zza<Integer> v = zza.a("measurement.upload.max_batch_size", 65536, 65536);
    public static zza<Integer> w = zza.a("measurement.upload.max_bundle_size", 65536, 65536);
    public static zza<Integer> x = zza.a("measurement.upload.max_events_per_bundle", 1000, 1000);
    public static zza<Integer> y = zza.a("measurement.upload.max_events_per_day", NexVideoClipItem.ABSTRACT_DIMENSION, NexVideoClipItem.ABSTRACT_DIMENSION);
    public static zza<Integer> z = zza.a("measurement.upload.max_error_events_per_day", 1000, 1000);
    public static zza<Integer> A = zza.a("measurement.upload.max_public_events_per_day", 50000, 50000);
    public static zza<Integer> B = zza.a("measurement.upload.max_conversions_per_day", 500, 500);
    public static zza<Integer> C = zza.a("measurement.upload.max_realtime_events_per_day", 10, 10);
    public static zza<Integer> D = zza.a("measurement.store.max_stored_events_per_app", NexVideoClipItem.ABSTRACT_DIMENSION, NexVideoClipItem.ABSTRACT_DIMENSION);
    public static zza<String> E = zza.a("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a");
    public static zza<Long> F = zza.a("measurement.upload.backoff_period", 43200000L, 43200000L);
    public static zza<Long> G = zza.a("measurement.upload.window_interval", 3600000L, 3600000L);
    public static zza<Long> H = zza.a("measurement.upload.interval", 3600000L, 3600000L);
    public static zza<Long> I = zza.a("measurement.upload.realtime_upload_interval", 10000L, 10000L);
    public static zza<Long> J = zza.a("measurement.upload.debug_upload_interval", 1000L, 1000L);
    public static zza<Long> K = zza.a("measurement.upload.minimum_delay", 500L, 500L);
    public static zza<Long> L = zza.a("measurement.alarm_manager.minimum_interval", 60000L, 60000L);
    public static zza<Long> M = zza.a("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L);
    public static zza<Long> N = zza.a("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L);
    public static zza<Long> O = zza.a("measurement.upload.initial_upload_delay_time", 15000L, 15000L);
    public static zza<Long> P = zza.a("measurement.upload.retry_time", 1800000L, 1800000L);
    public static zza<Integer> Q = zza.a("measurement.upload.retry_count", 6, 6);
    public static zza<Long> R = zza.a("measurement.upload.max_queue_time", 2419200000L, 2419200000L);
    public static zza<Integer> S = zza.a("measurement.lifetimevalue.max_currency_tracked", 4, 4);
    public static zza<Integer> T = zza.a("measurement.audience.filter_result_max_count", 200, 200);
    public static zza<Long> U = zza.a("measurement.service_client.idle_disconnect_millis", 5000L, 5000L);
    public static zza<Boolean> V = zza.a("measurement.test.boolean_flag", false, false);
    public static zza<String> W = zza.a("measurement.test.string_flag", "---", "---");
    public static zza<Long> X = zza.a("measurement.test.long_flag", -1L, -1L);
    public static zza<Integer> Y = zza.a("measurement.test.int_flag", -2, -2);
    public static zza<Double> Z = zza.a("measurement.test.double_flag", -3.0d, -3.0d);
    public static zza<Integer> aa = zza.a("measurement.experiment.max_ids", 50, 50);
    public static zza<Boolean> ba = zza.a("measurement.lifetimevalue.user_engagement_tracking_enabled", true, true);
    public static zza<Boolean> ca = zza.a("measurement.audience.complex_param_evaluation", true, true);
    public static zza<Boolean> da = zza.a("measurement.validation.internal_limits_internal_event_params", false, false);
    public static zza<Boolean> ea = zza.a("measurement.quality.unsuccessful_update_retry_counter", true, true);
    public static zza<Boolean> fa = zza.a("measurement.iid.disable_on_collection_disabled", true, true);
    public static zza<Boolean> ga = zza.a("measurement.app_launch.call_only_when_enabled", true, true);
    public static zza<Boolean> ha = zza.a("measurement.run_on_worker_inline", true, false);
    public static zza<Boolean> ia = zza.a("measurement.audience.dynamic_filters", true, true);
    public static zza<Boolean> ja = zza.a("measurement.reset_analytics.persist_time", false, false);
    public static zza<Boolean> ka = zza.a("measurement.validation.value_and_currency_params", false, false);
    public static zza<Boolean> la = zza.a("measurement.sampling.time_zone_offset_enabled", false, false);
    public static zza<Boolean> ma = zza.a("measurement.referrer.enable_logging_install_referrer_cmp_from_apk", false, false);
    public static zza<Boolean> na = zza.a("measurement.fetch_config_with_admob_app_id", true, true);
    public static zza<Boolean> oa = zza.a("measurement.sessions.session_id_enabled", false, false);
    public static zza<Boolean> pa = zza.a("measurement.sessions.session_number_enabled", false, false);
    public static zza<Boolean> qa = zza.a("measurement.sessions.immediate_start_enabled", false, false);
    public static zza<Boolean> ra = zza.a("measurement.sessions.background_sessions_enabled", false, false);
    public static zza<Boolean> sa = zza.a("measurement.collection.firebase_global_collection_flag_enabled", true, true);
    public static zza<Boolean> ta = zza.a("measurement.collection.efficient_engagement_reporting_enabled", false, false);
    public static zza<Boolean> ua = zza.a("measurement.collection.redundant_engagement_removal_enabled", false, false);
    public static zza<Boolean> va = zza.a("measurement.remove_app_instance_id_cache_enabled", true, true);
    public static zza<Boolean> wa = zza.a("measurement.collection.init_params_control_enabled", true, true);
    public static zza<Boolean> xa = zza.a("measurement.upload.disable_is_uploader", false, false);
    public static zza<Boolean> ya = zza.a("measurement.experiment.enable_experiment_reporting", false, false);
    public static zza<Boolean> za = zza.a("measurement.collection.log_event_and_bundle_v2", true, true);
    public static zza<Boolean> Aa = zza.a("measurement.collection.null_empty_event_name_fix", true, true);

    public static Map<String, String> a(Context context) {
        return zzrx.zza(context.getContentResolver(), zzsh.zzfq("com.google.android.gms.measurement")).zztk();
    }

    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class zza<V> {

        /* renamed from: a, reason: collision with root package name */
        private zzsi<V> f13909a;

        /* renamed from: b, reason: collision with root package name */
        private final V f13910b;

        /* renamed from: c, reason: collision with root package name */
        private final V f13911c;

        /* renamed from: d, reason: collision with root package name */
        private volatile V f13912d;

        /* renamed from: e, reason: collision with root package name */
        private final String f13913e;

        private zza(String str, V v, V v2) {
            this.f13913e = str;
            this.f13911c = v;
            this.f13910b = v2;
        }

        static zza<Boolean> a(String str, boolean z, boolean z2) {
            zza<Boolean> zzaVar = new zza<>(str, Boolean.valueOf(z), Boolean.valueOf(z2));
            zzai.f13904d.add(zzaVar);
            return zzaVar;
        }

        private static void d() {
            synchronized (zza.class) {
                if (!zzn.a()) {
                    zzn zznVar = zzai.f13901a;
                    try {
                        for (zza<Boolean> zzaVar : zzai.f13904d) {
                            ((zza) zzaVar).f13912d = (V) ((zza) zzaVar).f13909a.get();
                        }
                        for (zza<String> zzaVar2 : zzai.f13905e) {
                            ((zza) zzaVar2).f13912d = (V) ((zza) zzaVar2).f13909a.get();
                        }
                        for (zza<Long> zzaVar3 : zzai.f13903c) {
                            ((zza) zzaVar3).f13912d = (V) ((zza) zzaVar3).f13909a.get();
                        }
                        for (zza<Integer> zzaVar4 : zzai.f13902b) {
                            ((zza) zzaVar4).f13912d = (V) ((zza) zzaVar4).f13909a.get();
                        }
                        for (zza<Double> zzaVar5 : zzai.f13906f) {
                            ((zza) zzaVar5).f13912d = (V) ((zza) zzaVar5).f13909a.get();
                        }
                    } catch (SecurityException e2) {
                        zzai.a(e2);
                    }
                } else {
                    throw new IllegalStateException("Tried to refresh flag cache on main thread or on package side.");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void e() {
            synchronized (zza.class) {
                for (zza<Boolean> zzaVar : zzai.f13904d) {
                    zzso zzsoVar = zzai.f13907g;
                    String str = ((zza) zzaVar).f13913e;
                    zzn zznVar = zzai.f13901a;
                    ((zza) zzaVar).f13909a = (zzsi<V>) zzsoVar.zzd(str, ((zza) zzaVar).f13911c.booleanValue());
                }
                for (zza<String> zzaVar2 : zzai.f13905e) {
                    zzso zzsoVar2 = zzai.f13907g;
                    String str2 = ((zza) zzaVar2).f13913e;
                    zzn zznVar2 = zzai.f13901a;
                    ((zza) zzaVar2).f13909a = (zzsi<V>) zzsoVar2.zzy(str2, ((zza) zzaVar2).f13911c);
                }
                for (zza<Long> zzaVar3 : zzai.f13903c) {
                    zzso zzsoVar3 = zzai.f13907g;
                    String str3 = ((zza) zzaVar3).f13913e;
                    zzn zznVar3 = zzai.f13901a;
                    ((zza) zzaVar3).f13909a = (zzsi<V>) zzsoVar3.zze(str3, ((zza) zzaVar3).f13911c.longValue());
                }
                for (zza<Integer> zzaVar4 : zzai.f13902b) {
                    zzso zzsoVar4 = zzai.f13907g;
                    String str4 = ((zza) zzaVar4).f13913e;
                    zzn zznVar4 = zzai.f13901a;
                    ((zza) zzaVar4).f13909a = (zzsi<V>) zzsoVar4.zzd(str4, ((zza) zzaVar4).f13911c.intValue());
                }
                for (zza<Double> zzaVar5 : zzai.f13906f) {
                    zzso zzsoVar5 = zzai.f13907g;
                    String str5 = ((zza) zzaVar5).f13913e;
                    zzn zznVar5 = zzai.f13901a;
                    ((zza) zzaVar5).f13909a = (zzsi<V>) zzsoVar5.zzb(str5, ((zza) zzaVar5).f13911c.doubleValue());
                }
            }
        }

        public final String b() {
            return this.f13913e;
        }

        static zza<String> a(String str, String str2, String str3) {
            zza<String> zzaVar = new zza<>(str, str2, str3);
            zzai.f13905e.add(zzaVar);
            return zzaVar;
        }

        static zza<Long> a(String str, long j, long j2) {
            zza<Long> zzaVar = new zza<>(str, Long.valueOf(j), Long.valueOf(j2));
            zzai.f13903c.add(zzaVar);
            return zzaVar;
        }

        static zza<Integer> a(String str, int i, int i2) {
            zza<Integer> zzaVar = new zza<>(str, Integer.valueOf(i), Integer.valueOf(i2));
            zzai.f13902b.add(zzaVar);
            return zzaVar;
        }

        static zza<Double> a(String str, double d2, double d3) {
            Double valueOf = Double.valueOf(-3.0d);
            zza<Double> zzaVar = new zza<>(str, valueOf, valueOf);
            zzai.f13906f.add(zzaVar);
            return zzaVar;
        }

        public final V a() {
            if (zzai.f13901a == null) {
                return this.f13911c;
            }
            if (zzn.a()) {
                return this.f13912d == null ? this.f13911c : this.f13912d;
            }
            d();
            try {
                return this.f13909a.get();
            } catch (SecurityException e2) {
                zzai.a(e2);
                return this.f13909a.getDefaultValue();
            }
        }

        public final V a(V v) {
            if (v != null) {
                return v;
            }
            if (zzai.f13901a == null) {
                return this.f13911c;
            }
            if (zzn.a()) {
                return this.f13912d == null ? this.f13911c : this.f13912d;
            }
            d();
            try {
                return this.f13909a.get();
            } catch (SecurityException e2) {
                zzai.a(e2);
                return this.f13909a.getDefaultValue();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(zzbw zzbwVar) {
        f13908h = zzbwVar;
    }

    @VisibleForTesting
    static void a(Exception exc) {
        if (f13908h == null) {
            return;
        }
        Context context = f13908h.getContext();
        if (i == null) {
            i = Boolean.valueOf(GoogleApiAvailabilityLight.a().a(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) == 0);
        }
        if (i.booleanValue()) {
            f13908h.b().q().a("Got Exception on PhenotypeFlag.get on Play device", exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(zzn zznVar) {
        f13901a = zznVar;
        zza.e();
    }
}
