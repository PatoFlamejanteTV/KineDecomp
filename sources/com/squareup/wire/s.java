package com.squareup.wire;

import com.squareup.wire.Message;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Wire.java */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    final g f4870a;
    private final Map<Class<? extends Message>, MessageAdapter<? extends Message>> b;
    private final Map<Class<? extends Message.a>, a<? extends Message.a>> c;
    private final Map<Class<? extends m>, c<? extends m>> d;

    public s(Class<?>... clsArr) {
        this((List<Class<?>>) Arrays.asList(clsArr));
    }

    public s(List<Class<?>> list) {
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.f4870a = new g();
        Iterator<Class<?>> it = list.iterator();
        while (it.hasNext()) {
            for (Field field : it.next().getDeclaredFields()) {
                if (field.getType().equals(e.class)) {
                    try {
                        this.f4870a.a((e) field.get(null));
                    } catch (IllegalAccessException e) {
                        throw new AssertionError(e);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized <M extends Message> MessageAdapter<M> a(Class<M> cls) {
        MessageAdapter<M> messageAdapter;
        messageAdapter = (MessageAdapter) this.b.get(cls);
        if (messageAdapter == null) {
            messageAdapter = new MessageAdapter<>(this, cls);
            this.b.put(cls, messageAdapter);
        }
        return messageAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized <B extends Message.a> a<B> b(Class<B> cls) {
        a<B> aVar;
        aVar = (a) this.c.get(cls);
        if (aVar == null) {
            aVar = new a<>(cls);
            this.c.put(cls, aVar);
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized <E extends m> c<E> c(Class<E> cls) {
        c<E> cVar;
        cVar = (c) this.d.get(cls);
        if (cVar == null) {
            cVar = new c<>(cls);
            this.d.put(cls, cVar);
        }
        return cVar;
    }

    public <M extends Message> M a(byte[] bArr, Class<M> cls) throws IOException {
        l.a(bArr, "bytes");
        l.a(cls, "messageClass");
        return (M) a(t.a(bArr), cls);
    }

    public <M extends Message> M a(InputStream inputStream, Class<M> cls) throws IOException {
        l.a(inputStream, "input");
        l.a(cls, "messageClass");
        return (M) a(t.a(inputStream), cls);
    }

    private <M extends Message> M a(t tVar, Class<M> cls) throws IOException {
        return a(cls).a(tVar);
    }
}
