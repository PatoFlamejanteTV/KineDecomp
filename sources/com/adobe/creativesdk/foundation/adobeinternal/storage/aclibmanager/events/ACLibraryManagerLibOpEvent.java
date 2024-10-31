package com.adobe.creativesdk.foundation.adobeinternal.storage.aclibmanager.events;

import com.adobe.creativesdk.foundation.storage.C0614ub;

/* loaded from: classes.dex */
public class ACLibraryManagerLibOpEvent {

    /* renamed from: a, reason: collision with root package name */
    private final Type f4094a;

    /* renamed from: b, reason: collision with root package name */
    public String f4095b;

    /* renamed from: c, reason: collision with root package name */
    public String f4096c;

    /* renamed from: d, reason: collision with root package name */
    public C0614ub f4097d;

    /* loaded from: classes.dex */
    public enum Type {
        kElementAdded(1),
        kElementRemoved(2),
        kElementUpdated(3),
        kLibraryAdded(4),
        kLibraryDeleted(5),
        kLibraryUnShared(6),
        kLibraryUpdated(7),
        kLibraryRenamed(8),
        kCurrentLibrarySwitched(9),
        kCurrentLibraryUpdated(10),
        kSyncStarted(11),
        kSyncFinished(12),
        kSyncUnavailableDueToNoInternat(13);

        private int _val;

        Type(int i) {
            this._val = 0;
            this._val = i;
        }
    }

    public ACLibraryManagerLibOpEvent(Type type) {
        this.f4094a = type;
    }
}
