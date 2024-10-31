package android.support.v4.b.a;

import android.graphics.drawable.Drawable;

/* compiled from: DrawableWrapperKitKat.java */
/* loaded from: classes.dex */
class j extends i {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Drawable drawable) {
        super(drawable);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        this.b.setAutoMirrored(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.b.isAutoMirrored();
    }
}
