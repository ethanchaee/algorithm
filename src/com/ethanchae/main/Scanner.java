package com.ethanchae.main;

public class Scanner {
    private final java.util.Scanner scanner = new java.util.Scanner(System.in);

    public int getIntegerValue() {
        showNoticeContent();
        return scanner.nextInt();
    }

    public double getDoubleValue() {
        showNoticeContent();
        return scanner.nextDouble();
    }

    public String getStringValue() {
        showNoticeContent();
        return scanner.nextLine();
    }

    private void showNoticeContent() {
        System.out.println("값을 입력해주세요.");
    }
}
