package android.support.constraint;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.constraint.ConstraintLayout;
import android.view.View;

/* compiled from: Placeholder.java */
/* loaded from: classes.dex */
public class f extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f199a;

    /* renamed from: b, reason: collision with root package name */
    private View f200b;

    /* renamed from: c, reason: collision with root package name */
    private int f201c;

    public void a(ConstraintLayout constraintLayout) {
        if (this.f200b == null) {
            return;
        }
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        ConstraintLayout.a aVar2 = (ConstraintLayout.a) this.f200b.getLayoutParams();
        aVar2.la.n(0);
        aVar.la.o(aVar2.la.s());
        aVar.la.g(aVar2.la.i());
        aVar2.la.n(8);
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.f199a == -1 && !isInEditMode()) {
            setVisibility(this.f201c);
        }
        this.f200b = constraintLayout.findViewById(this.f199a);
        View view = this.f200b;
        if (view != null) {
            ((ConstraintLayout.a) view.getLayoutParams()).aa = true;
            this.f200b.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f200b;
    }

    public int getEmptyVisibility() {
        return this.f201c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((height / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i) {
        View findViewById;
        if (this.f199a == i) {
            return;
        }
        View view = this.f200b;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.a) this.f200b.getLayoutParams()).aa = false;
            this.f200b = null;
        }
        this.f199a = i;
        if (i == -1 || (findViewById = ((View) getParent()).findViewById(i)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i) {
        this.f201c = i;
    }
}
