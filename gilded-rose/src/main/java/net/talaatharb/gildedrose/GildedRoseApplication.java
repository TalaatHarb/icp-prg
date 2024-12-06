package net.talaatharb.gildedrose;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GildedRoseApplication {

	public static void main(String[] args) {
		log.trace("Application Started");

		Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20), //
				new Item(GildedRose.AGED_BRIE, 2, 0), //
				new Item("Elixir of the Mongoose", 5, 7), //
				new Item(GildedRose.SULFURAS_HAND_OF_RAGNAROS, 0, 80), //
				new Item(GildedRose.SULFURAS_HAND_OF_RAGNAROS, -1, 80),
				new Item(GildedRose.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT, 15, 20),
				new Item(GildedRose.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT, 10, 49),
				new Item(GildedRose.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT, 5, 49),
				new Item("Conjured Mana Cake", 3, 6) };

		GildedRose app = new GildedRose(items);

		int days = 2;
		if (args.length > 0) {
			days = Integer.parseInt(args[0]) + 1;
		}

		for (int i = 0; i < days; i++) {
			log.info("-------- day {} --------", i);
			log.info("name, sellIn, quality");
			for (Item item : items) {
				log.info(item.toString());
			}
			log.info("");
			app.updateQuality();
		}

		log.trace("Application finished");
	}
}