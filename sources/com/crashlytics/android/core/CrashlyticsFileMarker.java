package com.crashlytics.android.core;

import io.fabric.sdk.android.a.c.a;
import io.fabric.sdk.android.f;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class CrashlyticsFileMarker {
    private final a fileStore;
    private final String markerName;

    public CrashlyticsFileMarker(String str, a aVar) {
        this.markerName = str;
        this.fileStore = aVar;
    }

    private File getMarkerFile() {
        return new File(this.fileStore.a(), this.markerName);
    }

    public boolean create() {
        try {
            return getMarkerFile().createNewFile();
        } catch (IOException e2) {
            f.f().c(CrashlyticsCore.TAG, "Error creating marker: " + this.markerName, e2);
            return false;
        }
    }

    public boolean isPresent() {
        return getMarkerFile().exists();
    }

    public boolean remove() {
        return getMarkerFile().delete();
    }
}
