package com.nextreaming.nexeditorui;

import android.content.Context;
import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class NexPrimaryTimelineItem extends NexTimelineItem {
    private static final long serialVersionUID = 1;

    /* renamed from: b, reason: collision with root package name */
    private transient int f24113b;

    /* renamed from: c, reason: collision with root package name */
    private transient int f24114c;

    public boolean checkAndDeleteFontOfEffect() {
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public final int getAbsEndTime() {
        return this.f24114c;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public final int getAbsStartTime() {
        return this.f24113b;
    }

    public abstract String getCaptureFilename();

    public abstract String getEffectID();

    public abstract Map<String, String> getEffectOptions();

    public abstract int getEndOverlap();

    public abstract ResultTask<Bitmap> getEndThumbnail(int i);

    public abstract int getPixelWidth(float f2, float f3);

    public abstract int getStartOverlap();

    public abstract ResultTask<Bitmap> getStartThumbnail(int i);

    public abstract ResultTask<Bitmap> getThumbnail(Context context);

    public abstract NexTransitionItem getTransition();

    public abstract void onDuplicated(int i);

    public abstract void setCaptureFilename(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean updateAbsStartEndTime(int i, int i2) {
        if (this.f24113b == i && this.f24114c == i2) {
            return false;
        }
        this.f24113b = i;
        this.f24114c = i2;
        return true;
    }
}
