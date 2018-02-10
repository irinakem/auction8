package am.aua.aoop.model;

import am.aua.aoop.model.Item;

import java.util.ArrayList;

public class ItemCatalog {

    private ArrayList<Item> items = new ArrayList<>();

    public ArrayList<Item> getItems() {
        return items;
    }

    public void createItem(String name, String description, double startingPrice) {
        items.add(new Item(name, description, startingPrice));
    }

    public Item getItem(String name) {
       Item item1 = null;

        for(Item item : items)
        {
            if(item.getName().equals(name))
            {
                item1 = item;
            }
        }

        return item1;
    }
}
