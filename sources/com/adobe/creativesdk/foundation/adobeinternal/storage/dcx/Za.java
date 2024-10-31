package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import android.content.Context;
import android.os.Build;
import android.util.AtomicFile;
import android.util.Log;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;

/* compiled from: AdobeDCXUtils.java */
/* loaded from: classes.dex */
public class Za {

    /* renamed from: a, reason: collision with root package name */
    private static Ea f4294a;

    /* renamed from: b, reason: collision with root package name */
    private static Da f4295b;

    public static ob a(AdobeDCXLocalStorageScheme adobeDCXLocalStorageScheme) {
        if (adobeDCXLocalStorageScheme == AdobeDCXLocalStorageScheme.AdobeDCXLocalStorageSchemeDirectories) {
            if (f4294a == null) {
                f4294a = new Ea();
            }
            return f4294a;
        }
        if (f4295b == null) {
            f4295b = new Da();
        }
        return f4295b;
    }

    public static Boolean b(String str, String str2) throws IOException {
        if (str2 == null) {
            return false;
        }
        File file = new File(str);
        gb.a().a(file.getCanonicalPath());
        try {
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                    a("csdk_android_dcx", "dcxutils-fwrite", "mkdirs failed", "Directory '" + parentFile + "' could not be created");
                    throw new IOException("Directory '" + parentFile + "' could not be created");
                }
                try {
                    if (!file.createNewFile()) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Za.class.getSimpleName(), "File already exists at path " + str);
                    } else if (str.endsWith("/manifest")) {
                        a("csdk_android_dcx", "dcxutils-fwrite", "manifest created " + Arrays.toString(Thread.currentThread().getStackTrace()), str);
                    }
                } catch (IOException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Za.class.getSimpleName(), "Failed to create new file at path " + str, e2);
                    throw e2;
                }
            }
            if (Build.VERSION.SDK_INT < 17) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                bufferedWriter.write(str2);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStreamWriter.close();
                fileOutputStream.close();
            } else {
                AtomicFile atomicFile = new AtomicFile(file);
                FileOutputStream fileOutputStream2 = null;
                try {
                    fileOutputStream2 = atomicFile.startWrite();
                    fileOutputStream2.write(str2.getBytes());
                    atomicFile.finishWrite(fileOutputStream2);
                } catch (IOException e3) {
                    a("csdk_android_dcx", "dcxutils-fwrite", "atomic file fail" + e3.getMessage() + "Path is a directory: " + file.isDirectory() + Log.getStackTraceString(e3), str);
                    atomicFile.failWrite(fileOutputStream2);
                    throw e3;
                }
            }
            gb.a().b(file.getCanonicalPath());
            return true;
        } catch (Throwable th) {
            gb.a().b(file.getCanonicalPath());
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(String str) {
        return (str == null || !str.startsWith("/") || str.equals("/manifest") || str.startsWith("/manifest/") || str.equals("/mimetype") || str.startsWith("/mimetype/")) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(String str) {
        if (str.length() > 65535) {
            return false;
        }
        String[] split = str.split("/");
        if (split.length < 1) {
            return false;
        }
        Pattern compile = Pattern.compile("^[^\\x00-\\x1F\"\\\\:<>\\x7F]([^\\x00-\\x1F\"\\\\:<>\\x7F]*)");
        Pattern compile2 = Pattern.compile("[^\\x00-\\x1F\"*:<>?\\.\\x7F]{1}$");
        for (String str2 : split) {
            if (str2.length() > 255) {
                return false;
            }
            Matcher matcher = compile.matcher(str2);
            matcher.region(0, str2.length());
            Matcher matcher2 = compile2.matcher(str2);
            matcher2.region(0, str2.length());
            if (!matcher.find() || !matcher2.find()) {
                return false;
            }
        }
        return true;
    }

    public static String e(String str) {
        return org.apache.commons.io.c.c(org.apache.commons.io.c.k(str));
    }

    public static String c(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return str2;
        }
        if (str.endsWith("/")) {
            return str + str2;
        }
        return str + "/" + str2;
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new String(str.getBytes("UTF-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Object obj, JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            if (obj != null && obj.equals(jSONArray.opt(i))) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<String> a(Map<String, eb> map) {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<Map.Entry<String, eb>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getKey());
        }
        return arrayList;
    }

    public static String d(String str, String str2) {
        return c(str, str2) + "/";
    }

    public static long a(Object obj) {
        return ((Number) obj).longValue();
    }

    public static boolean a(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static void a(String str, String str2, String str3, String str4) {
        Context a2 = c.a.a.a.c.a.a.b().a();
        if (a2 == null || a2.getPackageName().equals("com.adobe.creativecloud")) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.analytics.o oVar = new com.adobe.creativesdk.foundation.internal.analytics.o();
        oVar.a("event.component", str);
        oVar.a("event.component.method", str2);
        oVar.a("event.error.desc", str3);
        oVar.a("event.error.extra_desc", str4);
        oVar.a();
    }

    public static String b(String str) throws IOException {
        String str2;
        if (str == null) {
            return null;
        }
        File file = new File(str);
        gb.a().a(file.getCanonicalPath());
        try {
            if (Build.VERSION.SDK_INT < 17) {
                str2 = new String(org.apache.commons.io.b.g(file), "UTF-8");
            } else {
                try {
                    str2 = new String(new AtomicFile(file).readFully(), "UTF-8");
                } catch (IOException e2) {
                    if (str != null && !str.contains("pull.manifest") && !str.contains("push.manifest") && !str.contains("manifest.base")) {
                        a("csdk_android_dcx", "dcxutils-fread", "atomic file readFully fail" + e2.getMessage() + Log.getStackTraceString(e2), str);
                    }
                    throw e2;
                }
            }
            return str2;
        } finally {
            gb.a().b(file.getCanonicalPath());
        }
    }
}
