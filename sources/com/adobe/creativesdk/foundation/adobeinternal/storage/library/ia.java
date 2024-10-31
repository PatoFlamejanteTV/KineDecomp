package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import android.graphics.BitmapFactory;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.storage.AdobeLibraryErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeLibraryException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: AdobeLibraryUtils.java */
/* loaded from: classes.dex */
public class ia {

    /* renamed from: a */
    static Set<String> f4636a;

    public static AdobeLibraryException a(AdobeLibraryErrorCode adobeLibraryErrorCode, Exception exc, String str, String str2) {
        HashMap hashMap = new HashMap();
        if (str != null) {
            hashMap.put(AdobeCSDKException.AdobeErrorPathKey, str);
        }
        return new AdobeLibraryException(adobeLibraryErrorCode, str2, hashMap, exc);
    }

    public static BitmapFactory.Options b(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options;
    }

    public static String c(String str) {
        Matcher matcher = Pattern.compile("application/vnd.adobe.element.(.+)\\\\+dcx").matcher(str);
        matcher.region(0, str.length());
        return (matcher.find() && matcher.groupCount() == 2) ? matcher.group(1) : str;
    }

    public static boolean d(String str) {
        return Pattern.compile("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}").matcher(str).matches();
    }

    public static boolean a(String str) {
        synchronized (ia.class) {
            if (f4636a == null) {
                f4636a = new HashSet();
                f4636a.add("application/x-indesign");
                f4636a.add("application/postscript");
                f4636a.add("application/illustrator");
                f4636a.add("application/pdf");
                f4636a.add("application/vnd.adobe.psremix");
                f4636a.add("application/vnd.adobe.pstouch");
                f4636a.add("application/vnd.adobe.ideas");
                f4636a.add("application/vnd.adobe.ase");
                f4636a.add("image/jpeg");
                f4636a.add("image/jpg");
                f4636a.add("image/pjpeg");
                f4636a.add("image/tiff");
                f4636a.add("image/gif");
                f4636a.add("image/bmp");
                f4636a.add("image/x-ms-bmp");
                f4636a.add("image/svg+xml");
                f4636a.add("image/png");
                f4636a.add("image/x-png");
                f4636a.add("image/jp2");
                f4636a.add("image/psd");
                f4636a.add("image/vnd.adobe.photoshop");
                f4636a.add("application/photoshop");
                f4636a.add("application/x-photoshop");
                f4636a.add("image/raw");
                f4636a.add("image/dng");
                f4636a.add("image/x-adobe-dng");
                f4636a.add("video/mp4");
                f4636a.add("video/mpeg");
                f4636a.add("video/x-ms-wmv");
                f4636a.add("video/3gpp");
                f4636a.add("video/3gpp2");
                f4636a.add("video/quicktime");
                f4636a.add("video/x-msvideo");
                f4636a.add("video/x-flv");
                f4636a.add("video/x-ms-asf");
                f4636a.add("video/x-m4v");
                f4636a.add("video/mp2t");
                f4636a.add("application/mxf");
                f4636a.add("application/x-shockwave-flash");
                f4636a.add("application/vnd.adobe.brushes.brush+ucf");
                f4636a.add("application/vnd.adobe.collage");
                f4636a.add("application/vnd.adobe.proto");
                f4636a.add("application/msword");
                f4636a.add("application/msexcel");
                f4636a.add("application/mspowerpoint");
                f4636a.add("application/vnd.ms-publisher");
                f4636a.add("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                f4636a.add("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                f4636a.add("application/vnd.openxmlformats-officedocument.presentationml.presentation");
                f4636a.add("text/plain");
                f4636a.add("text/rtf");
            }
        }
        return f4636a.contains(str);
    }

    public static boolean b() {
        Iterator it = Arrays.asList(Thread.currentThread().getStackTrace()).iterator();
        while (it.hasNext()) {
            if (((StackTraceElement) it.next()).getClassName().startsWith("org.junit.")) {
                return true;
            }
        }
        return false;
    }

    public static long a() {
        return new Date().getTime();
    }

    public static boolean a(String str, String str2) {
        return str2.equals(str) || (str.equals("image/svg+xml") && str2.equals("image/vnd.adobe.shape+svg"));
    }

    public static String a(String str, int i) {
        if (str == null) {
            return null;
        }
        if (str.equalsIgnoreCase("stock.adobe.io") || str.equalsIgnoreCase("stock.adobe.com") || str.equalsIgnoreCase("stock-stage.adobe.io") || str.equalsIgnoreCase("staging-astock1.fotolia.net")) {
            return Integer.toString(i);
        }
        return null;
    }
}
