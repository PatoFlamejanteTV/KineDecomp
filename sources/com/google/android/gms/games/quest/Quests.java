package com.google.android.gms.games.quest;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

/* loaded from: classes.dex */
public interface Quests {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f1395a = {1, 2, 3, 4, 101, 5, 102, 6, 103};

    /* loaded from: classes.dex */
    public interface AcceptQuestResult extends Result {
    }

    /* loaded from: classes.dex */
    public interface ClaimMilestoneResult extends Result {
    }

    /* loaded from: classes.dex */
    public interface LoadQuestsResult extends Releasable, Result {
    }
}
