package com.flurry.sdk;

import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.DigestOutputStream;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String f481a = f.class.getSimpleName();
    private byte[] b;

    public f(String str, String str2, String str3, boolean z, long j, long j2, List<u> list, Map<ej, ByteBuffer> map, Map<String, List<String>> map2, Map<String, List<String>> map3, long j3) throws IOException {
        DataOutputStream dataOutputStream;
        byte[] bArr;
        this.b = null;
        DataOutputStream dataOutputStream2 = null;
        try {
            an anVar = new an();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DigestOutputStream digestOutputStream = new DigestOutputStream(byteArrayOutputStream, anVar);
            dataOutputStream = new DataOutputStream(digestOutputStream);
            try {
                dataOutputStream.writeShort(27);
                dataOutputStream.writeShort(0);
                dataOutputStream.writeLong(0L);
                dataOutputStream.writeShort(0);
                dataOutputStream.writeShort(3);
                dataOutputStream.writeShort(com.flurry.a.a.a());
                dataOutputStream.writeLong(j3);
                dataOutputStream.writeUTF(str);
                dataOutputStream.writeUTF(str2);
                dataOutputStream.writeShort(map.size() + 1);
                dataOutputStream.writeShort(a.d());
                dataOutputStream.writeUTF(str3);
                if (!map.isEmpty()) {
                    for (Map.Entry<ej, ByteBuffer> entry : map.entrySet()) {
                        dataOutputStream.writeShort(entry.getKey().c);
                        byte[] array = entry.getValue().array();
                        dataOutputStream.writeShort(array.length);
                        dataOutputStream.write(array);
                    }
                }
                dataOutputStream.writeByte(0);
                dataOutputStream.writeBoolean(z);
                dataOutputStream.writeLong(j);
                dataOutputStream.writeLong(j2);
                dataOutputStream.writeShort(6);
                dataOutputStream.writeUTF("device.model");
                dataOutputStream.writeUTF(Build.MODEL);
                dataOutputStream.writeUTF("build.brand");
                dataOutputStream.writeUTF(Build.BRAND);
                dataOutputStream.writeUTF("build.id");
                dataOutputStream.writeUTF(Build.ID);
                dataOutputStream.writeUTF("version.release");
                dataOutputStream.writeUTF(Build.VERSION.RELEASE);
                dataOutputStream.writeUTF("build.device");
                dataOutputStream.writeUTF(Build.DEVICE);
                dataOutputStream.writeUTF("build.product");
                dataOutputStream.writeUTF(Build.PRODUCT);
                dataOutputStream.writeShort(map2 != null ? map2.keySet().size() : 0);
                if (map2 != null) {
                    as.a(3, f481a, "sending referrer values because it exists");
                    for (Map.Entry<String, List<String>> entry2 : map2.entrySet()) {
                        as.a(3, f481a, "Referrer Entry:  " + entry2.getKey() + "=" + entry2.getValue());
                        dataOutputStream.writeUTF(entry2.getKey());
                        as.a(3, f481a, "referrer key is :" + entry2.getKey());
                        dataOutputStream.writeShort(entry2.getValue().size());
                        for (String str4 : entry2.getValue()) {
                            dataOutputStream.writeUTF(str4);
                            as.a(3, f481a, "referrer value is :" + str4);
                        }
                    }
                }
                dataOutputStream.writeBoolean(false);
                int size = map3 != null ? map3.keySet().size() : 0;
                as.a(3, f481a, "optionsMapSize is:  " + size);
                dataOutputStream.writeShort(size);
                if (map3 != null) {
                    as.a(3, f481a, "sending launch options");
                    for (Map.Entry<String, List<String>> entry3 : map3.entrySet()) {
                        as.a(3, f481a, "Launch Options Key:  " + entry3.getKey());
                        dataOutputStream.writeUTF(entry3.getKey());
                        dataOutputStream.writeShort(entry3.getValue().size());
                        for (String str5 : entry3.getValue()) {
                            dataOutputStream.writeUTF(str5);
                            as.a(3, f481a, "Launch Options value is :" + str5);
                        }
                    }
                }
                int size2 = list.size();
                dataOutputStream.writeShort(size2);
                for (int i = 0; i < size2; i++) {
                    dataOutputStream.write(list.get(i).a());
                }
                digestOutputStream.on(false);
                dataOutputStream.write(anVar.a());
                dataOutputStream.close();
                bArr = byteArrayOutputStream.toByteArray();
                bb.a(dataOutputStream);
            } catch (Throwable th) {
                th = th;
                bb.a(dataOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        this.b = bArr;
    }

    public byte[] a() {
        return this.b;
    }
}
