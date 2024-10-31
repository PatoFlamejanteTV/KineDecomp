package f.a.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.bumptech.glide.load.engine.a.e;
import java.security.MessageDigest;

/* compiled from: BlurTransformation.java */
/* loaded from: classes3.dex */
public class b extends a {

    /* renamed from: a */
    private static int f26766a = 25;

    /* renamed from: b */
    private static int f26767b = 1;

    /* renamed from: c */
    private int f26768c;

    /* renamed from: d */
    private int f26769d;

    public b() {
        this(f26766a, f26767b);
    }

    @Override // f.a.a.a.a
    protected Bitmap a(Context context, e eVar, Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i3 = this.f26769d;
        Bitmap a2 = eVar.a(width / i3, height / i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(a2);
        int i4 = this.f26769d;
        canvas.scale(1.0f / i4, 1.0f / i4);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return f.a.a.a.a.a.a(a2, this.f26768c, true);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (bVar.f26768c == this.f26768c && bVar.f26769d == this.f26769d) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return "jp.wasabeef.glide.transformations.BlurTransformation.1".hashCode() + (this.f26768c * 1000) + (this.f26769d * 10);
    }

    public String toString() {
        return "BlurTransformation(radius=" + this.f26768c + ", sampling=" + this.f26769d + ")";
    }

    public b(int i) {
        this(i, f26767b);
    }

    public b(int i, int i2) {
        this.f26768c = i;
        this.f26769d = i2;
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.BlurTransformation.1" + this.f26768c + this.f26769d).getBytes(com.bumptech.glide.load.c.f8677a));
    }
}
