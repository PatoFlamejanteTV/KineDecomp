package f.a.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.a.e;
import java.security.MessageDigest;

/* compiled from: MaskTransformation.java */
/* loaded from: classes3.dex */
public class c extends a {

    /* renamed from: a */
    private static Paint f26770a = new Paint();

    /* renamed from: b */
    private int f26771b;

    static {
        f26770a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public c(int i) {
        this.f26771b = i;
    }

    @Override // f.a.a.a.a
    protected Bitmap a(Context context, e eVar, Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap a2 = eVar.a(width, height, Bitmap.Config.ARGB_8888);
        a2.setHasAlpha(true);
        Drawable a3 = f.a.a.a.a.b.a(context.getApplicationContext(), this.f26771b);
        Canvas canvas = new Canvas(a2);
        a3.setBounds(0, 0, width, height);
        a3.draw(canvas);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, f26770a);
        return a2;
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        return (obj instanceof c) && ((c) obj).f26771b == this.f26771b;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return "jp.wasabeef.glide.transformations.MaskTransformation.1".hashCode() + (this.f26771b * 10);
    }

    public String toString() {
        return "MaskTransformation(maskId=" + this.f26771b + ")";
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.MaskTransformation.1" + this.f26771b).getBytes(com.bumptech.glide.load.c.f8677a));
    }
}
