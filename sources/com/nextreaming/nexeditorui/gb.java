package com.nextreaming.nexeditorui;

import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
public class gb implements NexTimelineItem.x<NexVideoClipItem> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24285a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24286b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ NexTimelineItem.y f24287c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem f24288d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gb(NexVideoClipItem nexVideoClipItem, int i, int i2, NexTimelineItem.y yVar) {
        this.f24288d = nexVideoClipItem;
        this.f24285a = i;
        this.f24286b = i2;
        this.f24287c = yVar;
    }

    private void b(int i) {
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        z = this.f24288d.m_isImage;
        if (!z) {
            this.f24288d.m_trimTimeStart = this.f24286b + i;
            NexVideoClipItem nexVideoClipItem = this.f24288d;
            i2 = nexVideoClipItem.m_trimTimeStart;
            nexVideoClipItem.m_trimTimeStart = nexVideoClipItem.snapToIFrame(i2);
            i3 = this.f24288d.m_duration;
            i4 = this.f24288d.m_trimTimeEnd;
            int snapToIFrame = this.f24288d.snapToIFrame((i3 - i4) - Math.round((Math.max(100, (this.f24288d.getStartOverlap() + this.f24288d.getEndOverlap()) + 100) * this.f24288d.getPlaybackSpeed()) / 100.0f));
            i5 = this.f24288d.m_trimTimeStart;
            if (i5 > snapToIFrame) {
                this.f24288d.m_trimTimeStart = snapToIFrame;
            }
            i6 = this.f24288d.m_trimTimeStart;
            if (i6 < 0) {
                this.f24288d.m_trimTimeStart = 0;
            }
            NexVideoClipItem nexVideoClipItem2 = this.f24288d;
            i7 = nexVideoClipItem2.m_duration;
            i8 = this.f24288d.m_trimTimeEnd;
            int i12 = i7 - i8;
            i9 = this.f24288d.m_trimTimeStart;
            nexVideoClipItem2.m_trimmedDuration = i12 - i9;
            return;
        }
        int max = this.f24288d.getTimeline().getPrimaryItemCount() != 1 ? Math.max(this.f24288d.getStartOverlap() + this.f24288d.getEndOverlap() + 100, 100) : 100;
        this.f24288d.m_duration = this.f24286b - i;
        i10 = this.f24288d.m_duration;
        if (i10 < max) {
            this.f24288d.m_duration = max;
        }
        i11 = this.f24288d.m_duration;
        if (i11 > 1800000) {
            this.f24288d.m_duration = 1800000;
        }
    }

    private void c(int i) {
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        z = this.f24288d.m_isImage;
        if (!z) {
            this.f24288d.m_trimTimeEnd = this.f24286b - i;
            i2 = this.f24288d.m_duration;
            i3 = this.f24288d.m_trimTimeStart;
            int round = (i2 - i3) - Math.round((Math.max((this.f24288d.getStartOverlap() + this.f24288d.getEndOverlap()) + 100, 100) * this.f24288d.getPlaybackSpeed()) / 100.0f);
            i4 = this.f24288d.m_trimTimeEnd;
            if (i4 > round) {
                this.f24288d.m_trimTimeEnd = round;
            }
            i5 = this.f24288d.m_trimTimeEnd;
            if (i5 < 0) {
                this.f24288d.m_trimTimeEnd = 0;
            }
            NexVideoClipItem nexVideoClipItem = this.f24288d;
            i6 = nexVideoClipItem.m_duration;
            i7 = this.f24288d.m_trimTimeEnd;
            int i11 = i6 - i7;
            i8 = this.f24288d.m_trimTimeStart;
            nexVideoClipItem.m_trimmedDuration = i11 - i8;
            return;
        }
        int max = this.f24288d.getTimeline().getPrimaryItemCount() != 1 ? Math.max(this.f24288d.getStartOverlap() + this.f24288d.getEndOverlap() + 100, 100) : 100;
        this.f24288d.m_duration = this.f24286b + i;
        i9 = this.f24288d.m_duration;
        if (i9 < max) {
            this.f24288d.m_duration = max;
        }
        i10 = this.f24288d.m_duration;
        if (i10 > 1800000) {
            this.f24288d.m_duration = 1800000;
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.x
    public void a(int i) {
        if (this.f24285a == 1) {
            b(i);
        } else {
            c(i);
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.x
    public void commit() {
        NexVideoClipItem nexVideoClipItem = this.f24288d;
        nexVideoClipItem.checkEffectTime(nexVideoClipItem.getEffectStartTime(), this.f24288d.getEffectEndTime(), this.f24285a);
        this.f24288d.getTransition().ensureTransitionFits();
        if (this.f24288d.getPrecedingTransition() != null) {
            this.f24288d.getPrecedingTransition().ensureTransitionFits();
        }
        this.f24288d.getTimeline().requestCalcTimes();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.nextreaming.nexeditorui.NexTimelineItem.x
    public NexVideoClipItem getItem() {
        return this.f24288d;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.x
    public String a() {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        z = this.f24288d.m_isImage;
        if (z) {
            return this.f24287c.getString(R.string.video_drag_duration, EditorGlobal.a(this.f24288d.getDuration()));
        }
        if (this.f24285a == 1) {
            StringBuilder sb = new StringBuilder();
            NexTimelineItem.y yVar = this.f24287c;
            i3 = this.f24288d.m_trimmedDuration;
            sb.append(yVar.getString(R.string.video_drag_duration, EditorGlobal.a((i3 * 100) / this.f24288d.getPlaybackSpeed())));
            sb.append('\n');
            NexTimelineItem.y yVar2 = this.f24287c;
            i4 = this.f24288d.m_trimTimeStart;
            sb.append(yVar2.getString(R.string.video_drag_starttrim, EditorGlobal.a(i4)));
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        NexTimelineItem.y yVar3 = this.f24287c;
        i = this.f24288d.m_trimmedDuration;
        sb2.append(yVar3.getString(R.string.video_drag_duration, EditorGlobal.a((i * 100) / this.f24288d.getPlaybackSpeed())));
        sb2.append('\n');
        NexTimelineItem.y yVar4 = this.f24287c;
        i2 = this.f24288d.m_trimTimeEnd;
        sb2.append(yVar4.getString(R.string.video_drag_endtrim, EditorGlobal.a(i2)));
        return sb2.toString();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.x
    public int b() {
        return this.f24286b;
    }
}
