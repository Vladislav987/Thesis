package content;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class PlayList implements Serializable {
    private String name;
    private List<FreeContent> contents = new ArrayList<>();

    public PlayList(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<FreeContent> getContents() {
        return contents;
    }

    public void addToPlayList(FreeContent content) {
        contents.add(content);
    }

    public FreeContent getContent(int index) {
        if (index >= getContents().size()) {
            throw new IndexOutOfBoundsException("Такого контента нет");
        }
        return contents.get(index);
    }
    public void sort(Comparator<FreeContent> comparator){
        contents.sort(comparator);
    }

    public List<FreeContent> filter(Predicate<FreeContent> predicate){
         List<FreeContent> contentsAfterFiltering = new ArrayList<FreeContent>();
       for (FreeContent elem: contents){
           if (predicate.test(elem)){
               contentsAfterFiltering.add(elem);
           }
       }
           return contentsAfterFiltering;

    }


    @Override
    public String toString() {
        return "PlayList{" +
                "name='" + name + '\'' +
                ", contents=" + contents +
                '}';
    }
}
