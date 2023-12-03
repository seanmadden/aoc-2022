//package day16;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.stream.Collectors;
//
//class Solution {
//    public int minStickers(String[] stickers, String target) {
//        // Take an inventory of the letters I have available with 1 sticker each.
//        var numberOfStickers = stickers.length;
//
//        var restockMap = new HashMap<String, HashMap<Character, Integer>>();
//
//        var inventory = new HashMap<Character, Integer>();
//
//        for (var sticker : stickers) {
//            restockMap.put(sticker, new HashMap<>());
//
//            for (var letter : sticker.toCharArray()) {
//                if (!inventory.containsKey(letter)) {
//                    inventory.put(letter, 1);
//                    restockMap.get(sticker).put(letter, 1);
//                } else {
//                    var count = inventory.get(letter);
//                    inventory.put(letter, ++count);
//
//                    var restockCount = restockMap.get(sticker).get(letter);
//                    restockMap.get(sticker).put(letter, ++restockCount);
//                }
//            }
//        }
//
//        for (var targetLetter : target.toCharArray()) {
//            if (!inventory.containsKey(targetLetter)) {
//                // We don't have the inventory to support this
//                return -1;
//            }
//
//            var count = inventory.get(targetLetter);
//            // decrement inventory
//            inventory.put(targetLetter, --count);
//        }
//
//        // Any inventory that is negative needs to be stocked from an additional sticker or stickers
//        var negativeInventory = inventory.entrySet().stream().filter(it -> it.getValue() < 0).toList();
//        for (var sticker : stickers) {
//            // I know that some number of sticker will get me what I need, I need to minimize it though.
//            var containsAllNeededCharsAndQuantities = true;
//            var partialStickerMatch = false;
//
//            for (var entry : negativeInventory) {
//                System.out.println("I need " + Math.abs(entry.getValue()) + " '" + entry.getKey() + "'s");
//                if (!restockMap.get(sticker).containsKey(entry.getKey())) {
//                    System.out.println("Sticker " + sticker + " does not satisfy my problem");
//                    containsAllNeededCharsAndQuantities = false;
//                    break;
//                }
//
//                if (restockMap.get(sticker).get(entry.getKey()) >= entry.getValue()) {
//                    // yes this sticker will do, continue
//                    continue;
//                } else {
//                    // Might need 2!
//                    containsAllNeededCharsAndQuantities = false
//                    partialStickerMatch = true;
//                }
//            }
//
//            if (partialStickerMatch) {
//
//            }
//            if (containsAllNeededCharsAndQuantities) {
//
//            }
//
//        }
//
//        // make a map of what I need -> does the word contain it, and how many words would it take?
//
//
//        // At the very end, we need to recreate our stock stickers so we can remove them from the sticker count if not used.
//        for (var sticker : stickers) {
//            var containsAll = true;
//
//            for (var letter : sticker.toCharArray()) {
//                if (inventory.get(letter) <= 0) {
//                    containsAll = false;
//                    break;
//                }
//            }
//
//            if (containsAll) {
//                --numberOfStickers;
//
//                for (var letter : sticker.toCharArray()) {
//                    var count = inventory.get(letter);
//                    inventory.put(letter, --count);
//                }
//            }
//        }
//
//        return numberOfStickers;
//    }
//}
//public class scratch4 {
//    public static void main(String[] args) {
//        var s = new Solution();
//
//        var input = new String[] {
//                "with",
//                "example",
//                "science"
//        };
//
//        var output = s.minStickers(input, "thehat");
//        System.out.println(output);
//    }
//}
