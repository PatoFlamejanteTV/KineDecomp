package android.support.v7.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwitchCompat.java */
/* loaded from: classes.dex */
public class k extends Animation {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ float f228a;
    final /* synthetic */ float b;
    final /* synthetic */ SwitchCompat c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(SwitchCompat switchCompat, float f, float f2) {
        this.c = switchCompat;
        this.f228a = f;
        this.b = f2;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        this.c.setThumbPosition(this.f228a + (this.b * f));
    }
}
