package com.nexstreaming.kinemaster.ui.settings;

import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* compiled from: SubscriptionFragment.java */
/* loaded from: classes.dex */
class ay implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f4250a;
    final /* synthetic */ TextView b;
    final /* synthetic */ aw c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(aw awVar, View view, TextView textView) {
        this.c = awVar;
        this.f4250a = view;
        this.b = textView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4250a != null && this.b != null && this.c.getActivity() != null) {
            this.f4250a.setBackground(null);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f4250a.getLayoutParams();
            if (marginLayoutParams != null && this.c.getActivity() != null) {
                marginLayoutParams.bottomMargin = ((int) this.c.getResources().getDisplayMetrics().density) * 2;
            }
            String charSequence = this.b.getText().toString();
            float textSize = this.b.getTextSize();
            Paint paint = new Paint();
            paint.setTextSize(textSize);
            Rect rect = new Rect();
            paint.getTextBounds(charSequence.toString(), 0, charSequence.length(), rect);
            int width = rect.width();
            int height = rect.height() - ((int) (this.c.getResources().getDisplayMetrics().density * 4.0f));
            int width2 = this.f4250a.getWidth();
            while (true) {
                if (width <= width2 && height <= this.f4250a.getHeight()) {
                    break;
                }
                float f = textSize - this.c.getResources().getDisplayMetrics().density;
                if (f <= 0.0f) {
                    rect.width();
                    rect.height();
                    break;
                } else {
                    paint.setTextSize(f);
                    paint.getTextBounds(String.valueOf(charSequence), 0, charSequence.length(), rect);
                    width = rect.width();
                    height = rect.height();
                    textSize = f;
                }
            }
            this.b.setTextSize(0, textSize);
        }
    }
}
