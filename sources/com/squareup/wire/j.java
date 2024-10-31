package com.squareup.wire;

import com.squareup.wire.Message;
import java.util.Comparator;

/* compiled from: Message.java */
/* loaded from: classes.dex */
class j implements Comparator<Message.Label> {
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Message.Label label, Message.Label label2) {
        return label.name().compareTo(label2.name());
    }
}
