package com.yulikexuan.java.refactoring;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test com.yulikexuan.java.refactoring.ClassLoaderPrinter- ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class ClassLoaderPrinterTest {

    private ClassLoaderPrinter classLoaderPrinter;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.classLoaderPrinter = new ClassLoaderPrinter();
    }

    @Test
    void test_Class_Loaders() throws Exception {
        this.classLoaderPrinter.printClassLoaders();
    }

}///:~