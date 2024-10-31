package com.squareup.wire;

import com.squareup.wire.Message;
import java.util.Comparator;

/* compiled from: Message.java */
/* loaded from: classes.dex */
class i implements Comparator<Message.Datatype> {
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Message.Datatype datatype, Message.Datatype datatype2) {
        return datatype.name().compareTo(datatype2.name());
    }
}
