package com.adobe.creativesdk.foundation.adobeinternal.imageservice;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AdobeImageServiceBodyStreamFactory.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    private static String f3999a = "ImageStreamFactory";

    /* renamed from: b */
    String f4000b;

    d(String str, String str2, HashMap<String, com.adobe.creativesdk.foundation.internal.storage.model.resources.f> hashMap, String str3, String str4) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f3999a, "body stream file : " + str4);
        this.f4000b = str4;
        a(str, str2, hashMap, str3);
    }

    public static d a(String str, String str2, HashMap<String, com.adobe.creativesdk.foundation.internal.storage.model.resources.f> hashMap, String str3, String str4) {
        return new d(str, str2, hashMap, str3, str4);
    }

    private void a(String str, String str2, HashMap<String, com.adobe.creativesdk.foundation.internal.storage.model.resources.f> hashMap, String str3) {
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(this.f4000b)));
            StringBuilder sb = new StringBuilder("");
            byte[] bArr = new byte[32768];
            int i = 2;
            String format = String.format("--%s%s", str3, "\r\n");
            sb.append(format);
            sb.append(String.format("Content-ID: <%s>%s", str2, "\r\n"));
            sb.append(String.format("Content-Type: application/vnd.adobe.image-operation+json%s", "\r\n"));
            sb.append("\r\n");
            sb.append(str);
            sb.append("\r\n");
            StringBuilder sb2 = sb;
            for (Map.Entry<String, com.adobe.creativesdk.foundation.internal.storage.model.resources.f> entry : hashMap.entrySet()) {
                com.adobe.creativesdk.foundation.internal.storage.model.resources.f value = entry.getValue();
                sb2.append(format);
                Object[] objArr = new Object[i];
                objArr[0] = entry.getKey();
                objArr[1] = "\r\n";
                sb2.append(String.format("Content-ID: <%s>%s", objArr));
                Object[] objArr2 = new Object[i];
                objArr2[0] = value.f6612d;
                objArr2[1] = "\r\n";
                sb2.append(String.format("Content-Type: %s%s", objArr2));
                sb2.append("\r\n");
                bufferedOutputStream.write(sb2.toString().getBytes("UTF-8"));
                BufferedInputStream bufferedInputStream = null;
                try {
                    try {
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(new File(value.i())));
                        try {
                            for (int read = bufferedInputStream2.read(bArr); read > 0; read = bufferedInputStream2.read(bArr)) {
                                bufferedOutputStream.write(bArr);
                            }
                            bufferedInputStream2.close();
                        } catch (Exception e2) {
                            e = e2;
                            bufferedInputStream = bufferedInputStream2;
                            e.printStackTrace();
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f3999a, "bodyData : " + ((Object) sb2));
                            sb2 = new StringBuilder("");
                            sb2.append("\r\n");
                            i = 2;
                        } catch (Throwable th) {
                            th = th;
                            bufferedInputStream = bufferedInputStream2;
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f3999a, "bodyData : " + ((Object) sb2));
                sb2 = new StringBuilder("");
                sb2.append("\r\n");
                i = 2;
            }
            sb2.append(String.format("--%s--%s", str3, "\r\n"));
            bufferedOutputStream.write(sb2.toString().getBytes("UTF-8"));
            bufferedOutputStream.close();
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f3999a, "bodyData : " + ((Object) sb2));
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }
}
