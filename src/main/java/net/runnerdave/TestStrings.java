package net.runnerdave;

/**
 * Created by runnerdave on 14/06/17.
 * copied from: https://kylewbanks.com/blog/java-string-concatenation-vs-stringbuilder-vs-string-format-performance
 *
 * results:
 * 100000 iterations:
 * String Concatentation length: 888917 - time: 47342ms
 * StringBuilder length: 888917 - time: 4ms
 *
 * 10000 iterations:
 * String Concatentation length: 78917 - time: 893ms
 * StringBuilder length: 78917 - time: 1ms
 *
 * 1000 iterations:
 * String Concatentation length: 6917 - time: 21ms
 * StringBuilder length: 6917 - time: 0ms
 *
 */
public class TestStrings {
    private static final String PROFILE_PICTURE_URL_BASE = "https://cdn.myapp.com/user/";
    private static final String PROFILE_PICTURE_URL_EXTENSION = ".png";
    private static final int NUM_ITERATIONS = 1000;

    public static void main(String[] args) {
        int userId;
        long startTime;

        // String Concatentation
        startTime = System.currentTimeMillis();
        String profilePictureUrlConcat = PROFILE_PICTURE_URL_BASE;
        for (userId = 0; userId < NUM_ITERATIONS; userId ++) {
            profilePictureUrlConcat += userId + PROFILE_PICTURE_URL_EXTENSION;
        }
        System.out.println("String Concatentation length: " + profilePictureUrlConcat.length() + " - time: " + (System.currentTimeMillis() - startTime) + "ms");

        // StringBuilder
        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(PROFILE_PICTURE_URL_BASE);
        for (userId = 0; userId < NUM_ITERATIONS; userId ++) {

            sb.append(userId);
            sb.append(PROFILE_PICTURE_URL_EXTENSION);
        }
        System.out.println("StringBuilder length: " + sb.toString().length() + " - time: " + (System.currentTimeMillis() - startTime) + "ms");


    }
}
