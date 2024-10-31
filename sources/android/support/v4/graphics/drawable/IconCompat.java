package android.support.v4.graphics.drawable;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;

/* loaded from: classes.dex */
public class IconCompat {

    /* renamed from: a */
    private final int f1149a;

    /* renamed from: b */
    private Object f1150b;

    /* renamed from: c */
    private int f1151c;

    /* renamed from: d */
    private int f1152d;

    private IconCompat(int i) {
        this.f1149a = i;
    }

    static Bitmap a(Bitmap bitmap, boolean z) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f2 = min;
        float f3 = 0.5f * f2;
        float f4 = 0.9166667f * f3;
        if (z) {
            float f5 = 0.010416667f * f2;
            paint.setColor(0);
            paint.setShadowLayer(f5, 0.0f, f2 * 0.020833334f, 1023410176);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.setShadowLayer(f5, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2, (-(bitmap.getHeight() - min)) / 2);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f3, f3, f4, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static IconCompat createWithAdaptiveBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            IconCompat iconCompat = new IconCompat(5);
            iconCompat.f1150b = bitmap;
            return iconCompat;
        }
        throw new IllegalArgumentException("Bitmap must not be null.");
    }

    public static IconCompat createWithBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            IconCompat iconCompat = new IconCompat(1);
            iconCompat.f1150b = bitmap;
            return iconCompat;
        }
        throw new IllegalArgumentException("Bitmap must not be null.");
    }

    public static IconCompat createWithContentUri(String str) {
        if (str != null) {
            IconCompat iconCompat = new IconCompat(4);
            iconCompat.f1150b = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Uri must not be null.");
    }

    public static IconCompat createWithData(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            IconCompat iconCompat = new IconCompat(3);
            iconCompat.f1150b = bArr;
            iconCompat.f1151c = i;
            iconCompat.f1152d = i2;
            return iconCompat;
        }
        throw new IllegalArgumentException("Data must not be null.");
    }

    public static IconCompat createWithResource(Context context, int i) {
        if (context != null) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f1151c = i;
            iconCompat.f1150b = context;
            return iconCompat;
        }
        throw new IllegalArgumentException("Context must not be null.");
    }

    @Deprecated
    public void addToShortcutIntent(Intent intent) {
        addToShortcutIntent(intent, null);
    }

    public Icon toIcon() {
        int i = this.f1149a;
        if (i == 1) {
            return Icon.createWithBitmap((Bitmap) this.f1150b);
        }
        if (i == 2) {
            return Icon.createWithResource((Context) this.f1150b, this.f1151c);
        }
        if (i == 3) {
            return Icon.createWithData((byte[]) this.f1150b, this.f1151c, this.f1152d);
        }
        if (i == 4) {
            return Icon.createWithContentUri((String) this.f1150b);
        }
        if (i == 5) {
            if (Build.VERSION.SDK_INT >= 26) {
                return Icon.createWithAdaptiveBitmap((Bitmap) this.f1150b);
            }
            return Icon.createWithBitmap(a((Bitmap) this.f1150b, false));
        }
        throw new IllegalArgumentException("Unknown type");
    }

    public void addToShortcutIntent(Intent intent, Drawable drawable) {
        Bitmap bitmap;
        int i = this.f1149a;
        if (i == 1) {
            bitmap = (Bitmap) this.f1150b;
            if (drawable != null) {
                bitmap = bitmap.copy(bitmap.getConfig(), true);
            }
        } else if (i != 2) {
            if (i == 5) {
                bitmap = a((Bitmap) this.f1150b, true);
            } else {
                throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
            }
        } else {
            if (drawable == null) {
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext((Context) this.f1150b, this.f1151c));
                return;
            }
            Context context = (Context) this.f1150b;
            Drawable drawable2 = ContextCompat.getDrawable(context, this.f1151c);
            if (drawable2.getIntrinsicWidth() > 0 && drawable2.getIntrinsicHeight() > 0) {
                bitmap = Bitmap.createBitmap(drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            } else {
                int launcherLargeIconSize = ((ActivityManager) context.getSystemService("activity")).getLauncherLargeIconSize();
                bitmap = Bitmap.createBitmap(launcherLargeIconSize, launcherLargeIconSize, Bitmap.Config.ARGB_8888);
            }
            drawable2.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            drawable2.draw(new Canvas(bitmap));
        }
        if (drawable != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            drawable.setBounds(width / 2, height / 2, width, height);
            drawable.draw(new Canvas(bitmap));
        }
        intent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
    }

    public static IconCompat createWithContentUri(Uri uri) {
        if (uri != null) {
            return createWithContentUri(uri.toString());
        }
        throw new IllegalArgumentException("Uri must not be null.");
    }
}
