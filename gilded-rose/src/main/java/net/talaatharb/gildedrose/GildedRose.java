package net.talaatharb.gildedrose;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class GildedRose {
	public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	public static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
	public static final String AGED_BRIE = "Aged Brie";
	private static final String CONJURED = "conjured";
	private final Item[] items;

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			Item item = items[i];
			String name = item.getName();
			switch (name) {
			case AGED_BRIE:
				handleAgedBrie(item);
				break;
			case BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT:
				handleBackstagePasses(item);
				break;
			case SULFURAS_HAND_OF_RAGNAROS:
				break;
			default:
				if (item.getName().toLowerCase().contains(CONJURED)) {
					handleConjured(item);
				} else {
					handleDefault(item, 1);
				}
			}
		}
	}

	private void handleConjured(Item item) {
		handleDefault(item, 2);
	}

	private void handleDefault(Item item, int degradeRate) {
		if (item.getQuality() > 0) {
			item.setQuality(item.getQuality() - degradeRate);
		}

		item.setSellIn(item.getSellIn() - 1);

		if (item.getSellIn() < 0 && item.getQuality() > 0) {
			item.setQuality(item.getQuality() - degradeRate);
		}
	}

	private void handleBackstagePasses(Item item) {
		if (item.getQuality() < 50) {
			item.setQuality(item.getQuality() + 1);

			if (true) {
				if (item.getSellIn() < 11 && item.getQuality() < 50) {
					item.setQuality(item.getQuality() + 1);
				}

				if (item.getSellIn() < 6 && item.getQuality() < 50) {
					item.setQuality(item.getQuality() + 1);
				}

			}
		}

		item.setSellIn(item.getSellIn() - 1);

		if (item.getSellIn() < 0) {
			item.setQuality(0);
		}
	}

	private void handleAgedBrie(Item item) {
		if (item.getQuality() < 50) {
			item.setQuality(item.getQuality() + 1);
		}

		if (true) {
			item.setSellIn(item.getSellIn() - 1);
		}

		if (item.getSellIn() < 0 && item.getQuality() < 50) {
			item.setQuality(item.getQuality() + 1);
		}
	}
}