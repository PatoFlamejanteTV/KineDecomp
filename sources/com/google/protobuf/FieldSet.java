package com.google.protobuf;

import com.google.protobuf.FieldSet.FieldDescriptorLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyField;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class FieldSet<FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>> {

    /* renamed from: a */
    private static final FieldSet f18575a = new FieldSet(true);

    /* renamed from: c */
    private boolean f18577c;

    /* renamed from: d */
    private boolean f18578d = false;

    /* renamed from: b */
    private final U<FieldDescriptorType, Object> f18576b = U.b(16);

    /* loaded from: classes2.dex */
    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        boolean A();

        MessageLite.Builder a(MessageLite.Builder builder, MessageLite messageLite);

        int getNumber();

        boolean v();

        WireFormat.FieldType w();

        WireFormat.JavaType z();
    }

    private FieldSet() {
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> f() {
        return new FieldSet<>();
    }

    public Object a(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f18576b.get(fielddescriptortype);
        return obj instanceof LazyField ? ((LazyField) obj).c() : obj;
    }

    public boolean b() {
        return this.f18577c;
    }

    public void c(FieldDescriptorType fielddescriptortype, Object obj) {
        if (fielddescriptortype.v()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    b(fielddescriptortype.w(), it.next());
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            b(fielddescriptortype.w(), obj);
        }
        if (obj instanceof LazyField) {
            this.f18578d = true;
        }
        this.f18576b.a((U<FieldDescriptorType, Object>) fielddescriptortype, (FieldDescriptorType) obj);
    }

    public Iterator<Map.Entry<FieldDescriptorType, Object>> d() {
        if (this.f18578d) {
            return new LazyField.b(this.f18576b.entrySet().iterator());
        }
        return this.f18576b.entrySet().iterator();
    }

    public void e() {
        if (this.f18577c) {
            return;
        }
        this.f18576b.e();
        this.f18577c = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FieldSet) {
            return this.f18576b.equals(((FieldSet) obj).f18576b);
        }
        return false;
    }

    public int hashCode() {
        return this.f18576b.hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:            if ((r3 instanceof com.google.protobuf.Internal.EnumLite) == false) goto L61;     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:            if ((r3 instanceof byte[]) == false) goto L61;     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:            if ((r3 instanceof com.google.protobuf.LazyField) == false) goto L61;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(com.google.protobuf.WireFormat.FieldType r2, java.lang.Object r3) {
        /*
            if (r3 == 0) goto L4c
            int[] r0 = com.google.protobuf.C1671z.f18801a
            com.google.protobuf.WireFormat$JavaType r2 = r2.getJavaType()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L3f;
                case 2: goto L3c;
                case 3: goto L39;
                case 4: goto L36;
                case 5: goto L33;
                case 6: goto L30;
                case 7: goto L27;
                case 8: goto L1e;
                case 9: goto L14;
                default: goto L13;
            }
        L13:
            goto L41
        L14:
            boolean r2 = r3 instanceof com.google.protobuf.MessageLite
            if (r2 != 0) goto L1c
            boolean r2 = r3 instanceof com.google.protobuf.LazyField
            if (r2 == 0) goto L41
        L1c:
            r1 = 1
            goto L41
        L1e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L1c
            boolean r2 = r3 instanceof com.google.protobuf.Internal.EnumLite
            if (r2 == 0) goto L41
            goto L1c
        L27:
            boolean r2 = r3 instanceof com.google.protobuf.ByteString
            if (r2 != 0) goto L1c
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L41
            goto L1c
        L30:
            boolean r1 = r3 instanceof java.lang.String
            goto L41
        L33:
            boolean r1 = r3 instanceof java.lang.Boolean
            goto L41
        L36:
            boolean r1 = r3 instanceof java.lang.Double
            goto L41
        L39:
            boolean r1 = r3 instanceof java.lang.Float
            goto L41
        L3c:
            boolean r1 = r3 instanceof java.lang.Long
            goto L41
        L3f:
            boolean r1 = r3 instanceof java.lang.Integer
        L41:
            if (r1 == 0) goto L44
            return
        L44:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        L4c:
            java.lang.NullPointerException r2 = new java.lang.NullPointerException
            r2.<init>()
            goto L53
        L52:
            throw r2
        L53:
            goto L52
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.FieldSet.b(com.google.protobuf.WireFormat$FieldType, java.lang.Object):void");
    }

    /* renamed from: clone */
    public FieldSet<FieldDescriptorType> m18clone() {
        FieldSet<FieldDescriptorType> f2 = f();
        for (int i = 0; i < this.f18576b.a(); i++) {
            Map.Entry<FieldDescriptorType, Object> a2 = this.f18576b.a(i);
            f2.c(a2.getKey(), a2.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f18576b.c()) {
            f2.c(entry.getKey(), entry.getValue());
        }
        f2.f18578d = this.f18578d;
        return f2;
    }

    private FieldSet(boolean z) {
        e();
    }

    public void a(FieldDescriptorType fielddescriptortype, Object obj) {
        List list;
        if (fielddescriptortype.v()) {
            b(fielddescriptortype.w(), obj);
            Object a2 = a((FieldSet<FieldDescriptorType>) fielddescriptortype);
            if (a2 == null) {
                list = new ArrayList();
                this.f18576b.a((U<FieldDescriptorType, Object>) fielddescriptortype, (FieldDescriptorType) list);
            } else {
                list = (List) a2;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    private boolean a(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.z() == WireFormat.JavaType.MESSAGE) {
            if (key.v()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((MessageLite) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof MessageLite) {
                    if (!((MessageLite) value).isInitialized()) {
                        return false;
                    }
                } else {
                    if (value instanceof LazyField) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public boolean c() {
        for (int i = 0; i < this.f18576b.a(); i++) {
            if (!a((Map.Entry) this.f18576b.a(i))) {
                return false;
            }
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.f18576b.c().iterator();
        while (it.hasNext()) {
            if (!a((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private void b(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            value = ((LazyField) value).c();
        }
        if (key.v()) {
            Object a2 = a((FieldSet<FieldDescriptorType>) key);
            if (a2 == null) {
                a2 = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) a2).add(a(it.next()));
            }
            this.f18576b.a((U<FieldDescriptorType, Object>) key, (FieldDescriptorType) a2);
            return;
        }
        if (key.z() == WireFormat.JavaType.MESSAGE) {
            Object a3 = a((FieldSet<FieldDescriptorType>) key);
            if (a3 == null) {
                this.f18576b.a((U<FieldDescriptorType, Object>) key, (FieldDescriptorType) a(value));
                return;
            } else {
                this.f18576b.a((U<FieldDescriptorType, Object>) key, (FieldDescriptorType) key.a(((MessageLite) a3).b(), (MessageLite) value).build());
                return;
            }
        }
        this.f18576b.a((U<FieldDescriptorType, Object>) key, (FieldDescriptorType) a(value));
    }

    public static int a(WireFormat.FieldType fieldType, boolean z) {
        if (z) {
            return 2;
        }
        return fieldType.getWireType();
    }

    public void a(FieldSet<FieldDescriptorType> fieldSet) {
        for (int i = 0; i < fieldSet.f18576b.a(); i++) {
            b(fieldSet.f18576b.a(i));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = fieldSet.f18576b.c().iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    private Object a(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static Object a(CodedInputStream codedInputStream, WireFormat.FieldType fieldType, boolean z) throws IOException {
        if (z) {
            return WireFormat.a(codedInputStream, fieldType, WireFormat.Utf8Validation.STRICT);
        }
        return WireFormat.a(codedInputStream, fieldType, WireFormat.Utf8Validation.LOOSE);
    }

    public static void a(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i, Object obj) throws IOException {
        if (fieldType == WireFormat.FieldType.GROUP) {
            codedOutputStream.b(i, (MessageLite) obj);
        } else {
            codedOutputStream.h(i, a(fieldType, false));
            a(codedOutputStream, fieldType, obj);
        }
    }

    public static int b(FieldDescriptorLite<?> fieldDescriptorLite, Object obj) {
        WireFormat.FieldType w = fieldDescriptorLite.w();
        int number = fieldDescriptorLite.getNumber();
        if (fieldDescriptorLite.v()) {
            int i = 0;
            if (fieldDescriptorLite.A()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i += a(w, it.next());
                }
                return CodedOutputStream.i(number) + i + CodedOutputStream.f(i);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                i += a(w, number, it2.next());
            }
            return i;
        }
        return a(w, number, obj);
    }

    static void a(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (C1671z.f18802b[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.b(((Double) obj).doubleValue());
                return;
            case 2:
                codedOutputStream.b(((Float) obj).floatValue());
                return;
            case 3:
                codedOutputStream.h(((Long) obj).longValue());
                return;
            case 4:
                codedOutputStream.k(((Long) obj).longValue());
                return;
            case 5:
                codedOutputStream.n(((Integer) obj).intValue());
                return;
            case 6:
                codedOutputStream.g(((Long) obj).longValue());
                return;
            case 7:
                codedOutputStream.m(((Integer) obj).intValue());
                return;
            case 8:
                codedOutputStream.b(((Boolean) obj).booleanValue());
                return;
            case 9:
                codedOutputStream.c((MessageLite) obj);
                return;
            case 10:
                codedOutputStream.d((MessageLite) obj);
                return;
            case 11:
                if (obj instanceof ByteString) {
                    codedOutputStream.b((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.b((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof ByteString) {
                    codedOutputStream.b((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.c((byte[]) obj);
                    return;
                }
            case 13:
                codedOutputStream.r(((Integer) obj).intValue());
                return;
            case 14:
                codedOutputStream.p(((Integer) obj).intValue());
                return;
            case 15:
                codedOutputStream.i(((Long) obj).longValue());
                return;
            case 16:
                codedOutputStream.q(((Integer) obj).intValue());
                return;
            case 17:
                codedOutputStream.j(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof Internal.EnumLite) {
                    codedOutputStream.l(((Internal.EnumLite) obj).getNumber());
                    return;
                } else {
                    codedOutputStream.l(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static void a(FieldDescriptorLite<?> fieldDescriptorLite, Object obj, CodedOutputStream codedOutputStream) throws IOException {
        WireFormat.FieldType w = fieldDescriptorLite.w();
        int number = fieldDescriptorLite.getNumber();
        if (fieldDescriptorLite.v()) {
            List list = (List) obj;
            if (fieldDescriptorLite.A()) {
                codedOutputStream.h(number, 2);
                int i = 0;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    i += a(w, it.next());
                }
                codedOutputStream.o(i);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    a(codedOutputStream, w, it2.next());
                }
                return;
            }
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                a(codedOutputStream, w, number, it3.next());
            }
            return;
        }
        if (obj instanceof LazyField) {
            a(codedOutputStream, w, number, ((LazyField) obj).c());
        } else {
            a(codedOutputStream, w, number, obj);
        }
    }

    public int a() {
        int i = 0;
        for (int i2 = 0; i2 < this.f18576b.a(); i2++) {
            Map.Entry<FieldDescriptorType, Object> a2 = this.f18576b.a(i2);
            i += b((FieldDescriptorLite<?>) a2.getKey(), a2.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f18576b.c()) {
            i += b((FieldDescriptorLite<?>) entry.getKey(), entry.getValue());
        }
        return i;
    }

    public static int a(WireFormat.FieldType fieldType, int i, Object obj) {
        int i2 = CodedOutputStream.i(i);
        if (fieldType == WireFormat.FieldType.GROUP) {
            i2 *= 2;
        }
        return i2 + a(fieldType, obj);
    }

    static int a(WireFormat.FieldType fieldType, Object obj) {
        switch (C1671z.f18802b[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.a(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.a(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.b(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.e(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.c(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.a(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.b(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.a(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.a((MessageLite) obj);
            case 10:
                if (obj instanceof LazyField) {
                    return CodedOutputStream.a((LazyField) obj);
                }
                return CodedOutputStream.b((MessageLite) obj);
            case 11:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.a((ByteString) obj);
                }
                return CodedOutputStream.a((String) obj);
            case 12:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.a((ByteString) obj);
                }
                return CodedOutputStream.a((byte[]) obj);
            case 13:
                return CodedOutputStream.j(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.g(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.c(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.h(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.d(((Long) obj).longValue());
            case 18:
                if (obj instanceof Internal.EnumLite) {
                    return CodedOutputStream.a(((Internal.EnumLite) obj).getNumber());
                }
                return CodedOutputStream.a(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }
}
