package com.nextreaming.nexeditorui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import com.nexstreaming.app.kinemasterfree.R;
import kotlin.TypeCastException;

/* compiled from: ColorFilterChild.kt */
/* renamed from: com.nextreaming.nexeditorui.d */
/* loaded from: classes.dex */
public final class C2302d implements com.nexstreaming.kinemaster.ui.d.f {

    /* renamed from: a */
    private Drawable f24227a;

    /* renamed from: b */
    private final String f24228b;

    /* renamed from: c */
    private final ColorEffect f24229c;

    public C2302d(String str, ColorEffect colorEffect) {
        kotlin.jvm.internal.h.b(str, "effectTitle");
        kotlin.jvm.internal.h.b(colorEffect, "effect");
        this.f24228b = str;
        this.f24229c = colorEffect;
    }

    public final ColorEffect a() {
        return this.f24229c;
    }

    @Override // com.nexstreaming.kinemaster.ui.d.f
    public Object getObject() {
        return this.f24229c;
    }

    @Override // com.nexstreaming.kinemaster.ui.d.f
    public String getTitle() {
        return this.f24228b;
    }

    @Override // com.nexstreaming.kinemaster.ui.d.f
    public boolean a(Object obj) {
        kotlin.jvm.internal.h.b(obj, "any");
        return this.f24229c.equals(obj);
    }

    @Override // com.nexstreaming.kinemaster.ui.d.f
    public Drawable a(Context context) {
        Drawable drawable;
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        Drawable drawable2 = this.f24227a;
        if (drawable2 != null) {
            return drawable2;
        }
        if (this.f24229c.getIconResourceId() != 0) {
            drawable = context.getResources().getDrawable(this.f24229c.getIconResourceId());
            kotlin.jvm.internal.h.a((Object) drawable, "context.resources.getDra…le(effect.iconResourceId)");
        } else {
            drawable = context.getResources().getDrawable(R.drawable.img_sample_color_effect);
            kotlin.jvm.internal.h.a((Object) drawable, "context.resources.getDra….img_sample_color_effect)");
        }
        Resources resources = context.getResources();
        kotlin.jvm.internal.h.a((Object) resources, "context.resources");
        int applyDimension = (int) TypedValue.applyDimension(1, 4.0f, resources.getDisplayMetrics());
        if (drawable != null) {
            C2341x c2341x = new C2341x(a(context, (BitmapDrawable) drawable, applyDimension));
            ColorMatrix colorMatrix = this.f24229c.getColorMatrix();
            if (colorMatrix != null) {
                c2341x.a(colorMatrix);
            }
            this.f24227a = c2341x;
            return this.f24227a;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
    }

    private final Drawable a(Context context, BitmapDrawable bitmapDrawable, int i) {
        Bitmap bitmap = bitmapDrawable.getBitmap();
        kotlin.jvm.internal.h.a((Object) bitmap, "bitmap");
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        paint.setColor(-12434878);
        canvas.drawARGB(0, 0, 0, 0);
        float f2 = i;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return new BitmapDrawable(context.getResources(), createBitmap);
    }
}
