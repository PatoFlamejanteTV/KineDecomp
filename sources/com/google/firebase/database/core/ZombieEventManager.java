package com.google.firebase.database.core;

import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.core.view.QuerySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class ZombieEventManager implements EventRegistrationZombieListener {

    /* renamed from: a */
    private static ZombieEventManager f16963a = new ZombieEventManager();

    /* renamed from: b */
    final HashMap<EventRegistration, List<EventRegistration>> f16964b = new HashMap<>();

    private ZombieEventManager() {
    }

    @NotNull
    public static ZombieEventManager a() {
        return f16963a;
    }

    private void d(EventRegistration eventRegistration) {
        EventRegistration a2;
        List<EventRegistration> list;
        synchronized (this.f16964b) {
            List<EventRegistration> list2 = this.f16964b.get(eventRegistration);
            int i = 0;
            if (list2 != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= list2.size()) {
                        break;
                    }
                    if (list2.get(i2) == eventRegistration) {
                        list2.remove(i2);
                        break;
                    }
                    i2++;
                }
                if (list2.isEmpty()) {
                    this.f16964b.remove(eventRegistration);
                }
            }
            if (!eventRegistration.a().d() && (list = this.f16964b.get((a2 = eventRegistration.a(QuerySpec.a(eventRegistration.a().c()))))) != null) {
                while (true) {
                    if (i >= list.size()) {
                        break;
                    }
                    if (list.get(i) == eventRegistration) {
                        list.remove(i);
                        break;
                    }
                    i++;
                }
                if (list.isEmpty()) {
                    this.f16964b.remove(a2);
                }
            }
        }
    }

    public void b(EventRegistration eventRegistration) {
        synchronized (this.f16964b) {
            List<EventRegistration> list = this.f16964b.get(eventRegistration);
            if (list == null) {
                list = new ArrayList<>();
                this.f16964b.put(eventRegistration, list);
            }
            list.add(eventRegistration);
            if (!eventRegistration.a().d()) {
                EventRegistration a2 = eventRegistration.a(QuerySpec.a(eventRegistration.a().c()));
                List<EventRegistration> list2 = this.f16964b.get(a2);
                if (list2 == null) {
                    list2 = new ArrayList<>();
                    this.f16964b.put(a2, list2);
                }
                list2.add(eventRegistration);
            }
            eventRegistration.a(true);
            eventRegistration.a(this);
        }
    }

    public void c(EventRegistration eventRegistration) {
        synchronized (this.f16964b) {
            List<EventRegistration> list = this.f16964b.get(eventRegistration);
            if (list != null && !list.isEmpty()) {
                if (eventRegistration.a().d()) {
                    HashSet hashSet = new HashSet();
                    for (int size = list.size() - 1; size >= 0; size--) {
                        EventRegistration eventRegistration2 = list.get(size);
                        if (!hashSet.contains(eventRegistration2.a())) {
                            hashSet.add(eventRegistration2.a());
                            eventRegistration2.c();
                        }
                    }
                } else {
                    list.get(0).c();
                }
            }
        }
    }

    @Override // com.google.firebase.database.core.EventRegistrationZombieListener
    public void a(EventRegistration eventRegistration) {
        d(eventRegistration);
    }
}
