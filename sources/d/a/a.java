package d.a;

import android.support.v7.widget.ActivityChooserView;
import java.util.LinkedHashMap;

/* compiled from: DaggerCollections.java */
/* loaded from: classes3.dex */
public final class a {
    public static <K, V> LinkedHashMap<K, V> a(int i) {
        return new LinkedHashMap<>(b(i));
    }

    private static int b(int i) {
        return i < 3 ? i + 1 : i < 1073741824 ? (int) ((i / 0.75f) + 1.0f) : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }
}
