package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: CipherSuite.java */
/* renamed from: okhttp3.j */
/* loaded from: classes3.dex */
public final class C2566j {
    final String qb;

    /* renamed from: a */
    static final Comparator<String> f29166a = new C2565i();

    /* renamed from: b */
    private static final Map<String, C2566j> f29167b = new LinkedHashMap();

    /* renamed from: c */
    public static final C2566j f29168c = a("SSL_RSA_WITH_NULL_MD5", 1);

    /* renamed from: d */
    public static final C2566j f29169d = a("SSL_RSA_WITH_NULL_SHA", 2);

    /* renamed from: e */
    public static final C2566j f29170e = a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);

    /* renamed from: f */
    public static final C2566j f29171f = a("SSL_RSA_WITH_RC4_128_MD5", 4);

    /* renamed from: g */
    public static final C2566j f29172g = a("SSL_RSA_WITH_RC4_128_SHA", 5);

    /* renamed from: h */
    public static final C2566j f29173h = a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
    public static final C2566j i = a("SSL_RSA_WITH_DES_CBC_SHA", 9);
    public static final C2566j j = a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    public static final C2566j k = a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
    public static final C2566j l = a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
    public static final C2566j m = a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
    public static final C2566j n = a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
    public static final C2566j o = a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
    public static final C2566j p = a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
    public static final C2566j q = a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
    public static final C2566j r = a("SSL_DH_anon_WITH_RC4_128_MD5", 24);
    public static final C2566j s = a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
    public static final C2566j t = a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
    public static final C2566j u = a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
    public static final C2566j v = a("TLS_KRB5_WITH_DES_CBC_SHA", 30);
    public static final C2566j w = a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
    public static final C2566j x = a("TLS_KRB5_WITH_RC4_128_SHA", 32);
    public static final C2566j y = a("TLS_KRB5_WITH_DES_CBC_MD5", 34);
    public static final C2566j z = a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    public static final C2566j A = a("TLS_KRB5_WITH_RC4_128_MD5", 36);
    public static final C2566j B = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    public static final C2566j C = a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    public static final C2566j D = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    public static final C2566j E = a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    public static final C2566j F = a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    public static final C2566j G = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    public static final C2566j H = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
    public static final C2566j I = a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    public static final C2566j J = a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    public static final C2566j K = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    public static final C2566j L = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    public static final C2566j M = a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    public static final C2566j N = a("TLS_RSA_WITH_NULL_SHA256", 59);
    public static final C2566j O = a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    public static final C2566j P = a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    public static final C2566j Q = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    public static final C2566j R = a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    public static final C2566j S = a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    public static final C2566j T = a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    public static final C2566j U = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
    public static final C2566j V = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
    public static final C2566j W = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
    public static final C2566j X = a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    public static final C2566j Y = a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
    public static final C2566j Z = a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
    public static final C2566j aa = a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
    public static final C2566j ba = a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
    public static final C2566j ca = a("TLS_PSK_WITH_RC4_128_SHA", 138);
    public static final C2566j da = a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
    public static final C2566j ea = a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
    public static final C2566j fa = a("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
    public static final C2566j ga = a("TLS_RSA_WITH_SEED_CBC_SHA", 150);
    public static final C2566j ha = a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
    public static final C2566j ia = a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
    public static final C2566j ja = a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
    public static final C2566j ka = a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
    public static final C2566j la = a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
    public static final C2566j ma = a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
    public static final C2566j na = a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
    public static final C2566j oa = a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
    public static final C2566j pa = a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
    public static final C2566j qa = a("TLS_FALLBACK_SCSV", 22016);
    public static final C2566j ra = a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
    public static final C2566j sa = a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
    public static final C2566j ta = a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
    public static final C2566j ua = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    public static final C2566j va = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    public static final C2566j wa = a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    public static final C2566j xa = a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    public static final C2566j ya = a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
    public static final C2566j za = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    public static final C2566j Aa = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
    public static final C2566j Ba = a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
    public static final C2566j Ca = a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    public static final C2566j Da = a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    public static final C2566j Ea = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    public static final C2566j Fa = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    public static final C2566j Ga = a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    public static final C2566j Ha = a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    public static final C2566j Ia = a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    public static final C2566j Ja = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    public static final C2566j Ka = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    public static final C2566j La = a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    public static final C2566j Ma = a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    public static final C2566j Na = a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    public static final C2566j Oa = a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
    public static final C2566j Pa = a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
    public static final C2566j Qa = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
    public static final C2566j Ra = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
    public static final C2566j Sa = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    public static final C2566j Ta = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    public static final C2566j Ua = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
    public static final C2566j Va = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
    public static final C2566j Wa = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    public static final C2566j Xa = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    public static final C2566j Ya = a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    public static final C2566j Za = a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    public static final C2566j _a = a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
    public static final C2566j ab = a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
    public static final C2566j bb = a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
    public static final C2566j cb = a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
    public static final C2566j db = a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
    public static final C2566j eb = a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
    public static final C2566j fb = a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
    public static final C2566j gb = a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
    public static final C2566j hb = a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
    public static final C2566j ib = a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    public static final C2566j jb = a("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
    public static final C2566j kb = a("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
    public static final C2566j lb = a("TLS_AES_128_GCM_SHA256", 4865);
    public static final C2566j mb = a("TLS_AES_256_GCM_SHA384", 4866);
    public static final C2566j nb = a("TLS_CHACHA20_POLY1305_SHA256", 4867);
    public static final C2566j ob = a("TLS_AES_128_CCM_SHA256", 4868);
    public static final C2566j pb = a("TLS_AES_256_CCM_8_SHA256", 4869);

    private C2566j(String str) {
        if (str != null) {
            this.qb = str;
            return;
        }
        throw new NullPointerException();
    }

    public static synchronized C2566j a(String str) {
        C2566j c2566j;
        synchronized (C2566j.class) {
            c2566j = f29167b.get(str);
            if (c2566j == null) {
                c2566j = f29167b.get(b(str));
                if (c2566j == null) {
                    c2566j = new C2566j(str);
                }
                f29167b.put(str, c2566j);
            }
        }
        return c2566j;
    }

    private static String b(String str) {
        if (str.startsWith("TLS_")) {
            return "SSL_" + str.substring(4);
        }
        if (!str.startsWith("SSL_")) {
            return str;
        }
        return "TLS_" + str.substring(4);
    }

    public String toString() {
        return this.qb;
    }

    public static List<C2566j> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static C2566j a(String str, int i2) {
        C2566j c2566j = new C2566j(str);
        f29167b.put(str, c2566j);
        return c2566j;
    }
}
