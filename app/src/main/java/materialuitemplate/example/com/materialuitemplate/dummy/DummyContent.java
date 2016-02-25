package materialuitemplate.example.com.materialuitemplate.dummy;

import java.util.ArrayList;
import java.util.List;

import materialuitemplate.example.com.materialuitemplate.R;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace this class with custom data to be used for your app.
 */
public class DummyContent {

    private static DummyContent mInstance;
    private List<DummyItem> mItems = new ArrayList<>();

    private DummyContent() {
        initializeItems();
    }

    public static DummyContent getInstance() {
        if (mInstance == null) {
            mInstance = new DummyContent();
        }
        return mInstance;
    }

    /**
     * Initialize dummy data
     */
    private void initializeItems() {
        addItem(new DummyItem(0, "Burning fire", "fire details", R.drawable.img_fire));
        addItem(new DummyItem(1, "Money", "money details", R.drawable.img_dollars));
        addItem(new DummyItem(2, "Roses", "rose details", R.drawable.img_roses));
    }

    /**
     * Add dummy data to the list of Dummy Items
     *
     * @param item
     */
    private void addItem(DummyItem item) {
        mItems.add(item);
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
        private int image;

        public DummyItem(int id, String content, String details, int imageID) {
            this.id = id;
            this.content = content;
            this.details = details;
            this.image = imageID;
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

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
