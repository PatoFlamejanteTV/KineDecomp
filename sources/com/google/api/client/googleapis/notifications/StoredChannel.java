package com.google.api.client.googleapis.notifications;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Objects;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.store.DataStore;
import com.google.api.client.util.store.DataStoreFactory;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Beta
/* loaded from: classes2.dex */
public final class StoredChannel implements Serializable {
    public static final String DEFAULT_DATA_STORE_ID = "StoredChannel";
    private static final long serialVersionUID = 1;
    private String clientToken;
    private Long expiration;
    private final String id;
    private final Lock lock;
    private final UnparsedNotificationCallback notificationCallback;
    private String topicId;

    public StoredChannel(UnparsedNotificationCallback unparsedNotificationCallback) {
        this(unparsedNotificationCallback, NotificationUtils.a());
    }

    public static DataStore<StoredChannel> getDefaultDataStore(DataStoreFactory dataStoreFactory) throws IOException {
        return dataStoreFactory.a(DEFAULT_DATA_STORE_ID);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StoredChannel) {
            return getId().equals(((StoredChannel) obj).getId());
        }
        return false;
    }

    public String getClientToken() {
        this.lock.lock();
        try {
            return this.clientToken;
        } finally {
            this.lock.unlock();
        }
    }

    public Long getExpiration() {
        this.lock.lock();
        try {
            return this.expiration;
        } finally {
            this.lock.unlock();
        }
    }

    public String getId() {
        this.lock.lock();
        try {
            return this.id;
        } finally {
            this.lock.unlock();
        }
    }

    public UnparsedNotificationCallback getNotificationCallback() {
        this.lock.lock();
        try {
            return this.notificationCallback;
        } finally {
            this.lock.unlock();
        }
    }

    public String getTopicId() {
        this.lock.lock();
        try {
            return this.topicId;
        } finally {
            this.lock.unlock();
        }
    }

    public int hashCode() {
        return getId().hashCode();
    }

    public StoredChannel setClientToken(String str) {
        this.lock.lock();
        try {
            this.clientToken = str;
            return this;
        } finally {
            this.lock.unlock();
        }
    }

    public StoredChannel setExpiration(Long l) {
        this.lock.lock();
        try {
            this.expiration = l;
            return this;
        } finally {
            this.lock.unlock();
        }
    }

    public StoredChannel setTopicId(String str) {
        this.lock.lock();
        try {
            this.topicId = str;
            return this;
        } finally {
            this.lock.unlock();
        }
    }

    public StoredChannel store(DataStoreFactory dataStoreFactory) throws IOException {
        return store(getDefaultDataStore(dataStoreFactory));
    }

    public String toString() {
        return Objects.a(StoredChannel.class).a("notificationCallback", getNotificationCallback()).a("clientToken", getClientToken()).a("expiration", getExpiration()).a("id", getId()).a("topicId", getTopicId()).toString();
    }

    public StoredChannel(UnparsedNotificationCallback unparsedNotificationCallback, String str) {
        this.lock = new ReentrantLock();
        Preconditions.a(unparsedNotificationCallback);
        this.notificationCallback = unparsedNotificationCallback;
        Preconditions.a(str);
        this.id = str;
    }

    public StoredChannel store(DataStore<StoredChannel> dataStore) throws IOException {
        this.lock.lock();
        try {
            dataStore.a(getId(), this);
            return this;
        } finally {
            this.lock.unlock();
        }
    }
}
