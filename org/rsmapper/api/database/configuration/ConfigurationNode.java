//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.api.database.configuration;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ConfigurationNode {
    private Map<String, Object> children = new HashMap();

    public ConfigurationNode() {
    }

    public void set(String key, Object value) {
        this.children.put(key, value);
    }

    public boolean has(String key) {
        return this.children.containsKey(key);
    }

    public ConfigurationNode nodeFor(String name) {
        if (this.children.containsKey(name)) {
            Object value = this.children.get(name);
            if (value.getClass() != this.getClass()) {
                throw new ConfigurationException("Invalid node " + name + "!");
            } else {
                return (ConfigurationNode)value;
            }
        } else {
            return null;
        }
    }

    public String listChildren() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for(Iterator var3 = this.children.entrySet().iterator(); var3.hasNext(); builder.append(", ")) {
            Map.Entry<String, Object> entry = (Map.Entry)var3.next();
            builder.append((String)entry.getKey()).append(" => ");
            if (entry.getValue() instanceof ConfigurationNode) {
                builder.append(((ConfigurationNode)entry.getValue()).listChildren());
            } else {
                builder.append(entry.getValue());
            }
        }

        if (builder.length() > 2) {
            builder.deleteCharAt(builder.length() - 1);
            builder.deleteCharAt(builder.length() - 1);
        }

        builder.append("]");
        return builder.toString();
    }

    public Object get(String key) {
        return this.children.get(key);
    }

    public String getString(String string) {
        Object value = this.get(string);
        return value instanceof String ? (String)value : "null";
    }

    public int getInteger(String key) {
        return Integer.parseInt(this.getString(key));
    }

    public boolean getBoolean(String key) {
        return Boolean.parseBoolean(this.getString(key));
    }

    public Map<String, Object> getChildren() {
        return this.children;
    }
}
