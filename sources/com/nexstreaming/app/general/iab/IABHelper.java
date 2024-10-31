package com.nexstreaming.app.general.iab;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.google.gson.Gson;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.DiagnosticLogger;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.av;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class IABHelper {

    /* renamed from: a, reason: collision with root package name */
    public static int f3141a;
    protected static int b;
    protected static int c;
    protected static int d;
    protected static int e;
    protected static int f;
    private static final boolean g = av.a().f();
    private static final byte[] h = {80, 84, 84, 95, 84, 119, 92, 83, 95, 122, 118, 108, 117, 118, 116, 90, 36, 106, 45, 95, 92, 76, 88, 91, 92, 92, 82, 94, 92, 76, 37, 92, 80, 84, 84, 95, 94, 122, 86, 94, 92, 76, 88, 92, 115, 114, 126, 108, 120, 40, 121, 123, 37, 37, 82, Byte.MAX_VALUE, 120, 122, 95, 44, 85, 37, 109, 115, 106, 95, 116, 118, 123, 108, 74, 117, 82, 80, 89, 119, 47, 120, 91, 78, 83, 79, 113, 88, 43, 123, 88, 71, 95, 42, 109, 108, 101, 80, 109, 91, 45, 92, 44, 40, 83, 112, 83, 42, 45, 43, 46, 92, 43, 69, 124, 119, 72, 121, 83, 114, 42, 121, 115, 86, 44, 90, 101, 119, 47, 124, 118, 120, 92, 85, 50, 121, 112, 116, 90, 45, 107, 81, 101, 45, 111, 115, 101, 40, 86, 43, 76, 113, 40, 108, 43, 80, 117, 124, 76, 68, 114, 40, 104, 105, 88, 50, 95, 79, 88, 81, 120, 104, 54, 85, 76, 94, 68, 115, 116, 111, Byte.MAX_VALUE, 74, 101, 104, 44, 118, 78, 36, 111, Byte.MAX_VALUE, 75, 80, 95, 111, 46, 54, 74, 110, 107, 115, 79, 86, 84, 109, 92, 73, 104, 87, 80, 124, 109, 109, 89, 90, 82, 46, Byte.MAX_VALUE, 40, 78, 110, 47, 80, 90, 112, 82, 80, 71, 108, 87, 126, 83, 105, 36, 115, 124, 100, 100, 72, 42, 37, 89, 114, 108, 86, 37, 43, 71, 114, 112, 79, 82, 83, Byte.MAX_VALUE, 121, 82, 94, 68, 116, 77, 79, 95, 126, 76, 117, 113, 68, 94, 118, 101, 119, 79, 86, 73, 106, 89, 117, 105, 84, 72, 114, 40, 72, 103, 90, 114, 114, 92, 123, 119, 76, 111, 37, 43, Byte.MAX_VALUE, 84, 81, 80, 121, 101, 116, 45, 108, 88, 120, 46, 92, 100, 118, 75, 54, 77, 126, 44, 45, 121, 69, 72, 54, 40, 36, 120, 77, 42, 81, 40, 113, 124, Byte.MAX_VALUE, 88, 73, 80, 54, 103, 46, 83, 112, 120, 113, 107, 92, 121, 90, 108, 89, 85, 104, 68, 77, 74, 123, 88, 115, 79, 87, 36, 79, 42, 122, 82, 78, 79, 103, 121, 80, 123, 83, 84, 89, 123, 92, 117, 94, 69, 50, 44, 123, 121, 92, 80, 124, 100, 104, 47, 113, 116, 124, 79, 103, 75, 76, 84, 89, 92, 76, 92, 95};
    private static final String[] i = {"test.kinemaster.subscription.", "com.kinemaster.subscription."};
    private static final String[] j;
    private static Map<SKUType, Map<String, SKUDetails>> k;
    private static Map<SKUType, List<Purchase>> l;
    private Context m;
    private Gson n;
    private final String o;

    /* loaded from: classes.dex */
    public enum SKUType {
        inapp,
        subs,
        xiaomi,
        wechat
    }

    /* loaded from: classes.dex */
    public interface a {
        void a(BuyResult buyResult);

        void a(boolean z, Purchase purchase, String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(IABError iABError, String str);

        void a(SKUDetails sKUDetails, Purchase purchase);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(Map<SKUType, List<Purchase>> map);

        void b(IABError iABError, String str);
    }

    /* loaded from: classes.dex */
    public interface d {
        void b(Map<SKUType, Map<String, SKUDetails>> map);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(boolean z, int i);
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(Purchase purchase, int i);
    }

    public abstract void a();

    public abstract void a(c cVar);

    public abstract void a(d dVar);

    public abstract void a(e eVar);

    public abstract void a(SKUDetails sKUDetails, DeveloperPayLoad developerPayLoad, int i2, a aVar);

    public abstract boolean b();

    public abstract String c();

    public abstract String d();

    public abstract String e();

    public abstract String f();

    public abstract String g();

    public abstract String h();

    public abstract String q();

    public abstract String r();

    static {
        j = g ? new String[]{"test.kinemaster.onetime.", "test.kinemaster.extension."} : new String[]{"com.kinemaster.onetime.", "com.kinemaster.extension."};
        f3141a = 37429791;
        b = 69471369;
        c = 191889905;
        d = 268349438;
        e = 169863194;
        f = 0;
        k = new HashMap();
        l = new HashMap();
    }

    public IABHelper(Context context, String str) {
        f3141a = (((int) ((System.currentTimeMillis() * 31) & 65535)) * (e >> 1)) ^ 37429791;
        f = f3141a * 31;
        b = (69471369 ^ f3141a) & (-968648089);
        c = (191889905 ^ f3141a) & 968648088;
        d ^= f3141a;
        this.n = null;
        this.m = context;
        this.n = new Gson();
        this.o = str;
    }

    protected void a(Purchase purchase, DeveloperPayLoad developerPayLoad) {
    }

    public void a(SKUDetails sKUDetails, Purchase purchase, b bVar) {
        if (bVar != null) {
            bVar.a(sKUDetails, purchase);
        }
    }

    public void i() {
    }

    public void b(e eVar) {
        j();
        a(eVar);
    }

    public void c(e eVar) {
        j();
        a(eVar);
    }

    public void d(e eVar) {
        j();
        a(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
    }

    public int a(int i2) {
        return (f3141a & 65535) + (i2 ^ 4660);
    }

    public Purchase a(int i2, int i3, Intent intent, Task.TaskError[] taskErrorArr) {
        DeveloperPayLoad developerPayLoad;
        if (i3 != -1) {
            switch (i3) {
                case 0:
                    taskErrorArr[0] = BillingResponse.USER_CANCELED_ACTIVITY;
                    return null;
                default:
                    taskErrorArr[0] = BillingResponse.BAD_ACTIVITY_RESULT;
                    return null;
            }
        }
        if (intent == null) {
            taskErrorArr[0] = BillingResponse.NULL_INTENT_DATA;
            return null;
        }
        Bundle extras = intent.getExtras();
        BillingResponse fromCode = BillingResponse.fromCode(extras.getInt("RESPONSE_CODE"));
        if (fromCode != BillingResponse.OK) {
            taskErrorArr[0] = fromCode;
            return null;
        }
        Purchase purchase = new Purchase();
        String string = extras.getString("INAPP_PURCHASE_DATA");
        String string2 = extras.getString("INAPP_DATA_SIGNATURE");
        f *= 6163;
        int a2 = a(string, string2);
        if (((f3141a ^ a2) & (-65536)) != -491454464) {
            taskErrorArr[0] = BillingResponse.GENERAL_FAILURE;
            return null;
        }
        purchase.b(string2);
        purchase.a(a2);
        purchase.a((InAppPurchaseData) l().fromJson(string, InAppPurchaseData.class));
        purchase.a(purchase.h().c());
        purchase.a(p());
        try {
            developerPayLoad = (DeveloperPayLoad) l().fromJson(purchase.e(), DeveloperPayLoad.class);
        } catch (Exception e2) {
            e2.printStackTrace();
            developerPayLoad = null;
        }
        a(purchase, developerPayLoad);
        return purchase;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context k() {
        return this.m;
    }

    private static String b(int i2) {
        byte[] bArr = h;
        byte b2 = (byte) (i2 % 71);
        StringBuilder sb = new StringBuilder(bArr.length);
        for (byte b3 : bArr) {
            sb.appendCodePoint(b3 ^ b2);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(b(2355)) || TextUtils.isEmpty(str2)) {
            d *= 2347;
            return d * 5;
        }
        PublicKey h2 = h(b(2372));
        byte[] encoded = h2.getEncoded();
        return a(h2, str, str2, b ^ 61750) ^ ((encoded[198] * Byte.MAX_VALUE) + (((((((encoded[0] * 31) + ((encoded[10] * 31) * 31)) + (((encoded[32] * 31) * 31) * 31)) + ((((encoded[42] * 31) * 31) * 31) * 31)) + (encoded[50] * 700)) + (encoded[51] * 800)) + (encoded[160] * 567)));
    }

    private static PublicKey h(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("IRQLC");
        } catch (InvalidKeySpecException e3) {
            throw new IllegalArgumentException("IRQLA");
        }
    }

    private static int a(PublicKey publicKey, String str, String str2, int i2) {
        int i3;
        try {
            Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initVerify(publicKey);
            signature.update(str.getBytes());
            if (!signature.verify(Base64.decode(str2, 0))) {
                DiagnosticLogger.a().a(DiagnosticLogger.Tag.IH_VFY_SVF);
                d *= 2347;
                i3 = d * 3;
            } else {
                DiagnosticLogger.a().a(DiagnosticLogger.Tag.IH_VFY_SVOK);
                i3 = (c ^ i2) ^ (-382534749);
            }
            return i3;
        } catch (InvalidKeyException e2) {
            DiagnosticLogger.a().a(DiagnosticLogger.Tag.IH_VFY_INVALKEY);
            DiagnosticLogger.a().a(DiagnosticLogger.Tag.IH_VFY_SVX);
            d *= 2347;
            return d * 2;
        } catch (NoSuchAlgorithmException e3) {
            DiagnosticLogger.a().a(DiagnosticLogger.Tag.IH_VFY_NSALGO);
            DiagnosticLogger.a().a(DiagnosticLogger.Tag.IH_VFY_SVX);
            d *= 2347;
            return d * 2;
        } catch (SignatureException e4) {
            DiagnosticLogger.a().a(DiagnosticLogger.Tag.IH_VFY_SIGEX);
            DiagnosticLogger.a().a(DiagnosticLogger.Tag.IH_VFY_SVX);
            d *= 2347;
            return d * 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SKUDetails sKUDetails) {
        SKUType valueOf = SKUType.valueOf(sKUDetails.b());
        boolean c2 = c(sKUDetails);
        int b2 = b(sKUDetails);
        switch (valueOf) {
            case subs:
                sKUDetails.c(R.string.subscribe_now);
                if (sKUDetails.a().contains("monthly")) {
                    sKUDetails.b(R.string.subscription_monthly);
                    return;
                } else {
                    if (sKUDetails.a().contains("annual")) {
                        sKUDetails.b(R.string.subscription_annual);
                        return;
                    }
                    return;
                }
            case inapp:
            case xiaomi:
            case wechat:
                sKUDetails.c(R.string.buy_now);
                switch (b2) {
                    case 7:
                        sKUDetails.b(c2 ? R.string.sub_extension_seven_days : R.string.sub_use_for_seven_days);
                        return;
                    case 30:
                        sKUDetails.b(c2 ? R.string.sub_extension_thirty_days : R.string.sub_use_for_thirty_days);
                        return;
                    case 90:
                        sKUDetails.b(c2 ? R.string.sub_extension_ninety_days : R.string.sub_use_for_ninety_days);
                        return;
                    case 365:
                        sKUDetails.b(c2 ? R.string.sub_extension_one_year : R.string.sub_use_for_one_year);
                        return;
                    default:
                        return;
                }
            default:
                return;
        }
    }

    private boolean i(String str) {
        if (str == null) {
            return false;
        }
        return str.contains(j[1]);
    }

    private int j(String str) {
        int i2;
        if (str == null) {
            return 0;
        }
        int i3 = 0;
        for (String str2 : j) {
            if (str.contains(str2)) {
                String[] split = str.substring(str2.length()).split("\\.");
                if (split.length > 1) {
                    String trim = split[1].trim();
                    if (trim.equalsIgnoreCase("day") || trim.equalsIgnoreCase("days")) {
                        i2 = 1;
                    } else if (trim.equalsIgnoreCase("week") || trim.equalsIgnoreCase("weeks")) {
                        i2 = 7;
                    } else if (trim.equalsIgnoreCase("month") || trim.equalsIgnoreCase("months")) {
                        i2 = 30;
                    } else {
                        i2 = (trim.equalsIgnoreCase("year") || trim.equalsIgnoreCase("years")) ? 365 : 0;
                    }
                    try {
                        i3 = Integer.parseInt(split[0].trim()) * i2;
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                        DiagnosticLogger.a().a(DiagnosticLogger.Tag.IW_P_SUFFIX_MALFORMED);
                    }
                } else {
                    Log.i("IABHelper", "Bad sku id = " + str);
                }
            }
        }
        return i3;
    }

    private boolean k(String str) {
        if (str == null) {
            return false;
        }
        for (String str2 : i) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Gson l() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean m() {
        return com.nexstreaming.kinemaster.h.a.c(k());
    }

    public boolean a(String str) {
        if (str == null) {
            return false;
        }
        for (String str2 : i) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean b(String str) {
        if (str == null) {
            return false;
        }
        for (String str2 : j) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<SKUType, Map<String, SKUDetails>> n() {
        return k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<SKUType, List<Purchase>> o() {
        return l;
    }

    public PurchaseType c(String str) {
        PurchaseType purchaseType = PurchaseType.None;
        if (str != null) {
            for (String str2 : j) {
                if (str.contains(str2)) {
                    purchaseType = PurchaseType.OneTimeValid;
                } else {
                    purchaseType = PurchaseType.SubUnknown;
                }
            }
            for (String str3 : i) {
                if (str.contains(str3)) {
                    if (str.contains("monthly")) {
                        purchaseType = PurchaseType.SubMonthly;
                    } else if (str.contains("annual")) {
                        purchaseType = PurchaseType.SubAnnual;
                    } else {
                        purchaseType = PurchaseType.SubUnknown;
                    }
                }
            }
        }
        return purchaseType;
    }

    public int b(SKUDetails sKUDetails) {
        if (sKUDetails != null) {
            return j(sKUDetails.a());
        }
        return 0;
    }

    public int a(Purchase purchase) {
        if (purchase != null) {
            return j(purchase.a());
        }
        return 0;
    }

    public boolean c(SKUDetails sKUDetails) {
        return sKUDetails != null && i(sKUDetails.a());
    }

    public boolean b(Purchase purchase) {
        return purchase != null && i(purchase.a());
    }

    public boolean d(SKUDetails sKUDetails) {
        return sKUDetails != null && k(sKUDetails.a());
    }

    public boolean c(Purchase purchase) {
        return purchase != null && k(purchase.a());
    }

    public boolean e(SKUDetails sKUDetails) {
        if (!d(sKUDetails)) {
            return false;
        }
        for (String str : i) {
            if (sKUDetails.a().startsWith(str) && sKUDetails.a().contains("monthly")) {
                return true;
            }
        }
        return false;
    }

    public boolean d(Purchase purchase) {
        if (!c(purchase)) {
            return false;
        }
        for (String str : i) {
            if (purchase.a().startsWith(str) && purchase.a().contains("monthly")) {
                return true;
            }
        }
        return false;
    }

    public boolean f(SKUDetails sKUDetails) {
        if (!d(sKUDetails)) {
            return false;
        }
        for (String str : i) {
            if (sKUDetails.a().startsWith(str) && sKUDetails.a().contains("annual")) {
                return true;
            }
        }
        return false;
    }

    public boolean e(Purchase purchase) {
        if (!c(purchase)) {
            return false;
        }
        for (String str : i) {
            if (purchase.a().startsWith(str) && purchase.a().contains("annual")) {
                return true;
            }
        }
        return false;
    }

    public long p() {
        return com.nexstreaming.kinemaster.h.a.g(k());
    }

    public String s() {
        return this.o;
    }

    public String t() {
        return null;
    }

    /* loaded from: classes.dex */
    public static final class DeveloperPayLoad {
        public String preSku = null;
        public int remainingDays = 0;
        public String payload = null;

        public String toString() {
            return "DeveloperPayLoad{preSku='" + this.preSku + "', remainingDays=" + this.remainingDays + ", payload='" + this.payload + "'}";
        }
    }

    public static final String d(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                String hexString = Integer.toHexString(b2 & 255);
                while (hexString.length() < 2) {
                    hexString = AppEventsConstants.EVENT_PARAM_VALUE_NO + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public void a(String str, Purchase purchase, long j2) {
        if (purchase != null) {
            String f2 = f(l().toJson(purchase));
            String str2 = r() + str;
            PreferenceManager.getDefaultSharedPreferences(this.m).edit().putString(str2, f2).putLong(str2 + "exp", j2).apply();
        }
    }

    public Purchase e(String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.m);
        String str2 = r() + str;
        String string = defaultSharedPreferences.getString(str2, "");
        long j2 = defaultSharedPreferences.getLong(str2 + "exp", 0L);
        if (!TextUtils.isEmpty(string) && p() < j2) {
            Log.i("IABHelper", "lrp() called with: OK key = [" + str + "]");
            return (Purchase) l().fromJson(g(string), Purchase.class);
        }
        defaultSharedPreferences.edit().putString(str2, "").putLong(str2 + "exp", 0L).commit();
        Log.i("IABHelper", "lrp() called with: FAIL expired cache key = [" + str + "]");
        return null;
    }

    public boolean u() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String f(String str) {
        if (str == null) {
            return null;
        }
        return Base64.encodeToString(str.getBytes(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String g(String str) {
        if (str == null) {
            return null;
        }
        return new String(Base64.decode(str.getBytes(), 0));
    }
}
