package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;

@KeepForSdk
/* loaded from: classes.dex */
public final class ListenerHolder<L> {

    /* renamed from: a */
    private final a f10775a;

    /* renamed from: b */
    private volatile L f10776b;

    /* renamed from: c */
    private final ListenerKey<L> f10777c;

    @KeepForSdk
    /* loaded from: classes.dex */
    public static final class ListenerKey<L> {

        /* renamed from: a */
        private final L f10778a;

        /* renamed from: b */
        private final String f10779b;

        @KeepForSdk
        ListenerKey(L l, String str) {
            this.f10778a = l;
            this.f10779b = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListenerKey)) {
                return false;
            }
            ListenerKey listenerKey = (ListenerKey) obj;
            return this.f10778a == listenerKey.f10778a && this.f10779b.equals(listenerKey.f10779b);
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f10778a) * 31) + this.f10779b.hashCode();
        }
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface Notifier<L> {
        @KeepForSdk
        void a();

        @KeepForSdk
        void a(L l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a extends zap {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Preconditions.a(message.what == 1);
            ListenerHolder.this.a((Notifier) message.obj);
        }
    }

    @KeepForSdk
    public ListenerHolder(Looper looper, L l, String str) {
        this.f10775a = new a(looper);
        Preconditions.a(l, "Listener must not be null");
        this.f10776b = l;
        Preconditions.b(str);
        this.f10777c = new ListenerKey<>(l, str);
    }

    @KeepForSdk
    public final void a() {
        this.f10776b = null;
    }

    @KeepForSdk
    public final ListenerKey<L> b() {
        return this.f10777c;
    }

    @KeepForSdk
    final void a(Notifier<? super L> notifier) {
        L l = this.f10776b;
        if (l == null) {
            notifier.a();
            return;
        }
        try {
            notifier.a(l);
        } catch (RuntimeException e2) {
            notifier.a();
            throw e2;
        }
    }
}
