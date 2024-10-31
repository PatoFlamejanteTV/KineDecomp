package android.support.v4.graphics;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.util.Pair;

/* loaded from: classes.dex */
public final class PaintCompat {

    /* renamed from: a */
    private static final ThreadLocal<Pair<Rect, Rect>> f1127a = new ThreadLocal<>();

    private PaintCompat() {
    }

    private static Pair<Rect, Rect> a() {
        Pair<Rect, Rect> pair = f1127a.get();
        if (pair == null) {
            Pair<Rect, Rect> pair2 = new Pair<>(new Rect(), new Rect());
            f1127a.set(pair2);
            return pair2;
        }
        pair.first.setEmpty();
        pair.second.setEmpty();
        return pair;
    }

    public static boolean hasGlyph(Paint paint, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return paint.hasGlyph(str);
        }
        int length = str.length();
        if (length == 1 && Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float measureText = paint.measureText("\udfffd");
        float measureText2 = paint.measureText("m");
        float measureText3 = paint.measureText(str);
        float f2 = 0.0f;
        if (measureText3 == 0.0f) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (measureText3 > measureText2 * 2.0f) {
                return false;
            }
            int i = 0;
            while (i < length) {
                int charCount = Character.charCount(str.codePointAt(i)) + i;
                f2 += paint.measureText(str, i, charCount);
                i = charCount;
            }
            if (measureText3 >= f2) {
                return false;
            }
        }
        if (measureText3 != measureText) {
            return true;
        }
        Pair<Rect, Rect> a2 = a();
        paint.getTextBounds("\udfffd", 0, 2, a2.first);
        paint.getTextBounds(str, 0, length, a2.second);
        return !a2.first.equals(a2.second);
    }
}
