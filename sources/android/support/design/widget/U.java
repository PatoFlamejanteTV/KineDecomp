package android.support.design.widget;

import android.widget.ImageButton;

/* compiled from: VisibilityAwareImageButton.java */
/* loaded from: classes.dex */
class U extends ImageButton {

    /* renamed from: a */
    private int f461a;

    public final void a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f461a = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.f461a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        a(i, true);
    }
}
