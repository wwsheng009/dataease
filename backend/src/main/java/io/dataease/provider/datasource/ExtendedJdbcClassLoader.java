package io.dataease.provider.datasource;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
public class ExtendedJdbcClassLoader extends URLClassLoader {

    public ExtendedJdbcClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        if (name.contains("com.sap.db.jdbc.Driver")) {
			
			synchronized (getClassLoadingLock(name)) {
				try {
					URL u = new URL("jar:file:/opt/dataease/drivers/ngdbc-2.12.5.jar!/");
					URLClassLoader ucl = new URLClassLoader(new URL[] { u });
					Class<?> c1 = Class.forName(name, true, ucl);
					return c1;
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
		} else {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);

            if (c != null) {
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
            try {
                c = findClass(name);
                if (c != null) {
                    if (resolve) {
                        resolveClass(c);
                    }
                    return c;
                }
            } catch (ClassNotFoundException e) {
                // Ignore
            }


            try {
                if (getParent() != null) {
                    c = super.loadClass(name, resolve);
                    if (c != null) {
                        if (resolve) {
                            resolveClass(c);
                        }
                        return c;
                    }
                }
            } catch (ClassNotFoundException e) {
                // Ignore
            }
            try {
                c = findSystemClass(name);
                if (c != null) {
                    if (resolve) {
                        resolveClass(c);
                    }
                    return c;
                }
            } catch (ClassNotFoundException e) {
                // Ignore
            }
            throw new ClassNotFoundException(name);
        }
    }
    return null;
}


    @Override
    protected Package getPackage(String name) {
        return null;
    }


    public void addFile(String s) throws IOException {
        File f = new File(s);
        addFile(f);
    }

    public void addFile(File f) throws IOException {
        addFile(f.toURI().toURL());
    }

    public void addFile(URL u) throws IOException {
        try {
            this.addURL(u);
        } catch (Throwable t) {
            t.printStackTrace();
            throw new IOException("Error, could not add URL to system classloader");
        }
    }
}