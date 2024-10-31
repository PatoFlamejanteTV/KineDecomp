package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.protos.datapol.SemanticAnnotations;

@ShowFirstParty
@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzby {
    public static zzbz<String> zzaaa;
    public static zzbz<Integer> zzaab;
    private static zzbz<Long> zzaac;
    public static zzbz<Integer> zzaad;
    public static zzbz<Integer> zzaae;
    public static zzbz<Long> zzaaf;
    private static zzbz<String> zzaag;
    private static zzbz<Integer> zzaah;
    public static zzbz<Boolean> zzaai;
    public static zzbz<Long> zzaaj;
    public static zzbz<Long> zzaak;
    private static zzbz<Long> zzaal;
    private static zzbz<Long> zzaam;
    public static zzbz<Long> zzaan;
    public static zzbz<Long> zzaao;
    public static zzbz<Long> zzaap;
    public static zzbz<Boolean> zzaaq;
    private static zzbz<Boolean> zzyz = zzbz.zza("analytics.service_enabled", false, false);
    public static zzbz<Boolean> zzza = zzbz.zza("analytics.service_client_enabled", true, true);
    public static zzbz<String> zzzb = zzbz.zza("analytics.log_tag", "GAv4", "GAv4-SVC");
    private static zzbz<Long> zzzc = zzbz.zza("analytics.max_tokens", 60L, 60L);
    private static zzbz<Float> zzzd = zzbz.zza("analytics.tokens_per_sec", 0.5f, 0.5f);
    public static zzbz<Integer> zzze = zzbz.zza("analytics.max_stored_hits", SemanticAnnotations.SemanticType.ST_THIRD_PARTY_DATA_VALUE, 20000);
    private static zzbz<Integer> zzzf = zzbz.zza("analytics.max_stored_hits_per_app", SemanticAnnotations.SemanticType.ST_THIRD_PARTY_DATA_VALUE, SemanticAnnotations.SemanticType.ST_THIRD_PARTY_DATA_VALUE);
    public static zzbz<Integer> zzzg = zzbz.zza("analytics.max_stored_properties_per_app", 100, 100);
    public static zzbz<Long> zzzh = zzbz.zza("analytics.local_dispatch_millis", 1800000L, 120000L);
    public static zzbz<Long> zzzi = zzbz.zza("analytics.initial_local_dispatch_millis", 5000L, 5000L);
    private static zzbz<Long> zzzj = zzbz.zza("analytics.min_local_dispatch_millis", 120000L, 120000L);
    private static zzbz<Long> zzzk = zzbz.zza("analytics.max_local_dispatch_millis", 7200000L, 7200000L);
    public static zzbz<Long> zzzl = zzbz.zza("analytics.dispatch_alarm_millis", 7200000L, 7200000L);
    public static zzbz<Long> zzzm = zzbz.zza("analytics.max_dispatch_alarm_millis", 32400000L, 32400000L);
    public static zzbz<Integer> zzzn = zzbz.zza("analytics.max_hits_per_dispatch", 20, 20);
    public static zzbz<Integer> zzzo = zzbz.zza("analytics.max_hits_per_batch", 20, 20);
    public static zzbz<String> zzzp = zzbz.zza("analytics.insecure_host", "http://www.google-analytics.com", "http://www.google-analytics.com");
    public static zzbz<String> zzzq = zzbz.zza("analytics.secure_host", "https://ssl.google-analytics.com", "https://ssl.google-analytics.com");
    public static zzbz<String> zzzr = zzbz.zza("analytics.simple_endpoint", "/collect", "/collect");
    public static zzbz<String> zzzs = zzbz.zza("analytics.batching_endpoint", "/batch", "/batch");
    public static zzbz<Integer> zzzt = zzbz.zza("analytics.max_get_length", 2036, 2036);
    public static zzbz<String> zzzu = zzbz.zza("analytics.batching_strategy.k", zzbg.BATCH_BY_COUNT.name(), zzbg.BATCH_BY_COUNT.name());
    public static zzbz<String> zzzv;
    private static zzbz<Integer> zzzw;
    public static zzbz<Integer> zzzx;
    public static zzbz<Integer> zzzy;
    public static zzbz<Integer> zzzz;

    static {
        String name = zzbm.GZIP.name();
        zzzv = zzbz.zza("analytics.compression_strategy.k", name, name);
        zzzw = zzbz.zza("analytics.max_hits_per_request.k", 20, 20);
        zzzx = zzbz.zza("analytics.max_hit_length.k", 8192, 8192);
        zzzy = zzbz.zza("analytics.max_post_length.k", 8192, 8192);
        zzzz = zzbz.zza("analytics.max_batch_post_length", 8192, 8192);
        zzaaa = zzbz.zza("analytics.fallback_responses.k", "404,502", "404,502");
        zzaab = zzbz.zza("analytics.batch_retry_interval.seconds.k", 3600, 3600);
        zzaac = zzbz.zza("analytics.service_monitor_interval", 86400000L, 86400000L);
        zzaad = zzbz.zza("analytics.http_connection.connect_timeout_millis", 60000, 60000);
        zzaae = zzbz.zza("analytics.http_connection.read_timeout_millis", 61000, 61000);
        zzaaf = zzbz.zza("analytics.campaigns.time_limit", 86400000L, 86400000L);
        zzaag = zzbz.zza("analytics.first_party_experiment_id", "", "");
        zzaah = zzbz.zza("analytics.first_party_experiment_variant", 0, 0);
        zzaai = zzbz.zza("analytics.test.disable_receiver", false, false);
        zzaaj = zzbz.zza("analytics.service_client.idle_disconnect_millis", 10000L, 10000L);
        zzaak = zzbz.zza("analytics.service_client.connect_timeout_millis", 5000L, 5000L);
        zzaal = zzbz.zza("analytics.service_client.second_connect_delay_millis", 5000L, 5000L);
        zzaam = zzbz.zza("analytics.service_client.unexpected_reconnect_millis", 60000L, 60000L);
        zzaan = zzbz.zza("analytics.service_client.reconnect_throttle_millis", 1800000L, 1800000L);
        zzaao = zzbz.zza("analytics.monitoring.sample_period_millis", 86400000L, 86400000L);
        zzaap = zzbz.zza("analytics.initialization_warning_threshold", 5000L, 5000L);
        zzaaq = zzbz.zza("analytics.gcm_task_service", false, false);
    }
}
