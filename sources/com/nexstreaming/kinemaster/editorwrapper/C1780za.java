package com.nexstreaming.kinemaster.editorwrapper;

import com.nextreaming.nexeditorui.NexTimeline;

/* compiled from: Project.java */
/* renamed from: com.nexstreaming.kinemaster.editorwrapper.za */
/* loaded from: classes.dex */
public class C1780za {

    /* renamed from: a */
    private NexTimeline f20381a;

    public C1780za(NexTimeline nexTimeline) {
        this.f20381a = nexTimeline;
    }

    public NexTimeline a() {
        return this.f20381a;
    }

    public void b() {
        NexTimeline nexTimeline = this.f20381a;
        if (nexTimeline != null) {
            nexTimeline.release();
        }
    }
}
