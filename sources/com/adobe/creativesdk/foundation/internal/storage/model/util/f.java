package com.adobe.creativesdk.foundation.internal.storage.model.util;

import android.util.Log;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za;
import com.adobe.creativesdk.foundation.internal.utils.m;
import java.io.File;
import java.util.Iterator;

/* compiled from: AdobeStorageFileUtils.java */
/* loaded from: classes.dex */
public class f {
    public static boolean a(String str, String str2) {
        File file = new File(str2);
        File file2 = new File(str);
        if (file.exists()) {
            try {
                Za.b(str2, Za.b(str));
                return true;
            } catch (Exception e2) {
                Za.a("csdk_android_dcx", "storagefileutils-copyfile", "copy file atomically fail" + e2.getMessage() + Log.getStackTraceString(e2), "srcFile: " + str + " destFile: " + str2);
                return false;
            }
        }
        try {
            File file3 = new File(org.apache.commons.io.c.d(str2));
            if (!file3.exists()) {
                file3.mkdirs();
            }
            org.apache.commons.io.b.b(file2, file);
            return true;
        } catch (Exception e3) {
            Za.a("csdk_android_dcx", "storagefileutils-copyfile2", "copy file atomically fail" + e3.getMessage() + Log.getStackTraceString(e3), "srcFile: " + str + " destFile: " + str2);
            return false;
        }
    }

    public static boolean b(String str, String str2) {
        File file = new File(str2);
        File file2 = new File(str);
        if (file.exists()) {
            try {
                Za.b(str2, Za.b(str));
                org.apache.commons.io.b.c(file2);
                return true;
            } catch (Exception e2) {
                Za.a("csdk_android_dcx", "storagefileutils-movefile", "move file atomically fail" + e2.getMessage() + Log.getStackTraceString(e2), "srcFile: " + str + " destFile: " + str2);
                return false;
            }
        }
        try {
            File file3 = new File(org.apache.commons.io.c.d(str2));
            if (!file3.exists()) {
                file3.mkdirs();
            }
            org.apache.commons.io.b.d(file2, file);
            return true;
        } catch (Exception e3) {
            Za.a("csdk_android_dcx", "storagefileutils-movefile2", "move file atomically fail" + e3.getMessage() + Log.getStackTraceString(e3), "srcFile: " + str + " destFile: " + str2);
            return false;
        }
    }

    public static boolean c(String str) {
        return new File(str).setReadOnly();
    }

    public static boolean d(String str) {
        return m.a(str);
    }

    public static boolean a(String str) {
        return new File(str).setWritable(true);
    }

    public static boolean b(String str) throws AdobeDCXException {
        Iterator<File> a2 = org.apache.commons.io.b.a(new File(str), (String[]) null, true);
        boolean z = false;
        while (a2.hasNext() && !z) {
            z = !a2.next().setWritable(true);
        }
        return true ^ z;
    }
}
