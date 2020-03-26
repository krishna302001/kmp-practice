package com.kmp;


import java.io.File;

public class DeleteMVNfolders {
    public static void main(String[] args) {

        String rootPath = "C:\\path";

        String nameArray[] = new String[]{"10.2", "10.3", };
        for (String name : nameArray) {
            deletedFile(new File(rootPath), name);
            deleteFolders(new File(rootPath), name);
        }

//        String[] fileExtenstion = new String[]{".zip", ".rpm", ".iml"};
//        deleteFilewithSpecificExtension(new File(rootPath), ".zip");
//        deleteFilewithSpecificExtensions(new File(rootPath), fileExtenstion);
    }

    private static void deleteFolders(File file, final String folderName) {
        File[] subFiles = file.listFiles();
        if (subFiles != null) {
            for (File subFile : subFiles) {
                if (subFile.isDirectory() && subFile.getAbsolutePath().contains(folderName)) {
                    System.out.println("Deleting folder 1: " + subFile.getAbsolutePath());
                    subFile.delete();
                }
                deleteFolders(subFile, folderName);

            }
        } else {
            if (file.isDirectory() && file.getAbsolutePath().contains(folderName)) {
                System.out.println("Deleting folder 2: " + file.getAbsolutePath());
                file.delete();
            }
        }

    }

    private static void deleteFilewithSpecificExtensions(File file, String[] fileExtentions) {
        for (String fileExtension : fileExtentions) {
            if (file.isFile()) {
                if (file.getName().endsWith(fileExtension)) {
                    System.out.println("Deleting path: " + file.getAbsolutePath());
                    file.delete();
                }
            } else {
                File[] subFiles = file.listFiles();

                for (File subFile : subFiles) {

                    deleteFilewithSpecificExtension(subFile, fileExtension);
                }
                if (file.getName().endsWith(fileExtension)) {
                    System.out.println("Deleting path: " + file.getAbsolutePath());
                    file.delete();
                }
            }
        }
    }

    private static void deletedFile(File file, final String fileName) {

        if (file.isFile()) {
            if (file.getAbsolutePath().contains(fileName)) {
                System.out.println("Deleting file: " + file.getAbsolutePath());
                file.delete();
            }
        } else {
            File[] subFiles = file.listFiles();

            for (File subFile : subFiles) {

                deletedFile(subFile, fileName);
            }
        }
    }


    private static void deleteFilewithSpecificExtension(File file, final String fileExtension) {
        {

            if (file.isFile()) {
                if (file.getName().endsWith(fileExtension)) {
                    System.out.println("Deleting path: " + file.getAbsolutePath());
                    file.delete();
                }
            } else {
                File[] subFiles = file.listFiles();

                for (File subFile : subFiles) {

                    deleteFilewithSpecificExtension(subFile, fileExtension);
                }
                if (file.getName().endsWith(fileExtension)) {
                    System.out.println("Deleting path: " + file.getAbsolutePath());
                    file.delete();
                }
            }
        }
    }
}
