package cn.tealc.fxplugin;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.ServiceLoader;



public class FxPluginLoader {
    public FxPluginLoader() {
    }


    /**
     * description: 加载指定jar
     *
     * @param jarPath jar的绝对路径
     * @return FxPlugin
     */
    public Optional<FxPlugin> loadPlugin(String jarPath) throws Exception {
        File file = new File(jarPath);
        if (file.exists()) {
            //String fileUrl = URLEncoder.encode(file.toURI().toURL().toString(), StandardCharsets.UTF_8);//对反斜杠与空格进行处理
            URL[] urls = new URL[]{file.toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            ServiceLoader<FxPlugin> serviceLoader = ServiceLoader.load(FxPlugin.class, urlClassLoader);
            if (serviceLoader.iterator().hasNext()) {
                System.out.println("ServiceLoader 加载成功");
                return Optional.of(serviceLoader.iterator().next());
            }
        }
        return Optional.empty();
    }
}