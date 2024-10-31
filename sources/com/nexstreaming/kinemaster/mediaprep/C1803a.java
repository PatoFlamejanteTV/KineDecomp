package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.MediaSupportType;

/* compiled from: MediaPrepInfo.java */
/* renamed from: com.nexstreaming.kinemaster.mediaprep.a */
/* loaded from: classes.dex */
public class C1803a {

    /* renamed from: a */
    public MediaPrepState f20781a;

    /* renamed from: b */
    public int f20782b;

    /* renamed from: c */
    public int f20783c;

    /* renamed from: d */
    public Task.TaskError f20784d;

    /* renamed from: e */
    public MediaSupportType f20785e;

    /* renamed from: f */
    public Runnable f20786f;

    /* renamed from: g */
    public String f20787g;

    public C1803a() {
        MediaPrepState mediaPrepState = MediaPrepState.None;
        this.f20781a = mediaPrepState;
        this.f20781a = mediaPrepState;
        this.f20782b = 0;
        this.f20783c = 100;
        this.f20784d = null;
        this.f20785e = null;
        this.f20786f = null;
        this.f20787g = null;
    }

    public void a() {
        this.f20781a = MediaPrepState.None;
        this.f20782b = 0;
        this.f20783c = 100;
        this.f20784d = null;
        this.f20785e = null;
        this.f20786f = null;
        this.f20787g = null;
    }

    public void a(MediaPrepState mediaPrepState, int i, int i2) {
        this.f20781a = mediaPrepState;
        this.f20782b = i;
        this.f20783c = i2;
        this.f20784d = null;
        this.f20785e = null;
        this.f20786f = null;
        this.f20787g = null;
    }

    public void a(MediaPrepState mediaPrepState) {
        this.f20781a = mediaPrepState;
        this.f20783c = 0;
        this.f20782b = 100;
        this.f20784d = null;
        this.f20785e = null;
        this.f20786f = null;
        this.f20787g = null;
    }

    public void a(MediaPrepState mediaPrepState, Task.TaskError taskError) {
        this.f20781a = mediaPrepState;
        this.f20783c = 0;
        this.f20782b = 100;
        this.f20784d = taskError;
        this.f20785e = null;
        this.f20786f = null;
        this.f20787g = null;
    }

    public void a(C1803a c1803a) {
        this.f20781a = c1803a.f20781a;
        this.f20782b = c1803a.f20782b;
        this.f20783c = c1803a.f20783c;
        this.f20784d = c1803a.f20784d;
        this.f20785e = c1803a.f20785e;
        this.f20786f = null;
        this.f20787g = null;
    }

    public void a(MediaSupportType mediaSupportType) {
        this.f20781a = MediaPrepState.FailNotSupported;
        this.f20783c = 0;
        this.f20782b = 100;
        this.f20784d = null;
        this.f20785e = mediaSupportType;
        this.f20786f = null;
        this.f20787g = null;
    }

    public void a(Runnable runnable) {
        this.f20781a = MediaPrepState.UserInterventionRequired;
        this.f20783c = 0;
        this.f20782b = 100;
        this.f20784d = null;
        this.f20785e = null;
        this.f20786f = runnable;
        this.f20787g = null;
    }

    public void a(String str) {
        this.f20781a = MediaPrepState.Completed;
        this.f20783c = 0;
        this.f20782b = 100;
        this.f20784d = null;
        this.f20785e = null;
        this.f20786f = null;
        this.f20787g = str;
    }
}
