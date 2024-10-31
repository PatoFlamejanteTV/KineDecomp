package com.nexstreaming.kinemaster.editorwrapper;

import com.nextreaming.nexeditorui.NexTimeline;

/* compiled from: Project.java */
/* loaded from: classes.dex */
public class ar {

    /* renamed from: a, reason: collision with root package name */
    private NexTimeline f3319a;

    public ar(NexTimeline nexTimeline) {
        this.f3319a = nexTimeline;
    }

    public NexTimeline a() {
        return this.f3319a;
    }

    public void b() {
        if (this.f3319a != null) {
            this.f3319a.release();
        }
    }
}
