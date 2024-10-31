package com.flurry.sdk;

import com.flurry.sdk.a;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class u {
    private static final String b = u.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    byte[] f494a;

    public u(byte[] bArr) {
        this.f494a = bArr;
    }

    public u(v vVar) throws IOException {
        DataOutputStream dataOutputStream;
        int i;
        DataOutputStream dataOutputStream2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeShort(1);
                dataOutputStream.writeUTF(vVar.a());
                dataOutputStream.writeLong(vVar.b());
                dataOutputStream.writeLong(vVar.c());
                dataOutputStream.writeLong(vVar.d());
                dataOutputStream.writeUTF(vVar.e());
                dataOutputStream.writeUTF(vVar.f());
                dataOutputStream.writeByte(vVar.g());
                dataOutputStream.writeUTF(vVar.h());
                if (vVar.i() == null) {
                    dataOutputStream.writeBoolean(false);
                } else {
                    dataOutputStream.writeBoolean(true);
                    dataOutputStream.writeDouble(a(vVar.i().getLatitude()));
                    dataOutputStream.writeDouble(a(vVar.i().getLongitude()));
                    dataOutputStream.writeFloat(vVar.i().getAccuracy());
                }
                dataOutputStream.writeInt(vVar.j());
                dataOutputStream.writeByte(-1);
                dataOutputStream.writeByte(-1);
                dataOutputStream.writeByte(vVar.k());
                if (vVar.l() == null) {
                    dataOutputStream.writeBoolean(false);
                } else {
                    dataOutputStream.writeBoolean(true);
                    dataOutputStream.writeLong(vVar.l().longValue());
                }
                Map<String, a.C0026a> m = vVar.m();
                if (m == null) {
                    dataOutputStream.writeShort(0);
                } else {
                    dataOutputStream.writeShort(m.size());
                    for (Map.Entry<String, a.C0026a> entry : m.entrySet()) {
                        dataOutputStream.writeUTF(entry.getKey());
                        dataOutputStream.writeInt(entry.getValue().f446a);
                    }
                }
                List<e> n = vVar.n();
                if (n == null) {
                    dataOutputStream.writeShort(0);
                } else {
                    dataOutputStream.writeShort(n.size());
                    Iterator<e> it = n.iterator();
                    while (it.hasNext()) {
                        dataOutputStream.write(it.next().e());
                    }
                }
                dataOutputStream.writeBoolean(vVar.o());
                List<d> q = vVar.q();
                if (q != null) {
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        if (i2 >= q.size()) {
                            i = i4;
                            break;
                        }
                        i3 += q.get(i2).a();
                        if (i3 > 160000) {
                            as.a(5, b, "Error Log size exceeded. No more event details logged.");
                            i = i4;
                            break;
                        } else {
                            i4++;
                            i2++;
                        }
                    }
                } else {
                    i = 0;
                }
                dataOutputStream.writeInt(vVar.p());
                dataOutputStream.writeShort(i);
                for (int i5 = 0; i5 < i; i5++) {
                    dataOutputStream.write(q.get(i5).b());
                }
                dataOutputStream.writeShort(0);
                dataOutputStream.writeShort(0);
                this.f494a = byteArrayOutputStream.toByteArray();
                bb.a(dataOutputStream);
            } catch (IOException e) {
                e = e;
                dataOutputStream2 = dataOutputStream;
                try {
                    as.a(6, b, "", e);
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    bb.a(dataOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bb.a(dataOutputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
        }
    }

    public byte[] a() {
        return this.f494a;
    }

    double a(double d) {
        return Math.round(d * 1000.0d) / 1000.0d;
    }
}
