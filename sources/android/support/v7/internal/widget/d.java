package android.support.v7.internal.widget;

import android.graphics.Outline;

/* compiled from: ActionBarBackgroundDrawableV21.java */
/* loaded from: classes.dex */
class d extends c {
    public d(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f167a.d) {
            if (this.f167a.c != null) {
                this.f167a.c.getOutline(outline);
            }
        } else if (this.f167a.f145a != null) {
            this.f167a.f145a.getOutline(outline);
        }
    }
}
