package com.google.android.gms.games.snapshot;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

/* loaded from: classes.dex */
public interface Snapshots {

    /* loaded from: classes.dex */
    public interface CommitSnapshotResult extends Result {
    }

    /* loaded from: classes.dex */
    public interface DeleteSnapshotResult extends Result {
    }

    /* loaded from: classes.dex */
    public interface LoadSnapshotsResult extends Releasable, Result {
    }

    /* loaded from: classes.dex */
    public interface OpenSnapshotResult extends Result {
    }
}
