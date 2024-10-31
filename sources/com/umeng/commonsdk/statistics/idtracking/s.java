package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;

/* compiled from: UUIDTracker.java */
/* loaded from: classes3.dex */
public class s extends a {

    /* renamed from: a */
    private static final String f26446a = "uuid";

    /* renamed from: e */
    private static final String f26447e = "yosuid";

    /* renamed from: f */
    private static final String f26448f = "23346339";

    /* renamed from: b */
    private Context f26449b;

    /* renamed from: c */
    private String f26450c;

    /* renamed from: d */
    private String f26451d;

    /* compiled from: UUIDTracker.java */
    /* renamed from: com.umeng.commonsdk.statistics.idtracking.s$1 */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements HostnameVerifier {
        AnonymousClass1() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return new BrowserCompatHostnameVerifier().verify("cmnsguider.yunos.com", sSLSession);
        }
    }

    public s(Context context) {
        super(f26446a);
        this.f26449b = null;
        this.f26450c = null;
        this.f26451d = null;
        this.f26449b = context;
        this.f26450c = null;
        this.f26451d = null;
    }

    public static String a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:17|18|19|(13:38|39|41|42|43|44|(2:45|(1:47)(1:48))|49|50|22|23|(2:32|33)|(2:28|29))|21|22|23|(0)|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ee, code lost:            if (r1 != null) goto L181;     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0125, code lost:            r1.disconnect();     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0123, code lost:            if (r1 == null) goto L182;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x010b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0104 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.s.b(java.lang.String):java.lang.String");
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        try {
            if (TextUtils.isEmpty(a("ro.yunos.version", "")) || this.f26449b == null || (sharedPreferences = PreferenceWrapper.getDefault(this.f26449b)) == null) {
                return null;
            }
            String string = sharedPreferences.getString(f26447e, "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            this.f26451d = b(f26448f);
            if (!TextUtils.isEmpty(this.f26451d) && this.f26449b != null && sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
                edit.putString(f26447e, this.f26451d).commit();
            }
            return this.f26451d;
        } catch (Exception unused) {
            return null;
        }
    }
}
