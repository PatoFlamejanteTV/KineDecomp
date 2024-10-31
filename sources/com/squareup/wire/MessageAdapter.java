package com.squareup.wire;

import com.squareup.wire.ExtendableMessage;
import com.squareup.wire.Message;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import okio.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class MessageAdapter<M extends Message> {

    /* renamed from: a, reason: collision with root package name */
    private final s f25689a;

    /* renamed from: b, reason: collision with root package name */
    private final Class<M> f25690b;

    /* renamed from: c, reason: collision with root package name */
    private final Class<Message.a<M>> f25691c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, Integer> f25692d = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    private final p<a> f25693e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ImmutableList<T> extends AbstractList<T> implements Cloneable, RandomAccess, Serializable {
        private final List<T> list = new ArrayList();

        ImmutableList() {
        }

        public Object clone() {
            return this;
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i) {
            return this.list.get(i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.list.size();
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final int f25694a;

        /* renamed from: b, reason: collision with root package name */
        final String f25695b;

        /* renamed from: c, reason: collision with root package name */
        final Message.Datatype f25696c;

        /* renamed from: d, reason: collision with root package name */
        final Message.Label f25697d;

        /* renamed from: e, reason: collision with root package name */
        final Class<? extends m> f25698e;

        /* renamed from: f, reason: collision with root package name */
        final Class<? extends Message> f25699f;

        /* renamed from: g, reason: collision with root package name */
        final boolean f25700g;

        /* renamed from: h, reason: collision with root package name */
        MessageAdapter<? extends Message> f25701h;
        d<? extends m> i;
        private final Field j;
        private final Field k;

        /* synthetic */ a(int i, String str, Message.Datatype datatype, Message.Label label, boolean z, Class cls, Field field, Field field2, k kVar) {
            this(i, str, datatype, label, z, cls, field, field2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private a(int i, String str, Message.Datatype datatype, Message.Label label, boolean z, Class<?> cls, Field field, Field field2) {
            this.f25694a = i;
            this.f25695b = str;
            this.f25696c = datatype;
            this.f25697d = label;
            this.f25700g = z;
            if (datatype == Message.Datatype.ENUM) {
                this.f25698e = cls;
                this.f25699f = null;
            } else if (datatype == Message.Datatype.MESSAGE) {
                this.f25699f = cls;
                this.f25698e = null;
            } else {
                this.f25698e = null;
                this.f25699f = null;
            }
            this.j = field;
            this.k = field2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private Map<Integer, ImmutableList<Object>> f25702a;

        private b() {
        }

        void a(int i, Object obj) {
            Map<Integer, ImmutableList<Object>> map = this.f25702a;
            ImmutableList<Object> immutableList = map == null ? null : map.get(Integer.valueOf(i));
            if (immutableList == null) {
                immutableList = new ImmutableList<>();
                if (this.f25702a == null) {
                    this.f25702a = new LinkedHashMap();
                }
                this.f25702a.put(Integer.valueOf(i), immutableList);
            }
            ((ImmutableList) immutableList).list.add(obj);
        }

        /* synthetic */ b(k kVar) {
            this();
        }

        Set<Integer> a() {
            Map<Integer, ImmutableList<Object>> map = this.f25702a;
            return map == null ? Collections.emptySet() : map.keySet();
        }

        List<Object> a(int i) {
            Map<Integer, ImmutableList<Object>> map = this.f25702a;
            if (map == null) {
                return null;
            }
            return map.get(Integer.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageAdapter(s sVar, Class<M> cls) {
        Field[] fieldArr;
        this.f25689a = sVar;
        this.f25690b = cls;
        this.f25691c = a(cls);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Field[] declaredFields = cls.getDeclaredFields();
        int length = declaredFields.length;
        int i = 0;
        while (i < length) {
            Field field = declaredFields[i];
            n nVar = (n) field.getAnnotation(n.class);
            if (nVar != null) {
                int tag = nVar.tag();
                String name = field.getName();
                this.f25692d.put(name, Integer.valueOf(tag));
                Class cls2 = null;
                Message.Datatype type = nVar.type();
                if (type == Message.Datatype.ENUM) {
                    cls2 = a(field);
                } else if (type == Message.Datatype.MESSAGE) {
                    cls2 = b(field);
                }
                fieldArr = declaredFields;
                linkedHashMap.put(Integer.valueOf(tag), new a(tag, name, type, nVar.label(), nVar.redacted(), cls2, field, a(name), null));
            } else {
                fieldArr = declaredFields;
            }
            i++;
            declaredFields = fieldArr;
        }
        this.f25693e = p.a(linkedHashMap);
    }

    private Class<? extends Message> b(Field field) {
        Class type = field.getType();
        if (Message.class.isAssignableFrom(type)) {
            return type;
        }
        if (List.class.isAssignableFrom(type)) {
            return ((n) field.getAnnotation(n.class)).messageType();
        }
        return null;
    }

    private <M extends Message> int d(M m) {
        int serializedSize = m.getSerializedSize();
        return v.b(serializedSize) + serializedSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Class<Message> e(int i) {
        e<ExtendableMessage<?>, ?> c2;
        a b2 = this.f25693e.b(i);
        Class<Message> cls = b2 == null ? 0 : b2.f25699f;
        return (cls != 0 || (c2 = c(i)) == null) ? cls : c2.g();
    }

    Collection<a> a() {
        return this.f25693e.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c(M m) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f25690b.getSimpleName());
        sb.append("{");
        String str = "";
        for (a aVar : a()) {
            Object a2 = a((MessageAdapter<M>) m, aVar);
            if (a2 != null) {
                sb.append(str);
                sb.append(aVar.f25695b);
                sb.append("=");
                if (aVar.f25700g) {
                    a2 = "██";
                }
                sb.append(a2);
                str = ", ";
            }
        }
        if (m instanceof ExtendableMessage) {
            sb.append(str);
            sb.append("{extensions=");
            sb.append(((ExtendableMessage) m).extensionsToString());
            sb.append("}");
        }
        sb.append("}");
        return sb.toString();
    }

    Object a(M m, a aVar) {
        if (aVar.j != null) {
            try {
                return aVar.j.get(m);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
        throw new AssertionError("Field is not of type \"Message\"");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private MessageAdapter<? extends Message> d(int i) {
        MessageAdapter<? extends Message> messageAdapter;
        a b2 = this.f25693e.b(i);
        if (b2 != null && (messageAdapter = b2.f25701h) != null) {
            return messageAdapter;
        }
        MessageAdapter<? extends Message> c2 = this.f25689a.c(e(i));
        if (b2 != null) {
            b2.f25701h = c2;
        }
        return c2;
    }

    private int b(List<?> list, int i, Message.Datatype datatype) {
        Iterator<?> it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 += a(i, it.next(), datatype);
        }
        return i2;
    }

    public void a(Message.a<M> aVar, int i, Object obj) {
        try {
            this.f25693e.b(i).k.set(aVar, obj);
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        }
    }

    private void b(v vVar, List<?> list, int i, Message.Datatype datatype) throws IOException {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            a(vVar, i, it.next(), datatype);
        }
    }

    private Class<Message.a<M>> a(Class<M> cls) {
        try {
            return (Class<Message.a<M>>) Class.forName(cls.getName() + "$Builder");
        } catch (ClassNotFoundException unused) {
            throw new IllegalArgumentException("No builder class found for message type " + cls.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] b(M m) {
        byte[] bArr = new byte[a((MessageAdapter<M>) m)];
        try {
            a((MessageAdapter<M>) m, v.a(bArr));
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private Field a(String str) {
        try {
            return this.f25691c.getField(str);
        } catch (NoSuchFieldException unused) {
            throw new AssertionError("No builder field " + this.f25691c.getName() + "." + str);
        }
    }

    private int b(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt <= 127) {
                i2++;
            } else if (charAt <= 2047) {
                i2 += 2;
            } else if (Character.isHighSurrogate(charAt)) {
                i2 += 4;
                i++;
            } else {
                i2 += 3;
            }
            i++;
        }
        return i2;
    }

    private Class<? extends Enum> a(Field field) {
        Class type = field.getType();
        if (Enum.class.isAssignableFrom(type)) {
            return type;
        }
        if (List.class.isAssignableFrom(type)) {
            return ((n) field.getAnnotation(n.class)).enumType();
        }
        return null;
    }

    private <M extends Message> void b(M m, v vVar) throws IOException {
        vVar.g(m.getSerializedSize());
        this.f25689a.c(m.getClass()).a((MessageAdapter<M>) m, vVar);
    }

    private Class<? extends m> b(int i) {
        e<ExtendableMessage<?>, ?> c2;
        a b2 = this.f25693e.b(i);
        Class<? extends m> cls = b2 == null ? null : b2.f25698e;
        return (cls != null || (c2 = c(i)) == null) ? cls : c2.d();
    }

    private e<ExtendableMessage<?>, ?> c(int i) {
        g gVar = this.f25689a.f25741d;
        if (gVar == null) {
            return null;
        }
        return gVar.a(this.f25690b, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(M m) {
        f<T> fVar;
        int a2;
        int i = 0;
        for (a aVar : a()) {
            Object a3 = a((MessageAdapter<M>) m, aVar);
            if (a3 != null) {
                int i2 = aVar.f25694a;
                Message.Datatype datatype = aVar.f25696c;
                Message.Label label = aVar.f25697d;
                if (label.isRepeated()) {
                    if (label.isPacked()) {
                        a2 = a((List<?>) a3, i2, datatype);
                    } else {
                        a2 = b((List) a3, i2, datatype);
                    }
                } else {
                    a2 = a(i2, a3, datatype);
                }
                i += a2;
            }
        }
        if ((m instanceof ExtendableMessage) && (fVar = ((ExtendableMessage) m).extensionMap) != 0) {
            i += a(fVar);
        }
        return i + m.getUnknownFieldsSerializedSize();
    }

    private <T extends ExtendableMessage<?>> int a(f<T> fVar) {
        int a2;
        int i = 0;
        for (int i2 = 0; i2 < fVar.b(); i2++) {
            e<T, ?> a3 = fVar.a(i2);
            Object b2 = fVar.b(i2);
            int i3 = a3.i();
            Message.Datatype a4 = a3.a();
            Message.Label f2 = a3.f();
            if (f2.isRepeated()) {
                if (f2.isPacked()) {
                    a2 = a((List<?>) b2, i3, a4);
                } else {
                    a2 = b((List) b2, i3, a4);
                }
            } else {
                a2 = a(i3, b2, a4);
            }
            i += a2;
        }
        return i;
    }

    private int a(List<?> list, int i, Message.Datatype datatype) {
        Iterator<?> it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 += a(it.next(), datatype);
        }
        return v.b(v.a(i, WireType.LENGTH_DELIMITED)) + v.b(i2) + i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(M m, v vVar) throws IOException {
        f<T> fVar;
        for (a aVar : a()) {
            Object a2 = a((MessageAdapter<M>) m, aVar);
            if (a2 != null) {
                int i = aVar.f25694a;
                Message.Datatype datatype = aVar.f25696c;
                Message.Label label = aVar.f25697d;
                if (label.isRepeated()) {
                    if (label.isPacked()) {
                        a(vVar, (List<?>) a2, i, datatype);
                    } else {
                        b(vVar, (List) a2, i, datatype);
                    }
                } else {
                    a(vVar, i, a2, datatype);
                }
            }
        }
        if ((m instanceof ExtendableMessage) && (fVar = ((ExtendableMessage) m).extensionMap) != 0) {
            a(vVar, fVar);
        }
        m.writeUnknownFieldMap(vVar);
    }

    private <T extends ExtendableMessage<?>> void a(v vVar, f<T> fVar) throws IOException {
        for (int i = 0; i < fVar.b(); i++) {
            e<T, ?> a2 = fVar.a(i);
            Object b2 = fVar.b(i);
            int i2 = a2.i();
            Message.Datatype a3 = a2.a();
            Message.Label f2 = a2.f();
            if (f2.isRepeated()) {
                if (f2.isPacked()) {
                    a(vVar, (List<?>) b2, i2, a3);
                } else {
                    b(vVar, (List) b2, i2, a3);
                }
            } else {
                a(vVar, i2, b2, a3);
            }
        }
    }

    private void a(v vVar, List<?> list, int i, Message.Datatype datatype) throws IOException {
        Iterator<?> it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 += a(it.next(), datatype);
        }
        vVar.b(i, WireType.LENGTH_DELIMITED);
        vVar.g(i2);
        Iterator<?> it2 = list.iterator();
        while (it2.hasNext()) {
            a(vVar, it2.next(), datatype);
        }
    }

    private int a(int i, Object obj, Message.Datatype datatype) {
        return v.c(i) + a(obj, datatype);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int a(Object obj, Message.Datatype datatype) {
        int b2;
        int b3;
        switch (k.f25723a[datatype.ordinal()]) {
            case 1:
                return v.a(((Integer) obj).intValue());
            case 2:
            case 3:
                return v.a(((Long) obj).longValue());
            case 4:
                return v.b(((Integer) obj).intValue());
            case 5:
                return v.b(v.h(((Integer) obj).intValue()));
            case 6:
                return v.a(v.d(((Long) obj).longValue()));
            case 7:
                return 1;
            case 8:
                return a((MessageAdapter<M>) obj);
            case 9:
                b2 = b((String) obj);
                b3 = v.b(b2);
                break;
            case 10:
                b2 = ((ByteString) obj).size();
                b3 = v.b(b2);
                break;
            case 11:
                return d((MessageAdapter<M>) obj);
            case 12:
            case 13:
            case 14:
                return 4;
            case 15:
            case 16:
            case 17:
                return 8;
            default:
                throw new RuntimeException();
        }
        return b3 + b2;
    }

    private <E extends m> int a(E e2) {
        return v.b(this.f25689a.b(e2.getClass()).a((d<E>) e2));
    }

    private void a(v vVar, int i, Object obj, Message.Datatype datatype) throws IOException {
        vVar.b(i, datatype.wireType());
        a(vVar, obj, datatype);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(v vVar, Object obj, Message.Datatype datatype) throws IOException {
        switch (k.f25723a[datatype.ordinal()]) {
            case 1:
                vVar.f(((Integer) obj).intValue());
                return;
            case 2:
            case 3:
                vVar.c(((Long) obj).longValue());
                return;
            case 4:
                vVar.g(((Integer) obj).intValue());
                return;
            case 5:
                vVar.g(v.h(((Integer) obj).intValue()));
                return;
            case 6:
                vVar.c(v.d(((Long) obj).longValue()));
                return;
            case 7:
                vVar.e(((Boolean) obj).booleanValue() ? 1 : 0);
                return;
            case 8:
                a((MessageAdapter<M>) obj, vVar);
                return;
            case 9:
                byte[] bytes = ((String) obj).getBytes("UTF-8");
                vVar.g(bytes.length);
                vVar.b(bytes);
                return;
            case 10:
                ByteString byteString = (ByteString) obj;
                vVar.g(byteString.size());
                vVar.b(byteString.toByteArray());
                return;
            case 11:
                b((Message) obj, vVar);
                return;
            case 12:
            case 13:
                vVar.d(((Integer) obj).intValue());
                return;
            case 14:
                vVar.d(Float.floatToIntBits(((Float) obj).floatValue()));
                return;
            case 15:
            case 16:
                vVar.b(((Long) obj).longValue());
                return;
            case 17:
                vVar.b(Double.doubleToLongBits(((Double) obj).doubleValue()));
                return;
            default:
                throw new RuntimeException();
        }
    }

    private <E extends m> void a(E e2, v vVar) throws IOException {
        vVar.g(this.f25689a.b(e2.getClass()).a((d<E>) e2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public M a(u uVar) throws IOException {
        Message.Datatype datatype;
        Message.Label label;
        e<ExtendableMessage<?>, ?> eVar;
        long j;
        try {
            Message.a<M> newInstance = this.f25691c.newInstance();
            b bVar = new b(null);
            while (true) {
                int f2 = uVar.f();
                int i = f2 >> 3;
                WireType valueOf = WireType.valueOf(f2);
                if (i == 0) {
                    Iterator<Integer> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        int intValue = it.next().intValue();
                        if (this.f25693e.a(intValue)) {
                            a(newInstance, intValue, bVar.a(intValue));
                        } else {
                            a((ExtendableMessage.a) newInstance, c(intValue), bVar.a(intValue));
                        }
                    }
                    return newInstance.build();
                }
                a b2 = this.f25693e.b(i);
                if (b2 != null) {
                    datatype = b2.f25696c;
                    label = b2.f25697d;
                    eVar = null;
                } else {
                    e<ExtendableMessage<?>, ?> c2 = c(i);
                    if (c2 == null) {
                        a(newInstance, uVar, i, valueOf);
                    } else {
                        datatype = c2.a();
                        eVar = c2;
                        label = c2.f();
                    }
                }
                if (label.isPacked() && valueOf == WireType.LENGTH_DELIMITED) {
                    int g2 = uVar.g();
                    long a2 = uVar.a();
                    int d2 = uVar.d(g2);
                    while (true) {
                        j = g2 + a2;
                        if (uVar.a() >= j) {
                            break;
                        }
                        Object a3 = a(uVar, i, datatype);
                        if (datatype == Message.Datatype.ENUM && (a3 instanceof Integer)) {
                            newInstance.addVarint(i, ((Integer) a3).intValue());
                        } else {
                            bVar.a(i, a3);
                        }
                    }
                    uVar.c(d2);
                    if (uVar.a() != j) {
                        throw new IOException("Packed data had wrong length!");
                    }
                } else {
                    Object a4 = a(uVar, i, datatype);
                    if (datatype == Message.Datatype.ENUM && (a4 instanceof Integer)) {
                        newInstance.addVarint(i, ((Integer) a4).intValue());
                    } else if (label.isRepeated()) {
                        bVar.a(i, a4);
                    } else if (eVar != null) {
                        a((ExtendableMessage.a) newInstance, eVar, a4);
                    } else {
                        a(newInstance, i, a4);
                    }
                }
            }
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        }
    }

    private Object a(u uVar, int i, Message.Datatype datatype) throws IOException {
        switch (k.f25723a[datatype.ordinal()]) {
            case 1:
            case 4:
                return Integer.valueOf(uVar.g());
            case 2:
            case 3:
                return Long.valueOf(uVar.h());
            case 5:
                return Integer.valueOf(u.b(uVar.g()));
            case 6:
                return Long.valueOf(u.a(uVar.h()));
            case 7:
                return Boolean.valueOf(uVar.g() != 0);
            case 8:
                d<? extends m> a2 = a(i);
                int g2 = uVar.g();
                try {
                    return a2.a(g2);
                } catch (IllegalArgumentException unused) {
                    return Integer.valueOf(g2);
                }
            case 9:
                return uVar.e();
            case 10:
                return uVar.b();
            case 11:
                return a(uVar, i);
            case 12:
            case 13:
                return Integer.valueOf(uVar.c());
            case 14:
                return Float.valueOf(Float.intBitsToFloat(uVar.c()));
            case 15:
            case 16:
                return Long.valueOf(uVar.d());
            case 17:
                return Double.valueOf(Double.longBitsToDouble(uVar.d()));
            default:
                throw new RuntimeException();
        }
    }

    private Message a(u uVar, int i) throws IOException {
        int g2 = uVar.g();
        if (uVar.f25747e < 64) {
            int d2 = uVar.d(g2);
            uVar.f25747e++;
            Message a2 = d(i).a(uVar);
            uVar.a(0);
            uVar.f25747e--;
            uVar.c(d2);
            return a2;
        }
        throw new IOException("Wire recursion limit exceeded");
    }

    private d<? extends m> a(int i) {
        d<? extends m> dVar;
        a b2 = this.f25693e.b(i);
        if (b2 != null && (dVar = b2.i) != null) {
            return dVar;
        }
        d<? extends m> b3 = this.f25689a.b(b(i));
        if (b2 != null) {
            b2.i = b3;
        }
        return b3;
    }

    private void a(Message.a aVar, u uVar, int i, WireType wireType) throws IOException {
        switch (k.f25724b[wireType.ordinal()]) {
            case 1:
                aVar.ensureUnknownFieldMap().b(i, Long.valueOf(uVar.h()));
                return;
            case 2:
                aVar.ensureUnknownFieldMap().a(i, Integer.valueOf(uVar.c()));
                return;
            case 3:
                aVar.ensureUnknownFieldMap().a(i, Long.valueOf(uVar.d()));
                return;
            case 4:
                aVar.ensureUnknownFieldMap().a(i, uVar.e(uVar.g()));
                return;
            case 5:
                uVar.i();
                return;
            case 6:
                return;
            default:
                throw new RuntimeException("Unsupported wire type: " + wireType);
        }
    }

    private void a(ExtendableMessage.a aVar, e<?, ?> eVar, Object obj) {
        aVar.a(eVar, obj);
    }
}
