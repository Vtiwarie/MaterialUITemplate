package materialuitemplate.example.com.materialuitemplate.dummy;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

//    /**
//     * An array of sample (dummy) mItems.
//     */
//    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();
//
//    /**
//     * A map of sample (dummy) mItems, by ID.
//     */
//    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();
//
//    private static final int COUNT = 25;
//
//    static {
//        // Add some sample mItems.
//        for (int i = 1; i <= COUNT; i++) {
//            addItem(createDummyItem(i));
//        }
//    }
//
//    private static void addItem(DummyItem item) {
//        ITEMS.add(item);
//        ITEM_MAP.put(item.id, item);
//    }
//
//    private static DummyItem createDummyItem(int position) {
//        return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
//    }
//
//    private static String makeDetails(int position) {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Details about Item: ").append(position);
//        for (int i = 0; i < position; i++) {
//            builder.append("\nMore details information here.");
//        }
//        return builder.toString();
//    }

    private static DummyContent mInstance;
    private List<DummyItem> mItems = new ArrayList<>();
    private static final int COUNT = 30;

    private DummyContent() {
        initializeItems();
    }

    public static DummyContent getInstance() {
        if(mInstance == null) {
            mInstance = new DummyContent();
        }
        return mInstance;
    }

    private void initializeItems() {
        for(int i=0; i<COUNT; i++) {
            DummyItem item = new DummyItem(i, "Dummy Content " + i, "Dummy Details " + i);
            mItems.add(item);
        }
    }

    public List<DummyItem> getItems() {
        return mItems;
    }

    public DummyItem getItemAt(int position) {
        return mItems.get(position);
    }

    public int getSize() {
        return mItems.size();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        private int id;
        private String content;
        private String details;

        public DummyItem(int id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
