package f.a.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.g.n;
import com.bumptech.glide.load.engine.E;
import com.bumptech.glide.load.engine.a.e;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.resource.bitmap.d;

/* compiled from: BitmapTransformation.java */
/* loaded from: classes3.dex */
public abstract class a implements j<Bitmap> {
    protected abstract Bitmap a(Context context, e eVar, Bitmap bitmap, int i, int i2);

    @Override // com.bumptech.glide.load.j
    public final E<Bitmap> a(Context context, E<Bitmap> e2, int i, int i2) {
        if (n.b(i, i2)) {
            e c2 = com.bumptech.glide.c.a(context).c();
            Bitmap bitmap = e2.get();
            if (i == Integer.MIN_VALUE) {
                i = bitmap.getWidth();
            }
            int i3 = i;
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getHeight();
            }
            Bitmap a2 = a(context.getApplicationContext(), c2, bitmap, i3, i2);
            return bitmap.equals(a2) ? e2 : d.a(a2, c2);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
