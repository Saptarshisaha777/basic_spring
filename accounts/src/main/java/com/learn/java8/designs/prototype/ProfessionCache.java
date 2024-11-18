package com.learn.java8.designs.prototype;

import java.util.Hashtable;

public class ProfessionCache {

    private static Hashtable<Integer, Profession> cache = new Hashtable<Integer, Profession>();

    public static Profession getProfession(int key) {
        Profession cachedProfession = cache.get(key);
        return cachedProfession == null ? null : cachedProfession.cloningMethod();
    }

    public static void loadCacheProfessions() {
        Doctor doctor = new Doctor();
        doctor.id = 1;
        cache.put(doctor.id, doctor);

        Engineer engineer = new Engineer();
        engineer.id = 2;
        cache.put(engineer.id, engineer);

    }
}
