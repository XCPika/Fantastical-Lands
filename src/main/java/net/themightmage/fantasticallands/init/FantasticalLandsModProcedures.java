
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.themightmage.fantasticallands.init;

import net.themightmage.fantasticallands.procedures.XPTokenUsedProcedure;
import net.themightmage.fantasticallands.procedures.XPForgeLogicProcedure;
import net.themightmage.fantasticallands.procedures.XPForgeGUIProgress0Procedure;
import net.themightmage.fantasticallands.procedures.XPForgeGUIConditionTestProcedure;
import net.themightmage.fantasticallands.procedures.XPForgeGUICondition4Procedure;
import net.themightmage.fantasticallands.procedures.XPForgeGUICondition3Procedure;
import net.themightmage.fantasticallands.procedures.XPForgeGUICondition2Procedure;
import net.themightmage.fantasticallands.procedures.XPForgeGUICondition1Procedure;
import net.themightmage.fantasticallands.procedures.XPForgeGUICondition0Procedure;
import net.themightmage.fantasticallands.procedures.CoinUsedByPlayerProcedure;

@SuppressWarnings("InstantiationOfUtilityClass")
public class FantasticalLandsModProcedures {
	public static void load() {
		new CoinUsedByPlayerProcedure();
		new XPTokenUsedProcedure();
		new XPForgeLogicProcedure();
		new XPForgeGUICondition0Procedure();
		new XPForgeGUICondition1Procedure();
		new XPForgeGUICondition2Procedure();
		new XPForgeGUICondition3Procedure();
		new XPForgeGUICondition4Procedure();
		new XPForgeGUIConditionTestProcedure();
		new XPForgeGUIProgress0Procedure();
	}
}
