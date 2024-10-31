package com.nextreaming.nexeditorui;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import java.util.List;

/* loaded from: classes.dex */
public abstract class NexSecondaryTimelineItem extends NexTimelineItem implements Comparable<NexSecondaryTimelineItem> {
    private static final long serialVersionUID = 1;

    /* renamed from: a, reason: collision with root package name */
    private transient int f4490a;
    private transient boolean b = false;

    @Deprecated
    public abstract NexPrimaryTimelineItem getAnchorItem();

    public abstract int getEndTime();

    public abstract int getEndTrim();

    public abstract int getIntinsicDuration();

    public abstract boolean getPinned();

    @Deprecated
    public abstract int getRelativeEndTime();

    @Deprecated
    public abstract int getRelativeStartTime();

    public abstract int getStartTime();

    public abstract int getStartTrim();

    public abstract boolean hasIntrinsicDuration();

    public abstract void moveClip(int i);

    @Deprecated
    public abstract void setAnchorItem(NexPrimaryTimelineItem nexPrimaryTimelineItem);

    public abstract void setEndTime(int i);

    public abstract void setEndTrim(int i);

    public abstract void setPinned(boolean z);

    @Deprecated
    public abstract void setRelativeEndTime(int i);

    @Deprecated
    public abstract void setRelativeStartTime(int i);

    public abstract void setStartTime(int i);

    public abstract void setStartTrim(int i);

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

    public void setTrackMapping(int i) {
        this.f4490a = i;
    }

    public int getTrackMapping() {
        return this.f4490a;
    }

    public void setOverLimit(boolean z) {
        this.b = z;
    }

    public boolean getOverLimit() {
        return this.b;
    }

    public final void drawPin(com.nexstreaming.kinemaster.ui.projectedit.ay ayVar, int i) {
        if (getPinned()) {
            Canvas b = ayVar.b();
            Drawable drawable = ayVar.getResources().getDrawable(i);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            RectF c = ayVar.c();
            int min = (int) Math.min(c.height(), intrinsicHeight);
            int i2 = (intrinsicWidth * min) / intrinsicHeight;
            int height = (int) ((c.height() - min) / 2.0f);
            drawable.setBounds((((int) c.width()) - height) - i2, height, ((int) c.width()) - height, min + height);
            drawable.draw(b);
        }
    }

    public final void drawLayerAnimation(com.nexstreaming.kinemaster.ui.projectedit.ay ayVar, List<NexLayerItem.b> list, int i, int i2) {
        float f;
        if (ayVar == null || !ayVar.f()) {
            return;
        }
        if (ayVar.l() == R.id.editmode_layer_anim || (list != null && list.size() > 1)) {
            List<ef> o = ayVar.o();
            Drawable drawable = ayVar.getResources().getDrawable(i2);
            int intrinsicWidth = drawable.getIntrinsicWidth() / 2;
            int intrinsicHeight = drawable.getIntrinsicHeight() / 2;
            Canvas b = ayVar.b();
            RectF d = ayVar.d();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    float f2 = list.get(i4).f3299a;
                    float width = d.width() * f2;
                    if (i4 != 0 && o != null) {
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= o.size() - 1) {
                                break;
                            }
                            ef efVar = o.get(i6);
                            ef efVar2 = o.get(i6 + 1);
                            if (efVar.f4622a > i * f2 || i * f2 >= efVar2.f4622a) {
                                i5 = i6 + 1;
                            } else {
                                f = ((((i * f2) - efVar.f4622a) * (efVar2.b - efVar.b)) / (efVar2.f4622a - efVar.f4622a)) + efVar.b;
                                break;
                            }
                        }
                        float centerY = d.centerY();
                        drawable.setBounds((int) (f - intrinsicWidth), (int) (centerY - intrinsicHeight), (int) (f + intrinsicWidth), (int) (centerY + intrinsicHeight));
                        drawable.draw(b);
                        i3 = i4 + 1;
                    }
                    f = width;
                    float centerY2 = d.centerY();
                    drawable.setBounds((int) (f - intrinsicWidth), (int) (centerY2 - intrinsicHeight), (int) (f + intrinsicWidth), (int) (centerY2 + intrinsicHeight));
                    drawable.draw(b);
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
