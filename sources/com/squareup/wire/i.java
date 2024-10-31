package com.squareup.wire;

import com.squareup.wire.Message;
import java.util.Comparator;

/* compiled from: Message.java */
/* loaded from: classes.dex */
final class i implements Comparator<Message.Datatype> {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Message.Datatype datatype, Message.Datatype datatype2) {
        return datatype.name().compareTo(datatype2.name());
    }
}
