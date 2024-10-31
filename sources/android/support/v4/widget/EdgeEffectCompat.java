package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.widget.EdgeEffect;

/* loaded from: classes.dex */
public final class EdgeEffectCompat {

    /* renamed from: a */
    private static final EdgeEffectBaseImpl f1989a;

    /* renamed from: b */
    private EdgeEffect f1990b;

    /* loaded from: classes.dex */
    static class EdgeEffectApi21Impl extends EdgeEffectBaseImpl {
        EdgeEffectApi21Impl() {
        }

        @Override // android.support.v4.widget.EdgeEffectCompat.EdgeEffectBaseImpl
        public void onPull(EdgeEffect edgeEffect, float f2, float f3) {
            edgeEffect.onPull(f2, f3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class EdgeEffectBaseImpl {
        EdgeEffectBaseImpl() {
        }

        public void onPull(EdgeEffect edgeEffect, float f2, float f3) {
            edgeEffect.onPull(f2);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f1989a = new EdgeEffectApi21Impl();
        } else {
            f1989a = new EdgeEffectBaseImpl();
        }
    }

    @Deprecated
    public EdgeEffectCompat(Context context) {
        this.f1990b = new EdgeEffect(context);
    }

    @Deprecated
    public boolean draw(Canvas canvas) {
        return this.f1990b.draw(canvas);
    }

    @Deprecated
    public void finish() {
        this.f1990b.finish();
    }

    @Deprecated
    public boolean isFinished() {
        return this.f1990b.isFinished();
    }

    @Deprecated
    public boolean onAbsorb(int i) {
        this.f1990b.onAbsorb(i);
        return true;
    }

    @Deprecated
    public boolean onPull(float f2) {
        this.f1990b.onPull(f2);
        return true;
    }

    @Deprecated
    public boolean onRelease() {
        this.f1990b.onRelease();
        return this.f1990b.isFinished();
    }

    @Deprecated
    public void setSize(int i, int i2) {
        this.f1990b.setSize(i, i2);
    }

    @Deprecated
    public boolean onPull(float f2, float f3) {
        f1989a.onPull(this.f1990b, f2, f3);
        return true;
    }

    public static void onPull(EdgeEffect edgeEffect, float f2, float f3) {
        f1989a.onPull(edgeEffect, f2, f3);
    }
}
