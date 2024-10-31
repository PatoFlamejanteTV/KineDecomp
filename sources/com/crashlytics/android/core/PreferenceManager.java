package com.crashlytics.android.core;

import android.annotation.SuppressLint;
import io.fabric.sdk.android.a.c.c;
import io.fabric.sdk.android.a.c.d;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"CommitPrefEdits"})
/* loaded from: classes.dex */
public class PreferenceManager {
    static final String PREF_ALWAYS_SEND_REPORTS_KEY = "always_send_reports_opt_in";
    private static final String PREF_MIGRATION_COMPLETE = "preferences_migration_complete";
    private static final boolean SHOULD_ALWAYS_SEND_REPORTS_DEFAULT = false;
    private final CrashlyticsCore kit;
    private final c preferenceStore;

    public PreferenceManager(c cVar, CrashlyticsCore crashlyticsCore) {
        this.preferenceStore = cVar;
        this.kit = crashlyticsCore;
    }

    public static PreferenceManager create(c cVar, CrashlyticsCore crashlyticsCore) {
        return new PreferenceManager(cVar, crashlyticsCore);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setShouldAlwaysSendReports(boolean z) {
        c cVar = this.preferenceStore;
        cVar.a(cVar.edit().putBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean shouldAlwaysSendReports() {
        if (!this.preferenceStore.get().contains(PREF_MIGRATION_COMPLETE)) {
            d dVar = new d(this.kit);
            if (!this.preferenceStore.get().contains(PREF_ALWAYS_SEND_REPORTS_KEY) && dVar.get().contains(PREF_ALWAYS_SEND_REPORTS_KEY)) {
                boolean z = dVar.get().getBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, false);
                c cVar = this.preferenceStore;
                cVar.a(cVar.edit().putBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, z));
            }
            c cVar2 = this.preferenceStore;
            cVar2.a(cVar2.edit().putBoolean(PREF_MIGRATION_COMPLETE, true));
        }
        return this.preferenceStore.get().getBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, false);
    }
}
