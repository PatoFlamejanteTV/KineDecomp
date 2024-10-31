package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zzark
/* loaded from: classes2.dex */
public final class zzwe {
    public static final zzwe zzckj = new zzwe();

    @VisibleForTesting
    protected zzwe() {
    }

    public static zzwb zza(Context context, zzyx zzyxVar) {
        Context context2;
        List list;
        String str;
        Date birthday = zzyxVar.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1L;
        String contentUrl = zzyxVar.getContentUrl();
        int gender = zzyxVar.getGender();
        Set<String> keywords = zzyxVar.getKeywords();
        if (keywords.isEmpty()) {
            context2 = context;
            list = null;
        } else {
            list = Collections.unmodifiableList(new ArrayList(keywords));
            context2 = context;
        }
        boolean isTestDevice = zzyxVar.isTestDevice(context2);
        int zzqm = zzyxVar.zzqm();
        Location location = zzyxVar.getLocation();
        Bundle networkExtrasBundle = zzyxVar.getNetworkExtrasBundle(AdMobAdapter.class);
        boolean manualImpressionsEnabled = zzyxVar.getManualImpressionsEnabled();
        String publisherProvidedId = zzyxVar.getPublisherProvidedId();
        SearchAdRequest zzqj = zzyxVar.zzqj();
        zzzs zzzsVar = zzqj != null ? new zzzs(zzqj) : null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzwu.zzpv();
            str = zzbat.zza(Thread.currentThread().getStackTrace(), packageName);
        } else {
            str = null;
        }
        return new zzwb(8, time, networkExtrasBundle, gender, list, isTestDevice, zzqm, manualImpressionsEnabled, publisherProvidedId, zzzsVar, location, contentUrl, zzyxVar.zzql(), zzyxVar.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(zzyxVar.zzqn())), zzyxVar.zzqi(), str, zzyxVar.isDesignedForFamilies(), null, zzyxVar.zzqo(), zzyxVar.zzqp());
    }
}
