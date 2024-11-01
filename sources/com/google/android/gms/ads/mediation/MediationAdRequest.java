package com.google.android.gms.ads.mediation;

import android.location.Location;
import java.util.Date;
import java.util.Set;

/* loaded from: classes.dex */
public interface MediationAdRequest {
    Date getBirthday();

    int getGender();

    Set<String> getKeywords();

    Location getLocation();

    boolean isTesting();

    int taggedForChildDirectedTreatment();
}
