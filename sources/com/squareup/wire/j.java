package com.squareup.wire;

import com.squareup.wire.Message;
import java.util.Comparator;

/* compiled from: Message.java */
/* loaded from: classes.dex */
final class j implements Comparator<Message.Label> {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Message.Label label, Message.Label label2) {
        return label.name().compareTo(label2.name());
    }
}
