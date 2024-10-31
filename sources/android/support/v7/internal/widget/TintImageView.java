package android.support.v7.internal.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class TintImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f157a = {R.attr.background, R.attr.src};
    private final ab b;

    public TintImageView(Context context) {
        this(context, null);
    }

    public TintImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TintImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ac a2 = ac.a(getContext(), attributeSet, f157a, i, 0);
        if (a2.a() > 0) {
            if (a2.d(0)) {
                setBackgroundDrawable(a2.a(0));
            }
            if (a2.d(1)) {
                setImageDrawable(a2.a(1));
            }
        }
        a2.b();
        this.b = a2.c();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        setImageDrawable(this.b.a(i));
    }
}
