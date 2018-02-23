package am.aua.aoop.server;

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

    public void populateWithDummyData(){
        for (int i = 0; i < 20; i ++){
            createItem("Item " + i, "desc", 100);
        }
    }

}
