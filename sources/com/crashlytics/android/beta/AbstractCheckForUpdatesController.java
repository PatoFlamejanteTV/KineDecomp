package com.crashlytics.android.beta;

import android.annotation.SuppressLint;
import android.content.Context;
import io.fabric.sdk.android.a.c.c;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.i;
import io.fabric.sdk.android.services.common.m;
import io.fabric.sdk.android.services.network.f;
import io.fabric.sdk.android.services.settings.g;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
abstract class AbstractCheckForUpdatesController implements UpdatesController {
    static final long LAST_UPDATE_CHECK_DEFAULT = 0;
    static final String LAST_UPDATE_CHECK_KEY = "last_update_check";
    private static final long MILLIS_PER_SECOND = 1000;
    private Beta beta;
    private g betaSettings;
    private BuildProperties buildProps;
    private Context context;
    private m currentTimeProvider;
    private final AtomicBoolean externallyReady;
    private f httpRequestFactory;
    private IdManager idManager;
    private final AtomicBoolean initialized;
    private long lastCheckTimeMillis;
    private c preferenceStore;

    public AbstractCheckForUpdatesController() {
        this(false);
    }

    private void performUpdateCheck() {
        io.fabric.sdk.android.f.f().d(Beta.TAG, "Performing update check");
        String d2 = new i().d(this.context);
        String str = this.idManager.g().get(IdManager.DeviceIdentifierType.FONT_TOKEN);
        Beta beta = this.beta;
        new CheckForUpdatesRequest(beta, beta.getOverridenSpiEndpoint(), this.betaSettings.f27017a, this.httpRequestFactory, new CheckForUpdatesResponseTransform()).invoke(d2, str, this.buildProps);
    }

    @SuppressLint({"CommitPrefEdits"})
    public void checkForUpdates() {
        synchronized (this.preferenceStore) {
            if (this.preferenceStore.get().contains(LAST_UPDATE_CHECK_KEY)) {
                this.preferenceStore.a(this.preferenceStore.edit().remove(LAST_UPDATE_CHECK_KEY));
            }
        }
        long a2 = this.currentTimeProvider.a();
        long j = this.betaSettings.f27018b * MILLIS_PER_SECOND;
        io.fabric.sdk.android.f.f().d(Beta.TAG, "Check for updates delay: " + j);
        io.fabric.sdk.android.f.f().d(Beta.TAG, "Check for updates last check time: " + getLastCheckTimeMillis());
        long lastCheckTimeMillis = getLastCheckTimeMillis() + j;
        io.fabric.sdk.android.f.f().d(Beta.TAG, "Check for updates current time: " + a2 + ", next check time: " + lastCheckTimeMillis);
        if (a2 >= lastCheckTimeMillis) {
            try {
                performUpdateCheck();
                return;
            } finally {
                setLastCheckTimeMillis(a2);
            }
        }
        io.fabric.sdk.android.f.f().d(Beta.TAG, "Check for updates next check time was not passed");
    }

    long getLastCheckTimeMillis() {
        return this.lastCheckTimeMillis;
    }

    @Override // com.crashlytics.android.beta.UpdatesController
    public void initialize(Context context, Beta beta, IdManager idManager, g gVar, BuildProperties buildProperties, c cVar, m mVar, f fVar) {
        this.context = context;
        this.beta = beta;
        this.idManager = idManager;
        this.betaSettings = gVar;
        this.buildProps = buildProperties;
        this.preferenceStore = cVar;
        this.currentTimeProvider = mVar;
        this.httpRequestFactory = fVar;
        if (signalInitialized()) {
            checkForUpdates();
        }
    }

    void setLastCheckTimeMillis(long j) {
        this.lastCheckTimeMillis = j;
    }

    public boolean signalExternallyReady() {
        this.externallyReady.set(true);
        return this.initialized.get();
    }

    boolean signalInitialized() {
        this.initialized.set(true);
        return this.externallyReady.get();
    }

    public AbstractCheckForUpdatesController(boolean z) {
        this.initialized = new AtomicBoolean();
        this.lastCheckTimeMillis = 0L;
        this.externallyReady = new AtomicBoolean(z);
    }
}
