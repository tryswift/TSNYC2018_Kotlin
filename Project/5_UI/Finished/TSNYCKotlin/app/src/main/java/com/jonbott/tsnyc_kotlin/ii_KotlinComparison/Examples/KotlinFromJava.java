package com.jonbott.tsnyc_kotlin.ii_KotlinComparison.Examples;

import com.jonbott.tsnyc_kotlin.ii_KotlinComparison.Examples.Helpers.KotlinHelper;
import com.jonbott.tsnyc_kotlin.ii_KotlinComparison.Examples.Helpers.KotlinHelperKt;

public class KotlinFromJava {
    static void examples() {
        KotlinHelper kotlinHelper = new KotlinHelper();
        kotlinHelper.doSomething();

        boolean important = kotlinHelper.isImportant();
        kotlinHelper.setImportant(false);

        kotlinHelper.doSomething();

        boolean hasChanged = kotlinHelper.getHasChanged();
        kotlinHelper.setHasChanged(false);

        KotlinHelperKt.someGlobalMethod("Kakashi Hatake");

    }
}
