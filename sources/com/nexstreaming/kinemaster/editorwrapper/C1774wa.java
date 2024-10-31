package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: NexLayerItem.java */
/* renamed from: com.nexstreaming.kinemaster.editorwrapper.wa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C1774wa implements NexTimelineItem.x<NexLayerItem> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f20370a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f20371b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f20372c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ NexTimelineItem.y f20373d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ NexLayerItem f20374e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1774wa(NexLayerItem nexLayerItem, int i, int i2, int i3, NexTimelineItem.y yVar) {
        this.f20374e = nexLayerItem;
        this.f20370a = i;
        this.f20371b = i2;
        this.f20372c = i3;
        this.f20373d = yVar;
    }

    private void b(int i) {
        int i2 = this.f20371b + i;
        if (this.f20374e.getEndTime() - i2 < this.f20372c) {
            i2 = this.f20374e.getEndTime() - this.f20372c;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        NexLayerItem nexLayerItem = this.f20374e;
        nexLayerItem.trimClip(i2, nexLayerItem.getEndTime());
    }

    private void c(int i) {
        int i2 = this.f20371b + i;
        int i3 = this.f20372c;
        if (i2 >= i3) {
            i3 = i2;
        }
        if (i3 > this.f20374e.getTimeline().getTotalTime()) {
            i3 = this.f20374e.getTimeline().getTotalTime();
        }
        NexLayerItem nexLayerItem = this.f20374e;
        nexLayerItem.trimClip(nexLayerItem.getStartTime(), this.f20374e.getStartTime() + i3);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.x
    public void a(int i) {
        if (this.f20370a == 1) {
            b(i);
        } else {
            c(i);
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.x
    public void commit() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.nextreaming.nexeditorui.NexTimelineItem.x
    public NexLayerItem getItem() {
        return this.f20374e;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.x
    public String a() {
        return this.f20373d.getString(R.string.video_drag_duration, EditorGlobal.a(this.f20374e.getDuration()));
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.x
    public int b() {
        return this.f20371b;
    }
}
