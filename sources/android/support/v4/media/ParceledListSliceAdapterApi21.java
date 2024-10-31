package android.support.v4.media;

import java.lang.reflect.Constructor;
import java.util.List;

/* loaded from: classes.dex */
class ParceledListSliceAdapterApi21 {

    /* renamed from: a */
    private static Constructor f1413a;

    static {
        try {
            f1413a = Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class);
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            e2.printStackTrace();
        }
    }

    ParceledListSliceAdapterApi21() {
    }
}
