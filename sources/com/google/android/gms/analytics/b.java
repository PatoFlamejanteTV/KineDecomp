package com.google.android.gms.analytics;

import java.util.Comparator;

/* loaded from: classes.dex */
final class b implements Comparator<zzi> {
    public b(zze zzeVar) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzi zziVar, zzi zziVar2) {
        return zziVar.getClass().getCanonicalName().compareTo(zziVar2.getClass().getCanonicalName());
    }
}
