package com.autodealer.repository;

import java.util.List;

/**
 * Created by ilshyma on 23.03.2016.
 */
public class Util {

    private Util() {
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> castList(List list) {
        return list;
    }
}
