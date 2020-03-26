package com.kmp.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Hashing retrieval is a two-step process:
 * <p>
 * Find the right bucket (using hashCode())
 * Search the bucket for the right element (using equals() )
 * <p>
 * If we comment either of the hascode() or equals() then the result map below will have two entries. Which is wrong.
 */
public class HashCodeAndEqualsMethods {

    private final String  importantField;
    private final String anotherField;

    public HashCodeAndEqualsMethods(final String equalField, final String anotherField) {
        this.importantField = equalField;
        this.anotherField = anotherField;
    }

    public String getEqualField() {
        return importantField;
    }

    public String getAnotherField() {
        return anotherField;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((importantField == null) ? 0 : importantField.hashCode());

        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final HashCodeAndEqualsMethods other = (HashCodeAndEqualsMethods) obj;
        if (importantField == null) {
            if (other.importantField != null)
                return false;
        } else if (!importantField.equals(other.importantField))
            return false;
        return true;
    }

    public static void main(String args[]) {

        HashCodeAndEqualsMethods hem1 = new HashCodeAndEqualsMethods("abc", "First");
        HashCodeAndEqualsMethods hem2 = new HashCodeAndEqualsMethods("cba", "second");

        Map<HashCodeAndEqualsMethods, String> map = new HashMap<>();
        map.put(hem1, "hem11");
        map.put(hem2, "hem22");

        System.out.println(hem1.hashCode());
        System.out.println(hem2.hashCode());
        for (HashCodeAndEqualsMethods h : map.keySet()) {
            System.out.println("Key: " + h.getEqualField() + " + " + h.getAnotherField() + " Value: " + map.get(h));

        }
    }

}