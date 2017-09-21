package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

// Example scenarios for testing
//   Item("+5 Dexterity Vest", 10, 20));
//   Item("Aged Brie", 2, 0));
//   Item("Elixir of the Mongoose", 5, 7));
//   Item("Sulfuras, Hand of Ragnaros", 0, 80));
//   Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
//   Item("Conjured Mana Cake", 3, 6));

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_11() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(11, itemBrie.getQuality());
	}
	@Test
	public void testUpdateEndOfDay_AgedBrie_sellin() {
 	
 		GildedRose store = new GildedRose();
 		store.addItem(new Item("Aged Brie", 2, 0) );
 		store.updateEndOfDay();
 		List<Item> items = store.getItems();
 		Item itemBrie = items.get(0);
 		assertEquals(1, itemBrie.getSellIn());
 	}
 	
 	@Test
 	public void testUpdateEndOfDay_mongoose_sellin() {
 	
 		GildedRose store = new GildedRose();
 		store.addItem(new Item("Elixir of the Mongoose", 5, 7) );
 	    store.updateEndOfDay();
 		List<Item> items = store.getItems();
 		Item mongooseElixir = items.get(0);
 		assertEquals(4, mongooseElixir.getSellIn());
 	}
 	
 	@Test
 	public void testUpdateEndOfDay_mongoose_quality() {
 	
 		GildedRose store = new GildedRose();
 		store.addItem(new Item("Elixir of the Mongoose", 5, 7) );
 		store.updateEndOfDay();
 		List<Item> items = store.getItems();
 		Item mongooseElixir = items.get(0);
 		assertEquals(6, mongooseElixir.getQuality());
 	}
 	
 	@Test
 	public void testUpdateEndOfDay_backstage_quality() {
 	
 		GildedRose store = new GildedRose();
 		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) );
 		store.updateEndOfDay();
 		List<Item> items = store.getItems();
 		Item backstage = items.get(0);
 		assertEquals(21, backstage.getQuality());
 	}
 	@Test
 	public void testUpdateEndOfDay_backstage_sellin() {
 		
 		GildedRose store = new GildedRose();
 		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) );
 		store.updateEndOfDay();
 		List<Item> items = store.getItems();
 		Item backstage = items.get(0);
 		assertEquals(14, backstage.getSellIn());
 	}
}
