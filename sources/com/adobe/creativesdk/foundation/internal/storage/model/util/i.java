package com.adobe.creativesdk.foundation.internal.storage.model.util;

import android.net.Uri;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import com.adobe.creativesdk.foundation.internal.net.k;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFileRenditionType;
import com.adobe.creativesdk.foundation.storage.AdobeAssetMimeTypes;
import com.adobe.creativesdk.foundation.storage.C0533a;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import com.adobe.creativesdk.foundation.storage.V;
import com.facebook.appevents.AppEventsConstants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeStorageUtils.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a */
    private static k f6626a;

    /* renamed from: b */
    private static SimpleDateFormat[] f6627b;

    public static synchronized String a(InputStream inputStream, boolean z) {
        int i;
        synchronized (i.class) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    byte[] digest = messageDigest.digest();
                    if (z) {
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : digest) {
                            String hexString = Integer.toHexString(b2 & 255);
                            while (hexString.length() < 2) {
                                hexString = AppEventsConstants.EVENT_PARAM_VALUE_NO + hexString;
                            }
                            sb.append(hexString);
                        }
                        return sb.toString();
                    }
                    try {
                        return new String(Base64.encode(digest, 0), "UTF-8").replaceFirst("\\s+$", "");
                    } catch (UnsupportedEncodingException unused) {
                        return null;
                    }
                } catch (IOException unused2) {
                    return null;
                }
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public static Date b(String str) {
        int i;
        synchronized (i.class) {
            i = 0;
            if (f6627b == null) {
                f6627b = new SimpleDateFormat[6];
                f6627b[0] = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                f6627b[1] = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                f6627b[2] = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
                f6627b[3] = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z");
                f6627b[4] = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
                f6627b[5] = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
            }
        }
        Date date = null;
        if (str != null) {
            while (true) {
                SimpleDateFormat[] simpleDateFormatArr = f6627b;
                if (i >= simpleDateFormatArr.length || date != null) {
                    break;
                }
                date = a(simpleDateFormatArr[i], str);
                i++;
            }
        }
        return date;
    }

    public static String c(String str) {
        try {
            String a2 = a();
            return URLEncoder.encode(str.replace(" ", a2), "UTF-8").replace("%2F", "/").replace(a2, "%20");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String d(String str) {
        return MimeTypeMap.getFileExtensionFromUrl(str);
    }

    public static String e(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        if (mimeTypeFromExtension != null) {
            return mimeTypeFromExtension;
        }
        String b2 = V.b(fileExtensionFromUrl);
        return b2 != null ? b2 : URLConnection.getFileNameMap().getContentTypeFor(str);
    }

    public static AdobeAssetMimeTypes f(String str) {
        if (str != null) {
            for (AdobeAssetMimeTypes adobeAssetMimeTypes : AdobeAssetMimeTypes.values()) {
                if (str.equalsIgnoreCase(adobeAssetMimeTypes.getMimeType())) {
                    return adobeAssetMimeTypes;
                }
            }
        }
        return null;
    }

    public static synchronized void a(InputStream inputStream, boolean z, j jVar) {
        synchronized (i.class) {
            if (f6626a == null) {
                f6626a = new k(4, 4, 100L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            }
            f6626a.execute(new h(inputStream, z, jVar));
        }
    }

    public static synchronized void a(String str, boolean z, j jVar) {
        synchronized (i.class) {
            try {
                a(new FileInputStream(str), z, jVar);
            } catch (FileNotFoundException unused) {
                jVar.a(null);
            }
        }
    }

    public static JSONObject a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String a() {
        return UUID.randomUUID().toString().toUpperCase();
    }

    public static String a(String str, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes(org.apache.commons.io.a.f29306f));
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            if (z) {
                for (byte b2 : digest) {
                    String hexString = Integer.toHexString(b2 & 255);
                    while (hexString.length() < 2) {
                        hexString = AppEventsConstants.EVENT_PARAM_VALUE_NO + hexString;
                    }
                    sb.append(hexString);
                }
                return sb.toString();
            }
            try {
                return new String(Base64.encode(digest, 0), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return null;
            }
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private static Date a(SimpleDateFormat simpleDateFormat, String str) {
        if (simpleDateFormat == null) {
            return null;
        }
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException unused) {
            return null;
        }
    }

    public static boolean a(EnumSet<AdobeAssetMimeTypes> enumSet, String str) {
        AdobeAssetMimeTypes f2 = f(str);
        if (f2 != null) {
            return enumSet.contains(f2);
        }
        return false;
    }

    public static boolean a(EnumSet<AdobeAssetMimeTypes> enumSet, String str, boolean z) {
        if (enumSet == null || enumSet.size() == 0) {
            return false;
        }
        boolean a2 = a(enumSet, str);
        return z ? !a2 : a2;
    }

    public static String a(C0533a c0533a, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma, int i) {
        return String.format("%s-%d_%d-%d-%d", c0533a.getGUID(), Integer.valueOf(adobeAssetFileRenditionType.getIntVal()), Integer.valueOf((int) c0582ma.f7348a), Integer.valueOf((int) c0582ma.f7349b), Integer.valueOf(i));
    }

    public static String a(String str, com.adobe.creativesdk.foundation.internal.storage.model.resources.a aVar) {
        int i;
        if (str == null) {
            return null;
        }
        if (!str.contains("{") || !str.contains("}")) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf("{");
        int lastIndexOf2 = str.lastIndexOf("}");
        if (lastIndexOf < 0 || (i = lastIndexOf + 2) > lastIndexOf2) {
            return null;
        }
        String substring = str.substring(i, lastIndexOf2);
        String substring2 = str.substring(0, lastIndexOf);
        for (String str2 : substring.split(",")) {
            substring2 = substring2 + aVar.a(str2);
        }
        return Uri.encode(substring2, "%/:;=");
    }
}
