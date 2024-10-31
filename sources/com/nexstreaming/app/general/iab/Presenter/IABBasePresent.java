package com.nexstreaming.app.general.iab.Presenter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Base64;
import com.google.gson.Gson;
import com.nexstreaming.app.general.iab.DeveloperPayLoad;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.general.iab.InAppPurchaseData;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.util.DiagnosticLogger;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: IABBasePresent.kt */
/* loaded from: classes2.dex */
public abstract class IABBasePresent {

    /* renamed from: a, reason: collision with root package name */
    public static final a f19336a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final String f19337b;

    /* renamed from: c, reason: collision with root package name */
    private Gson f19338c;

    /* renamed from: d, reason: collision with root package name */
    private com.nexstreaming.app.general.iab.Utils.a f19339d;

    /* renamed from: e, reason: collision with root package name */
    private final io.reactivex.disposables.a f19340e;

    /* renamed from: f, reason: collision with root package name */
    private State f19341f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f19342g;

    /* renamed from: h, reason: collision with root package name */
    private final String f19343h;
    private final IABManager i;

    /* compiled from: IABBasePresent.kt */
    /* loaded from: classes2.dex */
    public enum State {
        NONE,
        REQUEST_LOGIN,
        SEND_RESULT
    }

    /* compiled from: IABBasePresent.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final String a(String str) {
            kotlin.jvm.internal.h.b(str, com.umeng.commonsdk.proguard.e.ap);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                byte[] bytes = str.getBytes(kotlin.text.c.f28548a);
                kotlin.jvm.internal.h.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                messageDigest.update(bytes);
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b2 : digest) {
                    String hexString = Integer.toHexString(b2 & 255);
                    while (hexString.length() < 2) {
                        hexString = '0' + hexString;
                    }
                    sb.append(hexString);
                }
                String sb2 = sb.toString();
                kotlin.jvm.internal.h.a((Object) sb2, "hexString.toString()");
                return sb2;
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
                return "";
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: IABBasePresent.kt */
    /* loaded from: classes2.dex */
    public interface b {
        void a(SKUDetails sKUDetails);
    }

    public IABBasePresent(Context context, String str, IABManager iABManager) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, "marketId");
        kotlin.jvm.internal.h.b(iABManager, "iabManager");
        this.f19342g = context;
        this.f19343h = str;
        this.i = iABManager;
        this.f19337b = "IABPresent";
        this.f19338c = new Gson();
        this.f19339d = new com.nexstreaming.app.general.iab.Utils.a();
        this.f19340e = new io.reactivex.disposables.a();
        this.f19341f = State.NONE;
    }

    public static final String e(String str) {
        return f19336a.a(str);
    }

    public abstract void A();

    public abstract io.reactivex.m<com.nexstreaming.app.general.iab.b.a> B();

    public abstract int a(int i);

    public abstract io.reactivex.m<com.nexstreaming.app.general.iab.b.b> a(Purchase purchase);

    public abstract io.reactivex.m<com.nexstreaming.app.general.iab.b.f> a(SKUDetails sKUDetails, DeveloperPayLoad developerPayLoad, Activity activity);

    public abstract io.reactivex.m<com.nexstreaming.app.general.iab.b.d> a(ArrayList<String> arrayList, IABConstant.SKUType sKUType);

    public abstract LinkedHashMap<String, SKUDetails> a(IABConstant.SKUType sKUType);

    public abstract void a();

    public final void a(State state) {
        kotlin.jvm.internal.h.b(state, "<set-?>");
        this.f19341f = state;
    }

    public abstract String b();

    public final String b(int i) {
        byte[] i2 = IABConstant.o.i();
        byte b2 = (byte) (i % 71);
        StringBuilder sb = new StringBuilder(i2.length);
        for (byte b3 : i2) {
            sb.appendCodePoint((byte) (b3 ^ b2));
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.h.a((Object) sb2, "sb.toString()");
        return sb2;
    }

    public abstract String c();

    public final PublicKey c(String str) {
        kotlin.jvm.internal.h.b(str, "encodedPublicKey");
        try {
            PublicKey generatePublic = KeyFactory.getInstance(IABConstant.o.f()).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            kotlin.jvm.internal.h.a((Object) generatePublic, "keyFactory.generatePubli…codedKeySpec(decodedKey))");
            return generatePublic;
        } catch (NoSuchAlgorithmException unused) {
            throw new RuntimeException("IRQLC");
        } catch (InvalidKeySpecException unused2) {
            throw new IllegalArgumentException("IRQLA");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.nexstreaming.app.general.iab.Utils.a d() {
        return this.f19339d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final io.reactivex.disposables.a e() {
        return this.f19340e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Context f() {
        return this.f19342g;
    }

    public abstract String g();

    /* JADX INFO: Access modifiers changed from: protected */
    public final Gson h() {
        return this.f19338c;
    }

    public final IABManager i() {
        return this.i;
    }

    public final State j() {
        return this.f19341f;
    }

    public final String k() {
        return this.f19343h;
    }

    public abstract LinkedHashMap<IABConstant.SKUType, List<Purchase>> l();

    public abstract String m();

    public abstract LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> n();

    public final String o() {
        return this.f19337b;
    }

    public abstract String p();

    public final long q() {
        return c.d.b.m.i.b(this.f19342g);
    }

    public abstract boolean r();

    public abstract boolean s();

    public abstract io.reactivex.m<com.nexstreaming.app.general.iab.b.c> t();

    public abstract io.reactivex.m<com.nexstreaming.app.general.iab.b.d> u();

    public abstract void v();

    public abstract void w();

    public abstract void x();

    public abstract ResultTask<Boolean> y();

    public final io.reactivex.m<com.nexstreaming.app.general.iab.b.e> z() {
        io.reactivex.m<com.nexstreaming.app.general.iab.b.e> a2 = io.reactivex.m.a((io.reactivex.o) new C1675d(this));
        kotlin.jvm.internal.h.a((Object) a2, "Observable.create {\n    …        }.run()\n        }");
        return a2;
    }

    public final void a(String str, Purchase purchase, long j) {
        kotlin.jvm.internal.h.b(str, "key");
        String str2 = c() + str;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f19342g);
        if (purchase != null) {
            Gson gson = this.f19338c;
            if (gson != null) {
                defaultSharedPreferences.edit().putString(str2, b(gson.toJson(purchase))).putLong(str2 + "exp", j).apply();
                return;
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
        defaultSharedPreferences.edit().putString(str2, "").putLong(str2 + "exp", 0L).apply();
    }

    public final Purchase d(String str) {
        kotlin.jvm.internal.h.b(str, "key");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f19342g);
        String str2 = c() + str;
        String string = defaultSharedPreferences.getString(str2, "");
        long j = defaultSharedPreferences.getLong(str2 + "exp", 0L);
        if (!TextUtils.isEmpty(string) && q() < j) {
            try {
                Gson gson = this.f19338c;
                if (gson != null) {
                    return (Purchase) gson.fromJson(a(string), Purchase.class);
                }
                kotlin.jvm.internal.h.a();
                throw null;
            } catch (Exception unused) {
                String a2 = a(string);
                if (a2 != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("Json", a2);
                    KMEvents.LOAD_RECENTLY_PURCHASE_PARSING_ERROR.logEvent(hashMap);
                }
            }
        } else {
            defaultSharedPreferences.edit().putString(str2, "").putLong(str2 + "exp", 0L).apply();
        }
        return null;
    }

    protected final String b(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes(kotlin.text.c.f28548a);
        kotlin.jvm.internal.h.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        return Base64.encodeToString(bytes, 0);
    }

    public final Purchase a(int i, com.android.billingclient.api.M m) {
        kotlin.jvm.internal.h.b(m, "purchase");
        Purchase purchase = new Purchase();
        String a2 = m.a();
        String d2 = m.d();
        IABConstant.a aVar = IABConstant.o;
        aVar.e(aVar.j() * 6163);
        kotlin.jvm.internal.h.a((Object) a2, "signedData");
        kotlin.jvm.internal.h.a((Object) d2, "signature");
        int a3 = a(a2, d2);
        purchase.a(d2);
        purchase.a(a3);
        purchase.a((InAppPurchaseData) this.f19338c.fromJson(a2, InAppPurchaseData.class));
        InAppPurchaseData e2 = purchase.e();
        kotlin.jvm.internal.h.a((Object) e2, "mPurchase.purchaseData");
        purchase.b(e2.c());
        purchase.a(this.f19339d.a(this.f19342g));
        return purchase;
    }

    public final int a(PublicKey publicKey, String str, String str2, int i) {
        kotlin.jvm.internal.h.b(publicKey, "publicKey");
        kotlin.jvm.internal.h.b(str, "signedData");
        kotlin.jvm.internal.h.b(str2, "signature");
        try {
            Signature signature = Signature.getInstance(IABConstant.o.k());
            kotlin.jvm.internal.h.a((Object) signature, "Signature.getInstance(IA…tant.SIGNATURE_ALGORITHM)");
            signature.initVerify(publicKey);
            byte[] bytes = str.getBytes(kotlin.text.c.f28548a);
            kotlin.jvm.internal.h.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            signature.update(bytes);
            if (!signature.verify(Base64.decode(str2, 0))) {
                DiagnosticLogger.b().a(DiagnosticLogger.Tag.IH_VFY_SVF);
                IABConstant.a aVar = IABConstant.o;
                aVar.a(aVar.b() * 2347);
                return IABConstant.o.b() * 3;
            }
            DiagnosticLogger.b().a(DiagnosticLogger.Tag.IH_VFY_SVOK);
            return (IABConstant.o.d() ^ i) ^ (-382534749);
        } catch (InvalidKeyException unused) {
            DiagnosticLogger.b().a(DiagnosticLogger.Tag.IH_VFY_INVALKEY);
            DiagnosticLogger.b().a(DiagnosticLogger.Tag.IH_VFY_SVX);
            IABConstant.a aVar2 = IABConstant.o;
            aVar2.a(aVar2.b() * 2347);
            return IABConstant.o.b() * 2;
        } catch (NoSuchAlgorithmException unused2) {
            DiagnosticLogger.b().a(DiagnosticLogger.Tag.IH_VFY_NSALGO);
            DiagnosticLogger.b().a(DiagnosticLogger.Tag.IH_VFY_SVX);
            IABConstant.a aVar22 = IABConstant.o;
            aVar22.a(aVar22.b() * 2347);
            return IABConstant.o.b() * 2;
        } catch (SignatureException unused3) {
            DiagnosticLogger.b().a(DiagnosticLogger.Tag.IH_VFY_SIGEX);
            DiagnosticLogger.b().a(DiagnosticLogger.Tag.IH_VFY_SVX);
            IABConstant.a aVar222 = IABConstant.o;
            aVar222.a(aVar222.b() * 2347);
            return IABConstant.o.b() * 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(String str, String str2) {
        kotlin.jvm.internal.h.b(str, "signedData");
        kotlin.jvm.internal.h.b(str2, "signature");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(b(2355)) && !TextUtils.isEmpty(str2)) {
            PublicKey c2 = c(b(2372));
            byte[] encoded = c2.getEncoded();
            return a(c2, str, str2, IABConstant.o.c() ^ 61750) ^ ((((((((encoded[0] * 31) + ((encoded[10] * 31) * 31)) + (((encoded[32] * 31) * 31) * 31)) + ((((encoded[42] * 31) * 31) * 31) * 31)) + (encoded[50] * 700)) + (encoded[51] * 800)) + (encoded[160] * 567)) + (encoded[198] * Byte.MAX_VALUE));
        }
        IABConstant.a aVar = IABConstant.o;
        aVar.a(aVar.b() * 2347);
        return IABConstant.o.b() * 5;
    }

    public final void a(SKUDetails sKUDetails) {
        boolean a2;
        boolean a3;
        kotlin.jvm.internal.h.b(sKUDetails, "sku");
        String k = sKUDetails.k();
        kotlin.jvm.internal.h.a((Object) k, "sku.type");
        IABConstant.SKUType valueOf = IABConstant.SKUType.valueOf(k);
        int a4 = this.f19339d.a(sKUDetails);
        sKUDetails.b(R.string.buy_now);
        int i = C1672a.f19366a[valueOf.ordinal()];
        if (i == 1) {
            String g2 = sKUDetails.g();
            kotlin.jvm.internal.h.a((Object) g2, "sku.productId");
            a2 = kotlin.text.w.a((CharSequence) g2, (CharSequence) IABConstant.o.m(), false, 2, (Object) null);
            if (a2) {
                sKUDetails.d(R.string.subscription_monthly);
                sKUDetails.a(this.f19342g.getResources().getStringArray(R.array.monthly_product_benefits));
                sKUDetails.b(R.string.subscription_monthly);
                return;
            }
            String g3 = sKUDetails.g();
            kotlin.jvm.internal.h.a((Object) g3, "sku.productId");
            a3 = kotlin.text.w.a((CharSequence) g3, (CharSequence) IABConstant.o.l(), false, 2, (Object) null);
            if (a3) {
                sKUDetails.d(R.string.subscription_annual);
                sKUDetails.a(this.f19342g.getResources().getStringArray(R.array.annual_product_benefits));
                sKUDetails.b(R.string.subscription_annual);
                return;
            }
            return;
        }
        if (i == 2 || i == 3) {
            if (a4 == 7) {
                sKUDetails.d(R.string.sub_use_for_seven_days);
                sKUDetails.a(this.f19342g.getResources().getStringArray(R.array.monthly_product_benefits));
                return;
            }
            if (a4 == 30) {
                sKUDetails.b(R.string.china_subscription_monthly);
                sKUDetails.d(R.string.sub_use_for_thirty_days);
                sKUDetails.a(this.f19342g.getResources().getStringArray(R.array.monthly_product_benefits));
            } else if (a4 == 90) {
                sKUDetails.d(R.string.sub_use_for_ninety_days);
                sKUDetails.a(this.f19342g.getResources().getStringArray(R.array.monthly_product_benefits));
            } else {
                if (a4 != 365) {
                    return;
                }
                sKUDetails.b(R.string.china_subscription_annual);
                sKUDetails.d(R.string.sub_use_for_one_year);
                sKUDetails.a(this.f19342g.getResources().getStringArray(R.array.annual_product_benefits));
            }
        }
    }

    protected final String a(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes(kotlin.text.c.f28548a);
        kotlin.jvm.internal.h.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] decode = Base64.decode(bytes, 0);
        kotlin.jvm.internal.h.a((Object) decode, "Base64.decode(value.toByteArray(), Base64.DEFAULT)");
        return new String(decode, kotlin.text.c.f28548a);
    }
}
