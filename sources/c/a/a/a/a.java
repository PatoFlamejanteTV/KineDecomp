package c.a.a.a;

import android.content.Context;
import com.adobe.creativesdk.foundation.auth.l;
import com.adobe.creativesdk.foundation.internal.auth.E;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: AdobeCSDKFoundation.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private static String f3417a;

    /* renamed from: b */
    private static String f3418b;

    /* renamed from: c */
    private static String f3419c;

    /* renamed from: d */
    private static String f3420d;

    /* renamed from: e */
    private static String f3421e;

    /* renamed from: f */
    private static String[] f3422f;

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Context context) {
        if (context instanceof l) {
            l lVar = (l) context;
            f3417a = lVar.b();
            f3418b = lVar.a();
            f3421e = lVar.c();
            f3422f = lVar.d();
            c.a.a.a.c.a.a.b().a(context);
            try {
                E.m().a(f3417a, f3418b, f3421e, f3422f, null);
                return;
            } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeCSDKFoundation", e2.getMessage(), e2);
                return;
            }
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeCSDKFoundation", "Context not instance of IAdobeAuthClientCredentials");
    }

    public static String b() {
        return f3420d;
    }

    public static String c() {
        return f3417a;
    }

    public static String d() {
        return "0.9.2001-30";
    }

    public static String a() {
        return f3419c;
    }
}
