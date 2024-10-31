package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;

/* compiled from: EncryptHelper.java */
/* loaded from: classes3.dex */
public class w {

    /* renamed from: a */
    private static String f25974a = null;

    /* renamed from: b */
    private static final String f25975b = "umeng+";

    /* renamed from: c */
    private static final String f25976c = "ek__id";

    /* renamed from: d */
    private static final String f25977d = "ek_key";

    /* renamed from: e */
    private static w f25978e;

    private w() {
    }

    public static w a() {
        if (f25978e == null) {
            synchronized (w.class) {
                if (f25978e == null) {
                    f25978e = new w();
                }
            }
        }
        return f25978e;
    }

    public String b(String str) {
        try {
            return TextUtils.isEmpty(f25974a) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f25974a.getBytes()));
        } catch (Exception unused) {
            return null;
        }
    }

    public void a(Context context) {
        try {
            if (TextUtils.isEmpty(f25974a)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(context, f25976c);
                if (TextUtils.isEmpty(multiProcessSP)) {
                    multiProcessSP = DeviceConfig.getDBencryptID(context);
                    if (!TextUtils.isEmpty(multiProcessSP)) {
                        UMUtils.setMultiProcessSP(context, f25976c, multiProcessSP);
                    }
                }
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    String substring = multiProcessSP.substring(1, 9);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < substring.length(); i++) {
                        char charAt = substring.charAt(i);
                        if (Character.isDigit(charAt)) {
                            if (Integer.parseInt(Character.toString(charAt)) == 0) {
                                sb.append(0);
                            } else {
                                sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                            }
                        } else {
                            sb.append(charAt);
                        }
                    }
                    f25974a = sb.toString();
                }
                if (TextUtils.isEmpty(f25974a)) {
                    return;
                }
                f25974a += new StringBuilder(f25974a).reverse().toString();
                String multiProcessSP2 = UMUtils.getMultiProcessSP(context, f25977d);
                if (TextUtils.isEmpty(multiProcessSP2)) {
                    UMUtils.setMultiProcessSP(context, f25977d, a(f25975b));
                } else {
                    f25975b.equals(b(multiProcessSP2));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public String a(String str) {
        try {
            return TextUtils.isEmpty(f25974a) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f25974a.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }
}
