package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.NexTransitionItem;
import java.io.IOException;

/* loaded from: classes2.dex */
public class TransitionIconView extends AppCompatImageView {

    /* renamed from: c, reason: collision with root package name */
    private NexTransitionItem f22640c;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f22641d;

    /* renamed from: e, reason: collision with root package name */
    private int f22642e;

    /* renamed from: f, reason: collision with root package name */
    private int f22643f;

    public TransitionIconView(Context context) {
        this(context, null, 0);
    }

    private Drawable a(String str) {
        Bitmap bitmap = null;
        try {
            com.nexstreaming.app.general.nexasset.assetpackage.r a2 = com.nexstreaming.app.general.nexasset.assetpackage.h.e().a(str);
            if (a2 != null) {
                bitmap = com.nexstreaming.app.general.nexasset.assetpackage.q.a(getContext(), a2, 0, 0);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return bitmap != null ? new BitmapDrawable(getResources(), bitmap) : new ColorDrawable(0);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        NexTransitionItem nexTransitionItem = this.f22640c;
        if (nexTransitionItem != null && nexTransitionItem.isSet() && (drawable = this.f22641d) != null) {
            DrawableCompat.setTint(drawable, isSelected() ? this.f22643f : this.f22642e);
            this.f22641d.setBounds(0, 0, getWidth(), getHeight());
            this.f22641d.draw(canvas);
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean z) {
        boolean z2 = false;
        if (z) {
            setActivated(false);
        } else {
            NexTransitionItem nexTransitionItem = this.f22640c;
            if (nexTransitionItem != null && nexTransitionItem.isSet()) {
                z2 = true;
            }
            setActivated(z2);
        }
        super.setSelected(z);
    }

    public void setTransitionItem(NexTransitionItem nexTransitionItem) {
        this.f22640c = nexTransitionItem;
        this.f22641d = a(nexTransitionItem.getEffectItemID());
        postInvalidateOnAnimation();
    }

    public TransitionIconView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TransitionIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22642e = getResources().getColor(R.color.km_red);
        this.f22643f = -1;
    }
}
