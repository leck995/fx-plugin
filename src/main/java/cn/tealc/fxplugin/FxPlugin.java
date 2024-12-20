package cn.tealc.fxplugin;

import cn.tealc.fxplugin.model.FxPluginType;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;


public interface FxPlugin {
    Optional<String> getPId();
    Optional<String> getName();
    Optional<String> getVersion();
    Optional<String> getAuthor();
    Optional<String> getDescription();
    Optional<Map<String,Object>> getData();
    FxPluginType getType();
    Optional<Object> run(Map<String, Object> params);
    void setOnFinished(Consumer<Object> event);
    void setOnFailed(Consumer<Object> event);
}