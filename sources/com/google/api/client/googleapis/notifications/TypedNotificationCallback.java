package com.google.api.client.googleapis.notifications;

import com.google.api.client.http.HttpMediaType;
import com.google.api.client.util.Beta;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import java.io.IOException;

@Beta
/* loaded from: classes.dex */
public abstract class TypedNotificationCallback<T> implements UnparsedNotificationCallback {
    private static final long serialVersionUID = 1;

    protected abstract Class<T> getDataClass() throws IOException;

    protected abstract ObjectParser getObjectParser() throws IOException;

    protected abstract void onNotification(StoredChannel storedChannel, TypedNotification<T> typedNotification) throws IOException;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.api.client.googleapis.notifications.UnparsedNotificationCallback
    public final void onNotification(StoredChannel storedChannel, UnparsedNotification unparsedNotification) throws IOException {
        TypedNotification typedNotification = new TypedNotification(unparsedNotification);
        String j = unparsedNotification.j();
        if (j != null) {
            typedNotification.a((TypedNotification) getObjectParser().a(unparsedNotification.k(), new HttpMediaType(j).d(), (Class) Preconditions.a(getDataClass())));
        }
        onNotification(storedChannel, typedNotification);
    }
}
