package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class a extends RelativeLayout {

    /* renamed from: a */
    private static final float[] f564a = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    private final RelativeLayout b;
    private AnimationDrawable c;

    public a(Context context, zza zzaVar) {
        super(context);
        zzx.a(zzaVar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(f564a, null, null));
        shapeDrawable.getPaint().setColor(zzaVar.c());
        this.b = new RelativeLayout(context);
        this.b.setLayoutParams(layoutParams);
        zzp.g().zza(this.b, shapeDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(zzaVar.a())) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(zzaVar.a());
            textView.setTextColor(zzaVar.d());
            textView.setTextSize(zzaVar.e());
            textView.setPadding(zzl.a().a(context, 4), 0, zzl.a().a(context, 4), 0);
            this.b.addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<Drawable> b = zzaVar.b();
        if (b.size() > 1) {
            this.c = new AnimationDrawable();
            Iterator<Drawable> it = b.iterator();
            while (it.hasNext()) {
                this.c.addFrame(it.next(), zzaVar.f());
            }
            zzp.g().zza(imageView, this.c);
        } else if (b.size() == 1) {
            imageView.setImageDrawable(b.get(0));
        }
        this.b.addView(imageView);
        addView(this.b);
    }

    public ViewGroup a() {
        return this.b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        if (this.c != null) {
            this.c.start();
        }
        super.onAttachedToWindow();
    }
}
