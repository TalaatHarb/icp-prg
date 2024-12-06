package net.talaatharb.gildedrose;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {

	private final String name;

	private int sellIn;

	private int quality;

	@Override
	public String toString() {
		return this.getName() + ", " + this.getSellIn() + ", " + this.getQuality();
	}
}