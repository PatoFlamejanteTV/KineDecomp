package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;

/* compiled from: MediaPrepInfo.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public MediaPrepState f3523a = null;
    public int b = 0;
    public int c = 100;
    public Task.TaskError d = null;
    public MediaStoreItem.MediaSupportType e = null;
    public Runnable f = null;
    public String g = null;

    public void a() {
        this.f3523a = null;
        this.b = 0;
        this.c = 100;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
    }

    public void a(MediaPrepState mediaPrepState, int i, int i2) {
        this.f3523a = mediaPrepState;
        this.b = i;
        this.c = i2;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
    }

    public void a(MediaPrepState mediaPrepState) {
        this.f3523a = mediaPrepState;
        this.c = 0;
        this.b = 100;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
    }

    public void a(MediaPrepState mediaPrepState, Task.TaskError taskError) {
        this.f3523a = mediaPrepState;
        this.c = 0;
        this.b = 100;
        this.d = taskError;
        this.e = null;
        this.f = null;
        this.g = null;
    }

    public void a(a aVar) {
        this.f3523a = aVar.f3523a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = null;
        this.g = null;
    }

    public void a(MediaStoreItem.MediaSupportType mediaSupportType) {
        this.f3523a = MediaPrepState.FailNotSupported;
        this.c = 0;
        this.b = 100;
        this.d = null;
        this.e = mediaSupportType;
        this.f = null;
        this.g = null;
    }

    public void a(Runnable runnable) {
        this.f3523a = MediaPrepState.UserInterventionRequired;
        this.c = 0;
        this.b = 100;
        this.d = null;
        this.e = null;
        this.f = runnable;
        this.g = null;
    }

    public void a(String str) {
        this.f3523a = MediaPrepState.Completed;
        this.c = 0;
        this.b = 100;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = str;
    }
}
