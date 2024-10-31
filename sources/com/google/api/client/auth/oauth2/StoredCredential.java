package com.google.api.client.auth.oauth2;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Objects;
import com.google.api.client.util.store.DataStore;
import com.google.api.client.util.store.DataStoreFactory;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Beta
/* loaded from: classes.dex */
public final class StoredCredential implements Serializable {
    public static final String DEFAULT_DATA_STORE_ID = StoredCredential.class.getSimpleName();
    private static final long serialVersionUID = 1;
    private String accessToken;
    private Long expirationTimeMilliseconds;
    private final Lock lock = new ReentrantLock();
    private String refreshToken;

    public StoredCredential() {
    }

    public StoredCredential(Credential credential) {
        setAccessToken(credential.a());
        setRefreshToken(credential.f());
        setExpirationTimeMilliseconds(credential.g());
    }

    public String getAccessToken() {
        this.lock.lock();
        try {
            return this.accessToken;
        } finally {
            this.lock.unlock();
        }
    }

    public StoredCredential setAccessToken(String str) {
        this.lock.lock();
        try {
            this.accessToken = str;
            return this;
        } finally {
            this.lock.unlock();
        }
    }

    public Long getExpirationTimeMilliseconds() {
        this.lock.lock();
        try {
            return this.expirationTimeMilliseconds;
        } finally {
            this.lock.unlock();
        }
    }

    public StoredCredential setExpirationTimeMilliseconds(Long l) {
        this.lock.lock();
        try {
            this.expirationTimeMilliseconds = l;
            return this;
        } finally {
            this.lock.unlock();
        }
    }

    public String getRefreshToken() {
        this.lock.lock();
        try {
            return this.refreshToken;
        } finally {
            this.lock.unlock();
        }
    }

    public StoredCredential setRefreshToken(String str) {
        this.lock.lock();
        try {
            this.refreshToken = str;
            return this;
        } finally {
            this.lock.unlock();
        }
    }

    public String toString() {
        return Objects.a(StoredCredential.class).a("accessToken", getAccessToken()).a("refreshToken", getRefreshToken()).a("expirationTimeMilliseconds", getExpirationTimeMilliseconds()).toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StoredCredential)) {
            return false;
        }
        StoredCredential storedCredential = (StoredCredential) obj;
        return Objects.a(getAccessToken(), storedCredential.getAccessToken()) && Objects.a(getRefreshToken(), storedCredential.getRefreshToken()) && Objects.a(getExpirationTimeMilliseconds(), storedCredential.getExpirationTimeMilliseconds());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getAccessToken(), getRefreshToken(), getExpirationTimeMilliseconds()});
    }

    public static DataStore<StoredCredential> getDefaultDataStore(DataStoreFactory dataStoreFactory) throws IOException {
        return dataStoreFactory.a(DEFAULT_DATA_STORE_ID);
    }
}
