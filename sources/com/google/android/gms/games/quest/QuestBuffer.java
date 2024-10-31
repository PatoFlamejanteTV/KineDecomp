package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.zzf;

/* loaded from: classes.dex */
public final class QuestBuffer extends zzf<Quest> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Quest a(int i, int i2) {
        return new QuestRef(this.f982a, i, i2);
    }

    @Override // com.google.android.gms.common.data.zzf
    protected String b() {
        return "external_quest_id";
    }
}
