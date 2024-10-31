package com.google.android.gms.tagmanager;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzb;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@ShowFirstParty
@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzgk extends E {

    /* renamed from: c */
    private static final String f14260c = com.google.android.gms.internal.gtm.zza.UNIVERSAL_ANALYTICS.toString();

    /* renamed from: d */
    private static final String f14261d = zzb.ACCOUNT.toString();

    /* renamed from: e */
    private static final String f14262e = zzb.ANALYTICS_PASS_THROUGH.toString();

    /* renamed from: f */
    private static final String f14263f = zzb.ENABLE_ECOMMERCE.toString();

    /* renamed from: g */
    private static final String f14264g = zzb.ECOMMERCE_USE_DATA_LAYER.toString();

    /* renamed from: h */
    private static final String f14265h = zzb.ECOMMERCE_MACRO_DATA.toString();
    private static final String i = zzb.ANALYTICS_FIELDS.toString();
    private static final String j = zzb.TRACK_TRANSACTION.toString();
    private static final String k = zzb.TRANSACTION_DATALAYER_MAP.toString();
    private static final String l = zzb.TRANSACTION_ITEM_DATALAYER_MAP.toString();
    private static final List<String> m = Arrays.asList("detail", "checkout", "checkout_option", "click", "add", "remove", "purchase", "refund");
    private static final Pattern n = Pattern.compile("dimension(\\d+)");
    private static final Pattern o = Pattern.compile("metric(\\d+)");
}
