package android.support.v4.b.a;

import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: DrawableWrapperLollipop.java */
/* loaded from: classes2.dex */
class k extends j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Drawable drawable) {
        super(drawable);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        this.b.setHotspot(f, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.b.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.b.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.b.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.b.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.b.getDirtyBounds();
    }
}
