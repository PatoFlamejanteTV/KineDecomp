package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ab {

    /* renamed from: a, reason: collision with root package name */
    private static final String f448a = ab.class.getSimpleName();
    private boolean b;
    private List<u> c;
    private long d = -1;

    public void a(boolean z) {
        this.b = z;
    }

    public boolean a() {
        return this.b;
    }

    public void a(List<u> list) {
        this.c = list;
    }

    public List<u> b() {
        return this.c;
    }

    public void a(long j) {
        this.d = j;
    }

    public long c() {
        return this.d;
    }

    public void a(DataOutputStream dataOutputStream, String str, String str2) throws IOException {
        try {
            try {
                dataOutputStream.writeShort(46586);
                dataOutputStream.writeShort(2);
                dataOutputStream.writeUTF(str);
                dataOutputStream.writeUTF(str2);
                dataOutputStream.writeBoolean(this.b);
                dataOutputStream.writeLong(this.d);
                int size = this.c.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    byte[] a2 = this.c.get(size).a();
                    int length = a2.length;
                    if (length + 2 + dataOutputStream.size() > 50000) {
                        as.a(6, f448a, "discarded sessions: " + size);
                        break;
                    } else {
                        dataOutputStream.writeShort(length);
                        dataOutputStream.write(a2);
                        size--;
                    }
                }
                dataOutputStream.writeShort(0);
            } catch (Throwable th) {
                as.a(6, f448a, "", th);
                throw new IOException(th.getMessage());
            }
        } finally {
            bb.a(dataOutputStream);
        }
    }

    public boolean a(DataInputStream dataInputStream, String str) throws IOException {
        boolean z = false;
        try {
            try {
                int readUnsignedShort = dataInputStream.readUnsignedShort();
                as.a(4, f448a, "Magic: " + readUnsignedShort);
                if (readUnsignedShort == 46586) {
                    z = a(str, dataInputStream);
                } else {
                    as.a(3, f448a, "Unexpected file type");
                }
                return z;
            } catch (Throwable th) {
                as.a(6, f448a, "Error when loading persistent file", th);
                throw new IOException(th.getMessage());
            }
        } finally {
            bb.a(dataInputStream);
        }
    }

    private boolean a(String str, DataInputStream dataInputStream) throws IOException {
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        as.a(3, f448a, "File version: " + readUnsignedShort);
        if (readUnsignedShort > 2) {
            as.a(6, f448a, "Unknown agent file version: " + readUnsignedShort);
            throw new IOException("Unknown agent file version: " + readUnsignedShort);
        }
        if (readUnsignedShort >= 2) {
            String readUTF = dataInputStream.readUTF();
            as.a(3, f448a, "Loading API key: " + a(str));
            if (readUTF.equals(str)) {
                ArrayList arrayList = new ArrayList();
                dataInputStream.readUTF();
                boolean readBoolean = dataInputStream.readBoolean();
                long readLong = dataInputStream.readLong();
                as.a(3, f448a, "Loading session reports");
                int i = 0;
                while (true) {
                    int readUnsignedShort2 = dataInputStream.readUnsignedShort();
                    if (readUnsignedShort2 != 0) {
                        byte[] bArr = new byte[readUnsignedShort2];
                        dataInputStream.readFully(bArr);
                        arrayList.add(0, new u(bArr));
                        i++;
                        as.a(3, f448a, "Session report added: " + i);
                    } else {
                        as.a(3, f448a, "Persistent file loaded");
                        a(readBoolean);
                        a(readLong);
                        a(arrayList);
                        return true;
                    }
                }
            } else {
                as.a(3, f448a, "Api keys do not match, old: " + a(str) + ", new: " + a(readUTF));
                return false;
            }
        } else {
            as.a(5, f448a, "Deleting old file version: " + readUnsignedShort);
            return false;
        }
    }

    private static String a(String str) {
        if (str != null && str.length() > 4) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length() - 4; i++) {
                sb.append('*');
            }
            sb.append(str.substring(str.length() - 4));
            return sb.toString();
        }
        return str;
    }
}
