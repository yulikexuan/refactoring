//: com.yulikexuan.java.refactoring.ClassLoaderPrinter


package com.yulikexuan.java.refactoring;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;


@Slf4j
class ClassLoaderPrinter {

    void printClassLoaders() throws ClassNotFoundException {

        log.info(">>> Classloader of this class: {} ",
                ClassLoaderPrinter.class.getClassLoader());

        log.info(">>> Classloader of Logging: {} ",
                Slf4j.class.getClassLoader());

        log.info(">>> Classloader of ArrayList: {} ",
                ArrayList.class.getClassLoader());

    }

}///:~