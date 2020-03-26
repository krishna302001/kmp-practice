package com.kmp;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class DeleteFilesOtherThanFormatSpecified {
        private static String[] fileExtenstion = new String[]{".jpg", ".mpg", ".mpeg", ".jpeg", ".mp4"};
//    private static String[] fileExtenstion = new String[]{"exe", "dll", "cpl"};
    private static List<String> fileExts = Arrays.asList(fileExtenstion);

    public static void main(String[] args) {
        String rootPath = "C:\\pathh";
        deleteFilewithSpecificExtensions(new File(rootPath));
    }

    private static void deleteFilewithSpecificExtensions(File file) {
        if (file.isDirectory() && !file.getName().contains("testdisk-7.2-WIP")) {
            File[] subFiles = file.listFiles();
            if (subFiles != null) {
                for (File subFile : subFiles) {
                    try {
                        if (subFile.isFile()) {
//                            if (subFile.getAbsolutePath().endsWith("exe") || subFile.getAbsolutePath().endsWith("dll") || subFile.getAbsolutePath().endsWith("cpl")) {
                            if (subFile.getName().contains(".")) {
                                if (fileExts.contains(subFile.getName().substring(subFile.getName().lastIndexOf('.')))) {
                                    if (subFile.length() / (1024 * 1024) > 3) {
                                        subFile.delete();
                                        System.out.println("Deleting size path: " + subFile.length() / (1024 * 1024) + " for " + subFile.getAbsolutePath());
                                    }
                                }
                            }
                        } else if (subFile.isDirectory() ) {
                            deleteFilewithSpecificExtensions(subFile);

                        }

                    } catch (Exception e) {
                        System.out.println(e.getMessage());

                    }
                }
            }
        }

    }
}
