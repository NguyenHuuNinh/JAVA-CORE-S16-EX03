package vn.edu.rikkei.session16.ex03;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Supplier<String> timeSupplier = () -> LocalDateTime.now().format(formatter);
        Consumer<String> logger = msg -> System.out.printf("| -> %-48s |\n", msg);
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|           NHẬT KÝ HỆ THỐNG CONSUMER-SUPPLIER          |");
        System.out.println("+-------------------------------------------------------+");
        try {
            AuditLogger.logEvent(timeSupplier, logger, "USER_LOGIN");
            Thread.sleep(1000);

            AuditLogger.logEvent(timeSupplier, logger, "UPDATE_DATABASE");
            Thread.sleep(1000);

            AuditLogger.logEvent(timeSupplier, logger, "SYSTEM_BACKUP");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("+-------------------------------------------------------+");

    }
}
