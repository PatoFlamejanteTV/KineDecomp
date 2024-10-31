package com.nexstreaming.app.general.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: ZipUtil.java */
/* loaded from: classes2.dex */
public class P {
    public static void a(File file, File file2) throws IOException {
        if (!file2.mkdirs() && !file2.exists()) {
            throw new IOException("Failed to create directory: " + file2);
        }
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    return;
                }
                String name = nextEntry.getName();
                if (!name.contains("..")) {
                    File file3 = new File(file2, name);
                    if (nextEntry.isDirectory()) {
                        if (!file3.mkdirs() && !file3.exists()) {
                            throw new IOException("Failed to create directory: " + file3);
                        }
                    } else {
                        FileOutputStream fileOutputStream = new FileOutputStream(file3);
                        try {
                            H.a(zipInputStream, fileOutputStream);
                            C1702f.a(fileOutputStream);
                        } catch (Throwable th) {
                            C1702f.a(fileOutputStream);
                            throw th;
                        }
                    }
                } else {
                    throw new IOException("Relative paths not allowed");
                }
            } finally {
                C1702f.a(zipInputStream);
            }
        }
    }
}
