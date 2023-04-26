package net.themightmage.fantasticallands.config;
import net.themightmage.fantasticallands.config.ConfigEntry;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;


@SuppressWarnings({ "RedundantSuppression", "unused" })
public class ConfigLoader extends HashMap<String, ConfigEntry>{

	public boolean ALLOW_SPAWNERS = true;
	public ArrayList<EntityType<?>> BLACKLIST = new ArrayList<EntityType<?>>();
	private static String config_location = FabricLoader.getInstance().getConfigDir().resolve("fantastical_lands.json").toString();
	private static final Gson gson = new Gson();

	public ConfigLoader() { init(); }

	public void init() {
		try { loadJson(); }
		catch (Exception e) {
			try {
				FileWriter file = new FileWriter(config_location);
				file.write(new String("""
				{
					'coins': {
						'iron_coin': {'chance': 35, 'max_amount': 8, 'multiply_amount_after_x_hp': 60 },
						'gold_coin': { 'chance': 22, 'max_amount': 3, 'multiply_amount_after_x_hp': 60 },
						'emerald_coin': { 'chance': 2, 'max_amount': 2, 'multiply_amount_after_x_hp': 60 },
						'netherite_coin': { 'chance': 1, 'max_amount': 1, 'multiply_amount_after_x_hp': 60},
						'options': {
							'blacklist': [
								'minecraft:silverfish'
							],
							'allow_coins_from_spawners': false
						}
					}
				}
				""").replace("'", "\""));
				file.close();
				loadJson();
			} catch (IOException _e) {
				System.out.println(_e);
			}
			
		}
	}

	private void loadCoinConfig(JsonObject coins_config) {
		Set<String> keys = coins_config.keySet();
		for(String key: keys) {
			JsonObject _obj = coins_config.getAsJsonObject(key);
			if (key.equals("options")) {
				ALLOW_SPAWNERS = _obj.get("allow_coins_from_spawners").getAsBoolean();
				_obj.get("blacklist").getAsJsonArray().forEach((e_rl) -> BLACKLIST.add(Registry.ENTITY_TYPE.get(new ResourceLocation(e_rl.getAsString()))));
			} else {
				this.put(String.format("%s_%s", key, "chance"), new ConfigEntry(_obj.get("chance").getAsInt()));
				this.put(String.format("%s_%s", key, "max_amount"), new ConfigEntry(_obj.get("max_amount").getAsInt()));
				this.put(String.format("%s_%s", key, "multiply_amount_after_x_hp"), new ConfigEntry(_obj.get("multiply_amount_after_x_hp").getAsInt()));
			}
		}
	}

	public void loadJson() throws JsonSyntaxException, FileNotFoundException {
		Object obj = gson.fromJson(new FileReader(config_location), JsonObject.class);
        JsonObject jo = (JsonObject) obj;
		loadCoinConfig(jo.getAsJsonObject("coins"));
	}

}