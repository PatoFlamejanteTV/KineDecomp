package com.nextreaming.nexeditorui;

import android.util.Log;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: NexAudioClipItem.java */
/* renamed from: com.nextreaming.nexeditorui.ea, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C2305ea implements NexTimelineItem.x<NexAudioClipItem> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24241a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24242b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f24243c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ NexTimelineItem.y f24244d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ NexAudioClipItem f24245e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2305ea(NexAudioClipItem nexAudioClipItem, int i, int i2, int i3, NexTimelineItem.y yVar) {
        this.f24245e = nexAudioClipItem;
        this.f24241a = i;
        this.f24242b = i2;
        this.f24243c = i3;
        this.f24244d = yVar;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.x
    public void a(int i) {
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
        if (this.f24241a != 1) {
            z = this.f24245e.m_loop;
            if (z) {
                NexAudioClipItem nexAudioClipItem = this.f24245e;
                i5 = nexAudioClipItem.m_relativeStartTime;
                nexAudioClipItem.m_relativeEndTime = i5 + this.f24242b + i;
                i6 = this.f24245e.m_relativeEndTime;
                i7 = this.f24245e.m_relativeStartTime;
                if (i6 >= i7 + 100) {
                    i8 = this.f24245e.m_relativeEndTime;
                    i9 = this.f24245e.m_relativeStartTime;
                    if ((i8 - i9) - i > this.f24243c) {
                        NexAudioClipItem nexAudioClipItem2 = this.f24245e;
                        i10 = nexAudioClipItem2.m_relativeStartTime;
                        nexAudioClipItem2.m_relativeEndTime = i10 + this.f24242b + this.f24243c;
                        return;
                    }
                    return;
                }
                NexAudioClipItem nexAudioClipItem3 = this.f24245e;
                i11 = nexAudioClipItem3.m_relativeStartTime;
                nexAudioClipItem3.m_relativeEndTime = i11 + 100;
                return;
            }
            int endTrim = (this.f24242b - i) - this.f24245e.getEndTrim();
            int endTime = this.f24245e.getEndTime() - endTrim;
            i2 = this.f24245e.m_duration;
            if (endTime > i2 + this.f24245e.getStartTime()) {
                int startTime = this.f24245e.getStartTime();
                i4 = this.f24245e.m_duration;
                endTime = startTime + i4;
            }
            if (endTime - this.f24245e.getStartTime() < 100) {
                endTime = this.f24245e.getStartTime() + 100;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[trim] endTrim: ");
            sb.append(endTrim);
            sb.append(", endTime: ");
            sb.append(endTime);
            sb.append(", startTrim: ");
            sb.append(this.f24242b);
            sb.append(", deltaTime: ");
            sb.append(i);
            sb.append(", dration: ");
            i3 = this.f24245e.m_duration;
            sb.append(i3);
            sb.append(", getEndTime: ");
            sb.append(this.f24245e.getEndTime());
            Log.d("NexAudioClipItem", sb.toString());
            NexAudioClipItem nexAudioClipItem4 = this.f24245e;
            nexAudioClipItem4.trimClip(nexAudioClipItem4.getStartTime(), endTime);
            return;
        }
        int startTime2 = this.f24245e.getStartTime() + ((this.f24242b + i) - this.f24245e.getStartTrim());
        if (startTime2 < 0) {
            startTime2 = 0;
        }
        if (this.f24245e.getEndTime() - startTime2 < 100) {
            startTime2 = this.f24245e.getEndTime() - 100;
        }
        NexAudioClipItem nexAudioClipItem5 = this.f24245e;
        nexAudioClipItem5.trimClip(startTime2, nexAudioClipItem5.getEndTime());
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.x
    public int b() {
        return this.f24242b;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.x
    public void commit() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.nextreaming.nexeditorui.NexTimelineItem.x
    public NexAudioClipItem getItem() {
        return this.f24245e;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.x
    public String a() {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        if (this.f24241a == 1) {
            NexTimelineItem.y yVar = this.f24244d;
            i4 = this.f24245e.m_trimTimeStart;
            return yVar.getString(R.string.video_drag_starttrim, EditorGlobal.a(i4));
        }
        NexTimelineItem.y yVar2 = this.f24244d;
        Object[] objArr = new Object[1];
        z = this.f24245e.m_loop;
        if (z) {
            i2 = this.f24245e.m_relativeEndTime;
            i3 = this.f24245e.m_relativeStartTime;
            i = i2 - i3;
        } else {
            i = this.f24245e.m_trimTimeEnd;
        }
        objArr[0] = EditorGlobal.a(i);
        return yVar2.getString(R.string.video_drag_endtrim, objArr);
    }
}
