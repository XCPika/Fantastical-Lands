package net.themightmage.fantasticallands.config;

public class ConfigEntry {
    private final String value_str;
	private final int value_int;
	private final boolean value_bool;
    private final String type;
    
    public ConfigEntry(String s) { value_str = s; value_int = -1; value_bool = false; type="str";}
    public ConfigEntry(int i) { value_int = i; value_str =""; value_bool = false; type = "int"; }
    public ConfigEntry(boolean b) { value_bool = b; value_int = -1; value_str =""; type = "bool"; }
    public final Object getValue() { return (type == "int" ? value_int : type == "bool" ? value_bool : value_str); }
}
