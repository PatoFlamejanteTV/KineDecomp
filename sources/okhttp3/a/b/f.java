package okhttp3.a.b;

import android.support.v7.widget.ActivityChooserView;
import com.facebook.stetho.server.http.HttpHeaders;
import java.util.List;
import okhttp3.A;
import okhttp3.C2571o;
import okhttp3.InterfaceC2573q;
import okhttp3.M;
import okhttp3.z;
import okio.ByteString;

/* compiled from: HttpHeaders.java */
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a */
    private static final ByteString f28878a = ByteString.encodeUtf8("\"\\");

    /* renamed from: b */
    private static final ByteString f28879b = ByteString.encodeUtf8("\t ,=");

    public static long a(M m) {
        return a(m.s());
    }

    public static boolean b(M m) {
        if (m.z().e().equals("HEAD")) {
            return false;
        }
        int c2 = m.c();
        return (((c2 >= 100 && c2 < 200) || c2 == 204 || c2 == 304) && a(m) == -1 && !"chunked".equalsIgnoreCase(m.e("Transfer-Encoding"))) ? false : true;
    }

    public static long a(z zVar) {
        return a(zVar.b(HttpHeaders.CONTENT_LENGTH));
    }

    private static long a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static void a(InterfaceC2573q interfaceC2573q, A a2, z zVar) {
        if (interfaceC2573q == InterfaceC2573q.f29202a) {
            return;
        }
        List<C2571o> a3 = C2571o.a(a2, zVar);
        if (a3.isEmpty()) {
            return;
        }
        interfaceC2573q.a(a2, a3);
    }

    public static int b(String str, int i) {
        char charAt;
        while (i < str.length() && ((charAt = str.charAt(i)) == ' ' || charAt == '\t')) {
            i++;
        }
        return i;
    }

    public static int a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int a(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
