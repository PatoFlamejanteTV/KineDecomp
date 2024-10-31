package com.google.android.gms.drive.events;

import android.app.Service;

/* loaded from: classes2.dex */
public abstract class DriveEventService extends Service implements ChangeListener, CompletionListener, zzc {

    /* renamed from: a, reason: collision with root package name */
    boolean f1071a;
    int b;
    private final String c;

    protected DriveEventService() {
        this("DriveEventService");
    }

    protected DriveEventService(String str) {
        this.f1071a = false;
        this.b = -1;
        this.c = str;
    }
}
