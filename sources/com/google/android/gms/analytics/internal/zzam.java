package com.google.android.gms.analytics.internal;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.internal.zzpc;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.keyczar.Keyczar;

/* loaded from: classes.dex */
public class zzam {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f735a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static double a(String str, double d) {
        if (str == null) {
            return d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return d;
        }
    }

    public static long a(String str) {
        if (str == null) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return 0L;
        }
    }

    public static zzpc a(zzaf zzafVar, String str) {
        com.google.android.gms.common.internal.zzx.a(zzafVar);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            List<NameValuePair> parse = URLEncodedUtils.parse(new URI("?" + str), Keyczar.DEFAULT_ENCODING);
            HashMap hashMap = new HashMap(parse.size());
            for (NameValuePair nameValuePair : parse) {
                hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
            zzpc zzpcVar = new zzpc();
            zzpcVar.zzdK((String) hashMap.get("utm_content"));
            zzpcVar.zzdI((String) hashMap.get("utm_medium"));
            zzpcVar.setName((String) hashMap.get("utm_campaign"));
            zzpcVar.zzdH((String) hashMap.get("utm_source"));
            zzpcVar.zzdJ((String) hashMap.get("utm_term"));
            zzpcVar.zzdL((String) hashMap.get("utm_id"));
            zzpcVar.zzdM((String) hashMap.get("anid"));
            zzpcVar.zzdN((String) hashMap.get("gclid"));
            zzpcVar.zzdO((String) hashMap.get("dclid"));
            zzpcVar.zzdP((String) hashMap.get("aclid"));
            return zzpcVar;
        } catch (URISyntaxException e) {
            zzafVar.d("No valid campaign data found", e);
            return null;
        }
    }

    public static String a(Locale locale) {
        if (locale == null) {
            return null;
        }
        String language = locale.getLanguage();
        if (TextUtils.isEmpty(language)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(language.toLowerCase());
        if (!TextUtils.isEmpty(locale.getCountry())) {
            sb.append("-").append(locale.getCountry().toLowerCase());
        }
        return sb.toString();
    }

    public static String a(boolean z) {
        return z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO;
    }

    public static void a(Map<String, String> map, String str, String str2) {
        if (str2 == null || map.containsKey(str)) {
            return;
        }
        map.put(str, str2);
    }

    public static void a(Map<String, String> map, String str, Map<String, String> map2) {
        a(map, str, map2.get(str));
    }

    public static void a(Map<String, String> map, String str, boolean z) {
        if (map.containsKey(str)) {
            return;
        }
        map.put(str, z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    public static boolean a(double d, String str) {
        return d > 0.0d && d < 100.0d && ((double) (c(str) % 10000)) >= 100.0d * d;
    }

    public static boolean a(Context context, Class<? extends Service> cls) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 4);
            if (serviceInfo != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
        }
        return false;
    }

    public static boolean a(Context context, Class<? extends BroadcastReceiver> cls, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, cls), 2);
            if (receiverInfo != null && receiverInfo.enabled) {
                if (z) {
                    if (receiverInfo.exported) {
                    }
                }
                return true;
            }
        } catch (PackageManager.NameNotFoundException e) {
        }
        return false;
    }

    public static boolean a(String str, boolean z) {
        if (str == null) {
            return z;
        }
        if (str.equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) || str.equalsIgnoreCase("yes") || str.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
            return true;
        }
        if (str.equalsIgnoreCase("false") || str.equalsIgnoreCase("no") || str.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            return false;
        }
        return z;
    }

    public static MessageDigest b(String str) {
        MessageDigest messageDigest;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                return null;
            }
            try {
                messageDigest = MessageDigest.getInstance(str);
            } catch (NoSuchAlgorithmException e) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
            i = i2 + 1;
        }
    }

    public static void b(Map<String, String> map, String str, String str2) {
        if (str2 == null || !TextUtils.isEmpty(map.get(str))) {
            return;
        }
        map.put(str, str2);
    }

    public static int c(String str) {
        int i = 1;
        if (!TextUtils.isEmpty(str)) {
            i = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char charAt = str.charAt(length);
                i = ((i << 6) & 268435455) + charAt + (charAt << 14);
                int i2 = 266338304 & i;
                if (i2 != 0) {
                    i ^= i2 >> 21;
                }
            }
        }
        return i;
    }

    public static boolean d(String str) {
        return TextUtils.isEmpty(str) || !str.startsWith("http:");
    }
}
