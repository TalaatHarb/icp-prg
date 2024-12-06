package net.talaatharb.gildedrose;

class GildedRose {
	public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	public static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
	public static final String AGED_BRIE = "Aged Brie";
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			Item item = items[i];
			switch (item.name) {
			case AGED_BRIE:
				handleAgedBrie(item);
				break;
			case BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT:
				handleBackstagePasses(item);
				break;
			case SULFURAS_HAND_OF_RAGNAROS:
				break;
			default:
				handleDefault(item);
			}
		}
	}

	private void handleDefault(Item item) {
		if (item.quality > 0) {
			item.quality = item.quality - 1;
		}

		item.sellIn = item.sellIn - 1;

		if (item.sellIn < 0 && item.quality > 0) {
			item.quality = item.quality - 1;
		}
	}

	private void handleBackstagePasses(Item item) {
		if (item.quality < 50) {
			item.quality = item.quality + 1;

			if (true) {
				if (item.sellIn < 11 && item.quality < 50) {
					item.quality = item.quality + 1;
				}

				if (item.sellIn < 6 && item.quality < 50) {
					item.quality = item.quality + 1;
				}

			}
		}

		item.sellIn = item.sellIn - 1;

		if (item.sellIn < 0) {
			item.quality = 0;
		}
	}

	private void handleAgedBrie(Item item) {
		if (item.quality < 50) {
			item.quality = item.quality + 1;
		}

		if (true) {
			item.sellIn = item.sellIn - 1;
		}

		if (item.sellIn < 0 && item.quality < 50) {
			item.quality = item.quality + 1;
		}
	}
}