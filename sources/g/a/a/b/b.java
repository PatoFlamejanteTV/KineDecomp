package g.a.a.b;

import android.support.v4.app.NotificationCompat;
import android.util.Log;
import kotlin.jvm.internal.h;
import org.koin.core.logger.Level;

/* compiled from: AndroidLogger.kt */
/* loaded from: classes3.dex */
public final class b extends org.koin.core.logger.b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Level level) {
        super(level);
        h.b(level, "level");
    }

    private final void d(String str) {
        int i = a.f26772a[a().ordinal()];
        if (i == 1) {
            Log.d("[Koin]", str);
        } else if (i == 2) {
            Log.i("[Koin]", str);
        } else {
            if (i != 3) {
                return;
            }
            Log.e("[Koin]", str);
        }
    }

    @Override // org.koin.core.logger.b
    public void a(Level level, String str) {
        h.b(level, "level");
        h.b(str, NotificationCompat.CATEGORY_MESSAGE);
        if (a().compareTo(level) <= 0) {
            d(str);
        }
    }
}
