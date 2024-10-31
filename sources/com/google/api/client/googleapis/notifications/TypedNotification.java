package com.google.api.client.googleapis.notifications;

import com.google.api.client.util.Beta;

@Beta
/* loaded from: classes.dex */
public class TypedNotification<T> extends AbstractNotification {

    /* renamed from: a, reason: collision with root package name */
    private T f2441a;

    public TypedNotification(UnparsedNotification unparsedNotification) {
        super(unparsedNotification);
    }

    public TypedNotification<T> a(T t) {
        this.f2441a = t;
        return this;
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public TypedNotification<T> a(long j) {
        return (TypedNotification) super.a(j);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public TypedNotification<T> a(String str) {
        return (TypedNotification) super.a(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public TypedNotification<T> b(String str) {
        return (TypedNotification) super.b(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public TypedNotification<T> c(String str) {
        return (TypedNotification) super.c(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public TypedNotification<T> d(String str) {
        return (TypedNotification) super.d(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public TypedNotification<T> e(String str) {
        return (TypedNotification) super.e(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public TypedNotification<T> f(String str) {
        return (TypedNotification) super.f(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public TypedNotification<T> g(String str) {
        return (TypedNotification) super.g(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public String toString() {
        return super.a().a("content", this.f2441a).toString();
    }
}
