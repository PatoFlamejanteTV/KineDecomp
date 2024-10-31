package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzaai {
    private final Collection<zzaac<?>> zzcnk = new ArrayList();
    private final Collection<zzaac<String>> zzcnl = new ArrayList();
    private final Collection<zzaac<String>> zzcnm = new ArrayList();

    public final void zza(zzaac zzaacVar) {
        this.zzcnk.add(zzaacVar);
    }

    public final void zzb(zzaac<String> zzaacVar) {
        this.zzcnl.add(zzaacVar);
    }

    public final void zzc(zzaac<String> zzaacVar) {
        this.zzcnm.add(zzaacVar);
    }

    public final List<String> zzqw() {
        ArrayList arrayList = new ArrayList();
        Iterator<zzaac<String>> it = this.zzcnl.iterator();
        while (it.hasNext()) {
            String str = (String) zzwu.zzpz().zzd(it.next());
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public final List<String> zzqx() {
        List<String> zzqw = zzqw();
        Iterator<zzaac<String>> it = this.zzcnm.iterator();
        while (it.hasNext()) {
            String str = (String) zzwu.zzpz().zzd(it.next());
            if (str != null) {
                zzqw.add(str);
            }
        }
        return zzqw;
    }

    public final void zza(SharedPreferences.Editor editor, int i, JSONObject jSONObject) {
        for (zzaac<?> zzaacVar : this.zzcnk) {
            if (zzaacVar.getSource() == 1) {
                zzaacVar.zza(editor, zzaacVar.zzb(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
        } else {
            zzbbd.e("Flag Json is null.");
        }
    }
}
