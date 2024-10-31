package com.nextreaming.nexeditorui;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.ui.projectedit.C1916ib;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2028i;
import com.nexstreaming.kinemaster.ui.widget.TimelineItemLayout;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes.dex */
public abstract class NexSecondaryTimelineItem extends NexTimelineItem implements Comparable<NexSecondaryTimelineItem> {
    private static final long serialVersionUID = 1;

    /* renamed from: b, reason: collision with root package name */
    private transient int f24116b;

    /* renamed from: c, reason: collision with root package name */
    private transient int f24117c;

    /* renamed from: d, reason: collision with root package name */
    private transient WeakReference<com.nexstreaming.kinemaster.editorwrapper.Ea> f24118d;

    /* renamed from: e, reason: collision with root package name */
    private transient boolean f24119e = false;
    public int track_id;

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa
    public void bindView(View view, InterfaceC2028i interfaceC2028i) {
        super.bindView(view, interfaceC2028i);
        TimelineItemLayout timelineItemLayout = (TimelineItemLayout) view.findViewById(R.id.item_layout);
        if (timelineItemLayout != null) {
            timelineItemLayout.setEnabled(getTrack().m());
        }
    }

    public final void drawLayerAnimation(C1916ib c1916ib, List<NexLayerItem.b> list, int i, int i2) {
        List<ob> list2;
        List<NexLayerItem.b> list3 = list;
        if (c1916ib == null || !c1916ib.p()) {
            return;
        }
        int i3 = 1;
        if (c1916ib.d() == R.id.editmode_layer_anim || (list3 != null && list.size() > 1)) {
            List<ob> b2 = c1916ib.b();
            Drawable drawable = c1916ib.getResources().getDrawable(i2);
            int intrinsicWidth = drawable.getIntrinsicWidth() / 2;
            int intrinsicHeight = drawable.getIntrinsicHeight() / 2;
            Canvas a2 = c1916ib.a();
            RectF k = c1916ib.k();
            int i4 = 0;
            while (i4 < list.size()) {
                float f2 = list3.get(i4).f20230a;
                float width = k.width() * f2;
                if (i4 != 0 && b2 != null) {
                    int i5 = 0;
                    while (i5 < b2.size() - i3) {
                        ob obVar = b2.get(i5);
                        i5++;
                        ob obVar2 = b2.get(i5);
                        int i6 = obVar.f24385a;
                        float f3 = i * f2;
                        if (i6 <= f3) {
                            list2 = b2;
                            if (f3 < obVar2.f24385a) {
                                width = obVar.f24386b + (((f3 - i6) * (obVar2.f24386b - r1)) / (r3 - i6));
                                break;
                            }
                        } else {
                            list2 = b2;
                        }
                        b2 = list2;
                        i3 = 1;
                    }
                }
                list2 = b2;
                float centerY = k.centerY();
                float f4 = intrinsicWidth;
                float f5 = intrinsicHeight;
                drawable.setBounds((int) (width - f4), (int) (centerY - f5), (int) (width + f4), (int) (centerY + f5));
                drawable.draw(a2);
                i4++;
                list3 = list;
                b2 = list2;
                i3 = 1;
            }
        }
    }

    public final void drawPin(C1916ib c1916ib, int i) {
        if (getPinned()) {
            Canvas a2 = c1916ib.a();
            Drawable drawable = c1916ib.getResources().getDrawable(i);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            RectF e2 = c1916ib.e();
            int min = (int) Math.min(e2.height(), intrinsicHeight);
            int i2 = (intrinsicWidth * min) / intrinsicHeight;
            int height = (int) ((e2.height() - min) / 2.0f);
            drawable.setBounds((((int) e2.width()) - height) - i2, height, ((int) e2.width()) - height, min + height);
            drawable.draw(a2);
        }
    }

    @Deprecated
    public abstract NexPrimaryTimelineItem getAnchorItem();

    public abstract int getEndTime();

    public abstract int getEndTrim();

    public abstract int getIntinsicDuration();

    public boolean getOverLimit() {
        return this.f24119e;
    }

    public abstract boolean getPinned();

    @Deprecated
    public abstract int getRelativeEndTime();

    @Deprecated
    public abstract int getRelativeStartTime();

    public abstract int getStartTime();

    public abstract int getStartTrim();

    public int getSubTrackMapping() {
        return this.f24117c;
    }

    public com.nexstreaming.kinemaster.editorwrapper.Ea getTrack() {
        WeakReference<com.nexstreaming.kinemaster.editorwrapper.Ea> weakReference = this.f24118d;
        if (weakReference != null) {
            com.nexstreaming.kinemaster.editorwrapper.Ea ea = weakReference.get();
            if (ea != null && ea.c() == this.track_id) {
                return ea;
            }
            this.f24118d.clear();
        }
        NexTimeline timeline = getTimeline();
        if (timeline == null) {
            return null;
        }
        com.nexstreaming.kinemaster.editorwrapper.Ea trackById = timeline.getTrackById(this.track_id);
        if (trackById != null) {
            this.f24118d = new WeakReference<>(trackById);
        }
        return trackById;
    }

    public int getTrackAffinity() {
        return 0;
    }

    public int getTrackId() {
        return this.track_id;
    }

    public int getTrackMapping() {
        return this.f24116b;
    }

    public int[] getTrackOptionItems() {
        return null;
    }

    public abstract boolean hasIntrinsicDuration();

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.InterfaceC1732b
    public boolean isDraggable() {
        return true;
    }

    public abstract void moveClip(int i);

    @Deprecated
    public abstract void setAnchorItem(NexPrimaryTimelineItem nexPrimaryTimelineItem);

    public abstract void setEndTime(int i);

    public abstract void setEndTrim(int i);

    public void setOverLimit(boolean z) {
        this.f24119e = z;
    }

    public abstract void setPinned(boolean z);

    @Deprecated
    public abstract void setRelativeEndTime(int i);

    @Deprecated
    public abstract void setRelativeStartTime(int i);

    public abstract void setStartTime(int i);

    public abstract void setStartTrim(int i);

    public void setSubTrackMapping(int i) {
        this.f24117c = i;
    }

    public void setTrackId(int i) {
        this.track_id = i;
    }

    public void setTrackMapping(int i) {
        this.f24116b = i;
    }

    public abstract void trimClip(int i, int i2);

    @Override // java.lang.Comparable
    public int compareTo(NexSecondaryTimelineItem nexSecondaryTimelineItem) {
        if (getAbsStartTime() < nexSecondaryTimelineItem.getAbsStartTime()) {
            return -1;
        }
        if (getAbsStartTime() > nexSecondaryTimelineItem.getAbsStartTime()) {
            return 1;
        }
        return getUniqueId().compareTo(nexSecondaryTimelineItem.getUniqueId());
    }
}
