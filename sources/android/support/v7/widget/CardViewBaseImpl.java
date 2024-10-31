package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v7.widget.RoundRectDrawableWithShadow;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CardViewBaseImpl implements CardViewImpl {

    /* renamed from: a */
    private final RectF f2709a = new RectF();

    /* renamed from: android.support.v7.widget.CardViewBaseImpl$1 */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements RoundRectDrawableWithShadow.RoundRectHelper {
        AnonymousClass1() {
        }

        @Override // android.support.v7.widget.RoundRectDrawableWithShadow.RoundRectHelper
        public void drawRoundRect(Canvas canvas, RectF rectF, float f2, Paint paint) {
            float f3 = 2.0f * f2;
            float width = (rectF.width() - f3) - 1.0f;
            float height = (rectF.height() - f3) - 1.0f;
            if (f2 >= 1.0f) {
                float f4 = f2 + 0.5f;
                float f5 = -f4;
                CardViewBaseImpl.this.f2709a.set(f5, f5, f4, f4);
                int save = canvas.save();
                canvas.translate(rectF.left + f4, rectF.top + f4);
                canvas.drawArc(CardViewBaseImpl.this.f2709a, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(CardViewBaseImpl.this.f2709a, 180.0f, 90.0f, true, paint);
                canvas.translate(height, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(CardViewBaseImpl.this.f2709a, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(CardViewBaseImpl.this.f2709a, 180.0f, 90.0f, true, paint);
                canvas.restoreToCount(save);
                float f6 = (rectF.left + f4) - 1.0f;
                float f7 = rectF.top;
                canvas.drawRect(f6, f7, (rectF.right - f4) + 1.0f, f7 + f4, paint);
                float f8 = (rectF.left + f4) - 1.0f;
                float f9 = rectF.bottom;
                canvas.drawRect(f8, f9 - f4, (rectF.right - f4) + 1.0f, f9, paint);
            }
            canvas.drawRect(rectF.left, rectF.top + f2, rectF.right, rectF.bottom - f2, paint);
        }
    }

    @Override // android.support.v7.widget.CardViewImpl
    public ColorStateList getBackgroundColor(CardViewDelegate cardViewDelegate) {
        return a(cardViewDelegate).a();
    }

    @Override // android.support.v7.widget.CardViewImpl
    public float getElevation(CardViewDelegate cardViewDelegate) {
        return a(cardViewDelegate).f();
    }

    @Override // android.support.v7.widget.CardViewImpl
    public float getMaxElevation(CardViewDelegate cardViewDelegate) {
        return a(cardViewDelegate).c();
    }

    @Override // android.support.v7.widget.CardViewImpl
    public float getMinHeight(CardViewDelegate cardViewDelegate) {
        return a(cardViewDelegate).d();
    }

    @Override // android.support.v7.widget.CardViewImpl
    public float getMinWidth(CardViewDelegate cardViewDelegate) {
        return a(cardViewDelegate).e();
    }

    @Override // android.support.v7.widget.CardViewImpl
    public float getRadius(CardViewDelegate cardViewDelegate) {
        return a(cardViewDelegate).b();
    }

    @Override // android.support.v7.widget.CardViewImpl
    public void initStatic() {
        RoundRectDrawableWithShadow.f2983b = new RoundRectDrawableWithShadow.RoundRectHelper() { // from class: android.support.v7.widget.CardViewBaseImpl.1
            AnonymousClass1() {
            }

            @Override // android.support.v7.widget.RoundRectDrawableWithShadow.RoundRectHelper
            public void drawRoundRect(Canvas canvas, RectF rectF, float f2, Paint paint) {
                float f3 = 2.0f * f2;
                float width = (rectF.width() - f3) - 1.0f;
                float height = (rectF.height() - f3) - 1.0f;
                if (f2 >= 1.0f) {
                    float f4 = f2 + 0.5f;
                    float f5 = -f4;
                    CardViewBaseImpl.this.f2709a.set(f5, f5, f4, f4);
                    int save = canvas.save();
                    canvas.translate(rectF.left + f4, rectF.top + f4);
                    canvas.drawArc(CardViewBaseImpl.this.f2709a, 180.0f, 90.0f, true, paint);
                    canvas.translate(width, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.f2709a, 180.0f, 90.0f, true, paint);
                    canvas.translate(height, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.f2709a, 180.0f, 90.0f, true, paint);
                    canvas.translate(width, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.f2709a, 180.0f, 90.0f, true, paint);
                    canvas.restoreToCount(save);
                    float f6 = (rectF.left + f4) - 1.0f;
                    float f7 = rectF.top;
                    canvas.drawRect(f6, f7, (rectF.right - f4) + 1.0f, f7 + f4, paint);
                    float f8 = (rectF.left + f4) - 1.0f;
                    float f9 = rectF.bottom;
                    canvas.drawRect(f8, f9 - f4, (rectF.right - f4) + 1.0f, f9, paint);
                }
                canvas.drawRect(rectF.left, rectF.top + f2, rectF.right, rectF.bottom - f2, paint);
            }
        };
    }

    @Override // android.support.v7.widget.CardViewImpl
    public void initialize(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        RoundRectDrawableWithShadow a2 = a(context, colorStateList, f2, f3, f4);
        a2.a(cardViewDelegate.getPreventCornerOverlap());
        cardViewDelegate.setCardBackground(a2);
        updatePadding(cardViewDelegate);
    }

    @Override // android.support.v7.widget.CardViewImpl
    public void onCompatPaddingChanged(CardViewDelegate cardViewDelegate) {
    }

    @Override // android.support.v7.widget.CardViewImpl
    public void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate) {
        a(cardViewDelegate).a(cardViewDelegate.getPreventCornerOverlap());
        updatePadding(cardViewDelegate);
    }

    @Override // android.support.v7.widget.CardViewImpl
    public void setBackgroundColor(CardViewDelegate cardViewDelegate, ColorStateList colorStateList) {
        a(cardViewDelegate).a(colorStateList);
    }

    @Override // android.support.v7.widget.CardViewImpl
    public void setElevation(CardViewDelegate cardViewDelegate, float f2) {
        a(cardViewDelegate).c(f2);
    }

    @Override // android.support.v7.widget.CardViewImpl
    public void setMaxElevation(CardViewDelegate cardViewDelegate, float f2) {
        a(cardViewDelegate).b(f2);
        updatePadding(cardViewDelegate);
    }

    @Override // android.support.v7.widget.CardViewImpl
    public void setRadius(CardViewDelegate cardViewDelegate, float f2) {
        a(cardViewDelegate).a(f2);
        updatePadding(cardViewDelegate);
    }

    @Override // android.support.v7.widget.CardViewImpl
    public void updatePadding(CardViewDelegate cardViewDelegate) {
        Rect rect = new Rect();
        a(cardViewDelegate).a(rect);
        cardViewDelegate.setMinWidthHeightInternal((int) Math.ceil(getMinWidth(cardViewDelegate)), (int) Math.ceil(getMinHeight(cardViewDelegate)));
        cardViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    private RoundRectDrawableWithShadow a(Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        return new RoundRectDrawableWithShadow(context.getResources(), colorStateList, f2, f3, f4);
    }

    private RoundRectDrawableWithShadow a(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawableWithShadow) cardViewDelegate.getCardBackground();
    }
}
