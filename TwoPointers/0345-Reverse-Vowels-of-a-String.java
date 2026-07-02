/*
# 345. Reverse Vowels of a String

## Problem Statement

Given a string `s`, reverse only the vowels in the string and return the resulting string.

**Example 1**

```text
Input: s = "hello"
Output: "holle"
```

**Example 2**

```text
Input: s = "leetcode"
Output: "leotcede"
```

---

## Approach

This solution uses the **Two Pointers** technique.

1. Convert the input string into a character array since Java strings are immutable.
2. Initialize two pointers:
   - `left` at the beginning of the array.
   - `right` at the end of the array.
3. Move the left pointer until it points to a vowel.
4. Move the right pointer until it points to a vowel.
5. Swap the vowels.
6. Continue until the two pointers meet.
7. Convert the character array back into a string.

---

## Algorithm

1. Convert the string to a character array.
2. Set `left = 0` and `right = n - 1`.
3. While `left < right`:
   - Skip non-vowels from the left.
   - Skip non-vowels from the right.
   - Swap the vowels.
   - Move both pointers inward.
4. Return the modified string.

---

## Complexity Analysis

- **Time Complexity:** `O(n)`
  - Each pointer traverses the string at most once.

- **Space Complexity:** `O(n)`
  - A character array is created because Java strings are immutable.

---

## Java Concepts Used

- Strings
- Character Arrays (`char[]`)
- Two Pointers
- Helper Methods
- Conditional Statements
- Loops
- Character Swapping

---

## Key Learning

- The **Two Pointers** technique is an efficient way to process data from both ends simultaneously.
- Converting a `String` to a `char[]` allows in-place modifications.
- Using a helper method (`isVowel`) improves code readability and maintainability.

---

## LeetCode

- **Problem Number:** 345
- **Difficulty:** Easy
- **Topic:** Strings, Two Pointers
*/

class Solution {
    public String reverseVowels(String s) {
        char[] ar = s.toCharArray();

        int i = 0;
        int j = ar.length - 1;

        while (i < j) {

            if (!isVowel(ar[i])) {
                i++;
                continue;
            }

            if (!isVowel(ar[j])) {
                j--;
                continue;
            }

            char temp = ar[i];
            ar[i] = ar[j];
            ar[j] = temp;

            i++;
            j--;
        }

        return new String(ar);
    }

    public static boolean isVowel(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'
            || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}