package net.themightmage.fantasticallands.init;

import net.themightmage.fantasticallands.procedures.XPTokenUsedProcedure;
import net.themightmage.fantasticallands.procedures.XPForgeLogicProcedure;
import net.themightmage.fantasticallands.procedures.CoinUsedByPlayerProcedure;

@SuppressWarnings("InstantiationOfUtilityClass")
public class FantasticalLandsModProcedures {
	public static void load() {
		new CoinUsedByPlayerProcedure();
		new XPTokenUsedProcedure();
		new XPForgeLogicProcedure();
	}
}
