package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.RoundRectDrawableWithShadow;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CardViewApi17Impl extends CardViewBaseImpl {

    /* renamed from: android.support.v7.widget.CardViewApi17Impl$1 */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements RoundRectDrawableWithShadow.RoundRectHelper {
        AnonymousClass1() {
        }

        @Override // android.support.v7.widget.RoundRectDrawableWithShadow.RoundRectHelper
        public void drawRoundRect(Canvas canvas, RectF rectF, float f2, Paint paint) {
            canvas.drawRoundRect(rectF, f2, f2, paint);
        }
    }

    @Override // android.support.v7.widget.CardViewBaseImpl, android.support.v7.widget.CardViewImpl
    public void initStatic() {
        RoundRectDrawableWithShadow.f2983b = new RoundRectDrawableWithShadow.RoundRectHelper() { // from class: android.support.v7.widget.CardViewApi17Impl.1
            AnonymousClass1() {
            }

            @Override // android.support.v7.widget.RoundRectDrawableWithShadow.RoundRectHelper
            public void drawRoundRect(Canvas canvas, RectF rectF, float f2, Paint paint) {
                canvas.drawRoundRect(rectF, f2, f2, paint);
            }
        };
    }
}
