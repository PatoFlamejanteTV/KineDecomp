package com.birbit.android.jobqueue.persistentQueue.sqlite;

import android.support.v4.util.LruCache;
import com.birbit.android.jobqueue.TagConstraint;
import com.birbit.android.jobqueue.h;
import java.util.Iterator;

/* compiled from: WhereQueryCache.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a */
    private final LruCache<Long, c> f8300a = new d(this, 15);

    /* renamed from: b */
    private final String f8301b;

    public e(long j) {
        this.f8301b = Long.toString(j);
    }

    private boolean b(h hVar) {
        return hVar.h().size() < 64 && hVar.c().size() < 64 && hVar.d().size() < 64;
    }

    public c a(h hVar, StringBuilder sb) {
        boolean b2 = b(hVar);
        long a2 = a(hVar);
        c cVar = b2 ? this.f8300a.get(Long.valueOf(a2)) : null;
        if (cVar == null) {
            cVar = a(a2, hVar, sb);
            if (b2) {
                this.f8300a.put(Long.valueOf(a2), cVar);
            }
        }
        a(hVar, cVar);
        return cVar;
    }

    private void a(h hVar, c cVar) {
        int i;
        cVar.f8295e[0] = Long.toString(hVar.f());
        cVar.f8295e[1] = Integer.toString(hVar.e());
        int i2 = 2;
        if (hVar.i() != null) {
            cVar.f8295e[2] = Long.toString(hVar.i().longValue());
            i2 = 3;
        }
        if (hVar.g() != null) {
            Iterator<String> it = hVar.h().iterator();
            while (it.hasNext()) {
                cVar.f8295e[i2] = it.next();
                i2++;
            }
        }
        Iterator<String> it2 = hVar.c().iterator();
        while (it2.hasNext()) {
            cVar.f8295e[i2] = it2.next();
            i2++;
        }
        Iterator<String> it3 = hVar.d().iterator();
        while (it3.hasNext()) {
            cVar.f8295e[i2] = it3.next();
            i2++;
        }
        if (hVar.b()) {
            i = i2 + 1;
            cVar.f8295e[i2] = this.f8301b;
        } else {
            i = i2;
        }
        if (i == cVar.f8295e.length) {
            return;
        }
        throw new IllegalStateException("something is wrong with where query cache for " + cVar.f8294d);
    }

    private c a(long j, h hVar, StringBuilder sb) {
        int i;
        sb.setLength(0);
        sb.append("( (");
        sb.append(a.j.f8269a);
        sb.append(" != ");
        sb.append(c.f8292b);
        sb.append(" AND ");
        sb.append(a.j.f8269a);
        sb.append(" <= ?) OR ");
        sb.append(a.i.f8269a);
        sb.append(" <= ?)");
        sb.append(" AND (");
        sb.append(a.l.f8269a);
        sb.append(" IS NULL OR ");
        sb.append(a.l.f8269a);
        sb.append(" != 1)");
        if (hVar.i() != null) {
            sb.append(" AND ");
            sb.append(a.f8288g.f8269a);
            sb.append(" <= ?");
            i = 3;
        } else {
            i = 2;
        }
        if (hVar.g() != null) {
            if (hVar.h().isEmpty()) {
                sb.append(" AND 0 ");
            } else {
                sb.append(" AND ");
                sb.append(a.f8283b.f8269a);
                sb.append(" IN ( SELECT ");
                sb.append(a.n.f8269a);
                sb.append(" FROM ");
                sb.append("job_holder_tags");
                sb.append(" WHERE ");
                sb.append(a.o.f8269a);
                sb.append(" IN (");
                SqlHelper.a(sb, hVar.h().size());
                sb.append(")");
                if (hVar.g() == TagConstraint.ANY) {
                    sb.append(")");
                } else if (hVar.g() == TagConstraint.ALL) {
                    sb.append(" GROUP BY (`");
                    sb.append(a.n.f8269a);
                    sb.append("`)");
                    sb.append(" HAVING count(*) = ");
                    sb.append(hVar.h().size());
                    sb.append(")");
                } else {
                    throw new IllegalArgumentException("unknown constraint " + hVar);
                }
                i += hVar.h().size();
            }
        }
        if (!hVar.c().isEmpty()) {
            sb.append(" AND (");
            sb.append(a.f8285d.f8269a);
            sb.append(" IS NULL OR ");
            sb.append(a.f8285d.f8269a);
            sb.append(" NOT IN(");
            SqlHelper.a(sb, hVar.c().size());
            sb.append("))");
            i += hVar.c().size();
        }
        if (!hVar.d().isEmpty()) {
            sb.append(" AND ");
            sb.append(a.f8283b.f8269a);
            sb.append(" NOT IN(");
            SqlHelper.a(sb, hVar.d().size());
            sb.append(")");
            i += hVar.d().size();
        }
        if (hVar.b()) {
            sb.append(" AND ");
            sb.append(a.f8289h.f8269a);
            sb.append(" != ?");
            i++;
        }
        return new c(j, sb.toString(), new String[i]);
    }

    private long a(h hVar) {
        return ((hVar.i() == null ? 1 : 0) << 21) | ((hVar.g() == null ? 2 : hVar.g().ordinal()) << 0) | (hVar.h().size() << 2) | (hVar.c().size() << 8) | (hVar.d().size() << 14) | ((hVar.b() ? 1 : 0) << 20);
    }
}
