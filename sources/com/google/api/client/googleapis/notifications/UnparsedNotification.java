package com.google.api.client.googleapis.notifications;

import com.google.api.client.util.Beta;
import java.io.InputStream;

@Beta
/* loaded from: classes.dex */
public class UnparsedNotification extends AbstractNotification {

    /* renamed from: a, reason: collision with root package name */
    private String f2442a;
    private InputStream b;

    public final String j() {
        return this.f2442a;
    }

    public final InputStream k() {
        return this.b;
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public UnparsedNotification a(long j) {
        return (UnparsedNotification) super.a(j);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public UnparsedNotification a(String str) {
        return (UnparsedNotification) super.a(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public UnparsedNotification b(String str) {
        return (UnparsedNotification) super.b(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public UnparsedNotification c(String str) {
        return (UnparsedNotification) super.c(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public UnparsedNotification d(String str) {
        return (UnparsedNotification) super.d(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public UnparsedNotification e(String str) {
        return (UnparsedNotification) super.e(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public UnparsedNotification f(String str) {
        return (UnparsedNotification) super.f(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public UnparsedNotification g(String str) {
        return (UnparsedNotification) super.g(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public String toString() {
        return super.a().a("contentType", this.f2442a).toString();
    }
}
