package main;

import ds.Tree;
import util.StringUtils;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        String[] testInputs = {
                "Electronics",
                "Electronics > Arcade Equipment",
                "Electronics > Arcade Equipment > Basketball Arcade Games",
                "Electronics > Arcade Equipment > Pinball Machine Accessories",
                "Electronics > Arcade Equipment > Pinball Machines",
                "Electronics > Arcade Equipment > Skee-Ball Machines",
                "Electronics > Arcade Equipment > Video Game Arcade Cabinet Accessories",
                "Electronics > Arcade Equipment > Video Game Arcade Cabinets",
                "Electronics > Audio",
                "Electronics > Audio > Audio Accessories",
                "Electronics > Audio > Audio Accessories > Audio & Video Receiver Accessories",
                "Electronics > Audio > Audio Accessories > Headphone & Headset Accessories",
                "Electronics > Audio > Audio Accessories > Headphone & Headset Accessories > Headphone Cushions & Tips",
                "Electronics > Audio > Audio Accessories > Karaoke System Accessories"
        };

        for (String input : testInputs
        ) {
            tree.getRoot().addCategory(StringUtils.splitInput(input));
        }
        System.out.println("\n############## Frequency of categories ##############");
        tree.printAllRootToNodePaths();
    }
}
