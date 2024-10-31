package com.nexstreaming.kinemaster.ui.a;

import android.graphics.Paint;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

/* compiled from: NexDialogFragment.java */
/* loaded from: classes.dex */
public class j implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ TextView f21339a;

    /* renamed from: b */
    final /* synthetic */ int f21340b;

    /* renamed from: c */
    final /* synthetic */ int f21341c;

    /* renamed from: d */
    final /* synthetic */ k f21342d;

    public j(k kVar, TextView textView, int i, int i2) {
        this.f21342d = kVar;
        this.f21339a = textView;
        this.f21340b = i;
        this.f21341c = i2;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        float a2;
        float b2;
        float b3;
        float b4;
        double measuredWidth = this.f21339a.getMeasuredWidth();
        Double.isNaN(measuredWidth);
        int i = (int) (measuredWidth * 0.7d);
        if (i == 0) {
            return;
        }
        Paint paint = new Paint();
        a2 = this.f21342d.a(this.f21339a.getTextSize());
        b2 = this.f21342d.b(a2);
        paint.setTextSize(b2);
        paint.setTypeface(this.f21339a.getTypeface());
        paint.setTextScaleX(this.f21339a.getTextScaleX());
        String charSequence = this.f21339a.getText().toString();
        float measureText = paint.measureText(charSequence);
        float f2 = i;
        if (measureText >= f2) {
            while (true) {
                if (measureText <= f2 && a2 <= this.f21340b) {
                    break;
                }
                int i2 = this.f21341c;
                if (a2 < i2) {
                    a2 = i2;
                    break;
                }
                a2 -= 1.0f;
                b3 = this.f21342d.b(a2);
                paint.setTextSize(b3);
                measureText = paint.measureText(charSequence);
            }
        } else {
            while (measureText < f2 && a2 <= this.f21340b) {
                a2 += 1.0f;
                b4 = this.f21342d.b(a2);
                paint.setTextSize(b4);
                measureText = paint.measureText(charSequence);
            }
            a2 -= 1.0f;
        }
        this.f21339a.setTextSize(a2);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
