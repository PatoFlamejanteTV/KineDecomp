package com.nextreaming.nexeditorui;

import android.content.Context;
import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class NexPrimaryTimelineItem extends NexTimelineItem {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private transient int f4488a;
    private transient int b;

    public abstract String getCaptureFilename();

    public abstract String getEffectID();

    public abstract Map<String, String> getEffectOptions();

    public abstract int getEndOverlap();

    public abstract ResultTask<Bitmap> getEndThumbnail(int i);

    public abstract int getPixelWidth(float f, float f2);

    public abstract int getStartOverlap();

    public abstract ResultTask<Bitmap> getStartThumbnail(int i);

    public abstract ResultTask<Bitmap> getThumbnail(Context context);

    public abstract NexTransitionItem getTransition();

    public abstract void onDuplicated(int i);

    public abstract void setCaptureFilename(String str);

    public final boolean updateAbsStartEndTime(int i, int i2) {
        if (this.f4488a == i && this.b == i2) {
            return false;
        }
        this.f4488a = i;
        this.b = i2;
        return true;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public final int getAbsStartTime() {
        return this.f4488a;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public final int getAbsEndTime() {
        return this.b;
    }
}
