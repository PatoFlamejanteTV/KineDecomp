package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class ZInvitationCluster implements SafeParcelable, Invitation {
    public static final InvitationClusterCreator CREATOR = new InvitationClusterCreator();

    /* renamed from: a, reason: collision with root package name */
    private final int f1375a;
    private final ArrayList<InvitationEntity> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZInvitationCluster(int i, ArrayList<InvitationEntity> arrayList) {
        this.f1375a = i;
        this.b = arrayList;
        m();
    }

    private void m() {
        zzb.a(!this.b.isEmpty());
        InvitationEntity invitationEntity = this.b.get(0);
        int size = this.b.size();
        for (int i = 1; i < size; i++) {
            zzb.a(invitationEntity.f().equals(this.b.get(i).f()), "All the invitations must be from the same inviter");
        }
    }

    public int b() {
        return this.f1375a;
    }

    public ArrayList<Invitation> c() {
        return new ArrayList<>(this.b);
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public Game d() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public String e() {
        return this.b.get(0).e();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ZInvitationCluster)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ZInvitationCluster zInvitationCluster = (ZInvitationCluster) obj;
        if (zInvitationCluster.b.size() != this.b.size()) {
            return false;
        }
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            if (!this.b.get(i).equals(zInvitationCluster.b.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public Participant f() {
        return this.b.get(0).f();
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public long g() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public int h() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int hashCode() {
        return zzw.a(this.b.toArray());
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public int i() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public int j() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public Invitation a() {
        return this;
    }

    @Override // com.google.android.gms.games.multiplayer.Participatable
    public ArrayList<Participant> l() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        InvitationClusterCreator.a(this, parcel, i);
    }
}
