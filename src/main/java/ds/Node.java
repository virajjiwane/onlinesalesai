package ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pojo.Categories;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Node {
    private Categories categories;
    private Long freq;
    private List<Node> subCategories;

    public Node() {
        categories = new Categories("/");
        freq = 1l;
        subCategories = new ArrayList<>();
    }

    public void addCategory(List<String> rawCategories) {
        //Increase freq because we have traversed this node
        freq++;

        if (rawCategories.isEmpty()) {
            //No categories provided. do nothing
        } else if (rawCategories.size() == 1) {
            //Reached last sub category. make it a children

            //Make a category
            Categories newSubCategory = new Categories();
            newSubCategory.setName(rawCategories.get(0));

            //Make a node
            Node children = new Node();
            children.setCategories(newSubCategory);
            children.setFreq(1l);
            children.setSubCategories(new ArrayList<>());

            //Make the node child
            subCategories.add(children);
        } else {
            //Still yet to reach the end.

            Node childToTraverse = null;

            //Remove current category
            String categoryToFind = rawCategories.remove(0);

            for (Node subCategory : subCategories) {
                if (subCategory.getCategories().getName().equals(categoryToFind)) {
                    childToTraverse = subCategory;
                    break;
                }
            }

            //Add remaining categories
            if (childToTraverse != null) {
                //Got a child add remaining remaining subcategories to that child
                childToTraverse.addCategory(rawCategories);
            } else {
                //This category is new. should create a new child and remaining sub categories to this child
                Node newSubCategory = new Node();
                newSubCategory.setCategories(new Categories(categoryToFind));
                newSubCategory.addCategory(rawCategories);
                subCategories.add(newSubCategory);
            }
        }
    }
}
