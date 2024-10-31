package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import javax.annotation.Nullable;

/* compiled from: SegmentPool.java */
/* loaded from: classes3.dex */
public final class x {

    /* renamed from: a */
    @Nullable
    static w f29279a;

    /* renamed from: b */
    static long f29280b;

    private x() {
    }

    public static w a() {
        synchronized (x.class) {
            if (f29279a != null) {
                w wVar = f29279a;
                f29279a = wVar.f29277f;
                wVar.f29277f = null;
                f29280b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                return wVar;
            }
            return new w();
        }
    }

    public static void a(w wVar) {
        if (wVar.f29277f == null && wVar.f29278g == null) {
            if (wVar.f29275d) {
                return;
            }
            synchronized (x.class) {
                if (f29280b + PlaybackStateCompat.ACTION_PLAY_FROM_URI > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    return;
                }
                f29280b += PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                wVar.f29277f = f29279a;
                wVar.f29274c = 0;
                wVar.f29273b = 0;
                f29279a = wVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
