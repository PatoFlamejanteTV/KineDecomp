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

    /* renamed from: a */
    private final Map<Class<? extends Message>, MessageAdapter<? extends Message>> f25738a;

    /* renamed from: b */
    private final Map<Class<? extends Message.a>, b<? extends Message.a>> f25739b;

    /* renamed from: c */
    private final Map<Class<? extends m>, d<? extends m>> f25740c;

    /* renamed from: d */
    final g f25741d;

    public s(Class<?>... clsArr) {
        this((List<Class<?>>) Arrays.asList(clsArr));
    }

    public synchronized <B extends Message.a> b<B> a(Class<B> cls) {
        b<B> bVar;
        bVar = (b) this.f25739b.get(cls);
        if (bVar == null) {
            bVar = new b<>(cls);
            this.f25739b.put(cls, bVar);
        }
        return bVar;
    }

    public synchronized <E extends m> d<E> b(Class<E> cls) {
        d<E> dVar;
        dVar = (d) this.f25740c.get(cls);
        if (dVar == null) {
            dVar = new d<>(cls);
            this.f25740c.put(cls, dVar);
        }
        return dVar;
    }

    public synchronized <M extends Message> MessageAdapter<M> c(Class<M> cls) {
        MessageAdapter<M> messageAdapter;
        messageAdapter = (MessageAdapter) this.f25738a.get(cls);
        if (messageAdapter == null) {
            messageAdapter = new MessageAdapter<>(this, cls);
            this.f25738a.put(cls, messageAdapter);
        }
        return messageAdapter;
    }

    public s(List<Class<?>> list) {
        this.f25738a = new LinkedHashMap();
        this.f25739b = new LinkedHashMap();
        this.f25740c = new LinkedHashMap();
        this.f25741d = new g();
        Iterator<Class<?>> it = list.iterator();
        while (it.hasNext()) {
            for (Field field : it.next().getDeclaredFields()) {
                if (field.getType().equals(e.class)) {
                    try {
                        this.f25741d.a((e) field.get(null));
                    } catch (IllegalAccessException e2) {
                        throw new AssertionError(e2);
                    }
                }
            }
        }
    }

    public <M extends Message> M a(byte[] bArr, Class<M> cls) throws IOException {
        l.a(bArr, "bytes");
        l.a(cls, "messageClass");
        return (M) a(u.a(bArr), cls);
    }

    public <M extends Message> M a(InputStream inputStream, Class<M> cls) throws IOException {
        l.a(inputStream, "input");
        l.a(cls, "messageClass");
        return (M) a(u.a(inputStream), cls);
    }

    private <M extends Message> M a(u uVar, Class<M> cls) throws IOException {
        return c(cls).a(uVar);
    }
}
