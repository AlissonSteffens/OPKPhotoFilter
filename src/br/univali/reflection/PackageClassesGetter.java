/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.reflection;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 *
 * @author Alisson
 */
public class PackageClassesGetter {
     /**
 * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
 *
 * @param packageName The base package
 * @return The classes
 * @throws ClassNotFoundException
 * @throws IOException
     * @throws java.net.URISyntaxException
 */
public static Class[] getClasses(String packageName) throws ClassNotFoundException, IOException, URISyntaxException {
    
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    assert classLoader != null;
    String path = packageName.replace('.', '/');
    Enumeration<URL> resources = classLoader.getResources(path);
    List<File> dirs = new ArrayList<>();
    while (resources.hasMoreElements()) {
        URL resource = resources.nextElement();
//        dirs.add(new File(resource.getFile()));
        File f = new File(resource.toURI());
        dirs.add(f);
        
    }
    ArrayList<Class> classes = new ArrayList<>();
    for (File directory : dirs) {
        classes.addAll(findClasses(directory, packageName));
    }
    return classes.toArray(new Class[classes.size()]);
}

/**
 * Recursive method used to find all classes in a given directory and subdirs.
 *
 * @param directory   The base directory
 * @param packageName The package name for classes found inside the base directory
 * @return The classes
 * @throws ClassNotFoundException
 */
private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
    List<Class> classes = new ArrayList<Class>();
    if (!directory.exists()) {
        return classes;
    }
    File[] files = directory.listFiles();
    for (File file : files) {
        if (file.isDirectory()) {
            assert !file.getName().contains(".");
            classes.addAll(findClasses(file, packageName + "." + file.getName()));
        } else if (file.getName().endsWith(".class")) {
            classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
        }
    }
    return classes;
}
}
