package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.internal.GamesLog;

/* loaded from: classes.dex */
public final class MilestoneRef extends zzc implements Milestone {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MilestoneRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private long i() {
        return b("initial_value");
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public String b() {
        return e("external_milestone_id");
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public long c() {
        long b;
        long j = 0;
        switch (e()) {
            case 1:
                b = 0;
                break;
            case 2:
                b = b("current_value");
                if (b("quest_state") != 6) {
                    b -= i();
                    break;
                }
                break;
            case 3:
            case 4:
                b = f();
                break;
            default:
                b = 0;
                break;
        }
        if (b < 0) {
            GamesLog.b("MilestoneRef", "Current progress should never be negative");
        } else {
            j = b;
        }
        if (j <= f()) {
            return j;
        }
        GamesLog.b("MilestoneRef", "Current progress should never exceed target progress");
        return f();
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public String d() {
        return e("external_event_id");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public int e() {
        return c("milestone_state");
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return MilestoneEntity.a(this, obj);
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public long f() {
        return b("target_value");
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public byte[] g() {
        return g("completion_reward_data");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public Milestone a() {
        return new MilestoneEntity(this);
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return MilestoneEntity.a(this);
    }

    public String toString() {
        return MilestoneEntity.b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((MilestoneEntity) a()).writeToParcel(parcel, i);
    }
}
