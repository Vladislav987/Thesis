package content;

import java.util.Comparator;

public class FreeContentComparators {
    public static Comparator<FreeContent> byName() {
        return new Comparator<FreeContent>() {
            @Override
            public int compare(FreeContent o1, FreeContent o2) {

                return o1.getContentMetaData().getName().compareTo(o2.getContentMetaData().getName());


            }
        };
    }
    public static Comparator<FreeContent> byAuthor(){
        return new Comparator<FreeContent>() {
            @Override
            public int compare(FreeContent o1, FreeContent o2) {
                return o1.getContentMetaData().getAuthor().compareTo(o2.getContentMetaData().getAuthor());
            }
        };
    }
    public static Comparator<FreeContent> byDuration(){
        return new Comparator<FreeContent>() {
            @Override
            public int compare(FreeContent o1, FreeContent o2) {
                return o1.getContentMetaData().getDuration().compareTo(o2.getContentMetaData().getDuration());
            }
        };
    }
    public static Comparator<FreeContent> byLike(){
        return new Comparator<FreeContent>() {

            public int compare(FreeContent o1, FreeContent o2) {
                return Long.compare(o2.getContentStatistics().getDislike(), o1.getContentStatistics().getDislike());
            }
        };
    }
    public static Comparator<FreeContent> byDislike(){
        return new Comparator<FreeContent>() {

            public int compare(FreeContent o1, FreeContent o2) {
                return Long.compare(o2.getContentStatistics().getDislike(), o1.getContentStatistics().getDislike());
            }
        };
    }
    public static Comparator<FreeContent> byTotalViews(){
        return new Comparator<FreeContent>() {

            public int compare(FreeContent o1, FreeContent o2) {
                return Long.compare(o2.getContentStatistics().getDislike(), o1.getContentStatistics().getDislike());
            }
        };
    }

}

