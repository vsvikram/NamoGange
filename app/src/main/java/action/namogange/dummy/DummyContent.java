package action.namogange.dummy;

import java.util.ArrayList;
import java.util.List;

import action.namogange.R;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<>();
    private static String[] places_names = {"Har Ki Pauri", "Mansa Devi Temple", "Bharat Mata Mandir", "Chandi Devi Temple",
            "Vaishno Devi Temple", "Daksheswara Mahadev Temple", "Shantikunj", "Gau Ghat",
            "Kushavarta Ghat", "Vishnu Ghat", "Asthi Pravah Ghat", "Subhash Ghat", "Gurukula Kangri Vishwavidyalaya",
            "Faculty of Engineering & Technology"};


    private static int[] image_list = {R.mipmap.har_ki_pauri, R.mipmap.mansa_devi, R.mipmap.bharat_mata_mandir, R.mipmap.chandi_devi,
            R.mipmap.vaishno_devi, R.mipmap.daksha_mandir, R.mipmap.shanti_kunj, R.mipmap.gau_ghat, R.mipmap.kush_ghat, R.mipmap.vishnu_ghat,
            R.mipmap.ashthi_pravah, R.mipmap.subhash_ghat, R.mipmap.gkv, R.mipmap.fet_gkv};

    private static final int COUNT = 14;

    static {
        // Add some sample items.
        for (int i = 0; i < COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(image_list[position], places_names[position]);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final int id;
        public final String content;

        public DummyItem(int id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
