package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.nexstreaming.app.general.iab.PurchaseType;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepManager;
import com.nexstreaming.kinemaster.ui.projectedit.TimelineView;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.WhichTimeline;

/* compiled from: ITimelineView.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.timeline.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC2025f {
    int a(boolean z);

    Rect a(NexTimelineItem nexTimelineItem);

    void a(int i);

    void a(int i, int i2, int i3);

    void a(int i, boolean z);

    void a(NexTimelineItem nexTimelineItem, TimelineView.AnimType animType, int i);

    void a(NexTimelineItem nexTimelineItem, boolean z);

    void a(NexTimelineItem nexTimelineItem, boolean z, boolean z2);

    void a(boolean z, Context context);

    boolean a();

    int b(NexTimelineItem nexTimelineItem, boolean z);

    void b();

    void b(NexTimelineItem nexTimelineItem);

    int c();

    void d();

    void e();

    void f();

    int g();

    int getCurrentTime();

    int getCurrentTimeAndStopFling();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    int getMSPerPixel();

    NexTimelineItem getOldSelectedItem();

    int getSelectedIndex();

    NexTimelineItem getSelectedItem();

    WhichTimeline getSelectedTimeline();

    NexTimeline getTimeline();

    int getWidth();

    boolean h();

    void i();

    void invalidate();

    boolean j();

    boolean k();

    void l();

    boolean post(Runnable runnable);

    boolean removeCallbacks(Runnable runnable);

    void requestLayout();

    void setEditingMode(int i);

    void setEditor(VideoEditor videoEditor);

    void setEnabled(boolean z);

    void setExpanded(boolean z);

    void setExpandingAnimation(boolean z);

    void setImageWorker(FragmentManager fragmentManager);

    void setLayoutParams(ViewGroup.LayoutParams layoutParams);

    void setListener(TimelineView.d dVar);

    void setMediaPrepManager(MediaPrepManager mediaPrepManager);

    void setOnTimelineScrollListener(TimelineView.f fVar);

    void setPlaying(boolean z);

    void setPurchaseType(PurchaseType purchaseType);

    void setSelectedItem(NexTimelineItem nexTimelineItem);

    void setSuppressScrollEvents(boolean z);

    void setTimeline(NexTimeline nexTimeline);

    void setVisibility(int i);

    void startAnimation(Animation animation);
}
