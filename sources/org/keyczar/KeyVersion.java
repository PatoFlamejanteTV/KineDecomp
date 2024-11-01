package org.keyczar;

import com.google.gson.annotations.Expose;
import org.keyczar.enums.KeyStatus;
import org.keyczar.util.Util;

/* loaded from: classes.dex */
public class KeyVersion {

    @Expose
    private boolean exportable;

    @Expose
    private KeyStatus status;

    @Expose
    private int versionNumber;

    private KeyVersion() {
        this.exportable = false;
        this.status = KeyStatus.ACTIVE;
        this.versionNumber = 0;
    }

    public KeyVersion(int i, boolean z) {
        this(i, KeyStatus.ACTIVE, z);
    }

    public KeyVersion(int i, KeyStatus keyStatus, boolean z) {
        this.exportable = false;
        this.status = KeyStatus.ACTIVE;
        this.versionNumber = 0;
        this.versionNumber = i;
        this.status = keyStatus;
        this.exportable = z;
    }

    public String toString() {
        return Util.gson().toJson(this);
    }

    public boolean equals(Object obj) {
        return (obj instanceof KeyVersion) && getVersionNumber() == ((KeyVersion) obj).getVersionNumber();
    }

    public int hashCode() {
        return this.versionNumber;
    }

    public KeyStatus getStatus() {
        return this.status;
    }

    public int getVersionNumber() {
        return this.versionNumber;
    }

    public boolean isExportable() {
        return this.exportable;
    }

    public void setStatus(KeyStatus keyStatus) {
        if (keyStatus == null) {
            keyStatus = this.status;
        }
        this.status = keyStatus;
    }

    public static KeyVersion read(String str) {
        return (KeyVersion) Util.gson().fromJson(str, KeyVersion.class);
    }
}
