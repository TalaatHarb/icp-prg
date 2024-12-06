package net.talaatharb.gildedrose;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;
import org.lambda.utils.Range;

class GildedRoseTest {

	@Test
	void approvalTests() {
		var names = new String[] { "foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert",
				"Sulfuras, Hand of Ragnaros" };
		var sellIns = Range.get(-1, 15);
		var qualities = new Integer[] { 0, -1, 1, 49, 50, 51 };
		CombinationApprovals.verifyAllCombinations(this::doUpdateQuality, names, sellIns, qualities);
	}

	private String doUpdateQuality(String name, int sellIn, int quality) {
		Item[] items = new Item[] { new Item(name, sellIn, quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		return items[0].toString();
	}

	@Test
	void testConjured() {
		Approvals.verify(doUpdateQuality("Conjured Mana Cake", 1, 10));
	}

}
