package com.nexstreaming.app.general.a;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.util.SparseArray;
import com.larvalabs.svgandroid.c;
import java.lang.ref.WeakReference;

/* compiled from: ScalablePictureDrawable.java */
/* loaded from: classes.dex */
public class a extends PictureDrawable {

    /* renamed from: a, reason: collision with root package name */
    public static SparseArray<WeakReference<a>> f3120a = new SparseArray<>();

    public a(Drawable drawable) {
        super(((PictureDrawable) drawable).getPicture());
    }

    @Override // android.graphics.drawable.PictureDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Picture picture = getPicture();
        if (picture != null) {
            Rect bounds = getBounds();
            canvas.save();
            canvas.clipRect(bounds);
            canvas.translate(bounds.left, bounds.top);
            canvas.scale(bounds.width() / getIntrinsicWidth(), bounds.height() / getIntrinsicHeight());
            canvas.drawPicture(picture);
            canvas.restore();
        }
    }

    public static a a(Resources resources, int i) {
        a aVar;
        WeakReference<a> weakReference = f3120a.get(i);
        if (weakReference == null || (aVar = weakReference.get()) == null) {
            a aVar2 = new a(c.a(resources, i).a());
            f3120a.put(i, new WeakReference<>(aVar2));
            return aVar2;
        }
        return aVar;
    }
}
