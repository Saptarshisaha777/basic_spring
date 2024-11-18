package com.learn.java8.designs.prototype;

import com.learn.java8.designs.prototype.Doctor;
import com.learn.java8.designs.prototype.Profession;
import com.learn.java8.designs.prototype.ProfessionCache;

public class PrototypeTest {
    public static void main(String[] args) {
        ProfessionCache.loadCacheProfessions();
        Profession doctor = ProfessionCache.getProfession(1);
        System.out.println(doctor.hashCode());
        Profession doctor1 = ProfessionCache.getProfession(1);
        System.out.println(doctor1.hashCode());

        Profession engineer = ProfessionCache.getProfession(2);
        System.out.println(engineer.hashCode());
        Profession engineer1 = ProfessionCache.getProfession(2);
        System.out.println(engineer1.hashCode());

    }
}
