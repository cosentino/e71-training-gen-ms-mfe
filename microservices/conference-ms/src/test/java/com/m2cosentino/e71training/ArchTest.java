package com.m2cosentino.e71training;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.m2cosentino.e71training");

        noClasses()
            .that()
            .resideInAnyPackage("com.m2cosentino.e71training.service..")
            .or()
            .resideInAnyPackage("com.m2cosentino.e71training.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.m2cosentino.e71training.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
