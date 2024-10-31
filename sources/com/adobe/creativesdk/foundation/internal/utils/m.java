package com.adobe.creativesdk.foundation.internal.utils;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

/* compiled from: AdobeNetworkFileUtils.java */
/* loaded from: classes.dex */
public class m {
    public static boolean a(String str) {
        File file = new File(str);
        if (!file.exists()) {
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            try {
                file.createNewFile();
            } catch (IOException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, m.class.getSimpleName(), "Failure while creating file", e2);
                return false;
            }
        }
        if (file.setLastModified(new Date().getTime())) {
            return true;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            long length = randomAccessFile.length();
            randomAccessFile.setLength(1 + length);
            randomAccessFile.setLength(length);
            randomAccessFile.close();
            return true;
        } catch (IOException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, m.class.getSimpleName(), "Failure while closing the stream ", e3);
            return false;
        }
    }
}
