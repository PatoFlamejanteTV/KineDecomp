package com.google.api.client.googleapis.notifications;

import com.google.api.client.util.Beta;

@Beta
/* loaded from: classes2.dex */
public class TypedNotification<T> extends AbstractNotification {
    private T i;

    public TypedNotification(UnparsedNotification unparsedNotification) {
        super(unparsedNotification);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public String toString() {
        return super.i().a("content", this.i).toString();
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public TypedNotification<T> b(String str) {
        super.b(str);
        return this;
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public TypedNotification<T> c(String str) {
        super.c(str);
        return this;
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public TypedNotification<T> d(String str) {
        super.d(str);
        return this;
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public TypedNotification<T> e(String str) {
        super.e(str);
        return this;
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public TypedNotification<T> f(String str) {
        super.f(str);
        return this;
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public TypedNotification<T> g(String str) {
        super.g(str);
        return this;
    }

    public TypedNotification<T> a(T t) {
        this.i = t;
        return this;
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public TypedNotification<T> a(long j) {
        super.a(j);
        return this;
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public TypedNotification<T> a(String str) {
        super.a(str);
        return this;
    }
}
