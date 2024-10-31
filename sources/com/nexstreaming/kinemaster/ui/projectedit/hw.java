package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.MotionEvent;
import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.nextreaming.nexvideoeditor.NexThemeView;
import java.lang.ref.WeakReference;

/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
class hw implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f3966a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hw(ProjectEditActivity projectEditActivity) {
        this.f3966a = projectEditActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        NexThemeView nexThemeView;
        TimelineView timelineView;
        WeakReference weakReference;
        boolean z;
        boolean z2;
        com.nexstreaming.kinemaster.editorwrapper.ar f;
        NexTimeline a2;
        String effectID;
        NexThemeView nexThemeView2;
        NexThemeView nexThemeView3;
        boolean z3;
        TimelineView timelineView2;
        TimelineView timelineView3;
        TimelineView timelineView4;
        TimelineView timelineView5;
        TimelineView timelineView6;
        NexLayerItem nexLayerItem;
        WeakReference weakReference2;
        ht htVar;
        ht htVar2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            nexThemeView = this.f3966a.i;
            if (nexThemeView.isEnabled()) {
                timelineView = this.f3966a.k;
                if (timelineView.getTimeline().getPrimaryItemCount() >= 1) {
                    weakReference = this.f3966a.F;
                    if (weakReference != null) {
                        weakReference2 = this.f3966a.F;
                        ht htVar3 = (ht) weakReference2.get();
                        if (htVar3 != null) {
                            this.f3966a.H = htVar3;
                            z = htVar3.a(view, motionEvent);
                            z2 = this.f3966a.J;
                            if (z2 && !z && (f = this.f3966a.p().f()) != null && (a2 = f.a()) != null) {
                                int v = this.f3966a.p().v();
                                int secondaryItemCount = a2.getSecondaryItemCount();
                                float x = (motionEvent.getX() * 1280.0f) / view.getWidth();
                                float y = (motionEvent.getY() * 720.0f) / view.getHeight();
                                NexLayerItem nexLayerItem2 = null;
                                int i = 0;
                                while (i < secondaryItemCount) {
                                    NexSecondaryTimelineItem secondaryItem = a2.getSecondaryItem(i);
                                    int absStartTime = secondaryItem.getAbsStartTime();
                                    int absEndTime = secondaryItem.getAbsEndTime();
                                    if (v >= absStartTime && v <= absEndTime && (secondaryItem instanceof NexLayerItem)) {
                                        if (nexLayerItem2 != null && nexLayerItem2.getZOrder() > ((NexLayerItem) secondaryItem).getZOrder()) {
                                            nexLayerItem = nexLayerItem2;
                                        } else if (((NexLayerItem) secondaryItem).isPointInLayerAtTime(x, y, v)) {
                                            nexLayerItem = (NexLayerItem) secondaryItem;
                                        }
                                        i++;
                                        nexLayerItem2 = nexLayerItem;
                                    }
                                    nexLayerItem = nexLayerItem2;
                                    i++;
                                    nexLayerItem2 = nexLayerItem;
                                }
                                if (nexLayerItem2 != null) {
                                    this.f3966a.Y = false;
                                    timelineView4 = this.f3966a.k;
                                    timelineView4.setSelectedItem(nexLayerItem2);
                                    timelineView5 = this.f3966a.k;
                                    timelineView5.invalidate();
                                    timelineView6 = this.f3966a.k;
                                    timelineView6.a(true);
                                    return true;
                                }
                                NexVideoClipItem firstVideoClipAtTime = a2.getFirstVideoClipAtTime(v);
                                if (firstVideoClipAtTime != null && (effectID = firstVideoClipAtTime.getEffectID()) != null) {
                                    int effectStartTime = firstVideoClipAtTime.getEffectStartTime() + firstVideoClipAtTime.getAbsStartTime();
                                    int effectEndTime = firstVideoClipAtTime.getEffectEndTime() + firstVideoClipAtTime.getAbsStartTime();
                                    if (v >= effectStartTime && v <= effectEndTime) {
                                        float x2 = motionEvent.getX();
                                        nexThemeView2 = this.f3966a.i;
                                        float width = x2 / nexThemeView2.getWidth();
                                        float y2 = motionEvent.getY();
                                        nexThemeView3 = this.f3966a.i;
                                        float height = 1.0f - (y2 / nexThemeView3.getHeight());
                                        if (effectID.equals("com.nexstreaming.kinemaster.basic.opening")) {
                                            z3 = ((double) width) > 0.2d && ((double) width) < 0.8d && ((double) height) > 0.4d && ((double) height) < 0.6d;
                                        } else if (effectID.equals("com.nexstreaming.kinemaster.builtin.title.bulletin")) {
                                            z3 = ((double) width) > 0.2d && ((double) width) < 0.8d && ((double) height) > 0.43d && ((double) height) < 0.57d;
                                        } else if (effectID.equals("com.nexstreaming.kinemaster.builtin.title.simple")) {
                                            z3 = ((double) height) < 0.21d;
                                        } else if (effectID.startsWith("com.nexstreaming.kinemaster.builtin.title")) {
                                            z3 = ((double) width) > 0.2d && ((double) width) < 0.8d && ((double) height) > 0.43d && ((double) height) < 0.57d;
                                        } else if (effectID.equals("com.nexstreaming.kinemaster.onstage.opening")) {
                                            z3 = ((double) width) > 0.2d && ((double) width) < 0.8d && ((double) height) > 0.1d && ((double) height) < 0.4d;
                                        } else if (effectID.equals("com.nexstreaming.kinemaster.onstage.ending")) {
                                            z3 = ((double) width) > 0.2d && ((double) width) < 0.8d && ((double) height) > 0.1d && ((double) height) < 0.4d;
                                        } else if (effectID.equals("com.nexstreaming.kinemaster.onstage.middle")) {
                                            z3 = ((double) height) < 0.3d;
                                        } else if (effectID.equals("com.nexstreaming.kinemaster.travel.opening")) {
                                            z3 = ((double) width) > 0.2d && ((double) width) < 0.8d && ((double) height) > 0.25d && ((double) height) < 0.5d;
                                        } else if (effectID.equals("com.nexstreaming.kinemaster.travel.middle")) {
                                            z3 = ((double) height) < 0.4d;
                                        } else if (effectID.equals("com.nexstreaming.kinemaster.travel.ending")) {
                                            z3 = ((double) height) < 0.4d;
                                        } else if (effectID.equals("com.nexstreaming.kinemaster.basic.ending")) {
                                            z3 = ((double) height) < 0.21d;
                                        } else if (effectID.equals("com.nexstreaming.kinemaster.basic.middle")) {
                                            z3 = ((double) height) < 0.21d;
                                        } else if (effectID.equals("com.nexstreaming.kinemaster.basic.accent")) {
                                            z3 = false;
                                        } else if (effectID.equals("com.nexstreaming.kinemaster.serene.ending")) {
                                            z3 = ((double) width) > 0.6d && ((double) height) < 0.3d;
                                        } else if (effectID.equals("com.nexstreaming.kinemaster.serene.middle")) {
                                            z3 = ((double) height) < 0.3d;
                                        } else if (effectID.contains("accent")) {
                                            z3 = false;
                                        } else if (effectID.contains("opening")) {
                                            z3 = ((double) width) > 0.2d && ((double) width) < 0.8d && ((double) height) > 0.4d && ((double) height) < 0.6d;
                                        } else {
                                            z3 = true;
                                        }
                                        if (z3) {
                                            this.f3966a.Y = true;
                                            timelineView2 = this.f3966a.k;
                                            timelineView2.setSelectedItem(firstVideoClipAtTime);
                                            timelineView3 = this.f3966a.k;
                                            timelineView3.invalidate();
                                            return true;
                                        }
                                        return z;
                                    }
                                    return z;
                                }
                                return z;
                            }
                            return z;
                        }
                    }
                    z = false;
                    z2 = this.f3966a.J;
                    return z2 ? z : z;
                }
            }
            return false;
        }
        boolean z4 = false;
        htVar = this.f3966a.H;
        if (htVar != null) {
            htVar2 = this.f3966a.H;
            z4 = htVar2.a(view, motionEvent);
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f3966a.H = null;
            return z4;
        }
        return z4;
    }
}
