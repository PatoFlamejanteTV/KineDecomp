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
import org.keyczar.Keyczar;

/* loaded from: classes.dex */
public final class MessageAdapter<M extends Message> {

    /* renamed from: a */
    private final s f4852a;
    private final Class<M> b;
    private final Class<Message.a<M>> c;
    private final Map<String, Integer> d = new LinkedHashMap();
    private final o<a> e;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        final int f4853a;
        final String b;
        final Message.Datatype c;
        final Message.Label d;
        final Class<? extends m> e;
        final Class<? extends Message> f;
        final boolean g;
        MessageAdapter<? extends Message> h;
        c<? extends m> i;
        private final Field j;
        private final Field k;

        /* synthetic */ a(int i, String str, Message.Datatype datatype, Message.Label label, boolean z, Class cls, Field field, Field field2, k kVar) {
            this(i, str, datatype, label, z, cls, field, field2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private a(int i, String str, Message.Datatype datatype, Message.Label label, boolean z, Class<?> cls, Field field, Field field2) {
            this.f4853a = i;
            this.b = str;
            this.c = datatype;
            this.d = label;
            this.g = z;
            if (datatype == Message.Datatype.ENUM) {
                this.e = cls;
                this.f = null;
            } else if (datatype == Message.Datatype.MESSAGE) {
                this.f = cls;
                this.e = null;
            } else {
                this.e = null;
                this.f = null;
            }
            this.j = field;
            this.k = field2;
        }
    }

    Collection<a> a() {
        return this.e.a();
    }

    Object a(M m, a aVar) {
        if (aVar.j != null) {
            try {
                return aVar.j.get(m);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
        throw new AssertionError("Field is not of type \"Message\"");
    }

    public void a(Message.a<M> aVar, int i, Object obj) {
        try {
            this.e.a(i).k.set(aVar, obj);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    public MessageAdapter(s sVar, Class<M> cls) {
        this.f4852a = sVar;
        this.b = cls;
        this.c = a(cls);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Field field : cls.getDeclaredFields()) {
            n nVar = (n) field.getAnnotation(n.class);
            if (nVar != null) {
                int a2 = nVar.a();
                String name = field.getName();
                this.d.put(name, Integer.valueOf(a2));
                Class cls2 = null;
                Message.Datatype b2 = nVar.b();
                if (b2 == Message.Datatype.ENUM) {
                    cls2 = b(field);
                } else if (b2 == Message.Datatype.MESSAGE) {
                    cls2 = a(field);
                }
                linkedHashMap.put(Integer.valueOf(a2), new a(a2, name, b2, nVar.c(), nVar.f(), cls2, field, a(name), null));
            }
        }
        this.e = o.a(linkedHashMap);
    }

    private Class<Message.a<M>> a(Class<M> cls) {
        try {
            return (Class<Message.a<M>>) Class.forName(cls.getName() + "$Builder");
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("No builder class found for message type " + cls.getName());
        }
    }

    private Field a(String str) {
        try {
            return this.c.getField(str);
        } catch (NoSuchFieldException e) {
            throw new AssertionError("No builder field " + this.c.getName() + "." + str);
        }
    }

    private Class<? extends Message> a(Field field) {
        Class type = field.getType();
        if (!Message.class.isAssignableFrom(type)) {
            if (List.class.isAssignableFrom(type)) {
                return ((n) field.getAnnotation(n.class)).d();
            }
            return null;
        }
        return type;
    }

    private Class<? extends Enum> b(Field field) {
        Class type = field.getType();
        if (!Enum.class.isAssignableFrom(type)) {
            if (List.class.isAssignableFrom(type)) {
                return ((n) field.getAnnotation(n.class)).e();
            }
            return null;
        }
        return type;
    }

    public int a(M m) {
        int a2;
        int i = 0;
        for (a aVar : a()) {
            Object a3 = a((MessageAdapter<M>) m, aVar);
            if (a3 != null) {
                int i2 = aVar.f4853a;
                Message.Datatype datatype = aVar.c;
                Message.Label label = aVar.d;
                if (label.isRepeated()) {
                    if (label.isPacked()) {
                        a2 = b((List) a3, i2, datatype);
                    } else {
                        a2 = a((List<?>) a3, i2, datatype);
                    }
                } else {
                    a2 = a(i2, a3, datatype);
                }
                i = a2 + i;
            }
        }
        if (m instanceof ExtendableMessage) {
            ExtendableMessage extendableMessage = (ExtendableMessage) m;
            if (extendableMessage.extensionMap != null) {
                i += a(extendableMessage.extensionMap);
            }
        }
        return m.getUnknownFieldsSerializedSize() + i;
    }

    private <T extends ExtendableMessage<?>> int a(f<T> fVar) {
        int a2;
        int i = 0;
        for (int i2 = 0; i2 < fVar.a(); i2++) {
            e<T, ?> a3 = fVar.a(i2);
            Object b2 = fVar.b(i2);
            int e = a3.e();
            Message.Datatype f = a3.f();
            Message.Label g = a3.g();
            if (g.isRepeated()) {
                if (g.isPacked()) {
                    a2 = b((List) b2, e, f);
                } else {
                    a2 = a((List<?>) b2, e, f);
                }
            } else {
                a2 = a(e, b2, f);
            }
            i += a2;
        }
        return i;
    }

    private int a(List<?> list, int i, Message.Datatype datatype) {
        int i2 = 0;
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            i2 += a(i, it.next(), datatype);
        }
        return i2;
    }

    private int b(List<?> list, int i, Message.Datatype datatype) {
        int i2 = 0;
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            i2 += a(it.next(), datatype);
        }
        return i2 + v.c(v.a(i, WireType.LENGTH_DELIMITED)) + v.c(i2);
    }

    public void a(M m, v vVar) throws IOException {
        for (a aVar : a()) {
            Object a2 = a((MessageAdapter<M>) m, aVar);
            if (a2 != null) {
                int i = aVar.f4853a;
                Message.Datatype datatype = aVar.c;
                Message.Label label = aVar.d;
                if (label.isRepeated()) {
                    if (label.isPacked()) {
                        b(vVar, (List) a2, i, datatype);
                    } else {
                        a(vVar, (List<?>) a2, i, datatype);
                    }
                } else {
                    a(vVar, i, a2, datatype);
                }
            }
        }
        if (m instanceof ExtendableMessage) {
            ExtendableMessage extendableMessage = (ExtendableMessage) m;
            if (extendableMessage.extensionMap != null) {
                a(vVar, extendableMessage.extensionMap);
            }
        }
        m.writeUnknownFieldMap(vVar);
    }

    private <T extends ExtendableMessage<?>> void a(v vVar, f<T> fVar) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < fVar.a()) {
                e<T, ?> a2 = fVar.a(i2);
                Object b2 = fVar.b(i2);
                int e = a2.e();
                Message.Datatype f = a2.f();
                Message.Label g = a2.g();
                if (g.isRepeated()) {
                    if (g.isPacked()) {
                        b(vVar, (List) b2, e, f);
                    } else {
                        a(vVar, (List<?>) b2, e, f);
                    }
                } else {
                    a(vVar, e, b2, f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(v vVar, List<?> list, int i, Message.Datatype datatype) throws IOException {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            a(vVar, i, it.next(), datatype);
        }
    }

    private void b(v vVar, List<?> list, int i, Message.Datatype datatype) throws IOException {
        int i2 = 0;
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            i2 += a(it.next(), datatype);
        }
        vVar.b(i, WireType.LENGTH_DELIMITED);
        vVar.f(i2);
        Iterator<?> it2 = list.iterator();
        while (it2.hasNext()) {
            a(vVar, it2.next(), datatype);
        }
    }

    public byte[] b(M m) {
        byte[] bArr = new byte[a((MessageAdapter<M>) m)];
        try {
            a((MessageAdapter<M>) m, v.a(bArr));
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String c(M m) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.b.getSimpleName());
        sb.append("{");
        String str = "";
        for (a aVar : a()) {
            Object a2 = a((MessageAdapter<M>) m, aVar);
            if (a2 != null) {
                sb.append(str);
                str = ", ";
                sb.append(aVar.b);
                sb.append("=");
                sb.append(aVar.g ? "██" : a2);
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

    private int a(int i, Object obj, Message.Datatype datatype) {
        return v.b(i) + a(obj, datatype);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int a(Object obj, Message.Datatype datatype) {
        switch (datatype) {
            case INT32:
                return v.a(((Integer) obj).intValue());
            case INT64:
            case UINT64:
                return v.a(((Long) obj).longValue());
            case UINT32:
                return v.c(((Integer) obj).intValue());
            case SINT32:
                return v.c(v.h(((Integer) obj).intValue()));
            case SINT64:
                return v.a(v.d(((Long) obj).longValue()));
            case BOOL:
                return 1;
            case ENUM:
                return a((MessageAdapter<M>) obj);
            case STRING:
                int b2 = b((String) obj);
                return b2 + v.c(b2);
            case BYTES:
                int size = ((ByteString) obj).size();
                return size + v.c(size);
            case MESSAGE:
                return d((MessageAdapter<M>) obj);
            case FIXED32:
            case SFIXED32:
            case FLOAT:
                return 4;
            case FIXED64:
            case SFIXED64:
            case DOUBLE:
                return 8;
            default:
                throw new RuntimeException();
        }
    }

    private int b(String str) {
        int i = 0;
        int length = str.length();
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

    private <E extends m> int a(E e) {
        return v.c(this.f4852a.c(e.getClass()).a((c<E>) e));
    }

    private <M extends Message> int d(M m) {
        int serializedSize = m.getSerializedSize();
        return serializedSize + v.c(serializedSize);
    }

    private void a(v vVar, int i, Object obj, Message.Datatype datatype) throws IOException {
        vVar.b(i, datatype.wireType());
        a(vVar, obj, datatype);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(v vVar, Object obj, Message.Datatype datatype) throws IOException {
        switch (datatype) {
            case INT32:
                vVar.e(((Integer) obj).intValue());
                return;
            case INT64:
            case UINT64:
                vVar.b(((Long) obj).longValue());
                return;
            case UINT32:
                vVar.f(((Integer) obj).intValue());
                return;
            case SINT32:
                vVar.f(v.h(((Integer) obj).intValue()));
                return;
            case SINT64:
                vVar.b(v.d(((Long) obj).longValue()));
                return;
            case BOOL:
                vVar.d(((Boolean) obj).booleanValue() ? 1 : 0);
                return;
            case ENUM:
                a((MessageAdapter<M>) obj, vVar);
                return;
            case STRING:
                byte[] bytes = ((String) obj).getBytes(Keyczar.DEFAULT_ENCODING);
                vVar.f(bytes.length);
                vVar.b(bytes);
                return;
            case BYTES:
                ByteString byteString = (ByteString) obj;
                vVar.f(byteString.size());
                vVar.b(byteString.toByteArray());
                return;
            case MESSAGE:
                b((Message) obj, vVar);
                return;
            case FIXED32:
            case SFIXED32:
                vVar.g(((Integer) obj).intValue());
                return;
            case FLOAT:
                vVar.g(Float.floatToIntBits(((Float) obj).floatValue()));
                return;
            case FIXED64:
            case SFIXED64:
                vVar.c(((Long) obj).longValue());
                return;
            case DOUBLE:
                vVar.c(Double.doubleToLongBits(((Double) obj).doubleValue()));
                return;
            default:
                throw new RuntimeException();
        }
    }

    private <M extends Message> void b(M m, v vVar) throws IOException {
        vVar.f(m.getSerializedSize());
        this.f4852a.a(m.getClass()).a((MessageAdapter<M>) m, vVar);
    }

    private <E extends m> void a(E e, v vVar) throws IOException {
        vVar.f(this.f4852a.c(e.getClass()).a((c<E>) e));
    }

    public M a(t tVar) throws IOException {
        Message.Datatype datatype;
        e<ExtendableMessage<?>, ?> eVar;
        Message.Label label;
        try {
            Message.a<M> newInstance = this.c.newInstance();
            b bVar = new b(null);
            while (true) {
                int a2 = tVar.a();
                int i = a2 >> 3;
                WireType valueOf = WireType.valueOf(a2);
                if (i == 0) {
                    Iterator<Integer> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        int intValue = it.next().intValue();
                        if (this.e.b(intValue)) {
                            a(newInstance, intValue, bVar.a(intValue));
                        } else {
                            a((ExtendableMessage.a) newInstance, d(intValue), bVar.a(intValue));
                        }
                    }
                    return newInstance.build();
                }
                a a3 = this.e.a(i);
                if (a3 != null) {
                    datatype = a3.c;
                    eVar = null;
                    label = a3.d;
                } else {
                    e<ExtendableMessage<?>, ?> d = d(i);
                    if (d == null) {
                        a(newInstance, tVar, i, valueOf);
                    } else {
                        Message.Datatype f = d.f();
                        Message.Label g = d.g();
                        eVar = d;
                        datatype = f;
                        label = g;
                    }
                }
                if (label.isPacked() && valueOf == WireType.LENGTH_DELIMITED) {
                    int d2 = tVar.d();
                    long h = tVar.h();
                    int d3 = tVar.d(d2);
                    while (tVar.h() < d2 + h) {
                        Object a4 = a(tVar, i, datatype);
                        if (datatype == Message.Datatype.ENUM && (a4 instanceof Integer)) {
                            newInstance.addVarint(i, ((Integer) a4).intValue());
                        } else {
                            bVar.a(i, a4);
                        }
                    }
                    tVar.e(d3);
                    if (tVar.h() != d2 + h) {
                        throw new IOException("Packed data had wrong length!");
                    }
                } else {
                    Object a5 = a(tVar, i, datatype);
                    if (datatype == Message.Datatype.ENUM && (a5 instanceof Integer)) {
                        newInstance.addVarint(i, ((Integer) a5).intValue());
                    } else if (label.isRepeated()) {
                        bVar.a(i, a5);
                    } else if (eVar != null) {
                        a((ExtendableMessage.a) newInstance, eVar, a5);
                    } else {
                        a(newInstance, i, a5);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        }
    }

    private Object a(t tVar, int i, Message.Datatype datatype) throws IOException {
        switch (datatype) {
            case INT32:
            case UINT32:
                return Integer.valueOf(tVar.d());
            case INT64:
            case UINT64:
                return Long.valueOf(tVar.e());
            case SINT32:
                return Integer.valueOf(t.c(tVar.d()));
            case SINT64:
                return Long.valueOf(t.a(tVar.e()));
            case BOOL:
                return Boolean.valueOf(tVar.d() != 0);
            case ENUM:
                c<? extends m> b2 = b(i);
                int d = tVar.d();
                try {
                    return b2.a(d);
                } catch (IllegalArgumentException e) {
                    return Integer.valueOf(d);
                }
            case STRING:
                return tVar.b();
            case BYTES:
                return tVar.c();
            case MESSAGE:
                return a(tVar, i);
            case FIXED32:
            case SFIXED32:
                return Integer.valueOf(tVar.f());
            case FLOAT:
                return Float.valueOf(Float.intBitsToFloat(tVar.f()));
            case FIXED64:
            case SFIXED64:
                return Long.valueOf(tVar.g());
            case DOUBLE:
                return Double.valueOf(Double.longBitsToDouble(tVar.g()));
            default:
                throw new RuntimeException();
        }
    }

    private Message a(t tVar, int i) throws IOException {
        int d = tVar.d();
        if (tVar.f4871a >= 64) {
            throw new IOException("Wire recursion limit exceeded");
        }
        int d2 = tVar.d(d);
        tVar.f4871a++;
        Message a2 = a(i).a(tVar);
        tVar.a(0);
        tVar.f4871a--;
        tVar.e(d2);
        return a2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private MessageAdapter<? extends Message> a(int i) {
        a a2 = this.e.a(i);
        if (a2 != null && a2.h != null) {
            return a2.h;
        }
        MessageAdapter<? extends Message> a3 = this.f4852a.a(c(i));
        if (a2 != null) {
            a2.h = a3;
        }
        return a3;
    }

    private c<? extends m> b(int i) {
        a a2 = this.e.a(i);
        if (a2 != null && a2.i != null) {
            return a2.i;
        }
        c<? extends m> c = this.f4852a.c(e(i));
        if (a2 != null) {
            a2.i = c;
        }
        return c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Class<Message> c(int i) {
        e<ExtendableMessage<?>, ?> d;
        a a2 = this.e.a(i);
        Class<Message> cls = a2 == null ? 0 : a2.f;
        if (cls == 0 && (d = d(i)) != null) {
            return d.b();
        }
        return cls;
    }

    private void a(Message.a aVar, t tVar, int i, WireType wireType) throws IOException {
        switch (wireType) {
            case VARINT:
                aVar.ensureUnknownFieldMap().a(i, Long.valueOf(tVar.e()));
                return;
            case FIXED32:
                aVar.ensureUnknownFieldMap().a(i, Integer.valueOf(tVar.f()));
                return;
            case FIXED64:
                aVar.ensureUnknownFieldMap().b(i, Long.valueOf(tVar.g()));
                return;
            case LENGTH_DELIMITED:
                aVar.ensureUnknownFieldMap().a(i, tVar.b(tVar.d()));
                return;
            case START_GROUP:
                tVar.i();
                return;
            case END_GROUP:
                return;
            default:
                throw new RuntimeException("Unsupported wire type: " + wireType);
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        private Map<Integer, ImmutableList<Object>> f4854a;

        private b() {
        }

        /* synthetic */ b(k kVar) {
            this();
        }

        void a(int i, Object obj) {
            ImmutableList<Object> immutableList = this.f4854a == null ? null : this.f4854a.get(Integer.valueOf(i));
            if (immutableList == null) {
                immutableList = new ImmutableList<>();
                if (this.f4854a == null) {
                    this.f4854a = new LinkedHashMap();
                }
                this.f4854a.put(Integer.valueOf(i), immutableList);
            }
            ((ImmutableList) immutableList).list.add(obj);
        }

        Set<Integer> a() {
            return this.f4854a == null ? Collections.emptySet() : this.f4854a.keySet();
        }

        List<Object> a(int i) {
            if (this.f4854a == null) {
                return null;
            }
            return this.f4854a.get(Integer.valueOf(i));
        }
    }

    private e<ExtendableMessage<?>, ?> d(int i) {
        g gVar = this.f4852a.f4870a;
        if (gVar == null) {
            return null;
        }
        return gVar.a(this.b, i);
    }

    private void a(ExtendableMessage.a aVar, e<?, ?> eVar, Object obj) {
        aVar.a(eVar, obj);
    }

    private Class<? extends m> e(int i) {
        e<ExtendableMessage<?>, ?> d;
        a a2 = this.e.a(i);
        Class<? extends m> cls = a2 == null ? null : a2.e;
        if (cls == null && (d = d(i)) != null) {
            return d.c();
        }
        return cls;
    }

    /* loaded from: classes.dex */
    public static class ImmutableList<T> extends AbstractList<T> implements Serializable, Cloneable, RandomAccess {
        private final List<T> list = new ArrayList();

        ImmutableList() {
        }

        public Object clone() {
            return this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.list.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i) {
            return this.list.get(i);
        }
    }
}
