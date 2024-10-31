package c.d.a.a.a;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.util.SparseArray;
import com.larvalabs.svgandroid.SVGParser;
import java.lang.ref.WeakReference;

/* compiled from: ScalablePictureDrawable.java */
/* loaded from: classes2.dex */
public class a extends PictureDrawable {

    /* renamed from: a */
    public static SparseArray<WeakReference<a>> f3539a = new SparseArray<>();

    public a(Picture picture) {
        super(picture);
    }

    public static a a(Resources resources, int i) {
        a aVar;
        WeakReference<a> weakReference = f3539a.get(i);
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        a aVar2 = new a(SVGParser.a(resources, i).a());
        f3539a.put(i, new WeakReference<>(aVar2));
        return aVar2;
    }

    @Override // android.graphics.drawable.PictureDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Picture picture = getPicture();
        if (picture == null) {
            return;
        }
        Rect bounds = getBounds();
        canvas.save();
        canvas.clipRect(bounds);
        canvas.translate(bounds.left, bounds.top);
        canvas.scale(bounds.width() / getIntrinsicWidth(), bounds.height() / getIntrinsicHeight());
        canvas.drawPicture(picture);
        canvas.restore();
    }

    public a(Drawable drawable) {
        super(((PictureDrawable) drawable).getPicture());
    }
}
