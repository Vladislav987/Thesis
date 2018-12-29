package content;

import java.util.function.Predicate;

public class FreeContentPredicates {
    public static Predicate<FreeContent> byName(String contains){
        return new Predicate<FreeContent>() {
            @Override
            public boolean test(FreeContent freeContent) {
                return freeContent.getContentMetaData().getName().contains(contains);
            }
        };
    }
    public static Predicate<FreeContent> byAuthor(String contains){
        return new Predicate<FreeContent>() {
            @Override
            public boolean test(FreeContent freeContent) {
                return freeContent.getContentMetaData().getAuthor().contains(contains);
            }
        };
    }


}
