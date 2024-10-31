package android.support.transition;

import android.graphics.Path;

/* compiled from: Transition.java */
/* loaded from: classes.dex */
class J extends A {
    @Override // android.support.transition.A
    public Path a(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(f2, f3);
        path.lineTo(f4, f5);
        return path;
    }
}
